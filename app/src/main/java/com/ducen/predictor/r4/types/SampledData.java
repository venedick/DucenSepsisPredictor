package com.ducen.predictor.r4.types;

public class SampledData {
    private Quantity origin;
    private String period;
    private String factor;
    private String lowerLimit;
    private String upperLimit;
    private String dimensions;
    private String data;

    public SampledData(Quantity origin, String period, String factor, String lowerLimit, String upperLimit, String dimensions, String data) {
        this.origin = origin;
        this.period = period;
        this.factor = factor;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.dimensions = dimensions;
        this.data = data;
    }

    public Quantity getOrigin() {
        return origin;
    }

    public void setOrigin(Quantity origin) {
        this.origin = origin;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public String getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(String lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public String getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(String upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SampledData{" +
                "origin=" + origin +
                ", period='" + period + '\'' +
                ", factor='" + factor + '\'' +
                ", lowerLimit='" + lowerLimit + '\'' +
                ", upperLimit='" + upperLimit + '\'' +
                ", dimensions='" + dimensions + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
