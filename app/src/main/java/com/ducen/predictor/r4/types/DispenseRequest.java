package com.ducen.predictor.r4.types;

import javax.xml.datatype.Duration;

public class DispenseRequest {
    private InitialFill initialFill;
    private String dispenseInterval;
    private Period validityPeriod;
    private String numberOfRepeatsAllowed;
    private SimpleQuantity quantity;
    private String expectedSupplyDuration;
    private Reference performer;

    public DispenseRequest(){

    }
    public DispenseRequest(InitialFill initialFill, String dispenseInterval, Period validityPeriod, String numberOfRepeatsAllowed, SimpleQuantity quantity, String expectedSupplyDuration, Reference performer) {
        this.initialFill = initialFill;
        this.dispenseInterval = dispenseInterval;
        this.validityPeriod = validityPeriod;
        this.numberOfRepeatsAllowed = numberOfRepeatsAllowed;
        this.quantity = quantity;
        this.expectedSupplyDuration = expectedSupplyDuration;
        this.performer = performer;
    }

    public InitialFill getInitialFill() {
        return initialFill;
    }

    public void setInitialFill(InitialFill initialFill) {
        this.initialFill = initialFill;
    }

    public String getDispenseInterval() {
        return dispenseInterval;
    }

    public void setDispenseInterval(String dispenseInterval) {
        this.dispenseInterval = dispenseInterval;
    }

    public Period getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(Period validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getNumberOfRepeatsAllowed() {
        return numberOfRepeatsAllowed;
    }

    public void setNumberOfRepeatsAllowed(String numberOfRepeatsAllowed) {
        this.numberOfRepeatsAllowed = numberOfRepeatsAllowed;
    }

    public SimpleQuantity getQuantity() {
        return quantity;
    }

    public void setQuantity(SimpleQuantity quantity) {
        this.quantity = quantity;
    }

    public String getExpectedSupplyDuration() {
        return expectedSupplyDuration;
    }

    public void setExpectedSupplyDuration(String expectedSupplyDuration) {
        this.expectedSupplyDuration = expectedSupplyDuration;
    }

    public Reference getPerformer() {
        return performer;
    }

    public void setPerformer(Reference performer) {
        this.performer = performer;
    }

    @Override
    public String toString() {
        return "DispenseRequest{" +
                "initialFill=" + initialFill +
                ", dispenseInterval=" + dispenseInterval +
                ", validityPeriod=" + validityPeriod +
                ", numberOfRepeatsAllowed='" + numberOfRepeatsAllowed + '\'' +
                ", quantity=" + quantity +
                ", expectedSupplyDuration=" + expectedSupplyDuration +
                ", performer=" + performer +
                '}';
    }
}
