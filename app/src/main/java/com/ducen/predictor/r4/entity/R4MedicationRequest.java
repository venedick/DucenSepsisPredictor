package com.ducen.predictor.r4.entity;

import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.DispenseRequest;
import com.ducen.predictor.r4.types.Dosage;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.RequestSubstitution;
import com.ducen.predictor.r4.types.Substitution;

import java.util.List;

public class R4MedicationRequest {

    private Meta meta;
    private List<Identifier> identifier;
    private String status;
    private CodeableConcept statusReason;
    private String intent;
    private CodeableConcept category;
    private String priority;
    private String doNotPerform;
    private String reportedBoolean;
    private Reference reportedReference;
    private CodeableConcept medicationCodeableConcept;
    private Reference medicationReference;
    private Reference subject;
    private Reference encounter;
    private List<Reference> supportingInformation;
    private String authoredOn;
    private Reference requester;
    private Reference performer;
    private CodeableConcept performerType;
    private Reference recorder;
    private List<CodeableConcept> reasonCode;
    private List<Reference> reasonReference;
    private List<String> instantiatesCanonical;
    private List<String> instantiatesUri;
    private List<Reference> basedOn;
    private Identifier groupIdentifier;
    private CodeableConcept courseOfTherapyType;
    private List<Reference> insurance;
    private List<Annotation> note;
    private List<Dosage> dosageIntruction;
    private DispenseRequest dispenseRequest;
    private RequestSubstitution substitution;
    private Reference priorPrescription;
    private List<Reference> detectedIssue;
    private List<Reference> eventHistory;

    public R4MedicationRequest(){

    }
    public R4MedicationRequest(Meta meta, List<Identifier> identifier, String status, CodeableConcept statusReason, String intent, CodeableConcept category, String priority, String doNotPerform, String reportedBoolean, Reference reportedReference, CodeableConcept medicationCodeableConcept, Reference medicationReference, Reference subject, Reference encounter, List<Reference> supportingInformation, String authoredOn, Reference requester, Reference performer, CodeableConcept performerType, Reference recorder, List<CodeableConcept> reasonCode, List<Reference> reasonReference, List<String> instantiatesCanonical, List<String> instantiatesUri, List<Reference> basedOn, Identifier groupIdentifier, CodeableConcept courseOfTherapyType, List<Reference> insurance, List<Annotation> note, List<Dosage> dosageIntruction, DispenseRequest dispenseRequest, RequestSubstitution substitution, Reference priorPrescription, List<Reference> detectedIssue, List<Reference> eventHistory) {
        this.meta = meta;
        this.identifier = identifier;
        this.status = status;
        this.statusReason = statusReason;
        this.intent = intent;
        this.category = category;
        this.priority = priority;
        this.doNotPerform = doNotPerform;
        this.reportedBoolean = reportedBoolean;
        this.reportedReference = reportedReference;
        this.medicationCodeableConcept = medicationCodeableConcept;
        this.medicationReference = medicationReference;
        this.subject = subject;
        this.encounter = encounter;
        this.supportingInformation = supportingInformation;
        this.authoredOn = authoredOn;
        this.requester = requester;
        this.performer = performer;
        this.performerType = performerType;
        this.recorder = recorder;
        this.reasonCode = reasonCode;
        this.reasonReference = reasonReference;
        this.instantiatesCanonical = instantiatesCanonical;
        this.instantiatesUri = instantiatesUri;
        this.basedOn = basedOn;
        this.groupIdentifier = groupIdentifier;
        this.courseOfTherapyType = courseOfTherapyType;
        this.insurance = insurance;
        this.note = note;
        this.dosageIntruction = dosageIntruction;
        this.dispenseRequest = dispenseRequest;
        this.substitution = substitution;
        this.priorPrescription = priorPrescription;
        this.detectedIssue = detectedIssue;
        this.eventHistory = eventHistory;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CodeableConcept getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(CodeableConcept statusReason) {
        this.statusReason = statusReason;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public CodeableConcept getCategory() {
        return category;
    }

    public void setCategory(CodeableConcept category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDoNotPerform() {
        return doNotPerform;
    }

    public void setDoNotPerform(String doNotPerform) {
        this.doNotPerform = doNotPerform;
    }

    public String getReportedBoolean() {
        return reportedBoolean;
    }

    public void setReportedBoolean(String reportedBoolean) {
        this.reportedBoolean = reportedBoolean;
    }

    public Reference getReportedReference() {
        return reportedReference;
    }

    public void setReportedReference(Reference reportedReference) {
        this.reportedReference = reportedReference;
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

    public Reference getEncounter() {
        return encounter;
    }

    public void setEncounter(Reference encounter) {
        this.encounter = encounter;
    }

    public List<Reference> getSupportingInformation() {
        return supportingInformation;
    }

    public void setSupportingInformation(List<Reference> supportingInformation) {
        this.supportingInformation = supportingInformation;
    }

    public String getAuthoredOn() {
        return authoredOn;
    }

    public void setAuthoredOn(String authoredOn) {
        this.authoredOn = authoredOn;
    }

    public Reference getRequester() {
        return requester;
    }

    public void setRequester(Reference requester) {
        this.requester = requester;
    }

    public Reference getPerformer() {
        return performer;
    }

    public void setPerformer(Reference performer) {
        this.performer = performer;
    }

    public CodeableConcept getPerformerType() {
        return performerType;
    }

    public void setPerformerType(CodeableConcept performerType) {
        this.performerType = performerType;
    }

    public Reference getRecorder() {
        return recorder;
    }

    public void setRecorder(Reference recorder) {
        this.recorder = recorder;
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

    public List<String> getInstantiatesCanonical() {
        return instantiatesCanonical;
    }

    public void setInstantiatesCanonical(List<String> instantiatesCanonical) {
        this.instantiatesCanonical = instantiatesCanonical;
    }

    public List<String> getInstantiatesUri() {
        return instantiatesUri;
    }

    public void setInstantiatesUri(List<String> instantiatesUri) {
        this.instantiatesUri = instantiatesUri;
    }

    public List<Reference> getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(List<Reference> basedOn) {
        this.basedOn = basedOn;
    }

    public Identifier getGroupIdentifier() {
        return groupIdentifier;
    }

    public void setGroupIdentifier(Identifier groupIdentifier) {
        this.groupIdentifier = groupIdentifier;
    }

    public CodeableConcept getCourseOfTherapyType() {
        return courseOfTherapyType;
    }

    public void setCourseOfTherapyType(CodeableConcept courseOfTherapyType) {
        this.courseOfTherapyType = courseOfTherapyType;
    }

    public List<Reference> getInsurance() {
        return insurance;
    }

    public void setInsurance(List<Reference> insurance) {
        this.insurance = insurance;
    }

    public List<Annotation> getNote() {
        return note;
    }

    public void setNote(List<Annotation> note) {
        this.note = note;
    }

    public List<Dosage> getDosageIntruction() {
        return dosageIntruction;
    }

    public void setDosageIntruction(List<Dosage> dosageIntruction) {
        this.dosageIntruction = dosageIntruction;
    }

    public DispenseRequest getDispenseRequest() {
        return dispenseRequest;
    }

    public void setDispenseRequest(DispenseRequest dispenseRequest) {
        this.dispenseRequest = dispenseRequest;
    }

    public RequestSubstitution getSubstitution() {
        return substitution;
    }

    public void setSubstitution(RequestSubstitution substitution) {
        this.substitution = substitution;
    }

    public Reference getPriorPrescription() {
        return priorPrescription;
    }

    public void setPriorPrescription(Reference priorPrescription) {
        this.priorPrescription = priorPrescription;
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

    @Override
    public String toString() {
        return "R4MedicationRequest{" +
                "meta =" + meta +
                ", identifier=" + identifier +
                ", status='" + status + '\'' +
                ", statusReason=" + statusReason +
                ", intent='" + intent + '\'' +
                ", category=" + category +
                ", priority='" + priority + '\'' +
                ", doNotPerform='" + doNotPerform + '\'' +
                ", reportedBoolean='" + reportedBoolean + '\'' +
                ", reportedReference=" + reportedReference +
                ", medicationCodeableConcept=" + medicationCodeableConcept +
                ", medicationReference=" + medicationReference +
                ", subject=" + subject +
                ", encounter=" + encounter +
                ", supportingInformation=" + supportingInformation +
                ", authoredOn='" + authoredOn + '\'' +
                ", requester=" + requester +
                ", performer=" + performer +
                ", performerType=" + performerType +
                ", recorder=" + recorder +
                ", reasonCode=" + reasonCode +
                ", reasonReference=" + reasonReference +
                ", instantiatesCanonical=" + instantiatesCanonical +
                ", instantiatesUri=" + instantiatesUri +
                ", basedOn=" + basedOn +
                ", groupIdentifier=" + groupIdentifier +
                ", courseOfTherapyType=" + courseOfTherapyType +
                ", insurance=" + insurance +
                ", note=" + note +
                ", dosageIntruction=" + dosageIntruction +
                ", dispenseRequest=" + dispenseRequest +
                ", substitution=" + substitution +
                ", priorPrescription=" + priorPrescription +
                ", detectedIssue=" + detectedIssue +
                ", eventHistory=" + eventHistory +
                '}';
    }
}
