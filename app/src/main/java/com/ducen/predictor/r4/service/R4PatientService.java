package com.ducen.predictor.r4.service;

import com.ducen.predictor.r4.entity.R4Patient;
import com.ducen.predictor.r4.types.Address;
import com.ducen.predictor.r4.types.Contact;
import com.ducen.predictor.r4.types.ContactPoint;
import com.ducen.predictor.r4.types.HumanName;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Relationship;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface R4PatientService {

    boolean checkExist(JSONObject jsonObject);

    R4Patient createR4Patient(JSONObject jsonObject);

    List<R4Patient> createR4PatientList(JSONObject jsonObject);

    List<Contact> createContactList(JSONArray jsonArray);

    Contact createContact(JSONObject jsonObject);

    List<HumanName> createContactHumanName(JSONObject jsonName);

    List<String> createContactSuffix(JSONObject jsonName);

    List<String> createContactPrefix(JSONObject jsonName);

    List<String> createContactGiven(JSONObject jsonName);

    Period createPeriod(JSONObject jsonObject);

    List<ContactPoint> createContactTelecom(JSONArray jsonArray);

    List<Relationship> createRelationshipList(JSONObject jsonObject);

    Relationship createRelationship(JSONArray jsonArray);

    List<Address> createAddress(JSONArray jsonArrayAddress);

    List<String> createLine(JSONArray jsonArrayLine);

    List<ContactPoint> createTelecom(JSONArray jsonArrayTelecom);

    List<HumanName> createHumanName(JSONArray jsonArrayName);

    List<String> createSuffix(JSONArray jsonArraySuffix);

    List<String> createPrefix(JSONArray jsonArrayPrefix);

    List<String> createGiven(JSONArray jsonArrayGiven);

    List<Identifier> createIdentifierList(JSONArray jsonArray);

    Identifier createIdentifier(JSONObject jsonObject);





}

