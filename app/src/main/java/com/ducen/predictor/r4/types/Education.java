package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class Education {

    private String documentType;
    private String reference;
    private String publicationDate;
    private String presentationDate;

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPresentationDate() {
        return presentationDate;
    }

    public void setPresentationDate(String presentationDate) {
        this.presentationDate = presentationDate;
    }

    public Education() {

    }

    public Education(String documentType, String reference, String publicationDate, String presentationDate) {
        this.documentType = documentType;
        this.reference = reference;
        this.publicationDate = publicationDate;
        this.presentationDate = presentationDate;
    }

    @Override
    public String toString() {
        return "Education{" +
                "documentType='" + documentType + '\'' +
                ", reference='" + reference + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", presentationDate='" + presentationDate + '\'' +
                '}';
    }
}
