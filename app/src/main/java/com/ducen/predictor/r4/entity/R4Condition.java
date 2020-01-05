package com.ducen.predictor.r4.entity;


import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.OnSet;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.Stage;

import java.util.List;

public class R4Condition {

    private Meta meta;
    private List<Identifier> identifier;
    private CodeableConcept clinicalStatus;
    private CodeableConcept verificationStatus;
    private List<CodeableConcept> category;

    private CodeableConcept severity;
    private CodeableConcept code;
    private List<CodeableConcept> bodySite;
    private Reference subject;
    private Reference encounter;
    private OnSet onSet;
    private OnSet abatement;
    private String recordedDate;
    private Reference recorder;
    private Reference asserter;
    private List<Stage> stage;
    private List<R4Evidence> r4Evidence;

    private List<Annotation> note;

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

    public CodeableConcept getClinicalStatus() {
        return clinicalStatus;
    }

    public void setClinicalStatus(CodeableConcept clinicalStatus) {
        this.clinicalStatus = clinicalStatus;
    }

    public CodeableConcept getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(CodeableConcept verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public List<CodeableConcept> getCategory() {
        return category;
    }

    public void setCategory(List<CodeableConcept> category) {
        this.category = category;
    }

    public CodeableConcept getSeverity() {
        return severity;
    }

    public void setSeverity(CodeableConcept severity) {
        this.severity = severity;
    }

    public CodeableConcept getCode() {
        return code;
    }

    public void setCode(CodeableConcept code) {
        this.code = code;
    }

    public List<CodeableConcept> getBodySite() {
        return bodySite;
    }

    public void setBodySite(List<CodeableConcept> bodySite) {
        this.bodySite = bodySite;
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

    public OnSet getOnSet() {
        return onSet;
    }

    public void setOnSet(OnSet onSet) {
        this.onSet = onSet;
    }

    public OnSet getAbatement() {
        return abatement;
    }

    public void setAbatement(OnSet abatement) {
        this.abatement = abatement;
    }

    public String getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(String recordedDate) {
        this.recordedDate = recordedDate;
    }

    public Reference getRecorder() {
        return recorder;
    }

    public void setRecorder(Reference recorder) {
        this.recorder = recorder;
    }

    public Reference getAsserter() {
        return asserter;
    }

    public void setAsserter(Reference asserter) {
        this.asserter = asserter;
    }

    public List<Stage> getStage() {
        return stage;
    }

    public void setStage(List<Stage> stage) {
        this.stage = stage;
    }

    public List<R4Evidence> getR4Evidence() {
        return r4Evidence;
    }

    public void setR4Evidence(List<R4Evidence> r4Evidence) {
        this.r4Evidence = r4Evidence;
    }

    public List<Annotation> getNote() {
        return note;
    }

    public void setNote(List<Annotation> note) {
        this.note = note;
    }

    public R4Condition() {

    }

    public R4Condition(Meta meta, List<Identifier> identifier, CodeableConcept clinicalStatus, CodeableConcept verificationStatus, List<CodeableConcept> category, CodeableConcept severity, CodeableConcept code, List<CodeableConcept> bodySite, Reference subject, Reference encounter, OnSet onSet, OnSet abatement, String recordedDate, Reference recorder, Reference asserter, List<Stage> stage, List<R4Evidence> r4Evidence, List<Annotation> note) {
        this.meta = meta;
        this.identifier = identifier;
        this.clinicalStatus = clinicalStatus;
        this.verificationStatus = verificationStatus;
        this.category = category;
        this.severity = severity;
        this.code = code;
        this.bodySite = bodySite;
        this.subject = subject;
        this.encounter = encounter;
        this.onSet = onSet;
        this.abatement = abatement;
        this.recordedDate = recordedDate;
        this.recorder = recorder;
        this.asserter = asserter;
        this.stage = stage;
        this.r4Evidence = r4Evidence;
        this.note = note;
    }

    @Override
    public String toString() {
        return "R4Condition{" +
                "meta=" + meta +
                ", identifier=" + identifier +
                ", clinicalStatus=" + clinicalStatus +
                ", verificationStatus=" + verificationStatus +
                ", category=" + category +
                ", severity=" + severity +
                ", code=" + code +
                ", bodySite=" + bodySite +
                ", subject=" + subject +
                ", encounter=" + encounter +
                ", onSet=" + onSet +
                ", abatement=" + abatement +
                ", recordedDate='" + recordedDate + '\'' +
                ", recorder=" + recorder +
                ", asserter=" + asserter +
                ", stage=" + stage +
                ", r4Evidence=" + r4Evidence +
                ", note=" + note +
                '}';
    }
}
