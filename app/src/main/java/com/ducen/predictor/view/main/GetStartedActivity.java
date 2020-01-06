package com.ducen.predictor.view.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ducen.predictor.defaultdata.ServerAddress;
import com.ducen.predictor.defaultdata.Session;
import com.ducen.predictor.session.SessionManagerImpl;
import com.ducen.predictor.view.R;
import com.ducen.predictor.view.login.LoginActivity;
import com.ducen.predictor.view.verify.EmailVerificationActivity;

import java.io.File;


public class GetStartedActivity extends AppCompatActivity {

    private SessionManagerImpl sessionManager;

    public SessionManagerImpl getSessionManager() {
        return sessionManager;
    }

    public void setSessionManager(SessionManagerImpl sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = new SessionManagerImpl(getApplicationContext());
        File file = new File(this.getExternalFilesDir(null), "ducensepsis.txt");
        if(file.exists()){
            Intent i = new Intent(this, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }else{
            setContentView(R.layout.activity_get_started);
            Button started = findViewById(R.id.btn_started);

            started.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), EmailVerificationActivity.class);
                    sessionManager.createSession(Session.BASE_SERVER.toString(), ServerAddress.R4_BASE_URL.toString());
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();
                }
            });

        }
    }
}
