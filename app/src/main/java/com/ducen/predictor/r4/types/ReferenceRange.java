package com.ducen.predictor.r4.types;

import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Quantity;
import com.ducen.predictor.r4.types.Range;

import java.util.List;

public class ReferenceRange {

    private Quantity low;
    private Quantity high;
    private CodeableConcept type;
    private List<CodeableConcept> appliesTo;
    private Range age;
    private String text;

    public ReferenceRange(Quantity low, Quantity high, CodeableConcept type, List<CodeableConcept> appliesTo, Range age, String text) {
        this.low = low;
        this.high = high;
        this.type = type;
        this.appliesTo = appliesTo;
        this.age = age;
        this.text = text;
    }

    public Quantity getLow() {
        return low;
    }

    public void setLow(Quantity low) {
        this.low = low;
    }

    public Quantity getHigh() {
        return high;
    }

    public void setHigh(Quantity high) {
        this.high = high;
    }

    public CodeableConcept getType() {
        return type;
    }

    public void setType(CodeableConcept type) {
        this.type = type;
    }

    public List<CodeableConcept> getAppliesTo() {
        return appliesTo;
    }

    public void setAppliesTo(List<CodeableConcept> appliesTo) {
        this.appliesTo = appliesTo;
    }

    public Range getAge() {
        return age;
    }

    public void setAge(Range age) {
        this.age = age;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ReferenceRange{" +
                "low=" + low +
                ", high=" + high +
                ", type=" + type +
                ", appliesTo=" + appliesTo +
                ", age=" + age +
                ", text='" + text + '\'' +
                '}';
    }
}
