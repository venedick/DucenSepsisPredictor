package com.ducen.predictor.r4.types;

import java.io.Serializable;
import java.util.List;

//get from R4 datatypes
public class Reference implements Serializable {

    private String reference;
    private String type;
    private List<Identifier> identifier;
    private String display;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Identifier> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<Identifier> identifier) {
        this.identifier = identifier;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public Reference() {

    }

    public Reference(String reference, String type, List<Identifier> identifier, String display) {
        this.reference = reference;
        this.type = type;
        this.identifier = identifier;
        this.display = display;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "reference='" + reference + '\'' +
                ", type='" + type + '\'' +
                ", identifier=" + identifier +
                ", display='" + display + '\'' +
                '}';
    }
}
