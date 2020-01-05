package com.ducen.predictor.service;

import android.util.Log;

import com.ducen.predictor.model.RecentPatient;
import com.ducen.predictor.r4.entity.R4Appointment;
import com.ducen.predictor.r4.entity.R4Patient;
import com.ducen.predictor.r4.types.Address;
import com.ducen.predictor.r4.types.ContactPoint;
import com.ducen.predictor.r4.types.HumanName;
import com.ducen.predictor.r4.types.Participant;
import com.ducen.predictor.r4.types.Reference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecentPatientService {

    public List<RecentPatient> createRecentPatientListBasedFromAppointmentList(List<R4Appointment> r4AppointmentList) {

        List<RecentPatient> recentPatientList = new ArrayList<>();

        for (R4Appointment r4Appointment : r4AppointmentList) {
            RecentPatient recentPatient = new RecentPatient();
            recentPatient.setAppointmentDate(r4Appointment.getStart());
            recentPatient.setAppointmentDescription(r4Appointment.getDescription());

            String patientId = extractPatientIdFromAppointment(r4Appointment);
            recentPatient.setPatientId(patientId);

            recentPatientList.add(recentPatient);
        }
        return recentPatientList;
    }

    public List<RecentPatient> createRecentPatientListBasedFromPatientList(List<R4Patient> r4PatientList) {
        List<RecentPatient> recentPatientList = new ArrayList<>();

        for (R4Patient r4Patient : r4PatientList) {
            RecentPatient recentPatient = new RecentPatient();

            String patientId = r4Patient.getPatientId();
            recentPatient.setPatientId(patientId);


            //populate human name
            if (r4Patient.getHumanName() != null) {
                List<HumanName> patientNames = r4Patient.getHumanName();
                for (HumanName humanName : patientNames) {
                    String familyName = humanName.getFamily();
                    String givenNames = humanName.getGiven().get(0);
                    String fullName = givenNames + " " + familyName;
                    recentPatient.setFullname(fullName);//fullName
                    recentPatient.setFname(givenNames);//firstName
                    recentPatient.setLname(familyName);//lastName
                }
            }

            if (r4Patient.getAddress() != null) {
                List<Address> patientAddress = r4Patient.getAddress();
                for (Address address : patientAddress) {
                    String homeAddress = address.getLine().get(0) + ", " + address.getCity() + ", " + address.getPostalCode() + ", " + address.getCountry();
                    recentPatient.setAddress(homeAddress);
                }
            }

            if (r4Patient.getTelecom() != null) {
                List<ContactPoint> patientContacts = r4Patient.getTelecom();
                for (ContactPoint contactPoint : patientContacts) {
                    String phoneNumber = contactPoint.getValue();
                    recentPatient.setPhoneNumber(phoneNumber);
                }
            }


            String gender = r4Patient.getGender();
            recentPatient.setGender(gender);//gender

            String birthdate = r4Patient.getBirthDate();
            recentPatient.setBirthDate(birthdate); // this should be birthdate, not age

            recentPatientList.add(recentPatient);
        }

        return recentPatientList;
    }

    public List<String> createPatientIdListBasedFromAppointmentList(List<R4Appointment> r4AppointmentList) {

        List<String> patientIdList = new ArrayList<>();

//        patientIdList.add("0");
//        patientIdList.add("13");
//        patientIdList.add("5");
//        patientIdList.add("22");

        for (R4Appointment r4Appointment : r4AppointmentList) {
            String patientId = extractPatientIdFromAppointment(r4Appointment);
            patientIdList.add(patientId);
        }

        Set<String> set = new HashSet<String>();

        set.addAll(patientIdList);
        patientIdList.clear();
        patientIdList.addAll(set);
        return patientIdList;
    }

    public List<String> createPatientIdListBasedFromPatientList(List<R4Patient> r4PatientList) {

        List<String> patientIdList = new ArrayList<>();

        for (R4Patient r4Patient : r4PatientList) {
            String patientId = r4Patient.getPatientId();
            patientIdList.add(patientId);
        }

        Set<String> set = new HashSet<String>();
        set.addAll(patientIdList);

        patientIdList.clear();
        patientIdList.addAll(set);
        return patientIdList;
    }

    public String extractPatientIdFromAppointment(R4Appointment r4Appointment) {
        String patientId = "";
        for (Participant participant : r4Appointment.getParticipant()) {
            Reference reference = participant.getActor();
            String getReference = reference.getReference();
            if (getReference.contains("Patient/")) {
                patientId = getReference.substring(8);
                break;
            }
        }
        return patientId;
    }

    public List<RecentPatient> setPatientDataOnRecentPatient(R4Patient r4Patient, List<RecentPatient> recentPatientList) {

        for (RecentPatient recentPatient : recentPatientList) {

            if (recentPatient.getPatientId().equalsIgnoreCase(r4Patient.getPatientId())) {

                //populate human name
                if (r4Patient.getHumanName() != null) {
                    List<HumanName> patientNames = r4Patient.getHumanName();
                    for (HumanName humanName : patientNames) {
                        String familyName = humanName.getFamily();
                        String givenNames = humanName.getGiven().get(0);
                        String fullName = givenNames + " " + familyName;
                        recentPatient.setFullname(fullName);//fullName
                        recentPatient.setFname(givenNames);//firstName
                        recentPatient.setLname(familyName);//lastName
                    }
                }

                if (r4Patient.getAddress() != null) {
                    List<Address> patientAddress = r4Patient.getAddress();
                    for (Address address : patientAddress) {
                        String homeAddress = address.getLine().get(0) + ", " + address.getCity() + ", " + address.getPostalCode() + ", " + address.getCountry();
                        recentPatient.setAddress(homeAddress);
                    }
                }

                if (r4Patient.getTelecom() != null) {
                    List<ContactPoint> patientContacts = r4Patient.getTelecom();
                    for (ContactPoint contactPoint : patientContacts) {
                        String phoneNumber = contactPoint.getValue();
                        recentPatient.setPhoneNumber(phoneNumber);
                    }
                }


                String gender = r4Patient.getGender();
                recentPatient.setGender(gender);//gender

                String birthdate = r4Patient.getBirthDate();
                recentPatient.setBirthDate(birthdate); // this should be birthdate, not age

            }
        }

        return recentPatientList;
    }

    public List<RecentPatient> setAppointmentDataOnRecentPatient(R4Appointment r4Appointment, List<RecentPatient> recentPatientList) {
        String patientId = extractPatientIdFromAppointment(r4Appointment);
        for (RecentPatient recentPatient : recentPatientList) {
            if (recentPatient.getPatientId().equalsIgnoreCase(patientId)) {
                recentPatient.setAppointmentDate(r4Appointment.getStart());
                recentPatient.setAppointmentDescription(r4Appointment.getDescription());
            }
        }
        return recentPatientList;
    }



}
