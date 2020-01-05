package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class Address {

    private String use;
    private String type;
    private String text;
    private List<String> line;
    private String city;
    private String district;
    private String state;
    private String postalCode;
    private String country;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getLine() {
        return line;
    }

    public void setLine(List<String> line) {
        this.line = line;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Address() {

    }

    public Address(String use, String type, String text, List<String> line, String city, String district, String state, String postalCode, String country, String period) {
        this.use = use;
        this.type = type;
        this.text = text;
        this.line = line;
        this.city = city;
        this.district = district;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.period = period;
    }

    @Override
    public String toString() {
        return "Address{" +
                "use='" + use + '\'' +
                ", type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", line='" + line + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", period='" + period + '\'' +
                '}';
    }
}
