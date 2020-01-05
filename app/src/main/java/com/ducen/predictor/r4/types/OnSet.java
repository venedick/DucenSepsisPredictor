package com.ducen.predictor.r4.types;

//get from R4 datatypes
public class OnSet {

    private String onsetDateTime;
    private String onsetAge;
    private Period onsetPeriod;
    private String onsetRange;
    private String onsetString;

    public String getOnsetDateTime() {
        return onsetDateTime;
    }

    public void setOnsetDateTime(String onsetDateTime) {
        this.onsetDateTime = onsetDateTime;
    }

    public String getOnsetAge() {
        return onsetAge;
    }

    public void setOnsetAge(String onsetAge) {
        this.onsetAge = onsetAge;
    }

    public Period getOnsetPeriod() {
        return onsetPeriod;
    }

    public void setOnsetPeriod(Period onsetPeriod) {
        this.onsetPeriod = onsetPeriod;
    }

    public String getOnsetRange() {
        return onsetRange;
    }

    public void setOnsetRange(String onsetRange) {
        this.onsetRange = onsetRange;
    }

    public String getOnsetString() {
        return onsetString;
    }

    public void setOnsetString(String onsetString) {
        this.onsetString = onsetString;
    }

    public OnSet() {

    }

    public OnSet(String onsetDateTime, String onsetAge, Period onsetPeriod, String onsetRange, String onsetString) {
        this.onsetDateTime = onsetDateTime;
        this.onsetAge = onsetAge;
        this.onsetPeriod = onsetPeriod;
        this.onsetRange = onsetRange;
        this.onsetString = onsetString;
    }

    @Override
    public String toString() {
        return "OnSet{" +
                "onsetDateTime='" + onsetDateTime + '\'' +
                ", onsetAge='" + onsetAge + '\'' +
                ", onsetPeriod='" + onsetPeriod + '\'' +
                ", onsetRange='" + onsetRange + '\'' +
                ", onsetString='" + onsetString + '\'' +
                '}';
    }
}
