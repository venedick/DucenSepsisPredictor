package com.ducen.predictor.view.patient.condition;

import com.ducen.predictor.model.RecentPatientCondition;

public class Conditions {
    public RecentPatientCondition[] getCondition() {
        RecentPatientCondition[] data = new RecentPatientCondition[5];
        for(int i = 0; i < 5; i ++) {
            RecentPatientCondition row = new RecentPatientCondition();
            row.setCondition("Visual Disturbance");
            row.setClinicalStatus("Active");
            row.setVerificationStatus("Confirmed");
            row.setOnsetDate("01/06/2020");
            data[i] = row;
        }
        return data;
    }
}
