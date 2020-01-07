package com.ducen.predictor.view.patient.condition;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.ducen.predictor.defaultdata.Session;
import com.ducen.predictor.model.Condition;
import com.ducen.predictor.r4.converter.R4ConditionConverterImpl;
import com.ducen.predictor.r4.entity.R4Condition;
import com.ducen.predictor.r4.webservice.R4ConditionRestServiceImpl;
import com.ducen.predictor.service.ConditionService;
import com.ducen.predictor.session.SessionManagerImpl;
import com.ducen.predictor.view.MainActivity;
import com.ducen.predictor.view.R;
import com.ducen.predictor.view.login.LoginActivity;
import com.ducen.predictor.view.pincode.PincodeActivity;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientConditionFragment extends Fragment {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private R4ConditionRestServiceImpl r4ConditionRestService;
    private R4ConditionConverterImpl r4ConditionConverter;
    private ConditionService conditionService;


    private List<Condition> conditionList;

    private TableLayout mTableLayout,freezeTable;
    private ProgressDialog mProgressBar;

    public PatientConditionFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_patient_condition, container, false);

        initClasses();

        initConditionList();

        //load
        mProgressBar = new ProgressDialog(getContext());

        //condition table
        mTableLayout = view.findViewById(R.id.tableConditions);
        mTableLayout.setStretchAllColumns(true);

        freezeTable = view.findViewById(R.id.tableCondition);

        loadData(view);
        return view;
    }

    private void initClasses() {
        this.r4ConditionRestService = new R4ConditionRestServiceImpl(getContext());
        this.r4ConditionConverter = new R4ConditionConverterImpl();
        this.conditionService = new ConditionService();

        this.conditionList = new ArrayList<>();
    }

    private void initUI() {

    }

    private void initConditionList() {
        if (isNetworkAvailable()) {
            conditionList.clear();
            callGetAppointmentByPractitionerWebService();
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "No Internet Connection. ", Toast.LENGTH_LONG).show();
            //No Internet Connection, maybe load the cache
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void callGetAppointmentByPractitionerWebService() {
        String patientId = "58504";
        getConditionByPatientIdObservable(10, patientId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Object object) {
                        if (object.equals(false)) {
                            Log.d("TEST", "No Condition yet for the patient. ");
                        } else if (object.equals(0)) {
                            Log.d("TEST", "Problem with Internet Connection. ");
                        } else {

                            List<R4Condition> r4ConditionList = (ArrayList) object;
                            conditionList = conditionService.createConditionList(r4ConditionList);
                            Log.d("TEST", "Condition List : " + conditionList.size());
//
//                            updateRecentPatientAdapter();
//
//                            List<String> patientIdList = recentPatientService.createPatientIdListBasedFromAppointmentList(r4AppointmentList);
//                            callGetPatientByIdWebService(patientIdList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private Observable<Object> getConditionByPatientIdObservable(int resultCount, String practitionerId) {
        return r4ConditionRestService.getConditionByPatientId(resultCount, practitionerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ResponseBody, Object>() {
                    @Override
                    public Object apply(ResponseBody responseBody) throws Exception {
                        Object object = new Object();
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody.string());

                            if (r4ConditionConverter.checkExist(jsonObject)) {
                                List<R4Condition> r4ConditionList = r4ConditionConverter.createR4ConditionList(jsonObject);
                                object = r4ConditionList;
                            } else {
                                object = false;
                            }

                        } catch (Exception e) {
                            object = 0;
                            e.printStackTrace();
                        }
                        return object;
                    }
                });
    }

    private void loadData(View view) {
        int leftRowMargin = 0;
        int topRowMargin = 0;
        int rightRowMargin = 0;
        int bottomRowMargin = 0;
        int textSize = 0, smallTextSize = 0;
/*
        textSize = (int) getResources().getDimension(R.dimen.font_size_verysmall);
        smallTextSize = (int) getResources().getDimension(R.dimen.font_size_small);*/

        Conditions condition = new Conditions();
        Condition[] data = condition.getCondition();


        int rows = data.length;
        TextView textSpacer = null;

        mTableLayout.removeAllViews();
        freezeTable.removeAllViews();

        // -1 means heading row
        for (int i = -1; i < rows; i++) {
            Condition row = null;
            if (i > -1)
                row = data[i];
            else {
                textSpacer = new TextView(view.getContext());
                textSpacer.setText("");

            }
            // Condition
            final TextView tv = new TextView(view.getContext());
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv.setGravity(Gravity.CENTER);

            tv.setPadding(20, 40, 20, 40);

            if (i == -1) {
                //Condition Header
                tv.setText(getResources().getString(R.string.condition));
                tv.setBackgroundColor(getResources().getColor(R.color.menuBGLightBlue));
                tv.setTextColor(getResources().getColor(R.color.fontColor));
            } else {
                tv.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv.setText(String.valueOf(row.getCondition()));
            }

            //Clinical Status
            final TextView tv2 = new TextView(view.getContext());
            tv2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

            tv2.setGravity(Gravity.CENTER);
            tv2.setPadding(20, 40, 20, 40);

            if (i == -1) {
                tv2.setText("Clinical Status");
                tv2.setBackgroundColor(getResources().getColor(R.color.menuBGLightBlue));
                tv2.setTextColor(getResources().getColor(R.color.fontColor));
            } else {
                tv2.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv2.setText(row.getClinicalStatus());
            }

            /*final LinearLayout layCustomer = new LinearLayout(view.getContext());
            layCustomer.setOrientation(LinearLayout.VERTICAL);
            layCustomer.setPadding(0, 10, 0, 10);
            layCustomer.setBackgroundColor(Color.parseColor("#f8f8f8"));*/

            //Verification Status
            final TextView tv3 = new TextView(view.getContext());
            tv3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

            tv3.setGravity(Gravity.CENTER);
            tv3.setPadding(20, 40, 20, 40);

            if (i == -1) {
                tv3.setText("Verification Status");
                tv3.setBackgroundColor(getResources().getColor(R.color.menuBGLightBlue));
                tv3.setTextColor(getResources().getColor(R.color.fontColor));
            } else {
                tv3.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv3.setText(row.getVerificationStatus());
            }

            //Onset Date
            final TextView tv4 = new TextView(view.getContext());
            tv4.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

            tv4.setGravity(Gravity.CENTER);
            tv4.setPadding(20, 40, 20, 40);

            if (i == -1) {
                tv4.setText("Onset Date");
                tv4.setBackgroundColor(getResources().getColor(R.color.menuBGLightBlue));
                tv4.setTextColor(getResources().getColor(R.color.fontColor));
            } else {
                tv4.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv4.setText(row.getOnsetDate());
            }

            // add table row
            final TableRow tr = new TableRow(view.getContext());
            final TableRow trf = new TableRow(view.getContext());
            tr.setId(i + 1);
            TableLayout.LayoutParams trParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT);
            tr.setLayoutParams(trParams);
            trf.addView(tv);
            tr.addView(tv2);
            tr.addView(tv3);
            tr.addView(tv4);

            if (i > -1) {
                tr.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        TableRow tr = (TableRow) v;
                        //do whatever action is needed
                    }
                });
            }

            mTableLayout.addView(tr, trParams);
            freezeTable.addView(trf, trParams);

            if (i > -1) {

                // add separator row
                final TableRow trSep = new TableRow(view.getContext());
                TableLayout.LayoutParams trParamsSep = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT);
                trParamsSep.setMargins(leftRowMargin, topRowMargin, rightRowMargin, bottomRowMargin);

                trSep.setLayoutParams(trParamsSep);
                TextView tvSep = new TextView(view.getContext());
                TableRow.LayoutParams tvSepLay = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT);
                tvSepLay.span = 4;
                tvSep.setLayoutParams(tvSepLay);
                tvSep.setBackgroundColor(Color.parseColor("#d9d9d9"));
                tvSep.setHeight(1);

                trSep.addView(tvSep);
                mTableLayout.addView(trSep, trParamsSep);
            }


        }
    }


}


