package com.ducen.predictor.view.password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import static com.ducen.predictor.defaultdata.Properties.KEY_PASSWORD;

import com.ducen.predictor.session.SessionManagerImpl;
import com.ducen.predictor.view.R;
import com.ducen.predictor.view.main.GetStartedActivity;
import com.ducen.predictor.view.pincode.PincodeActivity;

public class PasswordActivity extends AppCompatActivity {

    //session
    private SessionManagerImpl sessionManager;

    //ui elements
    EditText passwordEditText;
    EditText confirmEditText;
    Button nextButton;
    ProgressBar loadingProgressBar;
    TextWatcher afterTextChangedListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        initClasses();
        initUIComponents();
        initTextWatcher();
        initListeners();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (sessionManager.getStringSession(KEY_PASSWORD).equalsIgnoreCase(null)) {
            Log.d("PasswordActivity", "Reset Registration");
            sessionManager.reset();
            startActivity(new Intent(getApplicationContext(), GetStartedActivity.class));
        }
    }

    void initClasses() {
        sessionManager = new SessionManagerImpl(getApplicationContext());
    }

    void initUIComponents() {
        passwordEditText = findViewById(R.id.editText_password);
        confirmEditText = findViewById(R.id.editText_confirm);
        nextButton = findViewById(R.id.button_next);
        loadingProgressBar = findViewById(R.id.loading);
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
                if (checkPassword() && checkConfirmPassword()) {
                    nextButton.setEnabled(true);
                } else {
                    nextButton.setEnabled(false);
                }

            }
        };
    }

    void initListeners() {
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        confirmEditText.addTextChangedListener(afterTextChangedListener);

        confirmEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Log.d("Password Activity", "Set password");
                    sessionManager.createSession(KEY_PASSWORD, passwordEditText.getText().toString());
                    startActivity(new Intent(getApplicationContext(), PincodeActivity.class));
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
                        Log.d("PasswordActivity", "Password show");
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
        confirmEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (confirmEditText.getRight() - confirmEditText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        Log.d("PasswordActivity", "Confirm show");
                        if (confirmEditText.getTransformationMethod() == null) {
                            confirmEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        } else {
                            confirmEditText.setTransformationMethod(null);
                        }

                        return true;
                    }
                }
                return false;
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Password Activity", "Set password");

                createSession();
                startIntent();
            }
        });
    }

    boolean checkPassword(){
        boolean passFlag = false;
        if (passwordEditText.getText().toString().isEmpty() || passwordEditText.getText().toString().length() < 4) {
            passwordEditText.setError("Password too short");
            passFlag = false;
        } else {
            passwordEditText.setError(null);
            passwordEditText.setEnabled(true);
            passFlag = true;
        }
        return passFlag;
    }

    boolean checkConfirmPassword(){
        boolean confirmFlag = false;
        if (confirmEditText.getText().toString().isEmpty() || !confirmEditText.getText().toString().equals(passwordEditText.getText().toString())) {
            confirmEditText.setError("Password didn't match");
            confirmFlag = false;
        } else {
            confirmEditText.setError(null);
            confirmFlag = true;
        }
        return confirmFlag;
    }

    void createSession(){
        sessionManager.createSession(KEY_PASSWORD, passwordEditText.getText().toString());
    }

    void startIntent(){
        Intent intent = new Intent(getApplicationContext(), PincodeActivity.class);
        startActivity(intent);
    }

}
