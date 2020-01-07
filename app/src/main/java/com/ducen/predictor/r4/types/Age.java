package com.ducen.predictor.r4.types;


import java.util.List;

public class Age {

    private String value;
    private String system;
    private String code;

    public Age() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    @Override
    public String toString() {
        return "Age{" +
                "value='" + value + '\'' +
                ", system='" + system + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
