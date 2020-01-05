package com.ducen.predictor.r4.types;

//get from R4 datatypes
public class Annotation {

    private Reference author;
    private String time;
    private String text;

    public Reference getAuthor() {
        return author;
    }

    public void setAuthor(Reference author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Annotation(){

    }

    public Annotation(Reference author, String time, String text) {
        this.author = author;
        this.time = time;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Annotation{" +
                "author=" + author +
                ", time='" + time + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
