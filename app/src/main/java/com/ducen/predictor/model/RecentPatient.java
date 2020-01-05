package com.ducen.predictor.model;

import java.io.Serializable;

public class RecentPatient implements Serializable {

    private String patientId;
    private String fullname;
    private String fname;
    private String lname;
    private String phoneNumber;
    private String address;
    private String email;
    private String gender;
    private String age;
    private String birthDate;
    private String appointmentDescription;
    private String appointmentDate;

    public RecentPatient(){

    }

    public RecentPatient(String patientId, String fullname, String fname, String lname, String phoneNumber, String gender, String age, String birthDate, String address, String email, String appointmentDescription, String appointmentDate) {
        this.patientId = patientId;
        this.fullname = fullname;
        this.fname = fname;
        this.lname = lname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.birthDate = birthDate;
        this.appointmentDescription = appointmentDescription;
        this.appointmentDate = appointmentDate;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String toString() {
        return "RecentPatient{" +
                "patientId='" + patientId + '\'' +
                ", fullname='" + fullname + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", appointmentDescription='" + appointmentDescription + '\'' +
                ", appointmentDate='" + appointmentDate + '\'' +
                '}';
    }
}
