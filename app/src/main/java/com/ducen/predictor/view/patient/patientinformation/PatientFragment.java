package com.ducen.predictor.view.patient.patientinformation;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ducen.predictor.model.RecentPatient;
import com.ducen.predictor.view.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientFragment extends Fragment {


    public PatientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {//Create View
        View view = inflater.inflate(R.layout.fragment_patient, container, false);
        //Get RecentPatient from intent PatientActivity

        RecentPatient patient = (RecentPatient) getActivity().getIntent().getSerializableExtra("PATIENT_INFORMATION");


        //ImgBtn
        ImageButton btn_nav_toggle = view.findViewById(R.id.img_btn_nav_toggle);

        btn_nav_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PatientActivity) getActivity()).drawerLayout.openDrawer(Gravity.LEFT);

            }
        });

        //views
        TextView patientId = view.findViewById(R.id.tv_patientId);
        TextView patientFullName = view.findViewById(R.id.tv_patientFullName);
        TextView patientFName = view.findViewById(R.id.tv_patientFirstName);
        TextView patientLName = view.findViewById(R.id.tv_patientLastName);
        TextView patientAge = view.findViewById(R.id.tv_PatientAge);
        TextView patientGender = view.findViewById(R.id.tv_PatientGender);
        TextView patientBirthDate = view.findViewById(R.id.tv_PatientBirthDate);
        TextView patientPhoneNumber = view.findViewById(R.id.tv_PatientPhone);
        TextView patientAddress = view.findViewById(R.id.tv_PatientAddress);
        TextView patientEmail = view.findViewById(R.id.tv_PatientEmail);

        assert patient != null;
        String fullName = checkNull(patient.getFullname());
        String id = checkNull(patient.getPatientId());
        String fName = checkNull(patient.getFname());
        String lName = checkNull(patient.getLname());
        String gender = checkNull(patient.getGender());
        String birthDate = checkNull(patient.getBirthDate());
        String phoneNumber = checkNull(patient.getPhoneNumber());
        String address = checkNull(patient.getAddress());
        String email = checkNull(patient.getEmail());

        //set text for views
        patientId.setText(id);
        patientFullName.setText(fullName);
        patientFName.setText(fName);
        patientLName.setText(lName);
        patientGender.setText(gender);
        patientBirthDate.setText(birthDate);
        patientPhoneNumber.setText(phoneNumber);
        patientAddress.setText(address);
        patientAddress.setText(address);
        patientEmail.setText(email);

        return view;
    }


    private String checkNull(String value) {
        if (value == null) {
            return "Default";
        } else if (value.equalsIgnoreCase("")) {
            return "Default";
        } else {
            return value;
        }
    }

}
