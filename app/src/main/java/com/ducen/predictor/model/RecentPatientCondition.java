package com.ducen.predictor.model;

public class RecentPatientCondition {
    String condition;
    String clinicalStatus;
    String verificationStatus;
    String onsetDate;

    public RecentPatientCondition(){};

    public RecentPatientCondition(String condition, String clinicalStatus, String verificationStatus, String onsetDate) {
        this.condition = condition;
        this.clinicalStatus = clinicalStatus;
        this.verificationStatus = verificationStatus;
        this.onsetDate = onsetDate;
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

    @Override
    public String toString() {
        return "RecentPatientCondition{" +
                "condition='" + condition + '\'' +
                ", clinicalStatus='" + clinicalStatus + '\'' +
                ", verificationStatus='" + verificationStatus + '\'' +
                ", onsetDate='" + onsetDate + '\'' +
                '}';
    }
}
