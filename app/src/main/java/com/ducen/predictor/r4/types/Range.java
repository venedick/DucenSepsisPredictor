package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class Range {

    private SimpleQuantity low;
    private SimpleQuantity high;

    public SimpleQuantity getLow() {
        return low;
    }

    public void setLow(SimpleQuantity low) {
        this.low = low;
    }

    public SimpleQuantity getHigh() {
        return high;
    }

    public void setHigh(SimpleQuantity high) {
        this.high = high;
    }

    public Range() {

    }

    public Range(SimpleQuantity low, SimpleQuantity high) {
        this.low = low;
        this.high = high;
    }

    @Override
    public String toString() {
        return "Range{" +
                "low='" + low + '\'' +
                ", high='" + high + '\'' +
                '}';
    }
}
