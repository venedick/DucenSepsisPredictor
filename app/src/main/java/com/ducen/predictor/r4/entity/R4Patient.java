package com.ducen.predictor.r4.entity;

import com.ducen.predictor.r4.types.Address;
import com.ducen.predictor.r4.types.Attachment;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Contact;
import com.ducen.predictor.r4.types.ContactPoint;
import com.ducen.predictor.r4.types.HumanName;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Link;
import com.ducen.predictor.r4.types.Reference;

import java.io.Serializable;
import java.util.List;

public class R4Patient implements Serializable {

    private String patientId;
    private List<Identifier> identifiers;
    private String active;
    private List<HumanName> humanName;
    private List<ContactPoint> telecom;
    private String gender;
    private List<Address> address;
    private String deceasedBoolean;
    private String deceasedDateTime;
    private String multipleBirthBoolean;
    private String multipleBirthInteger;
    private String birthDate;
    private Attachment photo;
    private List<Contact> contact;
    private CodeableConcept communication;
    private Reference generalPractitioner;
    private Reference managingOrganization;
    private Link link;

    public R4Patient(){

    }

    public R4Patient(String patientId, List<Identifier> identifiers, String active, List<HumanName> humanName, List<ContactPoint> telecom, String gender, List<Address> address, String deceasedBoolean, String deceasedDateTime, String multipleBirthBoolean, String multipleBirthInteger, String birthDate, Attachment photo, List<Contact> contact, CodeableConcept communication, Reference generalPractitioner, Reference managingOrganization, Link link) {
        this.patientId = patientId;
        this.identifiers = identifiers;
        this.active = active;
        this.humanName = humanName;
        this.telecom = telecom;
        this.gender = gender;
        this.address = address;
        this.deceasedBoolean = deceasedBoolean;
        this.deceasedDateTime = deceasedDateTime;
        this.multipleBirthBoolean = multipleBirthBoolean;
        this.multipleBirthInteger = multipleBirthInteger;
        this.birthDate = birthDate;
        this.photo = photo;
        this.contact = contact;
        this.communication = communication;
        this.generalPractitioner = generalPractitioner;
        this.managingOrganization = managingOrganization;
        this.link = link;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public CodeableConcept getCommunication() {
        return communication;
    }

    public void setCommunication(CodeableConcept communication) {
        this.communication = communication;
    }

    public Reference getGeneralPractitioner() {
        return generalPractitioner;
    }

    public void setGeneralPractitioner(Reference generalPractitioner) {
        this.generalPractitioner = generalPractitioner;
    }

    public List<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<Identifier> identifiers) {
        this.identifiers = identifiers;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public String getDeceasedBoolean() {
        return deceasedBoolean;
    }

    public void setDeceasedBoolean(String deceasedBoolean) {
        this.deceasedBoolean = deceasedBoolean;
    }

    public String getDeceasedDateTime() {
        return deceasedDateTime;
    }

    public void setDeceasedDateTime(String deceasedDateTime) {
        this.deceasedDateTime = deceasedDateTime;
    }

    public String getMultipleBirthBoolean() {
        return multipleBirthBoolean;
    }

    public void setMultipleBirthBoolean(String multipleBirthBoolean) {
        this.multipleBirthBoolean = multipleBirthBoolean;
    }

    public String getMultipleBirthInteger() {
        return multipleBirthInteger;
    }

    public void setMultipleBirthInteger(String multipleBirthInteger) {
        this.multipleBirthInteger = multipleBirthInteger;
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

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    public CodeableConcept getCommunicaiton() {
        return communication;
    }

    public void setCommunicaiton(CodeableConcept communication) {
        this.communication = communication;
    }

    public Reference getGeneralPractioner() {
        return generalPractitioner;
    }

    public void setGeneralPractioner(Reference generalPractitioner) {
        this.generalPractitioner = generalPractitioner;
    }

    public Reference getManagingOrganization() {
        return managingOrganization;
    }

    public void setManagingOrganization(Reference managingOrganization) {
        this.managingOrganization = managingOrganization;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "R4Patient{" +
                "identifiers=" + identifiers +
                ", active='" + active + '\'' +
                ", humanName=" + humanName +
                ", telecom=" + telecom +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                ", deceasedBoolean='" + deceasedBoolean + '\'' +
                ", deceasedDateTime='" + deceasedDateTime + '\'' +
                ", multipleBirthBoolean='" + multipleBirthBoolean + '\'' +
                ", multipleBirthInteger='" + multipleBirthInteger + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", photo=" + photo +
                ", contact=" + contact +
                ", communication=" + communication +
                ", generalPractitioner=" + generalPractitioner +
                ", managingOrganization=" + managingOrganization +
                ", link=" + link +
                '}';
    }
}
