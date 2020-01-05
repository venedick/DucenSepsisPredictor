package com.ducen.predictor.r4.types;

import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class Detail {

    private String kind;
    private List<String> instantiatesCanonical;
    private List<String> instantiatesURI;
    private CodeableConcept code;
    private List<CodeableConcept> reasonCode;
    private List<Reference> reasonReference;
    private List<String> goal;
    private String status;
    private CodeableConcept statusReason;
    private String doNotPerform;
    private String scheduledTiming;
    private Period scheduledPeriod;
    private String scheduledString;
    private Reference location;
    private List<Reference> performer;
    private CodeableConcept productCodeableConcept;
    private Reference productReference;
    private String dailyAmount;
    private String quantity;
    private String description;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<String> getInstantiatesCanonical() {
        return instantiatesCanonical;
    }

    public void setInstantiatesCanonical(List<String> instantiatesCanonical) {
        this.instantiatesCanonical = instantiatesCanonical;
    }

    public List<String> getInstantiatesURI() {
        return instantiatesURI;
    }

    public void setInstantiatesURI(List<String> instantiatesURI) {
        this.instantiatesURI = instantiatesURI;
    }

    public CodeableConcept getCode() {
        return code;
    }

    public void setCode(CodeableConcept code) {
        this.code = code;
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

    public List<String> getGoal() {
        return goal;
    }

    public void setGoal(List<String> goal) {
        this.goal = goal;
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

    public String getDoNotPerform() {
        return doNotPerform;
    }

    public void setDoNotPerform(String doNotPerform) {
        this.doNotPerform = doNotPerform;
    }

    public String getScheduledTiming() {
        return scheduledTiming;
    }

    public void setScheduledTiming(String scheduledTiming) {
        this.scheduledTiming = scheduledTiming;
    }

    public Period getScheduledPeriod() {
        return scheduledPeriod;
    }

    public void setScheduledPeriod(Period scheduledPeriod) {
        this.scheduledPeriod = scheduledPeriod;
    }

    public String getScheduledString() {
        return scheduledString;
    }

    public void setScheduledString(String scheduledString) {
        this.scheduledString = scheduledString;
    }

    public Reference getLocation() {
        return location;
    }

    public void setLocation(Reference location) {
        this.location = location;
    }

    public List<Reference> getPerformer() {
        return performer;
    }

    public void setPerformer(List<Reference> performer) {
        this.performer = performer;
    }

    public CodeableConcept getProductCodeableConcept() {
        return productCodeableConcept;
    }

    public void setProductCodeableConcept(CodeableConcept productCodeableConcept) {
        this.productCodeableConcept = productCodeableConcept;
    }

    public Reference getProductReference() {
        return productReference;
    }

    public void setProductReference(Reference productReference) {
        this.productReference = productReference;
    }

    public String getDailyAmount() {
        return dailyAmount;
    }

    public void setDailyAmount(String dailyAmount) {
        this.dailyAmount = dailyAmount;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Detail() {

    }

    public Detail(String kind, List<String> instantiatesCanonical, List<String> instantiatesURI, CodeableConcept code, List<CodeableConcept> reasonCode, List<Reference> reasonReference, List<String> goal, String status, CodeableConcept statusReason, String doNotPerform, String scheduledTiming, Period scheduledPeriod, String scheduledString, Reference location, List<Reference> performer, CodeableConcept productCodeableConcept, Reference productReference, String dailyAmount, String quantity, String description) {
        this.kind = kind;
        this.instantiatesCanonical = instantiatesCanonical;
        this.instantiatesURI = instantiatesURI;
        this.code = code;
        this.reasonCode = reasonCode;
        this.reasonReference = reasonReference;
        this.goal = goal;
        this.status = status;
        this.statusReason = statusReason;
        this.doNotPerform = doNotPerform;
        this.scheduledTiming = scheduledTiming;
        this.scheduledPeriod = scheduledPeriod;
        this.scheduledString = scheduledString;
        this.location = location;
        this.performer = performer;
        this.productCodeableConcept = productCodeableConcept;
        this.productReference = productReference;
        this.dailyAmount = dailyAmount;
        this.quantity = quantity;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "kind='" + kind + '\'' +
                ", instantiatesCanonical=" + instantiatesCanonical +
                ", instantiatesURI=" + instantiatesURI +
                ", code=" + code +
                ", reasonCode=" + reasonCode +
                ", reasonReference=" + reasonReference +
                ", goal=" + goal +
                ", status='" + status + '\'' +
                ", statusReason=" + statusReason +
                ", doNotPerform='" + doNotPerform + '\'' +
                ", scheduledTiming='" + scheduledTiming + '\'' +
                ", scheduledPeriod=" + scheduledPeriod +
                ", scheduledString='" + scheduledString + '\'' +
                ", location=" + location +
                ", performer=" + performer +
                ", productCodeableConcept=" + productCodeableConcept +
                ", productReference=" + productReference +
                ", dailyAmount='" + dailyAmount + '\'' +
                ", quantity='" + quantity + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
