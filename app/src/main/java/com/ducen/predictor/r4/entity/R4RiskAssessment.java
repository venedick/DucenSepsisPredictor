package com.ducen.predictor.r4.entity;

import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Prediction;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class R4RiskAssessment {

    private Meta metaPractitioner;
    private List<Identifier> identifier;
    private Reference basedOn;
    private Reference parent;
    private String status;
    private CodeableConcept method;
    private CodeableConcept code;
    private Reference subject;
    private Reference encounter;
    private String occurrenceDateTime;
    private Period occurrencePeriod;
    private Reference condition;
    private Reference performer;
    private List<CodeableConcept> reasonCode;
    private List<Reference> reasonReference;
    private List<Reference> basis;
    private List<Prediction> prediction;
    private String mitigation;
    private List<Annotation> note;

    public R4RiskAssessment(){}

    public R4RiskAssessment(Meta metaPractitioner, List<Identifier> identifier, Reference basedOn, Reference parent, String status, CodeableConcept method, CodeableConcept code, Reference subject, Reference encounter, String occurrenceDateTime, Period occurrencePeriod, Reference condition, Reference performer, List<CodeableConcept> reasonCode, List<Reference> reasonReference, List<Reference> basis, List<Prediction> prediction, String mitigation, List<Annotation> note) {
        this.metaPractitioner = metaPractitioner;
        this.identifier = identifier;
        this.basedOn = basedOn;
        this.parent = parent;
        this.status = status;
        this.method = method;
        this.code = code;
        this.subject = subject;
        this.encounter = encounter;
        this.occurrenceDateTime = occurrenceDateTime;
        this.occurrencePeriod = occurrencePeriod;
        this.condition = condition;
        this.performer = performer;
        this.reasonCode = reasonCode;
        this.reasonReference = reasonReference;
        this.basis = basis;
        this.prediction = prediction;
        this.mitigation = mitigation;
        this.note = note;
    }

    public Meta getMetaPractitioner() {
        return metaPractitioner;
    }

    public void setMetaPractitioner(Meta meta) {
        this.metaPractitioner = meta;
    }

    public List<Identifier> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<Identifier> identifier) {
        this.identifier = identifier;
    }

    public Reference getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(Reference basedOn) {
        this.basedOn = basedOn;
    }

    public Reference getParent() {
        return parent;
    }

    public void setParent(Reference parent) {
        this.parent = parent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CodeableConcept getMethod() {
        return method;
    }

    public void setMethod(CodeableConcept method) {
        this.method = method;
    }

    public CodeableConcept getCode() {
        return code;
    }

    public void setCode(CodeableConcept code) {
        this.code = code;
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

    public String getOccurrenceDateTime() {
        return occurrenceDateTime;
    }

    public void setOccurrenceDateTime(String occurrenceDateTime) {
        this.occurrenceDateTime = occurrenceDateTime;
    }

    public Period getOccurrencePeriod() {
        return occurrencePeriod;
    }

    public void setOccurrencePeriod(Period occurrencePeriod) {
        this.occurrencePeriod = occurrencePeriod;
    }

    public Reference getCondition() {
        return condition;
    }

    public void setCondition(Reference condition) {
        this.condition = condition;
    }

    public Reference getPerformer() {
        return performer;
    }

    public void setPerformer(Reference performer) {
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

    public List<Reference> getBasis() {
        return basis;
    }

    public void setBasis(List<Reference> basis) {
        this.basis = basis;
    }

    public List<Prediction> getPrediction() {
        return prediction;
    }

    public void setPrediction(List<Prediction> prediction) {
        this.prediction = prediction;
    }

    public String getMitigation() {
        return mitigation;
    }

    public void setMitigation(String mitigation) {
        this.mitigation = mitigation;
    }

    public List<Annotation> getNote() {
        return note;
    }

    public void setNote(List<Annotation> note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "R4RiskAssessment{" +
                "metaPractitioner=" + metaPractitioner +
                ", identifier=" + identifier +
                ", basedOn=" + basedOn +
                ", parent=" + parent +
                ", status='" + status + '\'' +
                ", method=" + method +
                ", code=" + code +
                ", subject=" + subject +
                ", encounter=" + encounter +
                ", occurrenceDateTime='" + occurrenceDateTime + '\'' +
                ", occurrencePeriod=" + occurrencePeriod +
                ", condition=" + condition +
                ", performer=" + performer +
                ", reasonCode=" + reasonCode +
                ", reasonReference=" + reasonReference +
                ", basis=" + basis +
                ", prediction=" + prediction +
                ", mitigation='" + mitigation + '\'' +
                ", note=" + note +
                '}';
    }
}

