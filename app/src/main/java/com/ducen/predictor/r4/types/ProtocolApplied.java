package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class ProtocolApplied {

    private String series;
    private Reference authority;
    private List<CodeableConcept> targetDisease;
    private String doseNumberPositiveInt;
    private String doseNumberPositiveString;
    private String seriesDosesPositiveInt;
    private String seriesDosesPositiveString;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Reference getAuthority() {
        return authority;
    }

    public void setAuthority(Reference authority) {
        this.authority = authority;
    }

    public List<CodeableConcept> getTargetDisease() {
        return targetDisease;
    }

    public void setTargetDisease(List<CodeableConcept> targetDisease) {
        this.targetDisease = targetDisease;
    }

    public String getDoseNumberPositiveInt() {
        return doseNumberPositiveInt;
    }

    public void setDoseNumberPositiveInt(String doseNumberPositiveInt) {
        this.doseNumberPositiveInt = doseNumberPositiveInt;
    }

    public String getDoseNumberPositiveString() {
        return doseNumberPositiveString;
    }

    public void setDoseNumberPositiveString(String doseNumberPositiveString) {
        this.doseNumberPositiveString = doseNumberPositiveString;
    }

    public String getSeriesDosesPositiveInt() {
        return seriesDosesPositiveInt;
    }

    public void setSeriesDosesPositiveInt(String seriesDosesPositiveInt) {
        this.seriesDosesPositiveInt = seriesDosesPositiveInt;
    }

    public String getSeriesDosesPositiveString() {
        return seriesDosesPositiveString;
    }

    public void setSeriesDosesPositiveString(String seriesDosesPositiveString) {
        this.seriesDosesPositiveString = seriesDosesPositiveString;
    }

    public ProtocolApplied(){

    }

    public ProtocolApplied(String series, Reference authority, List<CodeableConcept> targetDisease, String doseNumberPositiveInt, String doseNumberPositiveString, String seriesDosesPositiveInt, String seriesDosesPositiveString) {
        this.series = series;
        this.authority = authority;
        this.targetDisease = targetDisease;
        this.doseNumberPositiveInt = doseNumberPositiveInt;
        this.doseNumberPositiveString = doseNumberPositiveString;
        this.seriesDosesPositiveInt = seriesDosesPositiveInt;
        this.seriesDosesPositiveString = seriesDosesPositiveString;
    }

    @Override
    public String toString() {
        return "ProtocolApplied{" +
                "series='" + series + '\'' +
                ", authority=" + authority +
                ", targetDisease=" + targetDisease +
                ", doseNumberPositiveInt='" + doseNumberPositiveInt + '\'' +
                ", doseNumberPositiveString='" + doseNumberPositiveString + '\'' +
                ", seriesDosesPositiveInt='" + seriesDosesPositiveInt + '\'' +
                ", seriesDosesPositiveString='" + seriesDosesPositiveString + '\'' +
                '}';
    }
}



