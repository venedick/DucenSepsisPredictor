package com.ducen.predictor.model;

public class Condition {

    String condition;
    String clinicalStatus;
    String verificationStatus;
    String onsetDate;
    String abatementDateTime;

    public Condition(){};

    public Condition(String condition, String clinicalStatus, String verificationStatus, String onsetDate, String abatementDateTime) {
        this.condition = condition;
        this.clinicalStatus = clinicalStatus;
        this.verificationStatus = verificationStatus;
        this.onsetDate = onsetDate;
        this.abatementDateTime = abatementDateTime;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getClinicalStatus() {
        return clinicalStatus;
    }

    public void setClinicalStatus(String clinicalStatus) {
        this.clinicalStatus = clinicalStatus;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getOnsetDate() {
        return onsetDate;
    }

    public void setOnsetDate(String onsetDate) {
        this.onsetDate = onsetDate;
    }

    public String getAbatementDateTime() {
        return abatementDateTime;
    }

    public void setAbatementDateTime(String abatementDateTime) {
        this.abatementDateTime = abatementDateTime;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "condition='" + condition + '\'' +
                ", clinicalStatus='" + clinicalStatus + '\'' +
                ", verificationStatus='" + verificationStatus + '\'' +
                ", onsetDate='" + onsetDate + '\'' +
                ", abatementDateTime='" + abatementDateTime + '\'' +
                '}';
    }
}