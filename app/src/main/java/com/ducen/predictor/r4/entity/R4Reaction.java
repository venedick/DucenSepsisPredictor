package com.ducen.predictor.r4.entity;


import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;

import java.util.List;

public class R4Reaction {

    private CodeableConcept substance;
    private List<CodeableConcept> manifestation;
    private String description;
    private String onSet;
    private String severity;
    private CodeableConcept exposureRoute;
    private List<Annotation> note;

    public CodeableConcept getSubstance() {
        return substance;
    }

    public void setSubstance(CodeableConcept substance) {
        this.substance = substance;
    }

    public List<CodeableConcept> getManifestation() {
        return manifestation;
    }

    public void setManifestation(List<CodeableConcept> manifestation) {
        this.manifestation = manifestation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOnSet() {
        return onSet;
    }

    public void setOnSet(String onSet) {
        this.onSet = onSet;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public CodeableConcept getExposureRoute() {
        return exposureRoute;
    }

    public void setExposureRoute(CodeableConcept exposureRoute) {
        this.exposureRoute = exposureRoute;
    }

    public List<Annotation> getNote() {
        return note;
    }

    public void setNote(List<Annotation> note) {
        this.note = note;
    }

    public R4Reaction() {

    }

    public R4Reaction(CodeableConcept substance, List<CodeableConcept> manifestation, String description, String onSet, String severity, CodeableConcept exposureRoute, List<Annotation> note) {
        this.substance = substance;
        this.manifestation = manifestation;
        this.description = description;
        this.onSet = onSet;
        this.severity = severity;
        this.exposureRoute = exposureRoute;
        this.note = note;
    }

    @Override
    public String toString() {
        return "R4Reaction{" +
                "substance=" + substance +
                ", manifestation=" + manifestation +
                ", description='" + description + '\'' +
                ", onSet='" + onSet + '\'' +
                ", severity=" + severity +
                ", exposureRoute=" + exposureRoute +
                ", note=" + note +
                '}';
    }
}
