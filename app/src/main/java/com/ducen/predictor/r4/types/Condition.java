package com.ducen.predictor.r4.types;

import com.ducen.predictor.view.R;

import java.util.List;

public class Condition {

    private CodeableConcept code;
    private CodeableConcept outcome;
    private String contributedToDeath;
    private String onSetAge;
    private Range onSetRange;
    private Period onSetPeriod;
    private String onSetString;
    private List<Annotation> note;

    public Condition(){

    }
    public Condition(CodeableConcept code, CodeableConcept outcome, String contributedToDeath, String onSetAge, Range onSetRange, Period onSetPeriod, String onSetString, List<Annotation> note) {
        this.code = code;
        this.outcome = outcome;
        this.contributedToDeath = contributedToDeath;
        this.onSetAge = onSetAge;
        this.onSetRange = onSetRange;
        this.onSetPeriod = onSetPeriod;
        this.onSetString = onSetString;
        this.note = note;
    }

    public CodeableConcept getCode() {
        return code;
    }

    public void setCode(CodeableConcept code) {
        this.code = code;
    }

    public CodeableConcept getOutcome() {
        return outcome;
    }

    public void setOutcome(CodeableConcept outcome) {
        this.outcome = outcome;
    }

    public String getContributedToDeath() {
        return contributedToDeath;
    }

    public void setContributedToDeath(String contributedToDeath) {
        this.contributedToDeath = contributedToDeath;
    }

    public String getOnSetAge() {
        return onSetAge;
    }

    public void setOnSetAge(String onSetAge) {
        this.onSetAge = onSetAge;
    }

    public Range getOnSetRange() {
        return onSetRange;
    }

    public void setOnSetRange(Range onSetRange) {
        this.onSetRange = onSetRange;
    }

    public Period getOnSetPeriod() {
        return onSetPeriod;
    }

    public void setOnSetPeriod(Period onSetPeriod) {
        this.onSetPeriod = onSetPeriod;
    }

    public String getOnSetString() {
        return onSetString;
    }

    public void setOnSetString(String onSetString) {
        this.onSetString = onSetString;
    }

    public List<Annotation> getNote() {
        return note;
    }

    public void setNote(List<Annotation> note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "code=" + code +
                ", outcome=" + outcome +
                ", contributedToDeath='" + contributedToDeath + '\'' +
                ", onSetAge='" + onSetAge + '\'' +
                ", onSetRange='" + onSetRange + '\'' +
                ", onSetPeriod='" + onSetPeriod + '\'' +
                ", onSetString='" + onSetString + '\'' +
                ", note=" + note +
                '}';
    }
}
