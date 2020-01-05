package com.ducen.predictor.r4.entity;

import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Dosage;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class R4MedicationStatement {

    private Meta meta;
    private List<Identifier> identifier;
    private List<Reference> basedOn;
    private List<Reference> partOf;
    private String status;
    private List<CodeableConcept> statusReason;
    private CodeableConcept category;
    private CodeableConcept medicationCodeableConcept;
    private Reference medicationReference;
    private Reference subject;
    private Reference context;
    private String effectiveDateTime;
    private Period effectivePeriod;
    private String dateAsserted;
    private Reference informationSource;
    private List<Reference> derivedFrom;
    private List<CodeableConcept> reasonCode;
    private List<Reference> reasonReference;
    private List<Annotation> note;
    private List<Dosage> dosage;

    public R4MedicationStatement(){

    }

    public R4MedicationStatement(Meta meta, List<Identifier> identifier, List<Reference> basedOn, List<Reference> partOf, String status, List<CodeableConcept> statusReason, CodeableConcept category, CodeableConcept medicationCodeableConcept, Reference medicationReference, Reference subject, Reference context, String effectiveDateTime, Period effectivePeriod, String dateAsserted, Reference informationSource, List<Reference> derivedFrom, List<CodeableConcept> reasonCode, List<Reference> reasonReference, List<Annotation> note, List<Dosage> dosage) {
        this.meta = meta;
        this.identifier = identifier;
        this.basedOn = basedOn;
        this.partOf = partOf;
        this.status = status;
        this.statusReason = statusReason;
        this.category = category;
        this.medicationCodeableConcept = medicationCodeableConcept;
        this.medicationReference = medicationReference;
        this.subject = subject;
        this.context = context;
        this.effectiveDateTime = effectiveDateTime;
        this.effectivePeriod = effectivePeriod;
        this.dateAsserted = dateAsserted;
        this.informationSource = informationSource;
        this.derivedFrom = derivedFrom;
        this.reasonCode = reasonCode;
        this.reasonReference = reasonReference;
        this.note = note;
        this.dosage = dosage;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Identifier> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<Identifier> identifier) {
        this.identifier = identifier;
    }

    public List<Reference> getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(List<Reference> basedOn) {
        this.basedOn = basedOn;
    }

    public List<Reference> getPartOf() {
        return partOf;
    }

    public void setPartOf(List<Reference> partOf) {
        this.partOf = partOf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CodeableConcept> getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(List<CodeableConcept> statusReason) {
        this.statusReason = statusReason;
    }

    public CodeableConcept getCategory() {
        return category;
    }

    public void setCategory(CodeableConcept category) {
        this.category = category;
    }

    public CodeableConcept getMedicationCodeableConcept() {
        return medicationCodeableConcept;
    }

    public void setMedicationCodeableConcept(CodeableConcept medicationCodeableConcept) {
        this.medicationCodeableConcept = medicationCodeableConcept;
    }

    public Reference getMedicationReference() {
        return medicationReference;
    }

    public void setMedicationReference(Reference medicationReference) {
        this.medicationReference = medicationReference;
    }

    public Reference getSubject() {
        return subject;
    }

    public void setSubject(Reference subject) {
        this.subject = subject;
    }

    public Reference getContext() {
        return context;
    }

    public void setContext(Reference context) {
        this.context = context;
    }

    public String getEffectiveDateTime() {
        return effectiveDateTime;
    }

    public void setEffectiveDateTime(String effectiveDateTime) {
        this.effectiveDateTime = effectiveDateTime;
    }

    public Period getEffectivePeriod() {
        return effectivePeriod;
    }

    public void setEffectivePeriod(Period effectivePeriod) {
        this.effectivePeriod = effectivePeriod;
    }

    public String getDateAsserted() {
        return dateAsserted;
    }

    public void setDateAsserted(String dateAsserted) {
        this.dateAsserted = dateAsserted;
    }

    public Reference getInformationSource() {
        return informationSource;
    }

    public void setInformationSource(Reference informationSource) {
        this.informationSource = informationSource;
    }

    public List<Reference> getDerivedFrom() {
        return derivedFrom;
    }

    public void setDerivedFrom(List<Reference> derivedFrom) {
        this.derivedFrom = derivedFrom;
    }

    public List<CodeableConcept> getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(List<CodeableConcept> reasonCode) {
        this.reasonCode = reasonCode;
    }

    public List<Reference> getReasonReference() {
        return reasonReference;
    }

    public void setReasonReference(List<Reference> reasonReference) {
        this.reasonReference = reasonReference;
    }

    public List<Annotation> getNote() {
        return note;
    }

    public void setNote(List<Annotation> note) {
        this.note = note;
    }

    public List<Dosage> getDosage() {
        return dosage;
    }

    public void setDosage(List<Dosage> dosage) {
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return "R4MedicationStatement{" +
                "meta=" + meta +
                ", identifier=" + identifier +
                ", basedOn=" + basedOn +
                ", partOf=" + partOf +
                ", status='" + status + '\'' +
                ", statusReason=" + statusReason +
                ", category=" + category +
                ", medicationCodeableConcept=" + medicationCodeableConcept +
                ", medicationReference=" + medicationReference +
                ", subject=" + subject +
                ", context=" + context +
                ", effectiveDateTime='" + effectiveDateTime + '\'' +
                ", effectivePeriod=" + effectivePeriod +
                ", dateAsserted='" + dateAsserted + '\'' +
                ", informationSource=" + informationSource +
                ", derivedFrom=" + derivedFrom +
                ", reasonCode=" + reasonCode +
                ", reasonReference=" + reasonReference +
                ", note=" + note +
                ", dosage=" + dosage +
                '}';
    }
}
