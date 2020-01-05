package com.ducen.predictor.view.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.ducen.predictor.view.R;
import com.google.android.material.navigation.NavigationView;

public class PatientActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    private static final String TAG = "PatientActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        Log.d(TAG, "onCreate: ");

        //Get View components
        drawerLayout = findViewById(R.id.dlPatient);
        NavigationView navView = findViewById(R.id.nav_side_view);
        //Common fragment controller
        NavController navController = Navigation.findNavController(PatientActivity.this, R.id.nav_host_fragment_patient);
        //Set Navigation to controller
        NavigationUI.setupWithNavController(navView, navController);
    }
}
