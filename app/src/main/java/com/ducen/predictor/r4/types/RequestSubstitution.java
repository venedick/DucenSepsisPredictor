package com.ducen.predictor.r4.types;

public class RequestSubstitution {

    private String allowedBoolean;
    private CodeableConcept allowedCodeableConcept;
    private CodeableConcept reason;

    public RequestSubstitution(){}

    public RequestSubstitution(String allowedBoolean, CodeableConcept allowedCodeableConcept, CodeableConcept reason) {
        this.allowedBoolean = allowedBoolean;
        this.allowedCodeableConcept = allowedCodeableConcept;
        this.reason = reason;
    }

    public String getAllowedBoolean() {
        return allowedBoolean;
    }

    public void setAllowedBoolean(String allowedBoolean) {
        this.allowedBoolean = allowedBoolean;
    }

    public CodeableConcept getAllowedCodeableConcept() {
        return allowedCodeableConcept;
    }

    public void setAllowedCodeableConcept(CodeableConcept allowedCodeableConcept) {
        this.allowedCodeableConcept = allowedCodeableConcept;
    }

    public CodeableConcept getReason() {
        return reason;
    }

    public void setReason(CodeableConcept reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "RequestSubstitution{" +
                "allowedBoolean='" + allowedBoolean + '\'' +
                ", allowedCodeableConcept=" + allowedCodeableConcept +
                ", reason=" + reason +
                '}';
    }
}
