package com.ducen.predictor.r4.types;


import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class Qualification {

    private List<Identifier> identifier;
    private CodeableConcept code;
    private Period period;
    private Reference issuer;

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

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Reference getIssuer() {
        return issuer;
    }

    public void setIssuer(Reference issuer) {
        this.issuer = issuer;
    }

    public Qualification() {

    }

    public Qualification(List<Identifier> identifier, CodeableConcept code, Period period, Reference issuer) {
        this.identifier = identifier;
        this.code = code;
        this.period = period;
        this.issuer = issuer;
    }

    @Override
    public String toString() {
        return "Qualification{" +
                "identifier='" + identifier + '\'' +
                ", code='" + code + '\'' +
                ", period='" + period + '\'' +
                ", issuer='" + issuer + '\'' +
                '}';
    }
}
