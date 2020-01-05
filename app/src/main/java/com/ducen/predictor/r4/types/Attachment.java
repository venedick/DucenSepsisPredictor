package com.ducen.predictor.r4.types;

import java.util.Base64;

//get from R4 datatypes
public class Attachment {

    private String contentType;
    private String language;
    private Base64 data;
    private String url;
    private String size;
    private Base64 hash;
    private String title;
    private String creation;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Base64 getData() {
        return data;
    }

    public void setData(Base64 data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Base64 getHash() {
        return hash;
    }

    public void setHash(Base64 hash) {
        this.hash = hash;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    public Attachment() {

    }


    public Attachment(String contentType, String language, Base64 data, String url, String size, Base64 hash, String title, String creation) {
        this.contentType = contentType;
        this.language = language;
        this.data = data;
        this.url = url;
        this.size = size;
        this.hash = hash;
        this.title = title;
        this.creation = creation;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "contentType='" + contentType + '\'' +
                ", language='" + language + '\'' +
                ", data=" + data +
                ", url=" + url +
                ", size='" + size + '\'' +
                ", hash=" + hash +
                ", title='" + title + '\'' +
                ", creation='" + creation + '\'' +
                '}';
    }
}
