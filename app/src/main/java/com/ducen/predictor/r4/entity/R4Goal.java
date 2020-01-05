package com.ducen.predictor.r4.entity;


import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.Target;

import java.util.List;

public class R4Goal {

    private Meta meta;
    private List<Identifier> identifier;
    private String lifecycleStatus;
    private CodeableConcept achievementStatus;
    private List<CodeableConcept> category;
    private CodeableConcept priority;
    private CodeableConcept description;
    private Reference subject;
    private String startDate;
    private CodeableConcept startCodeableConcept;
    private List<Target> target;
    private String statusDate;
    private String statusReason;
    private Reference expressedBy;
    private List<Reference> addresses;
    private List<Annotation> note;
    private List<CodeableConcept> outcomeCode;
    private List<Reference> outcomeReference;

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

    public String getLifecycleStatus() {
        return lifecycleStatus;
    }

    public void setLifecycleStatus(String lifecycleStatus) {
        this.lifecycleStatus = lifecycleStatus;
    }

    public CodeableConcept getAchievementStatus() {
        return achievementStatus;
    }

    public void setAchievementStatus(CodeableConcept achievementStatus) {
        this.achievementStatus = achievementStatus;
    }

    public List<CodeableConcept> getCategory() {
        return category;
    }

    public void setCategory(List<CodeableConcept> category) {
        this.category = category;
    }

    public CodeableConcept getPriority() {
        return priority;
    }

    public void setPriority(CodeableConcept priority) {
        this.priority = priority;
    }

    public CodeableConcept getDescription() {
        return description;
    }

    public void setDescription(CodeableConcept description) {
        this.description = description;
    }

    public Reference getSubject() {
        return subject;
    }

    public void setSubject(Reference subject) {
        this.subject = subject;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public CodeableConcept getStartCodeableConcept() {
        return startCodeableConcept;
    }

    public void setStartCodeableConcept(CodeableConcept startCodeableConcept) {
        this.startCodeableConcept = startCodeableConcept;
    }

    public List<Target> getTarget() {
        return target;
    }

    public void setTarget(List<Target> target) {
        this.target = target;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public Reference getExpressedBy() {
        return expressedBy;
    }

    public void setExpressedBy(Reference expressedBy) {
        this.expressedBy = expressedBy;
    }

    public List<Reference> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Reference> addresses) {
        this.addresses = addresses;
    }

    public List<Annotation> getNote() {
        return note;
    }

    public void setNote(List<Annotation> note) {
        this.note = note;
    }

    public List<CodeableConcept> getOutcomeCode() {
        return outcomeCode;
    }

    public void setOutcomeCode(List<CodeableConcept> outcomeCode) {
        this.outcomeCode = outcomeCode;
    }

    public List<Reference> getOutcomeReference() {
        return outcomeReference;
    }

    public void setOutcomeReference(List<Reference> outcomeReference) {
        this.outcomeReference = outcomeReference;
    }

    public R4Goal(){

    }

    public R4Goal(Meta meta, List<Identifier> identifier, String lifecycleStatus, CodeableConcept achievementStatus, List<CodeableConcept> category, CodeableConcept priority, CodeableConcept description, Reference subject, String startDate, CodeableConcept startCodeableConcept, List<Target> target, String statusDate, String statusReason, Reference expressedBy, List<Reference> addresses, List<Annotation> note, List<CodeableConcept> outcomeCode, List<Reference> outcomeReference) {
        this.meta = meta;
        this.identifier = identifier;
        this.lifecycleStatus = lifecycleStatus;
        this.achievementStatus = achievementStatus;
        this.category = category;
        this.priority = priority;
        this.description = description;
        this.subject = subject;
        this.startDate = startDate;
        this.startCodeableConcept = startCodeableConcept;
        this.target = target;
        this.statusDate = statusDate;
        this.statusReason = statusReason;
        this.expressedBy = expressedBy;
        this.addresses = addresses;
        this.note = note;
        this.outcomeCode = outcomeCode;
        this.outcomeReference = outcomeReference;
    }

    @Override
    public String toString() {
        return "R4Goal{" +
                "meta=" + meta +
                ", identifier=" + identifier +
                ", lifecycleStatus='" + lifecycleStatus + '\'' +
                ", achievementStatus=" + achievementStatus +
                ", category=" + category +
                ", priority=" + priority +
                ", description=" + description +
                ", subject=" + subject +
                ", startDate='" + startDate + '\'' +
                ", startCodeableConcept=" + startCodeableConcept +
                ", target=" + target +
                ", statusDate='" + statusDate + '\'' +
                ", statusReason='" + statusReason + '\'' +
                ", expressedBy=" + expressedBy +
                ", addresses=" + addresses +
                ", note=" + note +
                ", outcomeCode=" + outcomeCode +
                ", outcomeReference=" + outcomeReference +
                '}';
    }
}
