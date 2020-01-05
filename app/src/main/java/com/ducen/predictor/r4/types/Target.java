package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class Target {

    private CodeableConcept measure;
    private Quantity detailQuantity;
    private Range detailRange;
    private CodeableConcept detailCodeableConcept;
    private String detailString;
    private String detailBoolean;
    private String detailInteger;
    private Ratio detailRatio;
    private String dueDate;
    private String dueDuration;

    public CodeableConcept getMeasure() {
        return measure;
    }

    public void setMeasure(CodeableConcept measure) {
        this.measure = measure;
    }

    public Quantity getDetailQuantity() {
        return detailQuantity;
    }

    public void setDetailQuantity(Quantity detailQuantity) {
        this.detailQuantity = detailQuantity;
    }

    public Range getDetailRange() {
        return detailRange;
    }

    public void setDetailRange(Range detailRange) {
        this.detailRange = detailRange;
    }

    public void setDetailRatio(Ratio detailRatio) {
        this.detailRatio = detailRatio;
    }

    public CodeableConcept getDetailCodeableConcept() {
        return detailCodeableConcept;
    }

    public void setDetailCodeableConcept(CodeableConcept detailCodeableConcept) {
        this.detailCodeableConcept = detailCodeableConcept;
    }

    public String getDetailString() {
        return detailString;
    }

    public void setDetailString(String detailString) {
        this.detailString = detailString;
    }

    public String getDetailBoolean() {
        return detailBoolean;
    }

    public void setDetailBoolean(String detailBoolean) {
        this.detailBoolean = detailBoolean;
    }

    public String getDetailInteger() {
        return detailInteger;
    }

    public void setDetailInteger(String detailInteger) {
        this.detailInteger = detailInteger;
    }

    public Ratio getDetailRatio() {
        return detailRatio;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueDuration() {
        return dueDuration;
    }

    public void setDueDuration(String dueDuration) {
        this.dueDuration = dueDuration;
    }

    public Target(){

    }

    public Target(CodeableConcept measure, Quantity detailQuantity, Range detailRange, CodeableConcept detailCodeableConcept, String detailString, String detailBoolean, String detailInteger, Ratio detailRatio, String dueDate, String dueDuration) {
        this.measure = measure;
        this.detailQuantity = detailQuantity;
        this.detailRange = detailRange;
        this.detailCodeableConcept = detailCodeableConcept;
        this.detailString = detailString;
        this.detailBoolean = detailBoolean;
        this.detailInteger = detailInteger;
        this.detailRatio = detailRatio;
        this.dueDate = dueDate;
        this.dueDuration = dueDuration;
    }

    @Override
    public String toString() {
        return "Target{" +
                "measure=" + measure +
                ", detailQuantity='" + detailQuantity + '\'' +
                ", detailRange='" + detailRange + '\'' +
                ", detailCodeableConcept=" + detailCodeableConcept +
                ", detailString='" + detailString + '\'' +
                ", detailBoolean='" + detailBoolean + '\'' +
                ", detailInteger='" + detailInteger + '\'' +
                ", detailRatio='" + detailRatio + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", dueDuration='" + dueDuration + '\'' +
                '}';
    }
}


