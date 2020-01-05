package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class Hospitalization {

    private Identifier preAdmissionIdentifier;
    private Reference origin;
    private CodeableConcept admitSource;
    private CodeableConcept reAdmission;
    private List<CodeableConcept> dietPreference;
    private List<CodeableConcept> specialCourtesy;
    private List<CodeableConcept> specialArrangement;
    private Reference destination;
    private CodeableConcept dischargeDisposition;

    public Identifier getPreAdmissionIdentifier() {
        return preAdmissionIdentifier;
    }

    public void setPreAdmissionIdentifier(Identifier preAdmissionIdentifier) {
        this.preAdmissionIdentifier = preAdmissionIdentifier;
    }

    public Reference getOrigin() {
        return origin;
    }

    public void setOrigin(Reference origin) {
        this.origin = origin;
    }

    public CodeableConcept getAdmitSource() {
        return admitSource;
    }

    public void setAdmitSource(CodeableConcept admitSource) {
        this.admitSource = admitSource;
    }

    public CodeableConcept getReAdmission() {
        return reAdmission;
    }

    public void setReAdmission(CodeableConcept reAdmission) {
        this.reAdmission = reAdmission;
    }

    public List<CodeableConcept> getDietPreference() {
        return dietPreference;
    }

    public void setDietPreference(List<CodeableConcept> dietPreference) {
        this.dietPreference = dietPreference;
    }

    public List<CodeableConcept> getSpecialCourtesy() {
        return specialCourtesy;
    }

    public void setSpecialCourtesy(List<CodeableConcept> specialCourtesy) {
        this.specialCourtesy = specialCourtesy;
    }

    public List<CodeableConcept> getSpecialArrangement() {
        return specialArrangement;
    }

    public void setSpecialArrangement(List<CodeableConcept> specialArrangement) {
        this.specialArrangement = specialArrangement;
    }

    public Reference getDestination() {
        return destination;
    }

    public void setDestination(Reference destination) {
        this.destination = destination;
    }

    public CodeableConcept getDischargeDisposition() {
        return dischargeDisposition;
    }

    public void setDischargeDisposition(CodeableConcept dischargeDisposition) {
        this.dischargeDisposition = dischargeDisposition;
    }

    public Hospitalization() {

    }

    public Hospitalization(Identifier preAdmissionIdentifier, Reference origin, CodeableConcept admitSource, CodeableConcept reAdmission, List<CodeableConcept> dietPreference, List<CodeableConcept> specialCourtesy, List<CodeableConcept> specialArrangement, Reference destination, CodeableConcept dischargeDisposition) {
        this.preAdmissionIdentifier = preAdmissionIdentifier;
        this.origin = origin;
        this.admitSource = admitSource;
        this.reAdmission = reAdmission;
        this.dietPreference = dietPreference;
        this.specialCourtesy = specialCourtesy;
        this.specialArrangement = specialArrangement;
        this.destination = destination;
        this.dischargeDisposition = dischargeDisposition;
    }

    @Override
    public String toString() {
        return "Hospitalization{" +
                "preAdmissionIdentifier=" + preAdmissionIdentifier +
                ", origin=" + origin +
                ", admitSource=" + admitSource +
                ", reAdmission=" + reAdmission +
                ", dietPreference=" + dietPreference +
                ", specialCourtesy=" + specialCourtesy +
                ", specialArrangement=" + specialArrangement +
                ", destination=" + destination +
                ", dischargeDisposition=" + dischargeDisposition +
                '}';
    }
}
