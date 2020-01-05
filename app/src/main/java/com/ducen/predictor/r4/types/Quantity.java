package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class Quantity {

    private String value;
    private String comparator;
    private String unit;
    private String system;
    private String code;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getComparator() {
        return comparator;
    }

    public void setComparator(String comparator) {
        this.comparator = comparator;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Quantity(){

    }

    public Quantity(String value, String comparator, String unit, String system, String code) {
        this.value = value;
        this.comparator = comparator;
        this.unit = unit;
        this.system = system;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "value='" + value + '\'' +
                ", comparator='" + comparator + '\'' +
                ", unit='" + unit + '\'' +
                ", system='" + system + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}


