package com.ducen.predictor.view.verify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ducen.predictor.defaultdata.Session;
import com.ducen.predictor.r4.entity.R4Practitioner;
import com.ducen.predictor.r4.converter.R4PractitionerConverterImpl;
import com.ducen.predictor.r4.webservice.R4PractitionerRestServiceImpl;
import com.ducen.predictor.session.SessionManagerImpl;
import com.ducen.predictor.view.R;
import com.ducen.predictor.view.main.GetStartedActivity;
import com.ducen.predictor.view.password.PasswordActivity;

import org.json.JSONObject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class EmailVerificationActivity extends AppCompatActivity {

    private CompositeDisposable compositeDisposable;

    //services
    private R4PractitionerConverterImpl r4PractitionerService;

    //rest services
    private R4PractitionerRestServiceImpl r4PractitionerRestServiceImpl;

    //session
    private SessionManagerImpl sessionManager;

    //ui elements
    EditText practitionerIdEditText;
    EditText emailEditText;
    Button verifyButton;
    ProgressBar loadingProgressBar;
    ImageButton backbutton;
    TextWatcher afterTextChangedListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);

        initClasses();

        initUIComponents();

        initTextWatcher();

        initListeners();

        checkNetworkConnection();

    }

    @Override
    public void onBackPressed() {
        Log.d("EmailVerification", "Back Press");
        if (!sessionManager.contains(Session.PRACTITIONERID.toString())) {
            sessionManager.deleteSession(Session.PRACTITIONERID.toString());
        }
        if (!sessionManager.contains(Session.EMAIL.toString())) {
            sessionManager.deleteSession(Session.EMAIL.toString());
        }
        startActivity(new Intent(getApplicationContext(),GetStartedActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (sessionManager.contains(Session.PRACTITIONERID.toString()) && sessionManager.contains(Session.EMAIL.toString())) {
            if(sessionManager.getStringSession(Session.PRACTITIONERID.toString()).equalsIgnoreCase(null) && sessionManager.getStringSession(Session.EMAIL.toString()).equalsIgnoreCase(null)){
                Log.d("EmailVerification", "Reset Registration");
                sessionManager.reset();
                startActivity(new Intent(getApplicationContext(), GetStartedActivity.class));
                finish();
            }
        }
    }

    void initClasses() {
        String serverAddressFromSession = "http://hapi.fhir.org/baseR4/";

        Log.d("TEST", "initClasses Server Address is null : " + serverAddressFromSession);

        r4PractitionerRestServiceImpl = new R4PractitionerRestServiceImpl(getApplicationContext(), serverAddressFromSession);

        r4PractitionerService = new R4PractitionerConverterImpl();
        sessionManager = new SessionManagerImpl(getApplicationContext());
        compositeDisposable = new CompositeDisposable();
    }

    void initUIComponents() {
        practitionerIdEditText = findViewById(R.id.practitioner_id);
        emailEditText = findViewById(R.id.email);
        verifyButton = findViewById(R.id.button_verify);
        loadingProgressBar = findViewById(R.id.loading);
        backbutton = findViewById(R.id.header_back);

        String id = "80198"; //tj test, delete this line if production
        String email = "vtang@healthcross.com";//tj test, delete this line if production

        practitionerIdEditText.setText(id); //tj test, delete this line if production
        emailEditText.setText(email); //tj test, delete this line if production
    }

    void initTextWatcher() {
        afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (checkValidPractitioner() && checkValidEmail()) {
                    verifyButton.setEnabled(true);
                } else {
                    verifyButton.setEnabled(false);
                }
            }
        };
    }

    void initListeners() {
        practitionerIdEditText.addTextChangedListener(afterTextChangedListener);
        emailEditText.addTextChangedListener(afterTextChangedListener);
        emailEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.d("Email Verification", practitionerIdEditText.getText().toString() + " " + emailEditText.getText().toString());
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    clickBtnVerify(v);
                }
                return false;
            }
        });

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Email Verification", practitionerIdEditText.getText().toString() + " " + emailEditText.getText().toString());
                clickBtnVerify(v);
            }
        });

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Email Verification", "Back to previous page");
                startActivity(new Intent(getApplicationContext(), GetStartedActivity.class));
                finish();
            }
        });
    }

    void checkNetworkConnection() {
        Log.d("TEST", "Network : " + isNetworkAvailable());
        if (isNetworkAvailable()) {
            Toast.makeText(getApplicationContext(), "Theres internet connection. ",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "No Internet Connection. ",
                    Toast.LENGTH_LONG).show();
        }
    }

    boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    boolean checkValidPractitioner() {
        boolean flag = false;
        if (practitionerIdEditText.getText().toString().isEmpty() || practitionerIdEditText.getText().toString().length() < 4) {
            practitionerIdEditText.setError("Enter valid Practitioner ID");
            flag = false;
        } else {
            practitionerIdEditText.setError(null);
            practitionerIdEditText.setEnabled(true);
            flag = true;
        }
        return flag;
    }

    boolean checkValidEmail() {
        boolean flag = false;
        if (emailEditText.getText().toString().isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(emailEditText.getText().toString()).matches()) {
            emailEditText.setError("Enter valid Email Address");
            flag = false;
        } else {
            emailEditText.setError(null);
            flag = true;
        }
        return flag;
    }

    void clickBtnVerify(View view) {
        if (isNetworkAvailable()) {
            callGetPractitionerByIdAndEmailWebService(practitionerIdEditText.getText().toString(), emailEditText.getText().toString());
        } else {
            Toast.makeText(getApplicationContext(), "No Internet Connection. ",
                    Toast.LENGTH_LONG).show();
        }
    }

    void callGetPractitionerByIdAndEmailWebService(String id, String email) {
        getPractitionerByIdAndEmailObservable(id, email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                        loadingProgressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNext(Object object) {
                        loadingProgressBar.setVisibility(View.INVISIBLE);
                        if (object.equals(false)) {
                            Toast.makeText(getApplicationContext(), "Practitioner does not exist.",
                                    Toast.LENGTH_LONG).show();

                        } else if (object.equals(0)) {
                            Toast.makeText(getApplicationContext(), "Problem with internet connection. ",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            R4Practitioner r4Practitioner = (R4Practitioner) object;
                            Log.d("TEST", "3 r4Practitioner : " + r4Practitioner.toString());
                            createSession();
                            startIntent();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadingProgressBar.setVisibility(View.INVISIBLE);
                        Log.d("TEST", "onError : " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TEST", "5");
                    }
                });

    }

    Observable<Object> getPractitionerByIdAndEmailObservable(String id, String email) {
        return r4PractitionerRestServiceImpl.getPractitionerByIdAndEmail(id, email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ResponseBody, Object>() {
                    @Override
                    public Object apply(ResponseBody responseBody) throws Exception {
                        Object object = new Object();
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody.string());
                            //check if practitioner exist
                            if (r4PractitionerService.checkExist(jsonObject)) {
                                R4Practitioner r4Practitioner = r4PractitionerService.createR4Practitioner(jsonObject);
                                object = r4Practitioner;
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

    void createSession() {
        sessionManager.createSession(Session.PRACTITIONERID.toString(), practitionerIdEditText.getText().toString());
        sessionManager.createSession(Session.EMAIL.toString(), emailEditText.getText().toString());
    }

    void startIntent() {
        Intent intent = new Intent(getApplicationContext(), PasswordActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }


}