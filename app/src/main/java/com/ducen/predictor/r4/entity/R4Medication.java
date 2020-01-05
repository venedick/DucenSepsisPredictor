package com.ducen.predictor.r4.entity;


import com.ducen.predictor.r4.types.Batch;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Ingredient;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Ratio;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class R4Medication {

    private Meta meta;
    private List<Identifier> identifier;
    private CodeableConcept code;
    private String status;
    private Reference manufacturer;
    private CodeableConcept form;
    private Ratio amount;
    private List<Ingredient> ingredient;
    private Batch batch;

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

    public CodeableConcept getCode() {
        return code;
    }

    public void setCode(CodeableConcept code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Reference getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Reference manufacturer) {
        this.manufacturer = manufacturer;
    }

    public CodeableConcept getForm() {
        return form;
    }

    public void setForm(CodeableConcept form) {
        this.form = form;
    }

    public Ratio getAmount() {
        return amount;
    }

    public void setAmount(Ratio amount) {
        this.amount = amount;
    }

    public List<Ingredient> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<Ingredient> ingredient) {
        this.ingredient = ingredient;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public R4Medication(){

    }

    public R4Medication(Meta meta, List<Identifier> identifier, CodeableConcept code, String status, Reference manufacturer, CodeableConcept form, Ratio amount, List<Ingredient> ingredient, Batch batch) {
        this.meta = meta;
        this.identifier = identifier;
        this.code = code;
        this.status = status;
        this.manufacturer = manufacturer;
        this.form = form;
        this.amount = amount;
        this.ingredient = ingredient;
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "R4Medication{" +
                "meta=" + meta +
                ", identifier=" + identifier +
                ", code=" + code +
                ", status='" + status + '\'' +
                ", manufacturer=" + manufacturer +
                ", form=" + form +
                ", amount=" + amount +
                ", ingredient=" + ingredient +
                ", batch=" + batch +
                '}';
    }
}
