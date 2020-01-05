package com.ducen.predictor.view.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ducen.predictor.view.R;
import com.ducen.predictor.view.login.LoginActivity;
import com.ducen.predictor.view.verify.EmailVerificationActivity;

import java.io.File;

public class GetStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();
                }
            });

        }
    }
}
