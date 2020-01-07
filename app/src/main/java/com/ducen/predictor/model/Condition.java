package com.ducen.predictor.model;

public class Condition {

    String clinicalStatus;
    String verificationStatus;
    String condition;
    String onsetDate;
    String abatementDate;
    String bodySite;
    String severity;


    public Condition() {
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

    public String getBodySite() {
        return bodySite;
    }

    public void setBodySite(String bodySite) {
        this.bodySite = bodySite;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }


    @Override
    public String toString() {
        return "Condition{" +
                "clinicalStatus='" + clinicalStatus + '\'' +
                ", verificationStatus='" + verificationStatus + '\'' +
                ", condition='" + condition + '\'' +
                ", onsetDate='" + onsetDate + '\'' +
                ", abatementDate='" + abatementDate + '\'' +
                ", bodySite='" + bodySite + '\'' +
                ", severity='" + severity + '\'' +
                '}';
    }
}
