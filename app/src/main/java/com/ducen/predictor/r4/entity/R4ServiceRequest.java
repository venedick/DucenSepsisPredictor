package com.ducen.predictor.r4.entity;

import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Quantity;
import com.ducen.predictor.r4.types.Range;
import com.ducen.predictor.r4.types.Ratio;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.Timing;

import java.util.List;

public class R4ServiceRequest {

    private Meta meta;
    private List<Identifier> identifier;
    private List<String> instantiatesCanonical;
    private List<String> instantiatesUri;
    private List<Reference> basedOn;
    private List<Reference> replaces;
    private Identifier requisition;
    private String status;
    private String intent;
    private CodeableConcept category;
    private String priority;
    private String doNotPerform;
    private CodeableConcept code;
    private List<CodeableConcept> orderDetail;
    private Quantity quantityQuantity;
    private Ratio quantityRatio;
    private Range quantityRange;
    private Reference subject;
    private Reference encounter;
    private String occurrenceDateTime;
    private Period occurrencePeriod;
    private Timing occurrenceTiming;
    private String asNeededBoolean;
    private CodeableConcept asNeededCodeableConcept;
    private String authoredOn;
    private Reference requester;
    private CodeableConcept performerType;
    private List<Reference> performer;
    private List<CodeableConcept> locationCode;
    private List<Reference> locationReference;
    private List<CodeableConcept> reasonCode;
    private List<Reference> reasonReference;
    private List<Reference> insurance;
    private List<Reference> supportingInfo;
    private List<Reference> specimen;
    private List<CodeableConcept> bodySite;
    private List<Annotation> note;
    private String patientInstruction;
    private List<Reference> relevantHistory;

    public R4ServiceRequest(){

    }
    public R4ServiceRequest(Meta meta, List<Identifier> identifier, List<String> instantiatesCanonical, List<String> instantiatesUri, List<Reference> basedOn, List<Reference> replaces, Identifier requisition, String status, String intent, CodeableConcept category, String priority, String doNotPerform, CodeableConcept code, List<CodeableConcept> orderDetail, Quantity quantityQuantity, Ratio quantityRatio, Range quantityRange, Reference subject, Reference encounter, String occurrenceDateTime, Period occurrencePeriod, Timing occurrenceTiming, String asNeededBoolean, CodeableConcept asNeededCodeableConcept, String authoredOn, Reference requester, CodeableConcept performerType, List<Reference> performer, List<CodeableConcept> locationCode, List<Reference> locationReference, List<CodeableConcept> reasonCode, List<Reference> reasonReference, List<Reference> insurance, List<Reference> supportingInfo, List<Reference> specimen, List<CodeableConcept> bodySite, List<Annotation> note, String patientInstruction, List<Reference> relevantHistory) {
        this.meta = meta;
        this.identifier = identifier;
        this.instantiatesCanonical = instantiatesCanonical;
        this.instantiatesUri = instantiatesUri;
        this.basedOn = basedOn;
        this.replaces = replaces;
        this.requisition = requisition;
        this.status = status;
        this.intent = intent;
        this.category = category;
        this.priority = priority;
        this.doNotPerform = doNotPerform;
        this.code = code;
        this.orderDetail = orderDetail;
        this.quantityQuantity = quantityQuantity;
        this.quantityRatio = quantityRatio;
        this.quantityRange = quantityRange;
        this.subject = subject;
        this.encounter = encounter;
        this.occurrenceDateTime = occurrenceDateTime;
        this.occurrencePeriod = occurrencePeriod;
        this.occurrenceTiming = occurrenceTiming;
        this.asNeededBoolean = asNeededBoolean;
        this.asNeededCodeableConcept = asNeededCodeableConcept;
        this.authoredOn = authoredOn;
        this.requester = requester;
        this.performerType = performerType;
        this.performer = performer;
        this.locationCode = locationCode;
        this.locationReference = locationReference;
        this.reasonCode = reasonCode;
        this.reasonReference = reasonReference;
        this.insurance = insurance;
        this.supportingInfo = supportingInfo;
        this.specimen = specimen;
        this.bodySite = bodySite;
        this.note = note;
        this.patientInstruction = patientInstruction;
        this.relevantHistory = relevantHistory;
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

    public List<Reference> getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(List<Reference> basedOn) {
        this.basedOn = basedOn;
    }

    public List<Reference> getReplaces() {
        return replaces;
    }

    public void setReplaces(List<Reference> replaces) {
        this.replaces = replaces;
    }

    public Identifier getRequisition() {
        return requisition;
    }

    public void setRequisition(Identifier requisition) {
        this.requisition = requisition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public CodeableConcept getCode() {
        return code;
    }

    public void setCode(CodeableConcept code) {
        this.code = code;
    }

    public List<CodeableConcept> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<CodeableConcept> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Quantity getQuantityQuantity() {
        return quantityQuantity;
    }

    public void setQuantityQuantity(Quantity quantityQuantity) {
        this.quantityQuantity = quantityQuantity;
    }

    public Ratio getQuantityRatio() {
        return quantityRatio;
    }

    public void setQuantityRatio(Ratio quantityRatio) {
        this.quantityRatio = quantityRatio;
    }

    public Range getQuantityRange() {
        return quantityRange;
    }

    public void setQuantityRange(Range quantityRange) {
        this.quantityRange = quantityRange;
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

    public Timing getOccurrenceTiming() {
        return occurrenceTiming;
    }

    public void setOccurrenceTiming(Timing occurrenceTiming) {
        this.occurrenceTiming = occurrenceTiming;
    }

    public String getAsNeededBoolean() {
        return asNeededBoolean;
    }

    public void setAsNeededBoolean(String asNeededBoolean) {
        this.asNeededBoolean = asNeededBoolean;
    }

    public CodeableConcept getAsNeededCodeableConcept() {
        return asNeededCodeableConcept;
    }

    public void setAsNeededCodeableConcept(CodeableConcept asNeededCodeableConcept) {
        this.asNeededCodeableConcept = asNeededCodeableConcept;
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

    public CodeableConcept getPerformerType() {
        return performerType;
    }

    public void setPerformerType(CodeableConcept performerType) {
        this.performerType = performerType;
    }

    public List<Reference> getPerformer() {
        return performer;
    }

    public void setPerformer(List<Reference> performer) {
        this.performer = performer;
    }

    public List<CodeableConcept> getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(List<CodeableConcept> locationCode) {
        this.locationCode = locationCode;
    }

    public List<Reference> getLocationReference() {
        return locationReference;
    }

    public void setLocationReference(List<Reference> locationReference) {
        this.locationReference = locationReference;
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

    public List<Reference> getInsurance() {
        return insurance;
    }

    public void setInsurance(List<Reference> insurance) {
        this.insurance = insurance;
    }

    public List<Reference> getSupportingInfo() {
        return supportingInfo;
    }

    public void setSupportingInfo(List<Reference> supportingInfo) {
        this.supportingInfo = supportingInfo;
    }

    public List<Reference> getSpecimen() {
        return specimen;
    }

    public void setSpecimen(List<Reference> specimen) {
        this.specimen = specimen;
    }

    public List<CodeableConcept> getBodySite() {
        return bodySite;
    }

    public void setBodySite(List<CodeableConcept> bodySite) {
        this.bodySite = bodySite;
    }

    public List<Annotation> getNote() {
        return note;
    }

    public void setNote(List<Annotation> note) {
        this.note = note;
    }

    public String getPatientInstruction() {
        return patientInstruction;
    }

    public void setPatientInstruction(String patientInstruction) {
        this.patientInstruction = patientInstruction;
    }

    public List<Reference> getRelevantHistory() {
        return relevantHistory;
    }

    public void setRelevantHistory(List<Reference> relevantHistory) {
        this.relevantHistory = relevantHistory;
    }

    @Override
    public String toString() {
        return "R4ServiceRequest{" +
                "meta=" + meta +
                ", identifier=" + identifier +
                ", instantiatesCanonical=" + instantiatesCanonical +
                ", instantiatesUri=" + instantiatesUri +
                ", basedOn=" + basedOn +
                ", replaces=" + replaces +
                ", requisition=" + requisition +
                ", status='" + status + '\'' +
                ", intent='" + intent + '\'' +
                ", category=" + category +
                ", priority='" + priority + '\'' +
                ", doNotPerform='" + doNotPerform + '\'' +
                ", code=" + code +
                ", orderDetail=" + orderDetail +
                ", quantityQuantity=" + quantityQuantity +
                ", quantityRatio=" + quantityRatio +
                ", quantityRange=" + quantityRange +
                ", subject=" + subject +
                ", encounter=" + encounter +
                ", occurrenceDateTime='" + occurrenceDateTime + '\'' +
                ", occurrencePeriod=" + occurrencePeriod +
                ", occurrenceTiming=" + occurrenceTiming +
                ", asNeededBoolean='" + asNeededBoolean + '\'' +
                ", asNeededCodeableConcept=" + asNeededCodeableConcept +
                ", authoredOn='" + authoredOn + '\'' +
                ", requester=" + requester +
                ", performerType=" + performerType +
                ", performer=" + performer +
                ", locationCode=" + locationCode +
                ", locationReference=" + locationReference +
                ", reasonCode=" + reasonCode +
                ", reasonReference=" + reasonReference +
                ", insurance=" + insurance +
                ", supportingInfo=" + supportingInfo +
                ", specimen=" + specimen +
                ", bodySite=" + bodySite +
                ", note=" + note +
                ", patientInstruction='" + patientInstruction + '\'' +
                ", relevantHistory=" + relevantHistory +
                '}';
    }
}
