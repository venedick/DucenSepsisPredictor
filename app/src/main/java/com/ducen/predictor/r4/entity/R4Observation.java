package com.ducen.predictor.r4.entity;

import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Component;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Quantity;
import com.ducen.predictor.r4.types.Range;
import com.ducen.predictor.r4.types.Ratio;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.ReferenceRange;
import com.ducen.predictor.r4.types.SampledData;
import com.ducen.predictor.r4.types.Timing;

import java.util.List;

public class R4Observation {

    private List<Identifier> identifierList;
    private List<Reference> basedOn;
    private List<Reference> partOf;
    private String status;
    private List<CodeableConcept> category;
    private CodeableConcept code;
    private Reference subject;
    private List<Reference> focus;
    private Reference encounter;
    private String effectiveDateTime;
    private Period effectivePeriod;
    private Timing effectiveTiming;
    private String instant;
    private String issued;
    private List<Reference> performer;
    private Quantity valueQuantity;
    private CodeableConcept valueCodeableConcept;
    private String valueString;
    private String valueBoolean;
    private String valueInteger;
    private Range valueRange;
    private Ratio valueRatio;
    private String valueTime;
    private SampledData valueSampledData;
    private String valueDateTime;
    private Period valuePeriod;
    private CodeableConcept dataAbsentReason;
    private List<CodeableConcept> interpretation;
    private List<Annotation> note;
    private CodeableConcept bodySite;
    private CodeableConcept method;
    private List<Reference> specimen;
    private Reference device;
    private List<ReferenceRange> referenceRange;
    private List<Reference> hasMember;
    private List<Reference> derivedFrom;
    private List<Component> component;

    public R4Observation() {
    }

    public R4Observation(List<Identifier> identifierList, List<Reference> basedOn, List<Reference> partOf, String status, List<CodeableConcept> category, CodeableConcept code, Reference subject, List<Reference> focus, Reference encounter, String effectiveDateTime, Period effectivePeriod, Timing effectiveTiming, String instant, String issued, List<Reference> performer, Quantity valueQuantity, CodeableConcept valueCodeableConcept, String valueString, String valueBoolean, String valueInteger, Range valueRange, Ratio valueRatio, String valueTime, SampledData valueSampledData, String valueDateTime, Period valuePeriod, CodeableConcept dataAbsentReason, List<CodeableConcept> interpretation, List<Annotation> note, CodeableConcept bodySite, CodeableConcept method, List<Reference> specimen, Reference device, List<ReferenceRange> referenceRange, List<Reference> hasMember, List<Reference> derivedFrom, List<Component> component) {
        this.identifierList = identifierList;
        this.basedOn = basedOn;
        this.partOf = partOf;
        this.status = status;
        this.category = category;
        this.code = code;
        this.subject = subject;
        this.focus = focus;
        this.encounter = encounter;
        this.effectiveDateTime = effectiveDateTime;
        this.effectivePeriod = effectivePeriod;
        this.effectiveTiming = effectiveTiming;
        this.instant = instant;
        this.issued = issued;
        this.performer = performer;
        this.valueQuantity = valueQuantity;
        this.valueCodeableConcept = valueCodeableConcept;
        this.valueString = valueString;
        this.valueBoolean = valueBoolean;
        this.valueInteger = valueInteger;
        this.valueRange = valueRange;
        this.valueRatio = valueRatio;
        this.valueTime = valueTime;
        this.valueSampledData = valueSampledData;
        this.valueDateTime = valueDateTime;
        this.valuePeriod = valuePeriod;
        this.dataAbsentReason = dataAbsentReason;
        this.interpretation = interpretation;
        this.note = note;
        this.bodySite = bodySite;
        this.method = method;
        this.specimen = specimen;
        this.device = device;
        this.referenceRange = referenceRange;
        this.hasMember = hasMember;
        this.derivedFrom = derivedFrom;
        this.component = component;
    }

    public String getValueInteger() {
        return valueInteger;
    }

    public void setValueInteger(String valueInteger) {
        this.valueInteger = valueInteger;
    }

    public List<Identifier> getIdentifierList() {
        return identifierList;
    }

    public void setIdentifierList(List<Identifier> identifierList) {
        this.identifierList = identifierList;
    }

    public List<Reference> getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(List<Reference> basedOn) {
        this.basedOn = basedOn;
    }

    public List<Reference> getPartOf() {
        return partOf;
    }

    public void setPartOf(List<Reference> partOf) {
        this.partOf = partOf;
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

    public List<Reference> getFocus() {
        return focus;
    }

    public void setFocus(List<Reference> focus) {
        this.focus = focus;
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

    public Timing getEffectiveTiming() {
        return effectiveTiming;
    }

    public void setEffectiveTiming(Timing effectiveTiming) {
        this.effectiveTiming = effectiveTiming;
    }

    public String getInstant() {
        return instant;
    }

    public void setInstant(String instant) {
        this.instant = instant;
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

    public Quantity getValueQuantity() {
        return valueQuantity;
    }

    public void setValueQuantity(Quantity valueQuantity) {
        this.valueQuantity = valueQuantity;
    }

    public CodeableConcept getValueCodeableConcept() {
        return valueCodeableConcept;
    }

    public void setValueCodeableConcept(CodeableConcept valueCodeableConcept) {
        this.valueCodeableConcept = valueCodeableConcept;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    public String getValueBoolean() {
        return valueBoolean;
    }

    public void setValueBoolean(String valueBoolean) {
        this.valueBoolean = valueBoolean;
    }

    public Range getValueRange() {
        return valueRange;
    }

    public void setValueRange(Range valueRange) {
        this.valueRange = valueRange;
    }

    public Ratio getValueRatio() {
        return valueRatio;
    }

    public void setValueRatio(Ratio valueRatio) {
        this.valueRatio = valueRatio;
    }

    public String getValueTime() {
        return valueTime;
    }

    public void setValueTime(String valueTime) {
        this.valueTime = valueTime;
    }

    public SampledData getValueSampledData() {
        return valueSampledData;
    }

    public void setValueSampledData(SampledData valueSampledData) {
        this.valueSampledData = valueSampledData;
    }

    public String getValueDateTime() {
        return valueDateTime;
    }

    public void setValueDateTime(String valueDateTime) {
        this.valueDateTime = valueDateTime;
    }

    public Period getValuePeriod() {
        return valuePeriod;
    }

    public void setValuePeriod(Period valuePeriod) {
        this.valuePeriod = valuePeriod;
    }

    public CodeableConcept getDataAbsentReason() {
        return dataAbsentReason;
    }

    public void setDataAbsentReason(CodeableConcept dataAbsentReason) {
        this.dataAbsentReason = dataAbsentReason;
    }

    public List<CodeableConcept> getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(List<CodeableConcept> interpretation) {
        this.interpretation = interpretation;
    }

    public List<Annotation> getNote() {
        return note;
    }

    public void setNote(List<Annotation> note) {
        this.note = note;
    }

    public CodeableConcept getBodySite() {
        return bodySite;
    }

    public void setBodySite(CodeableConcept bodySite) {
        this.bodySite = bodySite;
    }

    public CodeableConcept getMethod() {
        return method;
    }

    public void setMethod(CodeableConcept method) {
        this.method = method;
    }

    public List<Reference> getSpecimen() {
        return specimen;
    }

    public void setSpecimen(List<Reference> specimen) {
        this.specimen = specimen;
    }

    public Reference getDevice() {
        return device;
    }

    public void setDevice(Reference device) {
        this.device = device;
    }

    public List<ReferenceRange> getReferenceRange() {
        return referenceRange;
    }

    public void setReferenceRange(List<ReferenceRange> referenceRange) {
        this.referenceRange = referenceRange;
    }

    public List<Reference> getHasMember() {
        return hasMember;
    }

    public void setHasMember(List<Reference> hasMember) {
        this.hasMember = hasMember;
    }

    public List<Reference> getDerivedFrom() {
        return derivedFrom;
    }

    public void setDerivedFrom(List<Reference> derivedFrom) {
        this.derivedFrom = derivedFrom;
    }

    public List<Component> getComponent() {
        return component;
    }

    public void setComponent(List<Component> component) {
        this.component = component;
    }

    @Override
    public String toString() {
        return "R4Observation{" +
                "identifierList=" + identifierList +
                ", basedOn=" + basedOn +
                ", partOf=" + partOf +
                ", status='" + status + '\'' +
                ", category=" + category +
                ", code=" + code +
                ", subject=" + subject +
                ", focus=" + focus +
                ", encounter=" + encounter +
                ", effectiveDateTime='" + effectiveDateTime + '\'' +
                ", effectivePeriod=" + effectivePeriod +
                ", effectiveTiming=" + effectiveTiming +
                ", instant='" + instant + '\'' +
                ", issued='" + issued + '\'' +
                ", performer=" + performer +
                ", valueQuantity=" + valueQuantity +
                ", valueCodeableConcept=" + valueCodeableConcept +
                ", valueString='" + valueString + '\'' +
                ", valueBoolean='" + valueBoolean + '\'' +
                ", valueInteger='" + valueInteger + '\'' +
                ", valueRange=" + valueRange +
                ", valueRatio=" + valueRatio +
                ", valueTime='" + valueTime + '\'' +
                ", valueSampledData=" + valueSampledData +
                ", valueDateTime='" + valueDateTime + '\'' +
                ", valuePeriod=" + valuePeriod +
                ", dataAbsentReason=" + dataAbsentReason +
                ", interpretation=" + interpretation +
                ", note=" + note +
                ", bodySite=" + bodySite +
                ", method=" + method +
                ", specimen=" + specimen +
                ", device=" + device +
                ", referenceRange=" + referenceRange +
                ", hasMember=" + hasMember +
                ", derivedFrom=" + derivedFrom +
                ", component=" + component +
                '}';
    }
}
