package com.ducen.predictor.r4.entity;

import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Condition;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Range;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class R4FamilyMemberHistory {

    private Meta meta;
    private List<Identifier> identifier;
    private List<String> instantiatesCanonical;
    private List<String> instantiatesUri;
    private String status;
    private CodeableConcept dataAbsentReason;
    private Reference patient;
    private String date;
    private String name;
    private CodeableConcept relationship;
    private CodeableConcept sex;
    private Period bornPeriod;
    private String bornDate;
    private String bornString;
    private String ageAge;
    private Range ageRange;
    private String ageString;
    private String estimatedAge;
    private String deceasedBoolean;
    private String deceasedAge;
    private Range deceasedRange;
    private String deceasedDate;
    private String deceasedString;
    private List<CodeableConcept> reasonCode;
    private List<Reference> reasonReference;
    private List<Annotation> note;
    private List<Condition> condition;

    public R4FamilyMemberHistory(){

    }

    public R4FamilyMemberHistory(Meta meta, List<Identifier> identifier, List<String> instantiatesCanonical, List<String> instantiatesUri, String status, CodeableConcept dataAbsentReason, Reference patient, String date, String name, CodeableConcept relationship, CodeableConcept sex, Period bornPeriod, String bornDate, String bornString, String ageAge, Range ageRange, String ageString, String estimatedAge, String deceasedBoolean, String deceasedAge, Range deceasedRange, String deceasedDate, String deceasedString, List<CodeableConcept> reasonCode, List<Reference> reasonReference, List<Annotation> note, List<Condition> condition) {
        this.meta = meta;
        this.identifier = identifier;
        this.instantiatesCanonical = instantiatesCanonical;
        this.instantiatesUri = instantiatesUri;
        this.status = status;
        this.dataAbsentReason = dataAbsentReason;
        this.patient = patient;
        this.date = date;
        this.name = name;
        this.relationship = relationship;
        this.sex = sex;
        this.bornPeriod = bornPeriod;
        this.bornDate = bornDate;
        this.bornString = bornString;
        this.ageAge = ageAge;
        this.ageRange = ageRange;
        this.ageString = ageString;
        this.estimatedAge = estimatedAge;
        this.deceasedBoolean = deceasedBoolean;
        this.deceasedAge = deceasedAge;
        this.deceasedRange = deceasedRange;
        this.deceasedDate = deceasedDate;
        this.deceasedString = deceasedString;
        this.reasonCode = reasonCode;
        this.reasonReference = reasonReference;
        this.note = note;
        this.condition = condition;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CodeableConcept getDataAbsentReason() {
        return dataAbsentReason;
    }

    public void setDataAbsentReason(CodeableConcept dataAbsentReason) {
        this.dataAbsentReason = dataAbsentReason;
    }

    public Reference getPatient() {
        return patient;
    }

    public void setPatient(Reference patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CodeableConcept getRelationship() {
        return relationship;
    }

    public void setRelationship(CodeableConcept relationship) {
        this.relationship = relationship;
    }

    public CodeableConcept getSex() {
        return sex;
    }

    public void setSex(CodeableConcept sex) {
        this.sex = sex;
    }

    public Period getBornPeriod() {
        return bornPeriod;
    }

    public void setBornPeriod(Period bornPeriod) {
        this.bornPeriod = bornPeriod;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getBornString() {
        return bornString;
    }

    public void setBornString(String bornString) {
        this.bornString = bornString;
    }

    public String getAgeAge() {
        return ageAge;
    }

    public void setAgeAge(String ageAge) {
        this.ageAge = ageAge;
    }

    public Range getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(Range ageRange) {
        this.ageRange = ageRange;
    }

    public String getAgeString() {
        return ageString;
    }

    public void setAgeString(String ageString) {
        this.ageString = ageString;
    }

    public String getEstimatedAge() {
        return estimatedAge;
    }

    public void setEstimatedAge(String estimatedAge) {
        this.estimatedAge = estimatedAge;
    }

    public String getDeceasedBoolean() {
        return deceasedBoolean;
    }

    public void setDeceasedBoolean(String deceasedBoolean) {
        this.deceasedBoolean = deceasedBoolean;
    }

    public String getDeceasedAge() {
        return deceasedAge;
    }

    public void setDeceasedAge(String deceasedAge) {
        this.deceasedAge = deceasedAge;
    }

    public Range getDeceasedRange() {
        return deceasedRange;
    }

    public void setDeceasedRange(Range deceasedRange) {
        this.deceasedRange = deceasedRange;
    }

    public String getDeceasedDate() {
        return deceasedDate;
    }

    public void setDeceasedDate(String deceasedDate) {
        this.deceasedDate = deceasedDate;
    }

    public String getDeceasedString() {
        return deceasedString;
    }

    public void setDeceasedString(String deceasedString) {
        this.deceasedString = deceasedString;
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

    public List<Condition> getCondition() {
        return condition;
    }

    public void setCondition(List<Condition> condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "R4FamilyMemberHistory{" +
                "meta=" + meta +
                ", identifier=" + identifier +
                ", instantiatesCanonical=" + instantiatesCanonical +
                ", instantiatesUri=" + instantiatesUri +
                ", status='" + status + '\'' +
                ", dataAbsentReason=" + dataAbsentReason +
                ", patient=" + patient +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", relationship=" + relationship +
                ", sex=" + sex +
                ", bornPeriod=" + bornPeriod +
                ", bornDate='" + bornDate + '\'' +
                ", bornString='" + bornString + '\'' +
                ", ageAge='" + ageAge + '\'' +
                ", ageRange=" + ageRange +
                ", ageString='" + ageString + '\'' +
                ", estimatedAge='" + estimatedAge + '\'' +
                ", deceasedBoolean='" + deceasedBoolean + '\'' +
                ", deceasedAge='" + deceasedAge + '\'' +
                ", deceasedRange=" + deceasedRange +
                ", deceasedDate='" + deceasedDate + '\'' +
                ", deceasedString='" + deceasedString + '\'' +
                ", reasonCode=" + reasonCode +
                ", reasonReference=" + reasonReference +
                ", note=" + note +
                ", condition=" + condition +
                '}';
    }
}
