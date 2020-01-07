package com.ducen.predictor.view.home;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.ducen.predictor.model.RecentPatient;
import com.ducen.predictor.r4.entity.R4Appointment;
import com.ducen.predictor.r4.entity.R4Patient;
import com.ducen.predictor.r4.converter.R4AppointmentConverterImpl;
import com.ducen.predictor.r4.converter.R4PatientConverterImpl;
import com.ducen.predictor.r4.webservice.R4AppointmentRestServiceImpl;
import com.ducen.predictor.r4.webservice.R4PatientRestServiceImpl;
import com.ducen.predictor.service.RecentPatientService;
import com.ducen.predictor.view.MainActivity;
import com.ducen.predictor.view.R;
import com.ducen.predictor.view.adapter.PatientAdapter;
import com.ducen.predictor.view.adapter.RecentPatientAdapter;
import com.ducen.predictor.view.patient.patientinformation.PatientActivity;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    //list
    private List<RecentPatient> recentPatientList = new ArrayList<>();

    private R4AppointmentConverterImpl r4AppointmentConverter;
    private R4PatientConverterImpl r4PatientConverter;

    private R4PatientRestServiceImpl r4PatientRestService;
    private R4AppointmentRestServiceImpl r4AppointmentRestService;
    private RecentPatientService recentPatientService;

    private ImageButton btnOptions;
    private SearchView svSearchPatient;
    private RecyclerView rvPatients;

    //adapter
    private RecentPatientAdapter recentPatientAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initClasses();

        initUI();

        initSearchView(view);

        initBtnDropDown(view);

        //initialize recyclerview
        initRecyclerView(view);

        initRecentPatientList();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        compositeDisposable.clear();
    }

    private void initClasses() {
        this.r4PatientConverter = new R4PatientConverterImpl();
        this.r4AppointmentConverter = new R4AppointmentConverterImpl();

        this.r4PatientRestService = new R4PatientRestServiceImpl(getContext());
        this.r4AppointmentRestService = new R4AppointmentRestServiceImpl(getContext());

        this.recentPatientService = new RecentPatientService();

        this.recentPatientList = new ArrayList<>();
    }

    private void initUI() {
        this.recentPatientAdapter = new RecentPatientAdapter(recentPatientList);
    }

    private void initRecyclerView(View view) {
        rvPatients = view.findViewById(R.id.rvPatients);
        rvPatients.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPatients.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        rvPatients.addOnItemTouchListener(new PatientAdapter.RecyclerTouchListener(getActivity(),
                rvPatients, new PatientAdapter.clickListener() {
            @Override
            public void onClick(View view, final int position) {
                try {
                    //TODO create a visit from the data from webcall (in appObj) for info passed to email, text etc
                    Intent i = new Intent(getActivity(), PatientActivity.class);
                    i.putExtra("PATIENT_INFORMATION", recentPatientList.get(position));
                    /*i.putExtra("PATIENT_KEY", patientList.get(position));
                    Log.d("Intent Patient",""+patientList.get(position));*/
                    startActivity(i);
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "The LoneWorker duration is not valid" + e, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onLongClick(View view, int position) {
                Log.e(TAG, "Long press on position :" + position);
            }
        }));
    }

    private void initBtnDropDown(View view) {
        btnOptions = view.findViewById(R.id.btnOptions);
        btnOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(getActivity(), btnOptions);

                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.menu_options_dropdown, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                getActivity(),
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        });
    }

    private void initSearchView(View view) {
        svSearchPatient = view.findViewById(R.id.svSearchPatient);
        svSearchPatient.setQueryHint("Search patient");
        svSearchPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svSearchPatient.setIconified(false);
            }
        });

        svSearchPatient.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                initRecentPatientList();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.equalsIgnoreCase("")) {
                    initRecentPatientList();
                }
                return false;
            }
        });
    }

    private void initRecentPatientList() {
        String searchValue = svSearchPatient.getQuery().toString();

//        String searchValue = "kumar";

        if (searchValue.equalsIgnoreCase("")) {
            if (isNetworkAvailable()) {
                recentPatientList.clear();
                callGetAppointmentByPractitionerWebService();
            } else {
                Toast.makeText(getActivity().getApplicationContext(), "No Internet Connection. ", Toast.LENGTH_LONG).show();
                //No Internet Connection, maybe load the cache
            }
        } else {
            if (isNetworkAvailable()) {
                recentPatientList.clear();
                callGetPatientByNameWebService(searchValue);
            } else {
                Toast.makeText(getActivity().getApplicationContext(), "No Internet Connection. ", Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void callGetAppointmentByPractitionerWebService() {

        String practitionerId = "249120";

        getAppointmentByPractitionerObservable(practitionerId)
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
                            Log.d("TEST", "No Appointments yet for the Practitioner. ");
                        } else if (object.equals(0)) {
                            Log.d("TEST", "Problem with Internet Connection. ");
                        } else {
                            List<R4Appointment> r4AppointmentList = (ArrayList) object;
                            recentPatientList = recentPatientService.createRecentPatientListBasedFromAppointmentList(r4AppointmentList);

                            updateRecentPatientAdapter();

                            List<String> patientIdList = recentPatientService.createPatientIdListBasedFromAppointmentList(r4AppointmentList);
                            callGetPatientByIdWebService(patientIdList);
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

    private Observable<Object> getAppointmentByPractitionerObservable(String practitionerId) {
        return r4AppointmentRestService.getAppointmentByPractitioner(10, practitionerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ResponseBody, Object>() {
                    @Override
                    public Object apply(ResponseBody responseBody) throws Exception {
                        Object object = new Object();
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody.string());
                            if (r4AppointmentConverter.checkExist(jsonObject)) {
                                List<R4Appointment> r4AppointmentList = r4AppointmentConverter.createR4AppointmentList(jsonObject);
                                object = r4AppointmentList;
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

    private void callGetPatientByIdWebService(List<String> patientIdList) {

        for (String patientId : patientIdList) {
            getPatientByIdObservable(1, patientId)
                    .delay(4, TimeUnit.SECONDS)
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
                                Toast.makeText(getActivity().getApplicationContext(), "Patient does not exist.",
                                        Toast.LENGTH_LONG).show();

                            } else if (object.equals(0)) {
                                Toast.makeText(getActivity().getApplicationContext(), "Problem with internet connection. ",
                                        Toast.LENGTH_LONG).show();
                            } else {
                                R4Patient r4Patient = (R4Patient) object;
                                recentPatientList = recentPatientService.setPatientDataOnRecentPatient(r4Patient, recentPatientList);
                                updateRecentPatientAdapter();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d("TEST", "setPatientDataOnRecentPatient onError : " + e.toString());
                        }

                        @Override
                        public void onComplete() {
                        }
                    });
        }
    }

    private Observable<Object> getPatientByIdObservable(int resultCount, String patientId) {
        return r4PatientRestService.getPatientById(resultCount, patientId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ResponseBody, Object>() {
                    @Override
                    public Object apply(ResponseBody responseBody) throws Exception {
                        Object object = new Object();
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody.string());
                            //check if practitioner exist
                            if (r4PatientConverter.checkExist(jsonObject)) {
                                List<R4Patient> r4PatientList = r4PatientConverter.createR4PatientList(jsonObject);
                                object = r4PatientList.get(0);
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

    private void callGetPatientByNameWebService(String name) {
        getPatientByNameObservable(name)
                .delay(4, TimeUnit.SECONDS)
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
                            Toast.makeText(getActivity().getApplicationContext(), "No patient found. ",
                                    Toast.LENGTH_LONG).show();

                        } else if (object.equals(0)) {
                            Toast.makeText(getActivity().getApplicationContext(), "Problem with internet connection. ",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            List<R4Patient> r4PatientList = (ArrayList) object;
                            recentPatientList = recentPatientService.createRecentPatientListBasedFromPatientList(r4PatientList);
                            updateRecentPatientAdapter();

                            List<String> patientIdList = recentPatientService.createPatientIdListBasedFromPatientList(r4PatientList);
                            Log.d("TEST", "PatientIDList : " + patientIdList.toString());

                            callGetAppointmentByPatientIdWebService(patientIdList);

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

    private Observable<Object> getPatientByNameObservable(String name) {
        return r4PatientRestService.getPatientByName(10, name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ResponseBody, Object>() {
                    @Override
                    public Object apply(ResponseBody responseBody) throws Exception {
                        Object object = new Object();
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody.string());
                            if (r4PatientConverter.checkExist(jsonObject)) {
                                List<R4Patient> r4PatientList = r4PatientConverter.createR4PatientList(jsonObject);
                                object = r4PatientList;
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

    private void callGetAppointmentByPatientIdWebService(List<String> patientIdList) {

        for (String patientId : patientIdList) {
            getAppointmentByPatientIdObservable(1, patientId)
                    .delay(4, TimeUnit.SECONDS)
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
                                Toast.makeText(getActivity().getApplicationContext(), "No appointment found. ",
                                        Toast.LENGTH_LONG).show();

                            } else if (object.equals(0)) {
                                Toast.makeText(getActivity().getApplicationContext(), "Problem with internet connection. ",
                                        Toast.LENGTH_LONG).show();
                            } else {
                                R4Appointment r4Appointment = (R4Appointment) object;
                                recentPatientList = recentPatientService.setAppointmentDataOnRecentPatient(r4Appointment, recentPatientList);
                                updateRecentPatientAdapter();
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

    }

    private Observable<Object> getAppointmentByPatientIdObservable(int resultCount, String patientId) {
        return r4AppointmentRestService.getAppointmentByPatientId(resultCount, patientId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ResponseBody, Object>() {
                    @Override
                    public Object apply(ResponseBody responseBody) throws Exception {
                        Object object = new Object();
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody.string());
                            if (r4AppointmentConverter.checkExist(jsonObject)) {
                                Log.d("TEST", "Appointment exist. . ");
                                List<R4Appointment> r4AppointmentList = r4AppointmentConverter.createR4AppointmentList(jsonObject);
                                object = r4AppointmentList.get(0);
                            } else {
                                Log.d("TEST", "Appointment dont exist. . ");
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

    private void updateRecentPatientAdapter() {
        //showData();
        recentPatientAdapter.notifyDataSetChanged();
        recentPatientAdapter = new RecentPatientAdapter(recentPatientList);
        rvPatients.setAdapter(recentPatientAdapter);
    }

    /*private void showData() {
        for (RecentPatient recentPatient : this.recentPatientList) {
            String patientId = recentPatient.getPatientId();
            String fullName = recentPatient.getFullname();
            String fName = recentPatient.getFname();
            String lName = recentPatient.getLname();
            String gender = recentPatient.getGender();
            String birthDay = recentPatient.getBirthDate();
            String phoneNumber = recentPatient.getPhoneNumber();
            String patientAddress = recentPatient.getAddress();
            String appointmentDescription = recentPatient.getAppointmentDescription();
            String appointmentDate = recentPatient.getAppointmentDate();
//            Log.d("TEST", "holder patient id: " + patientId);
//            Log.d("TEST", "holder fullName : " + fullName);
//            Log.d("TEST", "holder firstName : " + fName);
//            Log.d("TEST", "holder lastName : " + lName);
//            Log.d("TEST", "holder phoneNumber : " + phoneNumber);
//            Log.d("TEST", "holder patientAddress : " + patientAddress);
//            Log.d("TEST", "holder gender : " + gender);
//            Log.d("TEST", "holder birthDate : " + birthDay);
//            Log.d("TEST", "holder appointmentDescription : " + appointmentDescription);
//            Log.d("TEST", "holder appointmentDate : " + appointmentDate);
//            Log.d("TEST", "=====================================");
        }
    }*/

}
