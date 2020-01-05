package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class Reaction {

    private String date;
    private Reference detail;
    private String reported;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Reference getDetail() {
        return detail;
    }

    public void setDetail(Reference detail) {
        this.detail = detail;
    }

    public String getReported() {
        return reported;
    }

    public void setReported(String reported) {
        this.reported = reported;
    }

    public Reaction() {

    }

    public Reaction(String date, Reference detail, String reported) {
        this.date = date;
        this.detail = detail;
        this.reported = reported;
    }

    @Override
    public String toString() {
        return "Reaction{" +
                "date='" + date + '\'' +
                ", detail=" + detail +
                ", reported='" + reported + '\'' +
                '}';
    }
}


