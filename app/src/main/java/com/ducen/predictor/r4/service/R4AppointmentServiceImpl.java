package com.ducen.predictor.r4.service;

import android.util.Log;


import com.ducen.predictor.defaultdata.Properties;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Participant;
import com.ducen.predictor.r4.types.Stage;
import com.ducen.predictor.r4.entity.R4Appointment;
import com.ducen.predictor.r4.entity.R4Evidence;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class R4AppointmentServiceImpl implements R4AppointmentService {

    @Override
    public boolean checkExist(JSONObject jsonObject) {
        boolean status = false;
        try {
            if (jsonObject.has(Properties.KEY_TOTAL)) {
                String total = jsonObject.getString(Properties.KEY_TOTAL);
                if (Integer.parseInt(total) > 0) {
                    status = true;
                } else {
                    status = false;
                }
            }
        } catch (Exception e) {
            Log.d("TEST", "checkExist Exception : " + e.toString());
            status = false;
        }
        return status;
    }

    @Override
    public List<R4Appointment> createR4AppointmentList(JSONObject jsonObject) {
        List<R4Appointment> r4AppointmentList = new ArrayList<>();

        try {
            if (jsonObject.has(Properties.KEY_ENTRY)) {
                JSONArray jsonEntry = jsonObject.getJSONArray(Properties.KEY_ENTRY);
                for (int c = 0; c < jsonEntry.length(); c++) {

                    JSONObject jsonResources = jsonObject.getJSONArray(Properties.KEY_ENTRY).getJSONObject(c);

                    if (jsonResources.has(Properties.KEY_RESOURCE)) {
                        JSONObject jsonResource = jsonResources.getJSONObject(Properties.KEY_RESOURCE);
                        R4Appointment r4Appointment = createR4Appointment(jsonResource);
                        r4AppointmentList.add(r4Appointment);
                    }

                }

            }
        } catch (Exception e) {
            Log.d("TEST", "createR4AppointmentList Exception : " + e.toString());
        }

        return r4AppointmentList;
    }

    @Override
    public R4Appointment createR4Appointment(JSONObject jsonObject) {
        R4Appointment r4Appointment = new R4Appointment();

        try {

            //initialize META
            if (jsonObject.has(Properties.KEY_META)) {
                JSONObject jsonMeta = jsonObject.getJSONObject(Properties.KEY_META);
                Meta meta = createMeta(jsonMeta);
                r4Appointment.setMeta(meta);
            }

            //initialize IDENTIFIER
            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> identifierList = createIdentifierList(jsonArrayIdentifier);
                r4Appointment.setIdentifier(identifierList);
            }

            //initialize status
            if (jsonObject.has(Properties.KEY_STATUS)) {
                String status = jsonObject.getString(Properties.KEY_STATUS);
                r4Appointment.setStatus(status);
            }

            //initialize cancelationReason
            if (jsonObject.has(Properties.KEY_CANCELATION_REASON)) {
                JSONObject jsonCancelationReason = jsonObject.getJSONObject(Properties.KEY_CANCELATION_REASON);
                CodeableConcept cancelationReason = createCodeableConcept(jsonCancelationReason);
                r4Appointment.setCancelationReason(cancelationReason);
            }

            //initialize serviceCategory
            if (jsonObject.has(Properties.KEY_SERVICE_CATEGORY)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_SERVICE_CATEGORY);
                List<CodeableConcept> serviceCategoryList = createCodeableConceptList(jsonArray);
                r4Appointment.setServiceCategory(serviceCategoryList);
            }

            //initialize serviceType
            if (jsonObject.has(Properties.KEY_SERVICE_TYPE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_SERVICE_TYPE);
                List<CodeableConcept> serviceTypeList = createCodeableConceptList(jsonArray);
                r4Appointment.setServiceType(serviceTypeList);
            }

            //initialize specialty
            if (jsonObject.has(Properties.KEY_SPECIALTY)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_SPECIALTY);
                List<CodeableConcept> specialtyList = createCodeableConceptList(jsonArray);
                r4Appointment.setSpecialty(specialtyList);
            }

            //initialize appointmentType
            if (jsonObject.has(Properties.KEY_APPOINTMENT_TYPE)) {
                JSONObject jsonAppointmentType = jsonObject.getJSONObject(Properties.KEY_APPOINTMENT_TYPE);
                CodeableConcept appointmentType = createCodeableConcept(jsonAppointmentType);
                r4Appointment.setAppointmentType(appointmentType);
            }

            //initialize reasonCode
            if (jsonObject.has(Properties.KEY_REASON_CODE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_REASON_CODE);
                List<CodeableConcept> reasonCodeList = createCodeableConceptList(jsonArray);
                r4Appointment.setReasonCode(reasonCodeList);
            }

            //initialize reasonReference
            if (jsonObject.has(Properties.KEY_REASON_REFERENCE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_REASON_REFERENCE);
                List<Reference> reasonReferenceList = createReferenceList(jsonArray);
                r4Appointment.setReasonReference(reasonReferenceList);
            }

            //initialize priority
            if (jsonObject.has(Properties.KEY_PRIORITY)) {
                String priority = jsonObject.getString(Properties.KEY_PRIORITY);
                r4Appointment.setPriority(priority);
            }

            //initialize description
            if (jsonObject.has(Properties.KEY_DESCRIPTION)) {
                String description = jsonObject.getString(Properties.KEY_DESCRIPTION);
                r4Appointment.setDescription(description);
            }

            //initialize supportingInformation
            if (jsonObject.has(Properties.KEY_SUPPORTING_INFORMATION)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_SUPPORTING_INFORMATION);
                List<Reference> supportingInformationList = createReferenceList(jsonArray);
                r4Appointment.setSupportingInformation(supportingInformationList);
            }

            //initialize start
            if (jsonObject.has(Properties.KEY_START)) {
                String start = jsonObject.getString(Properties.KEY_START);
                r4Appointment.setStart(start);
            }

            //initialize end
            if (jsonObject.has(Properties.KEY_END)) {
                String end = jsonObject.getString(Properties.KEY_END);
                r4Appointment.setEnd(end);
            }

            //initialize minutesDuration
            if (jsonObject.has(Properties.KEY_MINUTES_DURATION)) {
                String minutesDuration = jsonObject.getString(Properties.KEY_MINUTES_DURATION);
                r4Appointment.setMinutesDuration(minutesDuration);
            }

            //initialize slot
            if (jsonObject.has(Properties.KEY_SLOT)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_SLOT);
                List<Reference> slotList = createReferenceList(jsonArray);
                r4Appointment.setSlot(slotList);
            }

            //initialize created
            if (jsonObject.has(Properties.KEY_CREATED)) {
                String created = jsonObject.getString(Properties.KEY_CREATED);
                r4Appointment.setCreated(created);
            }

            //initialize comment
            if (jsonObject.has(Properties.KEY_COMMENT)) {
                String comment = jsonObject.getString(Properties.KEY_COMMENT);
                r4Appointment.setComment(comment);
            }

            //initialize patientInstruction
            if (jsonObject.has(Properties.KEY_PATIENT_INSTRUCTION)) {
                String patientInstruction = jsonObject.getString(Properties.KEY_PATIENT_INSTRUCTION);
                r4Appointment.setPatientInstruction(patientInstruction);
            }

            //initialize basedOn
            if (jsonObject.has(Properties.KEY_BASED_ON)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_BASED_ON);
                List<Reference> basedOnList = createReferenceList(jsonArray);
                r4Appointment.setBasedOn(basedOnList);
            }

            //initialize participant
            if (jsonObject.has(Properties.KEY_PARTICIPANT)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_PARTICIPANT);
                List<Participant> participantList = createR4ParticipantList(jsonArray);
                r4Appointment.setParticipant(participantList);
            }

            //initialize requestedPeriod
            if (jsonObject.has(Properties.KEY_REQUESTED_PERIOD)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_REQUESTED_PERIOD);
                List<Period> requestedPeriodList = createPeriodList(jsonArray);
                r4Appointment.setRequestedPeriod(requestedPeriodList);
            }


        } catch (Exception e) {
            Log.d("TEST", "createR4Appointment Exception : " + e.toString());
        }

        return r4Appointment;
    }

    @Override
    public Meta createMeta(JSONObject jsonObject) {
        Meta meta = new Meta("", "", "");
        try {

            if (jsonObject.has(Properties.KEY_VERSIONID)) {
                String versionId = jsonObject.getString(Properties.KEY_VERSIONID);
                meta.setVersionId(versionId);
            }

            if (jsonObject.has(Properties.KEY_LAST_UPDATED)) {
                String lastUpdated = jsonObject.getString(Properties.KEY_LAST_UPDATED);
                meta.setLastUpdated(lastUpdated);
            }

            if (jsonObject.has(Properties.KEY_SOURCE)) {
                String source = jsonObject.getString(Properties.KEY_SOURCE);
                meta.setSource(source);
            }
        } catch (Exception e) {
            Log.d("TEST", "createMeta Exception : " + e.toString());
        }
        return meta;
    }

    @Override
    public Participant createR4Participant(JSONObject jsonObject) {
        Participant participant = new Participant();
        try {
            if (jsonObject.has(Properties.KEY_TYPE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_TYPE);
                List<CodeableConcept> typeList = createCodeableConceptList(jsonArray);
                participant.setType(typeList);
            }

            if (jsonObject.has(Properties.KEY_ACTOR)) {
                JSONObject jsonActor = jsonObject.getJSONObject(Properties.KEY_ACTOR);
                Reference actor = createReference(jsonActor);
                participant.setActor(actor);
            }

            if (jsonObject.has(Properties.KEY_REQUIRED)) {
                String required = jsonObject.getString(Properties.KEY_REQUIRED);
                participant.setRequired(required);
            }

            if (jsonObject.has(Properties.KEY_STATUS)) {
                String status = jsonObject.getString(Properties.KEY_STATUS);
                participant.setStatus(status);
            }

            if (jsonObject.has(Properties.KEY_PERIOD)) {
                JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_PERIOD);
                Period period = createPeriod(jsonPeriod);
                participant.setPeriod(period);
            }


        } catch (
                Exception e) {
            Log.d("TEST", "createR4Evidence Exception : " + e.toString());
        }
        return participant;

    }

    @Override
    public Annotation createAnnotation(JSONObject jsonObject) {
        Annotation annotation = new Annotation();
        try {
            if (jsonObject.has(Properties.KEY_AUTHOR_REFERENCE)) {
                JSONObject jsonReference = jsonObject.getJSONObject(Properties.KEY_AUTHOR_REFERENCE);
                Reference author = createReference(jsonReference);
                annotation.setAuthor(author);
            }

            if (jsonObject.has(Properties.KEY_TIME)) {
                String time = jsonObject.getString(Properties.KEY_TIME);
                annotation.setTime(time);
            }

            if (jsonObject.has(Properties.KEY_TEXT)) {
                String text = jsonObject.getString(Properties.KEY_TEXT);
                annotation.setText(text);
            }

        } catch (Exception e) {
            Log.d("TEST", "createAnnotation Exception : " + e.toString());
        }
        return annotation;
    }

    @Override
    public CodeableConcept createCodeableConcept(JSONObject jsonObject) {
        CodeableConcept codeableConcept = new CodeableConcept(null, "");
        try {

            if (jsonObject.has(Properties.KEY_CODING)) {
                JSONArray jsonArrayCoding = jsonObject.getJSONArray(Properties.KEY_CODING);
                List<Coding> listOfCoding = createCodingList(jsonArrayCoding);
                codeableConcept.setCoding(listOfCoding);
            }

            if (jsonObject.has(Properties.KEY_TEXT)) {
                String text = jsonObject.getString(Properties.KEY_TEXT);
                codeableConcept.setText(text);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createCodeableConcept Exception : " + e.toString());
        }
        return codeableConcept;
    }

    @Override
    public Coding createCoding(JSONObject jsonObject) {
        Coding coding = new Coding("", "", "", "", "");
        try {

            if (jsonObject.has(Properties.KEY_SYSTEM)) {
                String system = jsonObject.getString(Properties.KEY_SYSTEM);
                coding.setSystem(system);
            }

            if (jsonObject.has(Properties.KEY_VERSION)) {
                String version = jsonObject.getString(Properties.KEY_VERSION);
                coding.setVersion(version);
            }

            if (jsonObject.has(Properties.KEY_CODE)) {
                String code = jsonObject.getString(Properties.KEY_CODE);
                coding.setCode(code);
            }

            if (jsonObject.has(Properties.KEY_DISPLAY)) {
                String display = jsonObject.getString(Properties.KEY_DISPLAY);
                coding.setDisplay(display);
            }

            if (jsonObject.has(Properties.KEY_USER_SELECTED)) {
                String userSelected = jsonObject.getString(Properties.KEY_USER_SELECTED);
                coding.setUserSelected(userSelected);
            }

        } catch (Exception e) {
            Log.d("TEST", "createCoding Exception : " + e.toString());
        }
        return coding;
    }

    @Override
    public Identifier createIdentifier(JSONObject jsonObject) {
        Identifier identifier = new Identifier();
        try {

            if (jsonObject.has(Properties.KEY_USE)) {
                String use = jsonObject.getString(Properties.KEY_USE);
                identifier.setUse(use);
            }

            if (jsonObject.has(Properties.KEY_TYPE)) {
                String type = jsonObject.getString(Properties.KEY_TYPE);
                identifier.setType(type);
            }

            if (jsonObject.has(Properties.KEY_SYSTEM)) {
                String system = jsonObject.getString(Properties.KEY_SYSTEM);
                identifier.setSystem(system);
            }

            if (jsonObject.has(Properties.KEY_VALUE)) {
                String value = jsonObject.getString(Properties.KEY_VALUE);
                identifier.setValue(value);
            }

            if (jsonObject.has(Properties.KEY_PERIOD)) {
                String period = jsonObject.getString(Properties.KEY_PERIOD);
                identifier.setPeriod(period);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createIdentifier Exception : " + e.toString());
        }
        return identifier;
    }

    @Override
    public Period createPeriod(JSONObject jsonObject) {
        Period period = new Period("", "");
        try {

            if (jsonObject.has(Properties.KEY_START)) {
                String start = jsonObject.getString(Properties.KEY_START);
                period.setStart(start);
            }

            if (jsonObject.has(Properties.KEY_END)) {
                String end = jsonObject.getString(Properties.KEY_END);
                period.setEnd(end);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createPeriod Exception : " + e.toString());
        }
        return period;
    }

    @Override
    public Reference createReference(JSONObject jsonObject) {
        Reference patient = new Reference("", "", null, "");
        try {

            if (jsonObject.has(Properties.KEY_REFERENCE)) {
                String reference = jsonObject.getString(Properties.KEY_REFERENCE);
                patient.setReference(reference);
            }

            if (jsonObject.has(Properties.KEY_TYPE)) {
                String type = jsonObject.getString(Properties.KEY_TYPE);
                patient.setType(type);
            }

            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> listOfIdentifier = createIdentifierList(jsonArrayIdentifier);
                patient.setIdentifier(listOfIdentifier);
            }

            if (jsonObject.has(Properties.KEY_DISPLAY)) {
                String display = jsonObject.getString(Properties.KEY_DISPLAY);
                patient.setDisplay(display);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createReference Exception : " + e.toString());
        }
        return patient;
    }

    @Override
    public List<Identifier> createIdentifierList(JSONArray jsonArray) {
        List<Identifier> listOfIdentifier = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonIdentifier = jsonArray.getJSONObject(c);
                Identifier identifier = createIdentifier(jsonIdentifier);
                listOfIdentifier.add(identifier);
            }
        } catch (
                Exception e) {
            Log.d("TEST", "createIdentifier Exception : " + e.toString());
        }
        return listOfIdentifier;
    }

    @Override
    public List<Coding> createCodingList(JSONArray jsonArray) {
        List<Coding> codingList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Coding coding = createCoding(jsonObject);
                codingList.add(coding);
            }
        } catch (
                Exception e) {
            Log.d("TEST", "createCoding Exception : " + e.toString());
        }
        return codingList;
    }

    @Override
    public List<CodeableConcept> createCodeableConceptList(JSONArray jsonArray) {
        List<CodeableConcept> codeableConceptList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                CodeableConcept codeableConcept = createCodeableConcept(jsonObject);
                codeableConceptList.add(codeableConcept);
            }
        } catch (Exception e) {
            Log.d("TEST", "createCodeableConceptList Exception : " + e.toString());
        }
        return codeableConceptList;
    }

    @Override
    public List<Participant> createR4ParticipantList(JSONArray jsonArray) {
        List<Participant> participantList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Participant participant = createR4Participant(jsonObject);
                participantList.add(participant);
            }
        } catch (Exception e) {
            Log.d("TEST", "createR4ParticipantList Exception : " + e.toString());
        }
        return participantList;
    }

    @Override
    public List<Period> createPeriodList(JSONArray jsonArray) {
        List<Period> periodList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Period period = createPeriod(jsonObject);
                periodList.add(period);
            }
        } catch (Exception e) {
            Log.d("TEST", "createR4ParticipantList Exception : " + e.toString());
        }
        return periodList;
    }

    @Override
    public List<Reference> createReferenceList(JSONArray jsonArray) {
        List<Reference> referenceList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Reference reference = createReference(jsonObject);
                referenceList.add(reference);
            }
        } catch (Exception e) {
            Log.d("TEST", "createReaction Exception : " + e.toString());
        }
        return referenceList;
    }

}
