package com.ducen.predictor.r4.types;


import java.util.List;

public class Ingredient {

    private CodeableConcept itemCodeableConcept;
    private Reference itemReference;
    private String isActive;
    private Ratio strength;

    public CodeableConcept getItemCodeableConcept() {
        return itemCodeableConcept;
    }

    public void setItemCodeableConcept(CodeableConcept itemCodeableConcept) {
        this.itemCodeableConcept = itemCodeableConcept;
    }

    public Reference getItemReference() {
        return itemReference;
    }

    public void setItemReference(Reference itemReference) {
        this.itemReference = itemReference;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Ratio getStrength() {
        return strength;
    }

    public void setStrength(Ratio strength) {
        this.strength = strength;
    }

    public Ingredient(){

    }

    public Ingredient(CodeableConcept itemCodeableConcept, Reference itemReference, String isActive, Ratio strength) {
        this.itemCodeableConcept = itemCodeableConcept;
        this.itemReference = itemReference;
        this.isActive = isActive;
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "itemCodeableConcept=" + itemCodeableConcept +
                ", itemReference=" + itemReference +
                ", isActive='" + isActive + '\'' +
                ", strength=" + strength +
                '}';
    }
}
