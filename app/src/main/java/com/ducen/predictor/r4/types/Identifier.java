package com.ducen.predictor.r4.types;

//get from R4 datatypes
public class Identifier {

    private String use;
    private String type;
    private String system;
    private String value;
    private String period;

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Identifier() {
    }

    public Identifier(String use, String type, String system, String value, String period) {
        this.use = use;
        this.type = type;
        this.system = system;
        this.value = value;
        this.period = period;
    }

    @Override
    public String toString() {
        return "Identifier{" +
                "use='" + use + '\'' +
                ", type='" + type + '\'' +
                ", system='" + system + '\'' +
                ", value='" + value + '\'' +
                ", period='" + period + '\'' +
                '}';
    }
}
