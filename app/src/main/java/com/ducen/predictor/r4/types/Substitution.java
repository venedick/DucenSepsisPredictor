package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class Substitution {

    private String wasSubstituted;
    private CodeableConcept type;
    private List<CodeableConcept> reason;
    private List<Reference> responsibleParty;

    public String getWasSubstituted() {
        return wasSubstituted;
    }

    public void setWasSubstituted(String wasSubstituted) {
        this.wasSubstituted = wasSubstituted;
    }

    public CodeableConcept getType() {
        return type;
    }

    public void setType(CodeableConcept type) {
        this.type = type;
    }

    public List<CodeableConcept> getReason() {
        return reason;
    }

    public void setReason(List<CodeableConcept> reason) {
        this.reason = reason;
    }

    public List<Reference> getResponsibleParty() {
        return responsibleParty;
    }

    public void setResponsibleParty(List<Reference> responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    public Substitution(){

    }

    public Substitution(String wasSubstituted, CodeableConcept type, List<CodeableConcept> reason, List<Reference> responsibleParty) {
        this.wasSubstituted = wasSubstituted;
        this.type = type;
        this.reason = reason;
        this.responsibleParty = responsibleParty;
    }

    @Override
    public String toString() {
        return "Substitution{" +
                "wasSubstituted='" + wasSubstituted + '\'' +
                ", type=" + type +
                ", reason=" + reason +
                ", responsibleParty=" + responsibleParty +
                '}';
    }

}
