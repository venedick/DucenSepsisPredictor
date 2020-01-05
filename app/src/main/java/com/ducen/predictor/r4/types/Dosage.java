package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class Dosage {

    private String sequence;
    private String text;
    private List<CodeableConcept> additionalInstruction;
    private String patientInstruction;
    private Timing timing;
    private String asNeededBoolean;
    private CodeableConcept asNeededCodeableConcept;
    private CodeableConcept site;
    private CodeableConcept route;
    private CodeableConcept method;
    private List<DoseAndRate> doseAndRate;
    private Ratio maxDosePerPeriod;
    private Quantity maxDosePerAdministration;
    private Quantity maxDosePerLifetime;
    private Quantity dose;
    private Ratio rateRatio;
    private Quantity rateQuantity;

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<CodeableConcept> getAdditionalInstruction() {
        return additionalInstruction;
    }

    public void setAdditionalInstruction(List<CodeableConcept> additionalInstruction) {
        this.additionalInstruction = additionalInstruction;
    }

    public String getPatientInstruction() {
        return patientInstruction;
    }

    public void setPatientInstruction(String patientInstruction) {
        this.patientInstruction = patientInstruction;
    }

    public Timing getTiming() {
        return timing;
    }

    public void setTiming(Timing timing) {
        this.timing = timing;
    }

    public String getAsNeededBoolean() {
        return asNeededBoolean;
    }

    public void setAsNeededBoolean(String asNeededBoolean) {
        this.asNeededBoolean = asNeededBoolean;
    }

    public CodeableConcept getAsNeededCodeableConcept() {
        return asNeededCodeableConcept;
    }

    public void setAsNeededCodeableConcept(CodeableConcept asNeededCodeableConcept) {
        this.asNeededCodeableConcept = asNeededCodeableConcept;
    }

    public CodeableConcept getSite() {
        return site;
    }

    public void setSite(CodeableConcept site) {
        this.site = site;
    }

    public CodeableConcept getRoute() {
        return route;
    }

    public void setRoute(CodeableConcept route) {
        this.route = route;
    }

    public CodeableConcept getMethod() {
        return method;
    }

    public void setMethod(CodeableConcept method) {
        this.method = method;
    }

    public List<DoseAndRate> getDoseAndRate() {
        return doseAndRate;
    }

    public void setDoseAndRate(List<DoseAndRate> doseAndRate) {
        this.doseAndRate = doseAndRate;
    }

    public Ratio getMaxDosePerPeriod() {
        return maxDosePerPeriod;
    }

    public void setMaxDosePerPeriod(Ratio maxDosePerPeriod) {
        this.maxDosePerPeriod = maxDosePerPeriod;
    }

    public Quantity getMaxDosePerAdministration() {
        return maxDosePerAdministration;
    }

    public void setMaxDosePerAdministration(Quantity maxDosePerAdministration) {
        this.maxDosePerAdministration = maxDosePerAdministration;
    }

    public Quantity getMaxDosePerLifetime() {
        return maxDosePerLifetime;
    }

    public void setMaxDosePerLifetime(Quantity maxDosePerLifetime) {
        this.maxDosePerLifetime = maxDosePerLifetime;
    }

    public Quantity getDose() {
        return dose;
    }

    public void setDose(Quantity dose) {
        this.dose = dose;
    }

    public Ratio getRateRatio() {
        return rateRatio;
    }

    public void setRateRatio(Ratio rateRatio) {
        this.rateRatio = rateRatio;
    }

    public Quantity getRateQuantity() {
        return rateQuantity;
    }

    public void setRateQuantity(Quantity rateQuantity) {
        this.rateQuantity = rateQuantity;
    }

    public Dosage(){

    }

    public Dosage(String sequence, String text, List<CodeableConcept> additionalInstruction, String patientInstruction, Timing timing, String asNeededBoolean, CodeableConcept asNeededCodeableConcept, CodeableConcept site, CodeableConcept route, CodeableConcept method, List<DoseAndRate> doseAndRate, Ratio maxDosePerPeriod, Quantity maxDosePerAdministration, Quantity maxDosePerLifetime, Quantity dose, Ratio rateRatio, Quantity rateQuantity) {
        this.sequence = sequence;
        this.text = text;
        this.additionalInstruction = additionalInstruction;
        this.patientInstruction = patientInstruction;
        this.timing = timing;
        this.asNeededBoolean = asNeededBoolean;
        this.asNeededCodeableConcept = asNeededCodeableConcept;
        this.site = site;
        this.route = route;
        this.method = method;
        this.doseAndRate = doseAndRate;
        this.maxDosePerPeriod = maxDosePerPeriod;
        this.maxDosePerAdministration = maxDosePerAdministration;
        this.maxDosePerLifetime = maxDosePerLifetime;
        this.dose = dose;
        this.rateRatio = rateRatio;
        this.rateQuantity = rateQuantity;
    }

    @Override
    public String toString() {
        return "Dosage{" +
                "sequence='" + sequence + '\'' +
                ", text='" + text + '\'' +
                ", additionalInstruction=" + additionalInstruction +
                ", patientInstruction='" + patientInstruction + '\'' +
                ", timing=" + timing +
                ", asNeededBoolean='" + asNeededBoolean + '\'' +
                ", asNeededCodeableConcept=" + asNeededCodeableConcept +
                ", site=" + site +
                ", route=" + route +
                ", method=" + method +
                ", doseAndRate=" + doseAndRate +
                ", maxDosePerPeriod=" + maxDosePerPeriod +
                ", maxDosePerAdministration=" + maxDosePerAdministration +
                ", maxDosePerLifetime=" + maxDosePerLifetime +
                '}';
    }
}
