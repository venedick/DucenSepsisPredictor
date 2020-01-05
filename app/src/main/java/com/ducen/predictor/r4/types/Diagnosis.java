package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class Diagnosis {

    private Reference condition;
    private CodeableConcept use;
    private String rank;

    public Reference getCondition() {
        return condition;
    }

    public void setCondition(Reference condition) {
        this.condition = condition;
    }

    public CodeableConcept getUse() {
        return use;
    }

    public void setUse(CodeableConcept use) {
        this.use = use;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
