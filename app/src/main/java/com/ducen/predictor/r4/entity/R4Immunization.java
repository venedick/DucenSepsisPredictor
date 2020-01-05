package com.ducen.predictor.r4.entity;


import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Education;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Performer;
import com.ducen.predictor.r4.types.ProtocolApplied;
import com.ducen.predictor.r4.types.Reaction;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class R4Immunization {

    private Meta meta;
    private List<Identifier> identifier;
    private String code;
    private CodeableConcept statusReason;
    private CodeableConcept vaccineCode;
    private Reference patient;
    private Reference encounter;
    private String occurenceDateTime;
    private String occurenceString;
    private String recorded;
    private String primarySource;
    private CodeableConcept reportOrigin;
    private Reference location;
    private Reference manufacturer;
    private String lotNumber;

    private String expirationDate;
    private CodeableConcept site;
    private CodeableConcept route;
    private String doseQuantity;
    private List<Performer> performer;
    private List<Annotation> note;
    private List<CodeableConcept> reasonCode;
    private List<Reference> reasonReference;
    private String isSubpotent;
    private List<CodeableConcept> subpotentReason;

    private List<Education> education;
    private List<CodeableConcept> programEligibility;
    private CodeableConcept fundingSource;
    private List<Reaction> reaction;
    private List<ProtocolApplied> protocolApplied;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CodeableConcept getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(CodeableConcept statusReason) {
        this.statusReason = statusReason;
    }

    public CodeableConcept getVaccineCode() {
        return vaccineCode;
    }

    public void setVaccineCode(CodeableConcept vaccineCode) {
        this.vaccineCode = vaccineCode;
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

    public String getOccurenceDateTime() {
        return occurenceDateTime;
    }

    public void setOccurenceDateTime(String occurenceDateTime) {
        this.occurenceDateTime = occurenceDateTime;
    }

    public String getOccurenceString() {
        return occurenceString;
    }

    public void setOccurenceString(String occurenceString) {
        this.occurenceString = occurenceString;
    }

    public String getRecorded() {
        return recorded;
    }

    public void setRecorded(String recorded) {
        this.recorded = recorded;
    }

    public String getPrimarySource() {
        return primarySource;
    }

    public void setPrimarySource(String primarySource) {
        this.primarySource = primarySource;
    }

    public CodeableConcept getReportOrigin() {
        return reportOrigin;
    }

    public void setReportOrigin(CodeableConcept reportOrigin) {
        this.reportOrigin = reportOrigin;
    }

    public Reference getLocation() {
        return location;
    }

    public void setLocation(Reference location) {
        this.location = location;
    }

    public Reference getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Reference manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CodeableConcept getSite() {
        return site;
    }

    public void setSite(CodeableConcept site) {
        this.site = site;
    }

    public CodeableConcept getRoute() {
        return route;
    }

    public void setRoute(CodeableConcept route) {
        this.route = route;
    }

    public String getDoseQuantity() {
        return doseQuantity;
    }

    public void setDoseQuantity(String doseQuantity) {
        this.doseQuantity = doseQuantity;
    }

    public List<Performer> getPerformer() {
        return performer;
    }

    public void setPerformer(List<Performer> performer) {
        this.performer = performer;
    }

    public List<Annotation> getNote() {
        return note;
    }

    public void setNote(List<Annotation> note) {
        this.note = note;
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

    public String getIsSubpotent() {
        return isSubpotent;
    }

    public void setIsSubpotent(String isSubpotent) {
        this.isSubpotent = isSubpotent;
    }

    public List<CodeableConcept> getSubpotentReason() {
        return subpotentReason;
    }

    public void setSubpotentReason(List<CodeableConcept> subpotentReason) {
        this.subpotentReason = subpotentReason;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<CodeableConcept> getProgramEligibility() {
        return programEligibility;
    }

    public void setProgramEligibility(List<CodeableConcept> programEligibility) {
        this.programEligibility = programEligibility;
    }

    public CodeableConcept getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(CodeableConcept fundingSource) {
        this.fundingSource = fundingSource;
    }

    public List<Reaction> getReaction() {
        return reaction;
    }

    public void setReaction(List<Reaction> reaction) {
        this.reaction = reaction;
    }

    public List<ProtocolApplied> getProtocolApplied() {
        return protocolApplied;
    }

    public void setProtocolApplied(List<ProtocolApplied> protocolApplied) {
        this.protocolApplied = protocolApplied;
    }

    public R4Immunization() {

    }

    public R4Immunization(Meta meta, List<Identifier> identifier, String code, CodeableConcept statusReason, CodeableConcept vaccineCode, Reference patient, Reference encounter, String occurenceDateTime, String occurenceString, String recorded, String primarySource, CodeableConcept reportOrigin, Reference location, Reference manufacturer, String lotNumber, String expirationDate, CodeableConcept site, CodeableConcept route, String doseQuantity, List<Performer> performer, List<Annotation> note, List<CodeableConcept> reasonCode, List<Reference> reasonReference, String isSubpotent, List<CodeableConcept> subpotentReason, List<Education> education, List<CodeableConcept> programEligibility, CodeableConcept fundingSource, List<Reaction> reaction, List<ProtocolApplied> protocolApplied) {
        this.meta = meta;
        this.identifier = identifier;
        this.code = code;
        this.statusReason = statusReason;
        this.vaccineCode = vaccineCode;
        this.patient = patient;
        this.encounter = encounter;
        this.occurenceDateTime = occurenceDateTime;
        this.occurenceString = occurenceString;
        this.recorded = recorded;
        this.primarySource = primarySource;
        this.reportOrigin = reportOrigin;
        this.location = location;
        this.manufacturer = manufacturer;
        this.lotNumber = lotNumber;
        this.expirationDate = expirationDate;
        this.site = site;
        this.route = route;
        this.doseQuantity = doseQuantity;
        this.performer = performer;
        this.note = note;
        this.reasonCode = reasonCode;
        this.reasonReference = reasonReference;
        this.isSubpotent = isSubpotent;
        this.subpotentReason = subpotentReason;
        this.education = education;
        this.programEligibility = programEligibility;
        this.fundingSource = fundingSource;
        this.reaction = reaction;
        this.protocolApplied = protocolApplied;
    }

    @Override
    public String toString() {
        return "R4Immunization{" +
                "meta=" + meta +
                ", identifier=" + identifier +
                ", code='" + code + '\'' +
                ", statusReason=" + statusReason +
                ", vaccineCode=" + vaccineCode +
                ", patient=" + patient +
                ", encounter=" + encounter +
                ", occurenceDateTime='" + occurenceDateTime + '\'' +
                ", occurenceString='" + occurenceString + '\'' +
                ", recorded='" + recorded + '\'' +
                ", primarySource='" + primarySource + '\'' +
                ", reportOrigin=" + reportOrigin +
                ", location=" + location +
                ", manufacturer=" + manufacturer +
                ", lotNumber='" + lotNumber + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", site=" + site +
                ", route=" + route +
                ", doseQuantity='" + doseQuantity + '\'' +
                ", performer=" + performer +
                ", note=" + note +
                ", reasonCode=" + reasonCode +
                ", reasonReference=" + reasonReference +
                ", isSubpotent='" + isSubpotent + '\'' +
                ", subpotentReason=" + subpotentReason +
                ", education=" + education +
                ", programEligibility=" + programEligibility +
                ", fundingSource=" + fundingSource +
                ", reaction=" + reaction +
                ", protocolApplied=" + protocolApplied +
                '}';
    }
}
