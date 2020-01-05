package com.ducen.predictor.r4.types;


import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Detail;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class Activity {

    private List<CodeableConcept> outcomeCodeableConcept;
    private List<Reference> outcomeReference;
    private List<Annotation> progress;
    private Reference reference;
    private Detail detail;

    public List<CodeableConcept> getOutcomeCodeableConcept() {
        return outcomeCodeableConcept;
    }

    public void setOutcomeCodeableConcept(List<CodeableConcept> outcomeCodeableConcept) {
        this.outcomeCodeableConcept = outcomeCodeableConcept;
    }

    public List<Reference> getOutcomeReference() {
        return outcomeReference;
    }

    public void setOutcomeReference(List<Reference> outcomeReference) {
        this.outcomeReference = outcomeReference;
    }

    public List<Annotation> getProgress() {
        return progress;
    }

    public void setProgress(List<Annotation> progress) {
        this.progress = progress;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Activity() {

    }

    public Activity(List<CodeableConcept> outcomeCodeableConcept, List<Reference> outcomeReference, List<Annotation> progress, Reference reference, Detail detail) {
        this.outcomeCodeableConcept = outcomeCodeableConcept;
        this.outcomeReference = outcomeReference;
        this.progress = progress;
        this.reference = reference;
        this.detail = detail;
    }


    @Override
    public String toString() {
        return "Activity{" +
                "outcomeCodeableConcepts=" + outcomeCodeableConcept +
                ", outcomeReference=" + outcomeReference +
                ", progress=" + progress +
                ", reference=" + reference +
                ", detail=" + detail +
                '}';
    }
}
