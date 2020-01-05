package com.ducen.predictor.r4.types;


import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class Stage {

    CodeableConcept summary;
    List<Reference> assessment;
    CodeableConcept type;

    public CodeableConcept getSummary() {
        return summary;
    }

    public void setSummary(CodeableConcept summary) {
        this.summary = summary;
    }

    public List<Reference> getAssessment() {
        return assessment;
    }

    public void setAssessment(List<Reference> assessment) {
        this.assessment = assessment;
    }

    public CodeableConcept getType() {
        return type;
    }

    public void setType(CodeableConcept type) {
        this.type = type;
    }

    public Stage() {

    }

    public Stage(CodeableConcept summary, List<Reference> assessment, CodeableConcept type) {
        this.summary = summary;
        this.assessment = assessment;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "summary=" + summary +
                ", assessment=" + assessment +
                ", type=" + type +
                '}';
    }
}
