package com.ducen.predictor.r4.entity;


import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Participant;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class R4Appointment {

    private Meta meta;
    private List<Identifier> identifier;
    private String status;
    private CodeableConcept cancelationReason;
    private List<CodeableConcept> serviceCategory;
    private List<CodeableConcept> serviceType;
    private List<CodeableConcept> specialty;
    private CodeableConcept appointmentType;
    private List<CodeableConcept> reasonCode;
    private List<Reference> reasonReference;
    private String priority;
    private String description;
    private List<Reference> supportingInformation;
    private String start;
    private String end;
    private String minutesDuration;
    private List<Reference> slot;
    private String created;
    private String comment;
    private String patientInstruction;
    private List<Reference> basedOn;
    private List<Participant> participant;
    private List<Period> requestedPeriod;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CodeableConcept getCancelationReason() {
        return cancelationReason;
    }

    public void setCancelationReason(CodeableConcept cancelationReason) {
        this.cancelationReason = cancelationReason;
    }

    public List<CodeableConcept> getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(List<CodeableConcept> serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public List<CodeableConcept> getServiceType() {
        return serviceType;
    }

    public void setServiceType(List<CodeableConcept> serviceType) {
        this.serviceType = serviceType;
    }

    public List<CodeableConcept> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<CodeableConcept> specialty) {
        this.specialty = specialty;
    }

    public CodeableConcept getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(CodeableConcept appointmentType) {
        this.appointmentType = appointmentType;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Reference> getSupportingInformation() {
        return supportingInformation;
    }

    public void setSupportingInformation(List<Reference> supportingInformation) {
        this.supportingInformation = supportingInformation;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getMinutesDuration() {
        return minutesDuration;
    }

    public void setMinutesDuration(String minutesDuration) {
        this.minutesDuration = minutesDuration;
    }

    public List<Reference> getSlot() {
        return slot;
    }

    public void setSlot(List<Reference> slot) {
        this.slot = slot;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPatientInstruction() {
        return patientInstruction;
    }

    public void setPatientInstruction(String patientInstruction) {
        this.patientInstruction = patientInstruction;
    }

    public List<Reference> getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(List<Reference> basedOn) {
        this.basedOn = basedOn;
    }

    public List<Participant> getParticipant() {
        return participant;
    }

    public void setParticipant(List<Participant> participant) {
        this.participant = participant;
    }

    public List<Period> getRequestedPeriod() {
        return requestedPeriod;
    }

    public void setRequestedPeriod(List<Period> requestedPeriod) {
        this.requestedPeriod = requestedPeriod;
    }

    public R4Appointment() {

    }

    public R4Appointment(Meta meta, List<Identifier> identifier, String status, CodeableConcept cancelationReason, List<CodeableConcept> serviceCategory, List<CodeableConcept> serviceType, List<CodeableConcept> specialty, CodeableConcept appointmentType, List<CodeableConcept> reasonCode, List<Reference> reasonReference, String priority, String description, List<Reference> supportingInformation, String start, String end, String minutesDuration, List<Reference> slot, String created, String comment, String patientInstruction, List<Reference> basedOn, List<Participant> participant, List<Period> requestedPeriod) {
        this.meta = meta;
        this.identifier = identifier;
        this.status = status;
        this.cancelationReason = cancelationReason;
        this.serviceCategory = serviceCategory;
        this.serviceType = serviceType;
        this.specialty = specialty;
        this.appointmentType = appointmentType;
        this.reasonCode = reasonCode;
        this.reasonReference = reasonReference;
        this.priority = priority;
        this.description = description;
        this.supportingInformation = supportingInformation;
        this.start = start;
        this.end = end;
        this.minutesDuration = minutesDuration;
        this.slot = slot;
        this.created = created;
        this.comment = comment;
        this.patientInstruction = patientInstruction;
        this.basedOn = basedOn;
        this.participant = participant;
        this.requestedPeriod = requestedPeriod;
    }

    @Override
    public String toString() {
        return "R4Appointment{" +
                "identifier=" + identifier +
                ", status='" + status + '\'' +
                ", cancelationReason=" + cancelationReason +
                ", serviceCategory=" + serviceCategory +
                ", serviceType=" + serviceType +
                ", specialty=" + specialty +
                ", appointmentType=" + appointmentType +
                ", reasonCode=" + reasonCode +
                ", reasonReference=" + reasonReference +
                ", priority='" + priority + '\'' +
                ", description='" + description + '\'' +
                ", supportingInformation=" + supportingInformation +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", minutesDuration='" + minutesDuration + '\'' +
                ", slot=" + slot +
                ", created='" + created + '\'' +
                ", comment='" + comment + '\'' +
                ", patientInstruction='" + patientInstruction + '\'' +
                ", basedOn=" + basedOn +
                ", participant=" + participant +
                ", requestedPeriod=" + requestedPeriod +
                '}';
    }
}
