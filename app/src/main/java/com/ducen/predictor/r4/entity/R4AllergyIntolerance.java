package com.ducen.predictor.r4.entity;


import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class R4AllergyIntolerance {

    private Meta meta;
    private List<Identifier> identifier;
    private CodeableConcept clinicalStatus;
    private CodeableConcept verificationStatus;
    private String type;
    private List<String> category;
    private String criticality;
    private CodeableConcept code;
    private Reference patient;
    private Reference encounter;
    //    private Onset onset; this field is missing, continue it tomorrow
    private String recordedDate;
    private Reference recorder;
    private Reference asserter;
    private String lastOccurence;
    private List<Annotation> note;
    private List<R4Reaction> reaction;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getCriticality() {
        return criticality;
    }

    public void setCriticality(String criticality) {
        this.criticality = criticality;
    }

    public CodeableConcept getCode() {
        return code;
    }

    public void setCode(CodeableConcept code) {
        this.code = code;
    }

    public Reference getPatient() {
        return patient;
    }

    public void setPatient(Reference patient) {
        this.patient = patient;
    }

    public Reference getEncounter() {
        return encounter;
    }

    public void setEncounter(Reference encounter) {
        this.encounter = encounter;
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

    public String getLastOccurence() {
        return lastOccurence;
    }

    public void setLastOccurence(String lastOccurence) {
        this.lastOccurence = lastOccurence;
    }

    public List<Annotation> getNote() {
        return note;
    }

    public void setNote(List<Annotation> note) {
        this.note = note;
    }

    public List<R4Reaction> getReaction() {
        return reaction;
    }

    public void setReaction(List<R4Reaction> reaction) {
        this.reaction = reaction;
    }

    public R4AllergyIntolerance() {

    }

    public R4AllergyIntolerance(Meta meta, List<Identifier> identifier, CodeableConcept clinicalStatus, CodeableConcept verificationStatus, String type, List<String> category, String criticality, CodeableConcept code, Reference patient, Reference encounter, String recordedDate, Reference recorder, Reference asserter, String lastOccurence, List<Annotation> note, List<R4Reaction> reaction) {
        this.meta = meta;
        this.identifier = identifier;
        this.clinicalStatus = clinicalStatus;
        this.verificationStatus = verificationStatus;
        this.type = type;
        this.category = category;
        this.criticality = criticality;
        this.code = code;
        this.patient = patient;
        this.encounter = encounter;
        this.recordedDate = recordedDate;
        this.recorder = recorder;
        this.asserter = asserter;
        this.lastOccurence = lastOccurence;
        this.note = note;
        this.reaction = reaction;
    }

    @Override
    public String toString() {
        return "R4AllergyIntolerance{" +
                "meta=" + meta +
                ", identifier=" + identifier +
                ", clinicalStatus=" + clinicalStatus +
                ", verificationStatus=" + verificationStatus +
                ", type=" + type +
                ", category=" + category +
                ", criticality=" + criticality +
                ", code=" + code +
                ", patient=" + patient +
                ", encounter=" + encounter +
                ", recordedDate='" + recordedDate + '\'' +
                ", recorder=" + recorder +
                ", asserter=" + asserter +
                ", lastOccurence='" + lastOccurence + '\'' +
                ", note=" + note +
                ", reaction=" + reaction +
                '}';
    }
}
