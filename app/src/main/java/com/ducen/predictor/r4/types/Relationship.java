package com.ducen.predictor.r4.types;

public class Relationship {

    private String id;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Relationship(String id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

}
