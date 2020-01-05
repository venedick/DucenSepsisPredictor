package com.ducen.predictor.r4.entity;


import com.ducen.predictor.r4.types.Attachment;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Media;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class R4DiagnosticReport {

    private Meta meta;
    private List<Identifier> identifier;
    private List<Reference> basedOn;
    private String status;
    private List<CodeableConcept> category;
    private CodeableConcept code;
    private Reference subject;
    private Reference encounter;
    private String effectiveDateTime;
    private Period effectivePeriod;
    private String issued;
    private List<Reference> performer;
    private List<Reference> resultsInterpreter;
    private List<Reference> specimen;
    private List<Reference> result;
    private List<Reference> imagingStudy;

    private List<Media> media;
    private String conclusion;
    private List<CodeableConcept> conclusionCode;
    private List<Attachment> presentedForm;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CodeableConcept> getCategory() {
        return category;
    }

    public void setCategory(List<CodeableConcept> category) {
        this.category = category;
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

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public List<Reference> getPerformer() {
        return performer;
    }

    public void setPerformer(List<Reference> performer) {
        this.performer = performer;
    }

    public List<Reference> getResultsInterpreter() {
        return resultsInterpreter;
    }

    public void setResultsInterpreter(List<Reference> resultsInterpreter) {
        this.resultsInterpreter = resultsInterpreter;
    }

    public List<Reference> getSpecimen() {
        return specimen;
    }

    public void setSpecimen(List<Reference> specimen) {
        this.specimen = specimen;
    }

    public List<Reference> getResult() {
        return result;
    }

    public void setResult(List<Reference> result) {
        this.result = result;
    }

    public List<Reference> getImagingStudy() {
        return imagingStudy;
    }

    public void setImagingStudy(List<Reference> imagingStudy) {
        this.imagingStudy = imagingStudy;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public List<CodeableConcept> getConclusionCode() {
        return conclusionCode;
    }

    public void setConclusionCode(List<CodeableConcept> conclusionCode) {
        this.conclusionCode = conclusionCode;
    }

    public List<Attachment> getPresentedForm() {
        return presentedForm;
    }

    public void setPresentedForm(List<Attachment> presentedForm) {
        this.presentedForm = presentedForm;
    }

    public R4DiagnosticReport() {

    }

    public R4DiagnosticReport(Meta meta, List<Identifier> identifier, List<Reference> basedOn, String status, List<CodeableConcept> category, CodeableConcept code, Reference subject, Reference encounter, String effectiveDateTime, Period effectivePeriod, String issued, List<Reference> performer, List<Reference> resultsInterpreter, List<Reference> specimen, List<Reference> result, List<Reference> imagingStudy, List<Media> media, String conclusion, List<CodeableConcept> conclusionCode, List<Attachment> presentedForm) {
        this.meta = meta;
        this.identifier = identifier;
        this.basedOn = basedOn;
        this.status = status;
        this.category = category;
        this.code = code;
        this.subject = subject;
        this.encounter = encounter;
        this.effectiveDateTime = effectiveDateTime;
        this.effectivePeriod = effectivePeriod;
        this.issued = issued;
        this.performer = performer;
        this.resultsInterpreter = resultsInterpreter;
        this.specimen = specimen;
        this.result = result;
        this.imagingStudy = imagingStudy;
        this.media = media;
        this.conclusion = conclusion;
        this.conclusionCode = conclusionCode;
        this.presentedForm = presentedForm;
    }

    @Override
    public String toString() {
        return "R4DiagnosticReport{" +
                "meta=" + meta +
                ", identifier=" + identifier +
                ", basedOn=" + basedOn +
                ", status=" + status +
                ", category=" + category +
                ", code=" + code +
                ", subject=" + subject +
                ", encounter=" + encounter +
                ", effectiveDateTime='" + effectiveDateTime + '\'' +
                ", effectivePeriod=" + effectivePeriod +
                ", issued='" + issued + '\'' +
                ", performer=" + performer +
                ", resultsInterpreter=" + resultsInterpreter +
                ", specimen=" + specimen +
                ", result=" + result +
                ", imagingStudy=" + imagingStudy +
                ", media=" + media +
                ", conclusion='" + conclusion + '\'' +
                ", conclusionCode=" + conclusionCode +
                ", presentedForm=" + presentedForm +
                '}';
    }
}
