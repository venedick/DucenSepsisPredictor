package com.ducen.predictor.view.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ducen.predictor.defaultdata.Session;
import com.ducen.predictor.session.SessionManagerImpl;
import com.ducen.predictor.view.MainActivity;
import com.ducen.predictor.view.R;
import com.ducen.predictor.view.main.GetStartedActivity;
import com.ducen.predictor.view.pincode.PincodeActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LoginActivity extends AppCompatActivity {

    private SessionManagerImpl sessionManager;


    boolean doubleBackToExitPressedOnce = false;

    EditText usernameEditText;
    EditText passwordEditText;
    Button loginButton, resetButton;
    ProgressBar loadingProgressBar;
    TextWatcher afterTextChangedListener;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initClasses();

        if (validateSession()) {
            Intent i = new Intent(this, PincodeActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        } else {

            setContentView(R.layout.activity_login);

            initUIComponents();

            initTextWatcher();

            initListeners();

        }

    }

    void initClasses() {
        sessionManager = new SessionManagerImpl(getApplicationContext());
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    boolean validateSession() {
        boolean flag = false;
        if (sessionManager.getBooleanSession(Session.IS_LOGIN.toString())) {
            flag = true;
            flag = true;
        }
        return flag;
    }

    void initUIComponents() {
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        loadingProgressBar = findViewById(R.id.loading);
        resetButton = findViewById(R.id.button_reset);
        resetButton.setPaintFlags(resetButton.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

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
                if (checkUser() && checkPassword()) {
                    loginButton.setEnabled(true);
                } else {
                    loginButton.setEnabled(false);
                }

            }
        };
    }

    void initListeners() {
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);

        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    validateLogin(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        passwordEditText.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (passwordEditText.getRight() - passwordEditText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        Log.d("LoginActivity", "PasswordActivity show");
                        if (passwordEditText.getTransformationMethod() == null) {
                            passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        } else {
                            passwordEditText.setTransformationMethod(null);
                        }

                        return true;
                    }
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);

                validateLogin(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResetModal();
            }
        });
    }

    boolean checkUser(){
        boolean userFlag;
        if (usernameEditText.getText().toString().isEmpty()) {
            usernameEditText.setError("Enter a valid username");
            userFlag = false;
        } else {
            usernameEditText.setError(null);
            loginButton.setEnabled(true);
            userFlag = true;
        }
        return userFlag;
    }

    boolean checkPassword(){
        boolean passFlag = false;
        if (passwordEditText.getText().toString().isEmpty() || passwordEditText.getText().toString().length() < 3) {
            passwordEditText.setError("Higher 4 alphanumeric characters");
            passFlag = false;
        } else {
            passwordEditText.setError(null);
            passFlag = true;
        }
        return passFlag;
    }

    void showResetModal() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater factory = LayoutInflater.from(this);
        View view = getLayoutInflater().inflate(R.layout.alert_reset, null);
        builder.setView(view);
        final AlertDialog alert = builder.create();
        final AlertDialog alertShow = builder.show();
        Button no = (Button) view.findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertShow.dismiss();

            }
        });
        Button yes = (Button) view.findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getApplicationContext().getExternalFilesDir(null), "ducensepsis.txt");
                Boolean isDeleted = file.delete();
                if (isDeleted) {
                    sessionManager.reset();
                    Toast.makeText(getApplicationContext(), "Reset Successfully",
                            Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), GetStartedActivity.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Reset Unsuccessfully",
                            Toast.LENGTH_LONG).show();
                }
                alertShow.dismiss();

            }
        });
    }

    void validateLogin(String username, String password) {
        try {

            File testFile = new File(this.getExternalFilesDir(null), "ducensepsis.txt");
            Log.d("Login Activity", "Check file");
            String line, user, pass;
            if (testFile != null) {
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(testFile));
                    Boolean isLoginSuccess = false;
                    while ((line = reader.readLine()) != null) {
                        user = line.split(" ")[1].toLowerCase();
                        pass = line.split(" ")[2].toLowerCase();
                        Log.d("Login Activity", "PasswordActivity " + pass + " " + Integer.toString(password.hashCode()));
                        if (user.equals(username) && pass.equals(Integer.toString(password.hashCode()))) {
                            isLoginSuccess = true;
                            break;
                        }
                    }
                    if (isLoginSuccess) {
                        Log.i("Login Activity", "Successfully Login");
                        loadingProgressBar.setVisibility(View.GONE);

                        createSession(username);

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();

                    } else {
                        Log.i("Login Activity", "Login Failed");
                        loadingProgressBar.setVisibility(View.GONE);
                        usernameEditText.setText("");
                        passwordEditText.setText("");
                        Toast.makeText(getApplicationContext(), "Login failed! Try Again",
                                Toast.LENGTH_LONG).show();
                    }
                    reader.close();
                } catch (Exception e) {
                    Log.e("Login Activity", "Unable to read the file." + e.toString());
                }
            }

        } catch (Exception e) {
            Log.e("Login Activity", "Unable to write to the file.");
        }
    }

    void createSession(String username){
        sessionManager.createLoginSession(username);
    }

}
