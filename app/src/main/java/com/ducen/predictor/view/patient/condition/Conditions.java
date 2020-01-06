package com.ducen.predictor.view.patient.condition;

import com.ducen.predictor.model.Condition;

public class Conditions {

    public Condition[] getCondition() {
        Condition[] data = new Condition[5];
        for(int i = 0; i < 5; i ++) {
            Condition row = new Condition();
            row.setCondition("Visual Disturbance");
            row.setClinicalStatus("Active");
            row.setVerificationStatus("Confirmed");
            row.setOnsetDate("01/06/2020");
            data[i] = row;
        }
        return data;
    }

}
