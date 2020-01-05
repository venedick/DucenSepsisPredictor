package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class Location {

    private Reference location;
    private String status;
    private CodeableConcept physicalType;
    private Period period;

    public Reference getLocation() {
        return location;
    }

    public void setLocation(Reference location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CodeableConcept getPhysicalType() {
        return physicalType;
    }

    public void setPhysicalType(CodeableConcept physicalType) {
        this.physicalType = physicalType;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Location(){

    }

    public Location(Reference location, String status, CodeableConcept physicalType, Period period) {
        this.location = location;
        this.status = status;
        this.physicalType = physicalType;
        this.period = period;
    }


    @Override
    public String toString() {
        return "Location{" +
                "location=" + location +
                ", status='" + status + '\'' +
                ", physicalType=" + physicalType +
                ", period=" + period +
                '}';
    }
}
