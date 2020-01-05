package com.ducen.predictor.r4.types;

import java.io.Serializable;
import java.util.List;

//get from R4 datatypes
public class HumanName implements Serializable {

    private String use;
    private String text;
    private String family;
    private List<String> given;
    private List<String> prefix;
    private List<String> suffix;
    private Period period;

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<String> getGiven() {
        return given;
    }

    public void setGiven(List<String> given) {
        this.given = given;
    }

    public List<String> getPrefix() {
        return prefix;
    }

    public void setPrefix(List<String> prefix) {
        this.prefix = prefix;
    }

    public List<String> getSuffix() {
        return suffix;
    }

    public void setSuffix(List<String> suffix) {
        this.suffix = suffix;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public HumanName() {

    }

    public HumanName(String use, String text, String family, List<String> given, List<String> prefix, List<String> suffix, Period period) {
        this.use = use;
        this.text = text;
        this.family = family;
        this.given = given;
        this.prefix = prefix;
        this.suffix = suffix;
        this.period = period;
    }

    @Override
    public String toString() {
        return "HumanName{" +
                "use='" + use + '\'' +
                ", text='" + text + '\'' +
                ", family='" + family + '\'' +
                ", given=" + given +
                ", prefix=" + prefix +
                ", suffix=" + suffix +
                ", period='" + period + '\'' +
                '}';
    }
}
