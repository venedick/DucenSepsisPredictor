package com.ducen.predictor.r4.entity;


import com.ducen.predictor.r4.types.Address;
import com.ducen.predictor.r4.types.Attachment;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.ContactPoint;
import com.ducen.predictor.r4.types.HumanName;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Qualification;

import java.util.List;

public class R4Practitioner {

    private Meta meta;
    private List<Identifier> identifier;
    private String active;
    private List<HumanName> humanName;
    private List<ContactPoint> telecom;
    private List<Address> address;
    private String gender;
    private String birthDate;
    private Attachment photo;
    private List<Qualification> qualification;
    private CodeableConcept communication;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Identifier> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<Identifier> identifier) {
        this.identifier = identifier;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public List<HumanName> getHumanName() {
        return humanName;
    }

    public void setHumanName(List<HumanName> humanName) {
        this.humanName = humanName;
    }

    public List<ContactPoint> getTelecom() {
        return telecom;
    }

    public void setTelecom(List<ContactPoint> telecom) {
        this.telecom = telecom;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Attachment getPhoto() {
        return photo;
    }

    public void setPhoto(Attachment photo) {
        this.photo = photo;
    }

    public List<Qualification> getQualification() {
        return qualification;
    }

    public void setQualification(List<Qualification> qualification) {
        this.qualification = qualification;
    }

    public CodeableConcept getCommunication() {
        return communication;
    }

    public void setCommunication(CodeableConcept communication) {
        this.communication = communication;
    }

    public R4Practitioner() {

    }

    public R4Practitioner(Meta meta, List<Identifier> identifier, String active, List<HumanName> humanName, List<ContactPoint> telecom, List<Address> address, String gender, String birthDate, Attachment photo, List<Qualification> qualification, CodeableConcept communication) {
        this.meta = meta;
        this.identifier = identifier;
        this.active = active;
        this.humanName = humanName;
        this.telecom = telecom;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
        this.photo = photo;
        this.qualification = qualification;
        this.communication = communication;
    }

    @Override
    public String toString() {
        return "R4Practitioner{" +
                "meta=" + meta +
                ", identifier=" + identifier +
                ", active='" + active + '\'' +
                ", humanName=" + humanName +
                ", telecom=" + telecom +
                ", address=" + address +
                ", gender='" + gender + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", photo=" + photo +
                ", qualification=" + qualification +
                ", communication=" + communication +
                '}';
    }
}
