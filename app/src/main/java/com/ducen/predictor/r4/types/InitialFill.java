package com.ducen.predictor.r4.types;

import javax.xml.datatype.Duration;

public class InitialFill {

    private SimpleQuantity quantity;
    private String duration;

    public InitialFill(){

    }
    public InitialFill(SimpleQuantity quantity, String duration) {
        this.quantity = quantity;
        this.duration = duration;
    }

    public SimpleQuantity getQuantity() {
        return quantity;
    }

    public void setQuantity(SimpleQuantity quantity) {
        this.quantity = quantity;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "InitialFill{" +
                "quantity=" + quantity +
                ", duration=" + duration +
                '}';
    }
}
