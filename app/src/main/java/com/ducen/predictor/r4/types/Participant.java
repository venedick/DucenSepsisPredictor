package com.ducen.predictor.r4.types;


import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class Participant {

    private List<CodeableConcept> type;
    private Reference actor;
    private String required;
    private String status;
    private Period period;

    public List<CodeableConcept> getType() {
        return type;
    }

    public void setType(List<CodeableConcept> type) {
        this.type = type;
    }

    public Reference getActor() {
        return actor;
    }

    public void setActor(Reference actor) {
        this.actor = actor;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Participant() {

    }

    public Participant(List<CodeableConcept> type, Reference actor, String required, String status, Period period) {
        this.type = type;
        this.actor = actor;
        this.required = required;
        this.status = status;
        this.period = period;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "type=" + type +
                ", actor=" + actor +
                ", required='" + required + '\'' +
                ", status='" + status + '\'' +
                ", period=" + period +
                '}';
    }
}
