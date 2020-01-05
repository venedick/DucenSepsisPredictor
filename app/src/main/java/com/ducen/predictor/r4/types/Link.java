package com.ducen.predictor.r4.types;

import com.ducen.predictor.r4.types.Reference;

public class Link {
    private Reference other;
    private String type;

    public Link(Reference other, String type) {
        this.other = other;
        this.type = type;
    }

    public Reference getOther() {
        return other;
    }

    public void setOther(Reference other) {
        this.other = other;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Link{" +
                "other=" + other +
                ", type='" + type + '\'' +
                '}';
    }
}
