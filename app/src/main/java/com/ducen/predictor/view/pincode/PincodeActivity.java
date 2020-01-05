package com.ducen.predictor.view.pincode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ducen.predictor.session.SessionManagerImpl;
import com.ducen.predictor.view.MainActivity;
import com.ducen.predictor.view.R;
import com.ducen.predictor.view.login.LoginActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.ducen.predictor.defaultdata.Properties.IS_LOGIN;
import static com.ducen.predictor.defaultdata.Properties.KEY_EMAIL;
import static com.ducen.predictor.defaultdata.Properties.KEY_PASSWORD;
import static com.ducen.predictor.defaultdata.Properties.KEY_PRACTITIONER;
import static com.ducen.predictor.defaultdata.Properties.SET_CODE;

public class PincodeActivity extends AppCompatActivity {

    private SessionManagerImpl sessionManager;

    private String partialCode = "";
    private String confirmCode = "";
    private String enterCode = "";
    private boolean partialFlag = false;

    private ImageView editText_one, editText_two, editText_three, editText_four;
    private TextView textView_title;
    private Button button_confirm, button_forgot;
    private LinearLayout actionBar, logo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pincode);

        initClassess();

        initUIComponents();

        initListeners();

        if (sessionManager.getBooleanSession(SET_CODE)) {

            textView_title.setText(getString(R.string.enter_pin));
            actionBar.setVisibility(View.GONE);
            logo.setVisibility(View.VISIBLE);
            button_forgot.setVisibility(View.VISIBLE);
            textView_title.setTextSize(16);

        } else {
            textView_title.setText(getString(R.string.set_pin));
            logo.setVisibility(View.GONE);
            actionBar.setVisibility(View.VISIBLE);
            button_forgot.setVisibility(View.GONE);
            textView_title.setTextSize(30);

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        File test = new File(getApplicationContext().getExternalFilesDir(null), "ducensepsis.txt");
        if (!test.exists()) {
            Log.d("PincodeActivity", "Reset Registration");
            sessionManager.reset();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

    }

    void initClassess() {
        sessionManager = new SessionManagerImpl(getApplicationContext());
    }

    void initUIComponents() {
        editText_one = findViewById(R.id.editTextone);
        editText_two = findViewById(R.id.editTexttwo);
        editText_three = findViewById(R.id.editTextthree);
        editText_four = findViewById(R.id.editTextfour);
        textView_title = findViewById(R.id.header_title);
        button_confirm = findViewById(R.id.button_confirm);
        actionBar = findViewById(R.id.actionBar);
        logo = findViewById(R.id.logo);
        button_forgot = findViewById(R.id.button_forgot);
    }

    void initListeners() {
        button_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmCode();
            }
        });

    }

    public void setCode(View v) {
        String number = v.getTag().toString();
        String screen = textView_title.getText().toString();
        Log.d("Screen", screen);

        if (screen.equalsIgnoreCase(getString(R.string.set_pin))) {

            if (number.equalsIgnoreCase("back")) {
                if (partialCode.length() > 0)
                    partialCode = partialCode.substring(0, partialCode.length() - 1);
            } else {
                partialCode = partialCode + number;
            }

            Log.d("Partial Code : ", partialCode);

            switch (partialCode.length()) {
                case 4:
                    editText_four.setImageResource(R.drawable.circle2);
                    partialFlag = true;
                    break;
                case 3:
                    editText_four.setImageResource(R.drawable.circle);
                    editText_three.setImageResource(R.drawable.circle2);
                    break;
                case 2:
                    editText_three.setImageResource(R.drawable.circle);
                    editText_two.setImageResource(R.drawable.circle2);
                    break;
                case 1:
                    editText_two.setImageResource(R.drawable.circle);
                    editText_one.setImageResource(R.drawable.circle2);
                    break;
                default:
                    editText_one.setImageResource(R.drawable.circle);
            }
        } else if (screen.equalsIgnoreCase(getString(R.string.confirm_pin))) {
            if (number.equalsIgnoreCase("back")) {
                if (confirmCode.length() > 0)
                    confirmCode = confirmCode.substring(0, confirmCode.length() - 1);
            } else {
                confirmCode = confirmCode + number;
            }

            Log.d("Confirm Code : ", confirmCode);
            Log.d("Confirm code length", Integer.toString(confirmCode.length()));
            switch (confirmCode.length()) {
                case 4:
                    editText_four.setImageResource(R.drawable.circle2);
                    break;
                case 3:
                    editText_four.setImageResource(R.drawable.circle);
                    editText_three.setImageResource(R.drawable.circle2);
                    break;
                case 2:
                    editText_three.setImageResource(R.drawable.circle);
                    editText_two.setImageResource(R.drawable.circle2);
                    break;
                case 1:
                    editText_two.setImageResource(R.drawable.circle);
                    editText_one.setImageResource(R.drawable.circle2);
                    break;
                default:
                    editText_one.setImageResource(R.drawable.circle);
            }
        } else {
            if (number.equalsIgnoreCase("back")) {
                enterCode = enterCode.substring(0, enterCode.length() - 1);
            } else {
                enterCode = enterCode + number;
            }

            Log.d("Enter Code : ", enterCode);
            Log.d("Enter code length", Integer.toString(enterCode.length()));
            switch (enterCode.length()) {
                case 4:
                    editText_four.setImageResource(R.drawable.circle2);
                    verifyCode(enterCode);
                    break;
                case 3:
                    editText_four.setImageResource(R.drawable.circle);
                    editText_three.setImageResource(R.drawable.circle2);
                    break;
                case 2:
                    editText_three.setImageResource(R.drawable.circle);
                    editText_two.setImageResource(R.drawable.circle2);
                    break;
                case 1:
                    editText_two.setImageResource(R.drawable.circle);
                    editText_one.setImageResource(R.drawable.circle2);
                    break;
                default:
                    editText_one.setImageResource(R.drawable.circle);
            }
        }

        if (partialFlag) {
            Log.d("Partial Code", "Set " + partialCode);
            textView_title.setText(getString(R.string.confirm_pin));
            editText_one.setImageResource(R.drawable.circle);
            editText_two.setImageResource(R.drawable.circle);
            editText_three.setImageResource(R.drawable.circle);
            editText_four.setImageResource(R.drawable.circle);
            button_confirm.setVisibility(View.VISIBLE);
            partialFlag = false;
        }

    }

    void confirmCode() {
        Log.d("Pincode Activity", "Confirm Code - " + confirmCode);
        if (partialCode.equals(confirmCode)) {
            verifyCode(confirmCode);
            textView_title.setText(getString(R.string.set_pin));
            partialCode = "";
            confirmCode = "";
        } else {
            Toast.makeText(getApplicationContext(), "Code didn't match!", Toast.LENGTH_SHORT).show();
            partialCode = "";
            confirmCode = "";
            textView_title.setText(getString(R.string.set_pin));
            this.recreate();
        }
    }

    void verifyCode(String code) {
        try {
            String id = sessionManager.getStringSession(KEY_PRACTITIONER);
            String email = sessionManager.getStringSession(KEY_EMAIL);
            String username = email.substring(0, email.indexOf("@"));
            String password = sessionManager.getStringSession(KEY_PASSWORD);
            Boolean setCode = sessionManager.getBooleanSession(SET_CODE);
            Log.d("Pincode Activity", email + " " + username + " " + password + " " + setCode);
            File file = new File(getApplicationContext().getExternalFilesDir(null), "ducensepsis.txt");
            Log.d("Pincode Activity", "Verify code");
            if (setCode) {
                Log.d("Pincode Activity", "Check Code");
                String line;
                Boolean flag = false;
                if (file != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    BufferedReader reader = null;
                    try {
                        reader = new BufferedReader(new FileReader(file));
                        while ((line = reader.readLine()) != null) {
                            String pin = line.split(" ")[3].toLowerCase();
                            Log.d("Code", pin);
                            Log.d("Input Code", Integer.toString(pin.hashCode()));
                            if (pin.equals(Integer.toString(code.hashCode()))) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            Log.i("Login", "Code is correct");
                            sessionManager.createSession(IS_LOGIN, true);
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Log.i("Login", "Code is wrong");
                            enterCode = "";
                            editText_one.setImageResource(R.drawable.circle);
                            editText_two.setImageResource(R.drawable.circle);
                            editText_three.setImageResource(R.drawable.circle);
                            editText_four.setImageResource(R.drawable.circle);
                            Toast.makeText(getApplicationContext(), "Incorrect Pin !! Try Again!", Toast.LENGTH_SHORT).show();
                        }
                        reader.close();
                    } catch (Exception e) {
                        Log.e("ReadWriteFile", "Unable to read the login.txt file." + e.toString());
                    }
                }
            } else {
                Log.d("Pincode Activity", "Add code");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, false /*append*/));
                writer.write(id + " " + username + " " + password.hashCode() + " " + code.hashCode() + " \n");
                writer.close();
                MediaScannerConnection.scanFile(this,
                        new String[]{file.toString()},
                        null,
                        null);

                createSession();

                startIntent();

            }

        } catch (IOException e) {
            Log.e("ReadWriteFile", "Unable to write to the login.txt file.");
        } catch (Exception e) {
        }
    }

    void createSession() {
        sessionManager.createSession(SET_CODE, true);
    }

    void startIntent() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

}
