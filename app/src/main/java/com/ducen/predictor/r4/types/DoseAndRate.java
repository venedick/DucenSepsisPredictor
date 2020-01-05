package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class DoseAndRate {

    private CodeableConcept type;
    private String doseRange;
    private Quantity doseQuantity;
    private Ratio rateRatio;
    private Range rateRange;
    private Quantity rateQuantity;

    public CodeableConcept getType() {
        return type;
    }

    public void setType(CodeableConcept type) {
        this.type = type;
    }

    public String getDoseRange() {
        return doseRange;
    }

    public void setDoseRange(String doseRange) {
        this.doseRange = doseRange;
    }

    public Quantity getDoseQuantity() {
        return doseQuantity;
    }

    public void setDoseQuantity(Quantity doseQuantity) {
        this.doseQuantity = doseQuantity;
    }

    public Ratio getRateRatio() {
        return rateRatio;
    }

    public void setRateRatio(Ratio rateRatio) {
        this.rateRatio = rateRatio;
    }

    public Range getRateRange() {
        return rateRange;
    }

    public void setRateRange(Range rateRange) {
        this.rateRange = rateRange;
    }

    public Quantity getRateQuantity() {
        return rateQuantity;
    }

    public void setRateQuantity(Quantity rateQuantity) {
        this.rateQuantity = rateQuantity;
    }

    public DoseAndRate(){

    }

    public DoseAndRate(CodeableConcept type, String doseRange, Quantity doseQuantity, Ratio rateRatio, Range rateRange, Quantity rateQuantity) {
        this.type = type;
        this.doseRange = doseRange;
        this.doseQuantity = doseQuantity;
        this.rateRatio = rateRatio;
        this.rateRange = rateRange;
        this.rateQuantity = rateQuantity;
    }

    @Override
    public String toString() {
        return "DoseAndRate{" +
                "type=" + type +
                ", doseRange='" + doseRange + '\'' +
                ", doseQuantity=" + doseQuantity +
                ", rateRatio=" + rateRatio +
                ", rateRange=" + rateRange +
                ", rateQuantity=" + rateQuantity +
                '}';
    }
}


