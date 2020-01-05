package com.ducen.predictor.r4.types;

import java.util.List;

public class Component {

    private CodeableConcept code;
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
    private List<ReferenceRange> referenceRange;

    public Component(CodeableConcept code, Quantity valueQuantity, CodeableConcept valueCodeableConcept, String valueString, String valueBoolean, String valueInteger, Range valueRange, Ratio valueRatio, String valueTime, SampledData valueSampledData, String valueDateTime, Period valuePeriod, CodeableConcept dataAbsentReason, List<CodeableConcept> interpretation, List<ReferenceRange> referenceRange) {
        this.code = code;
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
        this.referenceRange = referenceRange;
    }

    public CodeableConcept getCode() {
        return code;
    }

    public void setCode(CodeableConcept code) {
        this.code = code;
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

    public String getValueInteger() {
        return valueInteger;
    }

    public void setValueInteger(String valueInteger) {
        this.valueInteger = valueInteger;
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

    public List<ReferenceRange> getReferenceRange() {
        return referenceRange;
    }

    public void setReferenceRange(List<ReferenceRange> referenceRange) {
        this.referenceRange = referenceRange;
    }

    @Override
    public String toString() {
        return "Component{" +
                "code=" + code +
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
                ", referenceRange=" + referenceRange +
                '}';
    }
}
