package com.ducen.predictor.r4.types;

import java.io.Serializable;

//get from R4 datatypes
public class ContactPoint implements Serializable {

    private String system;
    private String value;
    private String use;
    private String rank;
    private String period;

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

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public ContactPoint() {
    }

    public ContactPoint(String system, String value, String use, String rank, String period) {
        this.system = system;
        this.value = value;
        this.use = use;
        this.rank = rank;
        this.period = period;
    }

    @Override
    public String toString() {
        return "ContactPoint{" +
                "system='" + system + '\'' +
                ", value='" + value + '\'' +
                ", use='" + use + '\'' +
                ", rank='" + rank + '\'' +
                ", period='" + period + '\'' +
                '}';
    }

}
