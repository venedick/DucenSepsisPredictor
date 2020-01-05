package com.ducen.predictor.r4.types;

import java.io.Serializable;
import java.util.List;

//get from R4 datatypes
public class CodeableConcept implements Serializable {

    private List<Coding> coding;
    private String text;

    public List<Coding> getCoding() {
        return coding;
    }

    public void setCoding(List<Coding> coding) {
        this.coding = coding;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CodeableConcept() {

    }

    public CodeableConcept(List<Coding> coding, String text) {
        this.coding = coding;
        this.text = text;
    }

    @Override
    public String toString() {
        return "CodeableConcept{" +
                "coding=" + coding +
                ", text='" + text + '\'' +
                '}';
    }
}
