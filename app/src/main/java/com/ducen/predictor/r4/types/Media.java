package com.ducen.predictor.r4.types;


import com.ducen.predictor.r4.types.Reference;

public class Media {

    private String comment;
    private Reference link;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Reference getLink() {
        return link;
    }

    public void setLink(Reference link) {
        this.link = link;
    }

    public Media() {

    }

    public Media(String comment, Reference link) {
        this.comment = comment;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Media{" +
                "comment='" + comment + '\'' +
                ", link=" + link +
                '}';
    }
}
