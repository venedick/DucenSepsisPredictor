package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class Ratio {

    private Quantity numerator;
    private Quantity denominator;

    public Quantity getNumerator() {
        return numerator;
    }

    public void setNumerator(Quantity numerator) {
        this.numerator = numerator;
    }

    public Quantity getDenominator() {
        return denominator;
    }

    public void setDenominator(Quantity denominator) {
        this.denominator = denominator;
    }

    public Ratio(){

    }

    public Ratio(Quantity numerator, Quantity denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return "Ratio{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
