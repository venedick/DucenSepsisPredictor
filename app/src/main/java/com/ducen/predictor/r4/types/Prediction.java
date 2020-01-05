package com.ducen.predictor.r4.types;

public class Prediction {

    private CodeableConcept outcome;
    private String probabilityDecimal;
    private Range probabilityRange;
    private CodeableConcept qualitativeRisk;
    private String relativeRisk;
    private Period whenPeriod;
    private Range whenRange;
    private String rationale;

    public Prediction(){

    }

    public Prediction(CodeableConcept outcome, String probabilityDecimal, Range probabilityRange, CodeableConcept qualitativeRisk,String relativeRisk, Period whenPeriod, Range whenRange, String rationale) {
        this.outcome = outcome;
        this.probabilityDecimal = probabilityDecimal;
        this.probabilityRange = probabilityRange;
        this.qualitativeRisk = qualitativeRisk;
        this.relativeRisk = relativeRisk;
        this.whenPeriod = whenPeriod;
        this.whenRange = whenRange;
        this.rationale = rationale;
    }

    public CodeableConcept getOutcome() {
        return outcome;
    }

    public void setOutcome(CodeableConcept outcome) {
        this.outcome = outcome;
    }

    public String getProbabilityDecimal() {
        return probabilityDecimal;
    }

    public void setProbabilityDecimal(String probabilityDecimal) {
        this.probabilityDecimal = probabilityDecimal;
    }

    public Range getProbabilityRange() {
        return probabilityRange;
    }

    public void setProbabilityRange(Range probabilityRange) {
        this.probabilityRange = probabilityRange;
    }

    public CodeableConcept getQualitativeRisk() {
        return qualitativeRisk;
    }

    public void setQualitativeRisk(CodeableConcept qualitativeRisk) {
        this.qualitativeRisk = qualitativeRisk;
    }

    public String getRelativeRisk() {
        return relativeRisk;
    }

    public void setRelativeRisk(String relativeRisk) {
        this.relativeRisk = relativeRisk;
    }

    public Period getWhenPeriod() {
        return whenPeriod;
    }

    public void setWhenPeriod(Period whenPeriod) {
        this.whenPeriod = whenPeriod;
    }

    public Range getWhenRange() {
        return whenRange;
    }

    public void setWhenRange(Range whenRange) {
        this.whenRange = whenRange;
    }

    public String getRationale() {
        return rationale;
    }

    public void setRationale(String rationale) {
        this.rationale = rationale;
    }

    @Override
    public String toString() {
        return "Prediction{" +
                "outcome=" + outcome +
                ", probabilityDecimal='" + probabilityDecimal + '\'' +
                ", probabilityRange=" + probabilityRange +
                ", qualitativeRisk=" + qualitativeRisk +
                ", relativeRisk='" + relativeRisk + '\'' +
                ", whenPeriod=" + whenPeriod +
                ", whenRange=" + whenRange +
                ", rationale='" + rationale + '\'' +
                '}';
    }
}
