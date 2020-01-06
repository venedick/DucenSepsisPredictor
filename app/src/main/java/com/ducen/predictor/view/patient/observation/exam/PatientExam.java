package com.ducen.predictor.view.patient.observation.exam;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ducen.predictor.view.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientExam extends Fragment {


    public PatientExam() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patient_exam, container, false);
    }

}
