package com.ducen.predictor.view.patient.patientinformation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import android.view.MenuItem;

import com.ducen.predictor.defaultdata.Session;
import com.ducen.predictor.session.SessionManagerImpl;
import com.ducen.predictor.view.MainActivity;
import com.ducen.predictor.view.R;
import com.ducen.predictor.view.login.LoginActivity;
import com.ducen.predictor.view.patient.allergy.PatientAllergyFragment;
import com.ducen.predictor.view.patient.condition.PatientConditionFragment;
import com.ducen.predictor.view.patient.medication.dispense.PatientDispenseFragment;
import com.ducen.predictor.view.patient.medication.order.PatientOrderFragment;
import com.ducen.predictor.view.patient.observation.exam.PatientExam;
import com.ducen.predictor.view.patient.observation.laboratory.PatientLaboratory;
import com.ducen.predictor.view.patient.observation.socialhistory.PatientSocialHistoryFragment;
import com.ducen.predictor.view.pincode.PincodeActivity;
import com.google.android.material.navigation.NavigationView;

public class PatientActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    private static final String TAG = "PatientActivity";

    private Handler handler;
    private Runnable r;

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
        setContentView(R.layout.activity_patient);

        Log.d("Patient Activity", "onCreate: ");

        //Get View components
        drawerLayout = findViewById(R.id.dlPatient);
        NavigationView navView = findViewById(R.id.nav_side_view);
        //Common fragment controller
        NavController navController = Navigation.findNavController(PatientActivity.this, R.id.nav_host_fragment_patient);
        //Set Navigation to controller
        NavigationUI.setupWithNavController(navView, navController);

        /*navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return false;int id = item.getItemId();
                Fragment fragment = null;
                Bundle bundle = new Bundle();
                if (id == R.id.navigation_side_patient) {
                    fragment = new PatientFragment();
                } else if (id == R.id.navigation_side_allergy) {
                    fragment = new PatientAllergyFragment();
                } else if (id == R.id.navigation_side_condition) {
                    fragment = new PatientConditionFragment();
                } else if (id == R.id.navigation_side_med_dispense) {
                    fragment = new PatientDispenseFragment();
                } else if (id == R.id.navigation_side_med_order) {
                    fragment = new PatientOrderFragment();
                } else if (id == R.id.navigation_side_obs_exam) {
                    fragment = new PatientExam();
                } else if (id == R.id.navigation_side_obs_lab) {
                    fragment = new PatientLaboratory();
                } else if (id == R.id.navigation_side_obs_social_hist) {
                    fragment = new PatientSocialHistoryFragment();
                }
                if (fragment != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });*/

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
        Log.i("Patient Activity","End Inactive User Interaction");
        handler.removeCallbacks(r);
    }
    public void startHandler() {
        Log.i("Patient Activity","Start Inactive User Interaction");
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
    private void lockScreen(){
        Log.i("Patient Activity","Lock Screen");
        Boolean log = sessionManager.getBooleanSession(Session.IS_LOGIN.toString());
        if(log){
            Log.i("Patient Activity","Visited : "+ MainActivity.class.getCanonicalName());
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
}
