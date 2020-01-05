package com.ducen.predictor.r4.entity;


import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Dosage;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Performer;
import com.ducen.predictor.r4.types.Quantity;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.Substitution;

import java.util.List;

public class R4MedicationDispense {

    private Meta meta;
    private List<Identifier> identifier;
    private List<Reference> partOf;
    private String status;
    private CodeableConcept statusReasonCodeableConcept;
    private Reference statusReasonReference;
    private CodeableConcept category;

    private CodeableConcept medicationCodeableConcept;
    private Reference medicationReference;
    private Reference subject;
    private Reference context;
    private List<Reference> supportingInformation;
    private List<Performer> performer;
    private Reference location;
    private List<Reference> authorizingPrescription;
    private CodeableConcept type;
    private Quantity quantity;
    private Quantity daysSupply;
    private String whenPrepared;
    private String whenHandedOver;
    private Reference destination;
    private List<Reference> receiver;
    private List<Annotation> note;
    private List<Dosage> dosageInstruction;
    private Substitution substitution;
    private List<Reference> detectedIssue;
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

    public CodeableConcept getStatusReasonCodeableConcept() {
        return statusReasonCodeableConcept;
    }

    public void setStatusReasonCodeableConcept(CodeableConcept statusReasonCodeableConcept) {
        this.statusReasonCodeableConcept = statusReasonCodeableConcept;
    }

    public Reference getStatusReasonReference() {
        return statusReasonReference;
    }

    public void setStatusReasonReference(Reference statusReasonReference) {
        this.statusReasonReference = statusReasonReference;
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

    public List<Performer> getPerformer() {
        return performer;
    }

    public void setPerformer(List<Performer> performer) {
        this.performer = performer;
    }

    public Reference getLocation() {
        return location;
    }

    public void setLocation(Reference location) {
        this.location = location;
    }

    public List<Reference> getAuthorizingPrescription() {
        return authorizingPrescription;
    }

    public void setAuthorizingPrescription(List<Reference> authorizingPrescription) {
        this.authorizingPrescription = authorizingPrescription;
    }

    public CodeableConcept getType() {
        return type;
    }

    public void setType(CodeableConcept type) {
        this.type = type;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Quantity getDaysSupply() {
        return daysSupply;
    }

    public void setDaysSupply(Quantity daysSupply) {
        this.daysSupply = daysSupply;
    }

    public String getWhenPrepared() {
        return whenPrepared;
    }

    public void setWhenPrepared(String whenPrepared) {
        this.whenPrepared = whenPrepared;
    }

    public String getWhenHandedOver() {
        return whenHandedOver;
    }

    public void setWhenHandedOver(String whenHandedOver) {
        this.whenHandedOver = whenHandedOver;
    }

    public Reference getDestination() {
        return destination;
    }

    public void setDestination(Reference destination) {
        this.destination = destination;
    }

    public List<Reference> getReceiver() {
        return receiver;
    }

    public void setReceiver(List<Reference> receiver) {
        this.receiver = receiver;
    }

    public List<Annotation> getNote() {
        return note;
    }

    public void setNote(List<Annotation> note) {
        this.note = note;
    }

    public List<Dosage> getDosageInstruction() {
        return dosageInstruction;
    }

    public void setDosageInstruction(List<Dosage> dosageInstruction) {
        this.dosageInstruction = dosageInstruction;
    }

    public Substitution getSubstitution() {
        return substitution;
    }

    public void setSubstitution(Substitution substitution) {
        this.substitution = substitution;
    }

    public List<Reference> getDetectedIssue() {
        return detectedIssue;
    }

    public void setDetectedIssue(List<Reference> detectedIssue) {
        this.detectedIssue = detectedIssue;
    }

    public List<Reference> getEventHistory() {
        return eventHistory;
    }

    public void setEventHistory(List<Reference> eventHistory) {
        this.eventHistory = eventHistory;
    }

    public R4MedicationDispense(){

    }

    public R4MedicationDispense(Meta meta, List<Identifier> identifier, List<Reference> partOf, String status, CodeableConcept statusReasonCodeableConcept, Reference statusReasonReference, CodeableConcept category, CodeableConcept medicationCodeableConcept, Reference medicationReference, Reference subject, Reference context, List<Reference> supportingInformation, List<Performer> performer, Reference location, List<Reference> authorizingPrescription, CodeableConcept type, Quantity quantity, Quantity daysSupply, String whenPrepared, String whenHandedOver, Reference destination, List<Reference> receiver, List<Annotation> note, List<Dosage> dosageInstruction, Substitution substitution, List<Reference> detectedIssue, List<Reference> eventHistory) {
        this.meta = meta;
        this.identifier = identifier;
        this.partOf = partOf;
        this.status = status;
        this.statusReasonCodeableConcept = statusReasonCodeableConcept;
        this.statusReasonReference = statusReasonReference;
        this.category = category;
        this.medicationCodeableConcept = medicationCodeableConcept;
        this.medicationReference = medicationReference;
        this.subject = subject;
        this.context = context;
        this.supportingInformation = supportingInformation;
        this.performer = performer;
        this.location = location;
        this.authorizingPrescription = authorizingPrescription;
        this.type = type;
        this.quantity = quantity;
        this.daysSupply = daysSupply;
        this.whenPrepared = whenPrepared;
        this.whenHandedOver = whenHandedOver;
        this.destination = destination;
        this.receiver = receiver;
        this.note = note;
        this.dosageInstruction = dosageInstruction;
        this.substitution = substitution;
        this.detectedIssue = detectedIssue;
        this.eventHistory = eventHistory;
    }

    @Override
    public String toString() {
        return "R4MedicationDispense{" +
                "meta=" + meta +
                ", identifier=" + identifier +
                ", partOf=" + partOf +
                ", status='" + status + '\'' +
                ", statusReasonCodeableConcept=" + statusReasonCodeableConcept +
                ", statusReasonReference=" + statusReasonReference +
                ", category=" + category +
                ", medicationCodeableConcept=" + medicationCodeableConcept +
                ", medicationReference=" + medicationReference +
                ", subject=" + subject +
                ", context=" + context +
                ", supportingInformation=" + supportingInformation +
                ", performer=" + performer +
                ", location=" + location +
                ", authorizingPrescription=" + authorizingPrescription +
                ", type=" + type +
                ", quantity=" + quantity +
                ", daysSupply=" + daysSupply +
                ", whenPrepared='" + whenPrepared + '\'' +
                ", whenHandedOver='" + whenHandedOver + '\'' +
                ", destination=" + destination +
                ", receiver=" + receiver +
                ", note=" + note +
                ", dosageInstruction=" + dosageInstruction +
                ", substitution=" + substitution +
                ", detectedIssue=" + detectedIssue +
                ", eventHistory=" + eventHistory +
                '}';
    }

}
