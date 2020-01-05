package com.ducen.predictor.r4.entity;


import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Dosage;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Performer;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Quantity;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.Substitution;

import java.util.List;

public class R4MedicationAdministration {

    private Meta meta;
    private List<Identifier> identifier;
    private List<String> instantiates;
    private List<Reference> partOf;
    private String status;
    private List<CodeableConcept> statusReason;
    private CodeableConcept category;
    private CodeableConcept medicationCodeableConcept;
    private Reference medicationReference;
    private Reference subject;
    private Reference context;
    private List<Reference> supportingInformation;
    private String effectiveDateTime;
    private Period effectivePeriod;
    private List<Performer> performer;
    private List<CodeableConcept> reasonCode;
    private List<Reference> reasonReference;
    private Reference request;
    private List<Reference> device;
    private List<Annotation> note;
    private Dosage dosage;
    private List<Reference> eventHistory;

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

    public List<String> getInstantiates() {
        return instantiates;
    }

    public void setInstantiates(List<String> instantiates) {
        this.instantiates = instantiates;
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

    public List<Reference> getSupportingInformation() {
        return supportingInformation;
    }

    public void setSupportingInformation(List<Reference> supportingInformation) {
        this.supportingInformation = supportingInformation;
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

    public List<Performer> getPerformer() {
        return performer;
    }

    public void setPerformer(List<Performer> performer) {
        this.performer = performer;
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

    public Reference getRequest() {
        return request;
    }

    public void setRequest(Reference request) {
        this.request = request;
    }

    public List<Reference> getDevice() {
        return device;
    }

    public void setDevice(List<Reference> device) {
        this.device = device;
    }

    public List<Annotation> getNote() {
        return note;
    }

    public void setNote(List<Annotation> note) {
        this.note = note;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    public List<Reference> getEventHistory() {
        return eventHistory;
    }

    public void setEventHistory(List<Reference> eventHistory) {
        this.eventHistory = eventHistory;
    }

    public R4MedicationAdministration(){

    }

    public R4MedicationAdministration(Meta meta, List<Identifier> identifier, List<String> instantiates, List<Reference> partOf, String status, List<CodeableConcept> statusReason, CodeableConcept category, CodeableConcept medicationCodeableConcept, Reference medicationReference, Reference subject, Reference context, List<Reference> supportingInformation, String effectiveDateTime, Period effectivePeriod, List<Performer> performer, List<CodeableConcept> reasonCode, List<Reference> reasonReference, Reference request, List<Reference> device, List<Annotation> note, Dosage dosage, List<Reference> eventHistory) {
        this.meta = meta;
        this.identifier = identifier;
        this.instantiates = instantiates;
        this.partOf = partOf;
        this.status = status;
        this.statusReason = statusReason;
        this.category = category;
        this.medicationCodeableConcept = medicationCodeableConcept;
        this.medicationReference = medicationReference;
        this.subject = subject;
        this.context = context;
        this.supportingInformation = supportingInformation;
        this.effectiveDateTime = effectiveDateTime;
        this.effectivePeriod = effectivePeriod;
        this.performer = performer;
        this.reasonCode = reasonCode;
        this.reasonReference = reasonReference;
        this.request = request;
        this.device = device;
        this.note = note;
        this.dosage = dosage;
        this.eventHistory = eventHistory;
    }

    @Override
    public String toString() {
        return "R4MedicationAdministration{" +
                "meta=" + meta +
                ", identifier=" + identifier +
                ", instantiates=" + instantiates +
                ", partOf=" + partOf +
                ", status='" + status + '\'' +
                ", statusReason=" + statusReason +
                ", category=" + category +
                ", medicationCodeableConcept=" + medicationCodeableConcept +
                ", medicationReference=" + medicationReference +
                ", subject=" + subject +
                ", context=" + context +
                ", supportingInformation=" + supportingInformation +
                ", effectiveDateTime='" + effectiveDateTime + '\'' +
                ", effectivePeriod=" + effectivePeriod +
                ", performer=" + performer +
                ", reasonCode=" + reasonCode +
                ", reasonReference=" + reasonReference +
                ", request=" + request +
                ", device=" + device +
                ", note=" + note +
                ", dosage=" + dosage +
                ", eventHistory=" + eventHistory +
                '}';
    }
}
