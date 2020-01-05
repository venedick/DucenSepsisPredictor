package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class Performer {

    private CodeableConcept function;
    private Reference actor;

    public CodeableConcept getFunction() {
        return function;
    }

    public void setFunction(CodeableConcept function) {
        this.function = function;
    }

    public Reference getActor() {
        return actor;
    }

    public void setActor(Reference actor) {
        this.actor = actor;
    }

    public Performer(){

    }

    public Performer(CodeableConcept function, Reference actor) {
        this.function = function;
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Performer{" +
                "function=" + function +
                ", actor=" + actor +
                '}';
    }
}
