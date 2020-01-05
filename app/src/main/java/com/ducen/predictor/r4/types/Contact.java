package com.ducen.predictor.r4.types;

import com.ducen.predictor.r4.types.Address;
import com.ducen.predictor.r4.types.ContactPoint;
import com.ducen.predictor.r4.types.HumanName;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.Relationship;

import java.io.Serializable;
import java.util.List;

public class Contact implements Serializable {
    private List<Relationship> relationship;
    private List<HumanName> humanName;
    private List<ContactPoint> telecom;
    private List<Address> address;
    private String gender;
    private Reference organization;
    private Period period;

    public Contact(){

    }

    public Contact(List<Relationship> relationship, List<HumanName> humanName, List<ContactPoint> telecom, List<Address> address, String gender, Period period) {
        this.relationship = relationship;
        this.humanName = humanName;
        this.telecom = telecom;
        this.address = address;
        this.gender = gender;
        this.period = period;
    }

    public List<Relationship> getRelationship() {
        return relationship;
    }

    public void setRelationship(List<Relationship> relationship) {
        this.relationship = relationship;
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

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "relationship=" + relationship +
                ", humanName=" + humanName +
                ", telecom=" + telecom +
                ", address=" + address +
                ", gender='" + gender + '\'' +
                ", period=" + period +
                '}';
    }
}
