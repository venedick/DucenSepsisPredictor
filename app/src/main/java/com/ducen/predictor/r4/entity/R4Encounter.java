package com.ducen.predictor.r4.entity;


import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.History;
import com.ducen.predictor.r4.types.Hospitalization;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Location;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Participant;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class R4Encounter {

    private Meta meta;
    private List<Identifier> identifier;
    private String status;
    private List<History> statusHistory;
    private Coding codingClass;
    private List<History> codingClassHistory;
    private List<CodeableConcept> type;
    private CodeableConcept serviceType;
    private CodeableConcept priority;
    private Reference subject;
    private List<Reference> episodeOfCare;
    private List<Reference> basedOn;
    private List<Participant> participant;
    private List<Reference> appointment;
    private Period period;
    private String length;
    private List<CodeableConcept> reasonCode;
    private List<Reference> reasonReference;
    private List<Reference> account;
    private Hospitalization hospitalization;
    private List<Location> location;
    private Reference serviceProvider;
    private Reference partOf;

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

    public List<History> getStatusHistory() {
        return statusHistory;
    }

    public void setStatusHistory(List<History> statusHistory) {
        this.statusHistory = statusHistory;
    }

    public Coding getCodingClass() {
        return codingClass;
    }

    public void setCodingClass(Coding codingClass) {
        this.codingClass = codingClass;
    }

    public List<History> getCodingClassHistory() {
        return codingClassHistory;
    }

    public void setCodingClassHistory(List<History> codingClassHistory) {
        this.codingClassHistory = codingClassHistory;
    }

    public List<CodeableConcept> getType() {
        return type;
    }

    public void setType(List<CodeableConcept> type) {
        this.type = type;
    }

    public CodeableConcept getServiceType() {
        return serviceType;
    }

    public void setServiceType(CodeableConcept serviceType) {
        this.serviceType = serviceType;
    }

    public CodeableConcept getPriority() {
        return priority;
    }

    public void setPriority(CodeableConcept priority) {
        this.priority = priority;
    }

    public Reference getSubject() {
        return subject;
    }

    public void setSubject(Reference subject) {
        this.subject = subject;
    }

    public List<Reference> getEpisodeOfCare() {
        return episodeOfCare;
    }

    public void setEpisodeOfCare(List<Reference> episodeOfCare) {
        this.episodeOfCare = episodeOfCare;
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

    public List<Reference> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Reference> appointment) {
        this.appointment = appointment;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
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

    public List<Reference> getAccount() {
        return account;
    }

    public void setAccount(List<Reference> account) {
        this.account = account;
    }

    public Hospitalization getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(Hospitalization hospitalization) {
        this.hospitalization = hospitalization;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    public Reference getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(Reference serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public Reference getPartOf() {
        return partOf;
    }

    public void setPartOf(Reference partOf) {
        this.partOf = partOf;
    }

    public R4Encounter(){

    }

    public R4Encounter(Meta meta, List<Identifier> identifier, String status, List<History> statusHistory, Coding codingClass, List<History> codingClassHistory, List<CodeableConcept> type, CodeableConcept serviceType, CodeableConcept priority, Reference subject, List<Reference> episodeOfCare, List<Reference> basedOn, List<Participant> participant, List<Reference> appointment, Period period, String length, List<CodeableConcept> reasonCode, List<Reference> reasonReference, List<Reference> account, Hospitalization hospitalization, List<Location> location, Reference serviceProvider, Reference partOf) {
        this.meta = meta;
        this.identifier = identifier;
        this.status = status;
        this.statusHistory = statusHistory;
        this.codingClass = codingClass;
        this.codingClassHistory = codingClassHistory;
        this.type = type;
        this.serviceType = serviceType;
        this.priority = priority;
        this.subject = subject;
        this.episodeOfCare = episodeOfCare;
        this.basedOn = basedOn;
        this.participant = participant;
        this.appointment = appointment;
        this.period = period;
        this.length = length;
        this.reasonCode = reasonCode;
        this.reasonReference = reasonReference;
        this.account = account;
        this.hospitalization = hospitalization;
        this.location = location;
        this.serviceProvider = serviceProvider;
        this.partOf = partOf;
    }

    @Override
    public String toString() {
        return "R4Encounter{" +
                "meta=" + meta +
                ", identifier=" + identifier +
                ", status='" + status + '\'' +
                ", r4StatusHistory=" + statusHistory +
                ", codingClass=" + codingClass +
                ", codingClassHistory=" + codingClassHistory +
                ", type=" + type +
                ", serviceType=" + serviceType +
                ", priority=" + priority +
                ", subject=" + subject +
                ", episodeOfCare=" + episodeOfCare +
                ", basedOn=" + basedOn +
                ", participant=" + participant +
                ", appointment=" + appointment +
                ", period=" + period +
                ", length='" + length + '\'' +
                ", reasonCode=" + reasonCode +
                ", reasonReference=" + reasonReference +
                ", account=" + account +
                ", hospitalization=" + hospitalization +
                ", location=" + location +
                ", serviceProvider=" + serviceProvider +
                ", partOf=" + partOf +
                '}';
    }
}
