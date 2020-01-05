package com.ducen.predictor.r4.types;

public class SimpleQuantity {
    private String value;
    private String currency;

    public SimpleQuantity(String value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "SimpleQuantity{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
