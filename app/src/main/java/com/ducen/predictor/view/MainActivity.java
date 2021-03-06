package com.ducen.predictor.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.ducen.predictor.defaultdata.Session;
import com.ducen.predictor.session.SessionManagerImpl;
import com.ducen.predictor.view.login.LoginActivity;
import com.ducen.predictor.view.pincode.PincodeActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Timer;


public class MainActivity extends AppCompatActivity {

    private SessionManagerImpl sessionManager;
    boolean doubleBackToExitPressedOnce = false;
    private Timer timer;
    private Handler handler;
    private Runnable r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManager = new SessionManagerImpl(getApplicationContext());
        //Navigation
        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_dashboard);
        NavigationUI.setupWithNavController(navView, navController);

        handler = new Handler();
        r = new Runnable() {

            @Override
            public void run() {
                lockScreen();
            }
        };
        startHandler();

    }
    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        stopHandler();
        startHandler();
    }
    public void stopHandler() {
        Log.i("Main Activity","End Inactive User Interaction");
        handler.removeCallbacks(r);
    }
    public void startHandler() {
        Log.i("Main Activity","Start Inactive User Interaction");
        handler.postDelayed(r, 3*60*1000);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        boolean isScreenOn;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            isScreenOn = powerManager.isInteractive();
        } else {
            isScreenOn = powerManager.isScreenOn();
        }

        if (!isScreenOn) {
            lockScreen();
        }
    }

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


    private void lockScreen(){
        Log.i("Main Activity","Lock Screen");
        Boolean log = sessionManager.getBooleanSession(Session.IS_LOGIN.toString());
        if(log){
            Log.i("Main Activity","Visited : "+ MainActivity.class.getCanonicalName());
            sessionManager.createSession(Session.LAST_VISIT.toString(),true);
            Intent i = new Intent(getApplicationContext(), PincodeActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }else{
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }
    }

    private String getPractitionerId(){
        String practitionerId = "";
        try {
            File testFile = new File(this.getExternalFilesDir(null), "ducensepsis.txt");
            Log.d("Main Activity", "Get practitionerid");
            String line,server;
            if (testFile != null) {
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(testFile));
                    while ((line = reader.readLine()) != null) {
                        practitionerId = line.split(" ")[0];
                        Log.d("Main Activity", "Server Address : " + practitionerId);
                    }
                    reader.close();
                } catch (Exception e) {
                    Log.e("Main Activity", "Unable to read the file." + e.toString());
                }
            }

        } catch (Exception e) {
            Log.e("Main Activity", "Unable to write to the file.");
        }

        return practitionerId;
    }


}