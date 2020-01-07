package com.ducen.predictor.model;

public class Condition {

    String condition;
    String clinicalStatus;
    String verificationStatus;
    String onsetDate;
    String abatementDate;

    public Condition(){};

    public Condition(String condition, String clinicalStatus, String verificationStatus, String onsetDate, String abatementDate) {
        this.condition = condition;
        this.clinicalStatus = clinicalStatus;
        this.verificationStatus = verificationStatus;
        this.onsetDate = onsetDate;
        this.abatementDate = abatementDate;
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

    public String getAbatementDate() {
        return abatementDate;
    }

    public void setAbatementDate(String abatementDate) {
        this.abatementDate = abatementDate;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "condition='" + condition + '\'' +
                ", clinicalStatus='" + clinicalStatus + '\'' +
                ", verificationStatus='" + verificationStatus + '\'' +
                ", onsetDate='" + onsetDate + '\'' +
                ", abatementDate='" + abatementDate + '\'' +
                '}';
    }
}
