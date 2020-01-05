package com.ducen.predictor.r4.service;

import android.util.Log;

import com.ducen.predictor.defaultdata.Properties;
import com.ducen.predictor.defaultdata.ResponseKeys;
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

import java.util.ArrayList;
import java.util.List;

public class R4PatientServiceImpl implements R4PatientService {

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
            Log.d("TEST", "Exception : " + e.toString());
            status = false;
        }
        return status;
    }

    @Override
    public List<R4Patient> createR4PatientList(JSONObject jsonObject) {
        List<R4Patient> patients = new ArrayList<>();
        try {
            if (jsonObject.has(Properties.KEY_ENTRY)) {
                JSONArray jsonEntry = jsonObject.getJSONArray(Properties.KEY_ENTRY);
                for (int i = 0; i < jsonEntry.length(); i++) {
                    JSONObject jsonResources = jsonObject.getJSONArray(Properties.KEY_ENTRY).getJSONObject(i);
                    if (jsonResources.has(Properties.KEY_RESOURCE)) {
                        JSONObject jsonResource = jsonResources.getJSONObject(Properties.KEY_RESOURCE);
                        R4Patient r4Patient = createR4Patient(jsonResource);
                        patients.add(r4Patient);
                    }
                }
            }
        } catch (Exception e) {
            Log.d("TEST", "createR4PatientList Exception: " + e.getMessage());
        }
        return patients;
    }

    @Override
    public R4Patient createR4Patient(JSONObject jsonResource) {
        R4Patient patient = new R4Patient();
        try {

            //initialize PatientId
            if (jsonResource.has(ResponseKeys.KEY_ID.toString())) {
                String patientId = jsonResource.getString(ResponseKeys.KEY_ID.toString());
                patient.setPatientId(patientId);
            }

            //initialize Identifier
            if (jsonResource.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonResource.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> list = createIdentifierList(jsonArrayIdentifier);
                patient.setIdentifiers(list);
            }

            //initialize ACTIVE
            if (jsonResource.has(Properties.KEY_ACTIVE)) {
                String active = String.valueOf(jsonResource.getBoolean(Properties.KEY_ACTIVE));
                patient.setActive(active);
            }

            //initialize NAME
            if (jsonResource.has(Properties.KEY_NAME)) {


                JSONArray jsonArrayName = jsonResource.getJSONArray(Properties.KEY_NAME);
                List<HumanName> listOfHumanName = createHumanName(jsonArrayName);
                patient.setHumanName(listOfHumanName);

            }
            //initialize telecom
            if (jsonResource.has(Properties.KEY_TELECOM)) {
                JSONArray jsonArrayTelecom = jsonResource.getJSONArray(Properties.KEY_TELECOM);
                List<ContactPoint> listOfTelecom = createTelecom(jsonArrayTelecom);
                patient.setTelecom(listOfTelecom);
            }

            //initialize address
            if (jsonResource.has(Properties.KEY_ADDRESS)) {
                JSONArray jsonArrayAddress = jsonResource.getJSONArray(Properties.KEY_ADDRESS);
                List<Address> listOfAddress = createAddress(jsonArrayAddress);
                patient.setAddress(listOfAddress);
            }

            //initialize gender
            if (jsonResource.has(Properties.KEY_GENDER)) {
                String gender = jsonResource.getString(Properties.KEY_GENDER);
                patient.setGender(gender);
            }

            //initialize birthdate
            if (jsonResource.has(Properties.KEY_BIRTHDATE)) {
                String birthDate = jsonResource.getString(Properties.KEY_BIRTHDATE);
                patient.setBirthDate(birthDate);
            }

            if (jsonResource.has(Properties.KEY_CONTACT)) {
                JSONArray jsonArray = jsonResource.getJSONArray(Properties.KEY_CONTACT);
                List<Contact> contact = createContactList(jsonArray);
                patient.setContact(contact);
            }

        } catch (Exception e) {
            Log.d("TEST", "create patient exception:" + e.toString());
        }
        return patient;
    }

    @Override
    public List<Contact> createContactList(JSONArray jsonArray) {
        List<Contact> contacts = new ArrayList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Contact contact = createContact(jsonObject);
                contacts.add(contact);
            }
        } catch (Exception e) {
            Log.d("TEST", "create contact Exception: " + e.toString());
        }
        return contacts;
    }

    @Override
    public Contact createContact(JSONObject jsonObject) {
        Contact contact = new Contact();
        try {

            if (jsonObject.has(Properties.KEY_RELATIONSHIP)) {
                List<Relationship> createRelationshipList = createRelationshipList(jsonObject);
                contact.setRelationship(createRelationshipList);
            }
            if (jsonObject.has(Properties.KEY_TELECOM)) {
                JSONArray jsonArrayTelecom = jsonObject.getJSONArray(Properties.KEY_TELECOM);
                List<ContactPoint> listOfTelecom = createContactTelecom(jsonArrayTelecom);
                contact.setTelecom(listOfTelecom);
            }

            if (jsonObject.has(Properties.KEY_NAME)) {
                JSONObject jsonName = jsonObject.getJSONObject(Properties.KEY_NAME);
                contact.setHumanName(createContactHumanName(jsonName));
            }

            if (jsonObject.has(Properties.KEY_GENDER)) {
                String gender = jsonObject.getString(Properties.KEY_GENDER);
                contact.setGender(gender);
            }

            if (jsonObject.has(Properties.KEY_PERIOD)) {
                JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_PERIOD);
                Period period = createPeriod(jsonPeriod);
                contact.setPeriod(period);
            }

        } catch (Exception e) {
            Log.d("TEST", "create contact Exception: " + e.toString());
        }

        return contact;
    }

    @Override
    public List<HumanName> createContactHumanName(JSONObject jsonName) {
        List<HumanName> humanNameList = new ArrayList<>();
        try {
            HumanName contactHumanName = new HumanName("", "", "", null, null, null, null);

            if (jsonName.has(Properties.KEY_FAMILY)) {
                String family = jsonName.getString(Properties.KEY_FAMILY);
                contactHumanName.setFamily(family);
            }

            if (jsonName.has(Properties.KEY_GIVEN)) {
                contactHumanName.setGiven(createContactGiven(jsonName));
            }

            if (jsonName.has(Properties.KEY_PREFIX)) {
                contactHumanName.setPrefix(createContactPrefix(jsonName));
            }

            if (jsonName.has(Properties.KEY_SUFFIX)) {
                contactHumanName.setSuffix(createContactSuffix(jsonName));
            }

            humanNameList.add(contactHumanName);

        } catch (Exception e) {
            Log.d("TEST", "createContactHumanName : " + e.toString());
        }

        return humanNameList;
    }

    @Override
    public List<String> createContactSuffix(JSONObject jsonName) {
        List<String> suffixNameList = new ArrayList<>();
        try {
            JSONArray jsonSuffix = jsonName.getJSONArray(Properties.KEY_SUFFIX);
            for (int i = 0; i < jsonSuffix.length(); i++) {
                suffixNameList.add(jsonSuffix.getString(i));
            }
        } catch (Exception e) {
            Log.d("TEST", "createPrefix : " + e.toString());
        }
        return suffixNameList;
    }

    @Override
    public List<String> createContactPrefix(JSONObject jsonName) {
        List<String> prefixNameList = new ArrayList<>();
        try {
            JSONArray jsonPrefix = jsonName.getJSONArray(Properties.KEY_PREFIX);
            for (int i = 0; i < jsonPrefix.length(); i++) {
                prefixNameList.add(jsonPrefix.getString(i));
            }
        } catch (Exception e) {
            Log.d("TEST", "createPrefix : " + e.toString());
        }
        return prefixNameList;
    }

    @Override
    public List<String> createContactGiven(JSONObject jsonName) {
        List<String> givenNameList = new ArrayList<>();
        try {
            JSONArray jsonGiven = jsonName.getJSONArray(Properties.KEY_GIVEN);
            for (int c = 0; c < jsonGiven.length(); c++) {
                givenNameList.add(jsonGiven.getString(c));
            }
        } catch (Exception e) {
            Log.d("TEST", "createGiven : " + e.toString());
        }
        return givenNameList;
    }

    @Override
    public Period createPeriod(JSONObject jsonPeriod) {
        Period period = new Period("", "");
        try {

            if (jsonPeriod.has(Properties.KEY_START)) {
                String start = jsonPeriod.getString(Properties.KEY_START);
                period.setStart(start);
            }

            if (jsonPeriod.has(Properties.KEY_END)) {
                String end = jsonPeriod.getString(Properties.KEY_END);
                period.setEnd(end);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createCode Exception : " + e.toString());
        }
        return period;
    }

    @Override
    public List<ContactPoint> createContactTelecom(JSONArray jsonArrayTelecom) {
        List<ContactPoint> listOfTelecom = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArrayTelecom.length(); c++) {

                ContactPoint contactPoint = new ContactPoint("", "", "", "", "");

                JSONObject jsonObject = jsonArrayTelecom.getJSONObject(c);

                if (jsonObject.has(Properties.KEY_SYSTEM)) {
                    String system = jsonObject.getString(Properties.KEY_SYSTEM);
                    contactPoint.setSystem(system);
                }

                if (jsonObject.has(Properties.KEY_VALUE)) {
                    String value = jsonObject.getString(Properties.KEY_VALUE);
                    contactPoint.setValue(value);
                }

                if (jsonObject.has(Properties.KEY_USE)) {
                    String use = jsonObject.getString(Properties.KEY_USE);
                    contactPoint.setUse(use);
                }

                if (jsonObject.has(Properties.KEY_RANK)) {
                    String rank = jsonObject.getString(Properties.KEY_RANK);
                    contactPoint.setRank(rank);
                }

                if (jsonObject.has(Properties.KEY_PERIOD)) {
                    String period = jsonObject.getString(Properties.KEY_PERIOD);
                    contactPoint.setPeriod(period);
                }

                listOfTelecom.add(contactPoint);
            }
        } catch (Exception e) {
            Log.d("TEST", "createSuffix Exception : " + e.toString());
        }
        return listOfTelecom;
    }

    @Override
    public List<Relationship> createRelationshipList(JSONObject jsonRelationships) {
        List<Relationship> relationships = new ArrayList<>();
        try {
            JSONArray jsonRelationship = jsonRelationships.getJSONArray(Properties.KEY_RELATIONSHIP);
            Relationship relationship = createRelationship(jsonRelationship);
            relationships.add(relationship);
        } catch (Exception e) {
            Log.d("TEST", "Exception: " + e.getMessage());
        }
        return relationships;
    }

    @Override
    public Relationship createRelationship(JSONArray jsonArray) {
        Relationship relationship = new Relationship("", "");
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.has(Properties.KEY_ID)) {
                    String id = jsonObject.getString(Properties.KEY_ID);
                    relationship.setId(id);
                }
                if (jsonObject.has("text")) {
                    String text = jsonObject.getString("text");
                    relationship.setText(text);
                }
            }
        } catch (Exception e) {
            Log.d("TEST", "Exception: " + e.getMessage());
        }
        return relationship;
    }

    @Override
    public List<Address> createAddress(JSONArray jsonArrayAddress) {
        List<Address> listOfAddress = new ArrayList<>();
        try {

            for (int c = 0; c < jsonArrayAddress.length(); c++) {

                Address address = new Address("", "", "", null, "", "", "", "", "", "");

                JSONObject jsonObject = jsonArrayAddress.getJSONObject(c);

                if (jsonObject.has(Properties.KEY_USE)) {
                    String use = jsonObject.getString(Properties.KEY_USE);
                    address.setUse(use);
                }

                if (jsonObject.has(Properties.KEY_TYPE)) {
                    String type = jsonObject.getString(Properties.KEY_TYPE);
                    address.setType(type);
                }

                if (jsonObject.has(Properties.KEY_TEXT)) {
                    String text = jsonObject.getString(Properties.KEY_TEXT);
                    address.setText(text);
                }

                if (jsonObject.has(Properties.KEY_LINE)) {
                    JSONArray jsonArrayLine = jsonObject.getJSONArray(Properties.KEY_LINE);
                    address.setLine(createLine(jsonArrayLine));
                }

                if (jsonObject.has(Properties.KEY_CITY)) {
                    String city = jsonObject.getString(Properties.KEY_CITY);
                    address.setCity(city);
                }

                if (jsonObject.has(Properties.KEY_DISTRICT)) {
                    String district = jsonObject.getString(Properties.KEY_DISTRICT);
                    address.setDistrict(district);
                }

                if (jsonObject.has(Properties.KEY_STATE)) {
                    String state = jsonObject.getString(Properties.KEY_STATE);
                    address.setState(state);
                }

                if (jsonObject.has(Properties.KEY_POSTALCODE)) {
                    String postalCode = jsonObject.getString(Properties.KEY_POSTALCODE);
                    address.setPostalCode(postalCode);
                }

                if (jsonObject.has(Properties.KEY_COUNTRY)) {
                    String country = jsonObject.getString(Properties.KEY_COUNTRY);
                    address.setCountry(country);
                }

                if (jsonObject.has(Properties.KEY_PERIOD)) {
                    String period = jsonObject.getString(Properties.KEY_PERIOD);
                    address.setPeriod(period);
                }

                listOfAddress.add(address);
            }
        } catch (Exception e) {
            Log.d("TEST", "createAddress Exception : " + e.toString());
        }
        return listOfAddress;
    }

    @Override
    public List<String> createLine(JSONArray jsonArrayLine) {
        List<String> lineList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArrayLine.length(); c++) {

                String line = jsonArrayLine.getString(c);
                lineList.add(line);
            }
        } catch (Exception e) {
            Log.d("TEST", "createLine Exception : " + e.toString());
        }
        return lineList;
    }

    @Override
    public List<ContactPoint> createTelecom(JSONArray jsonArrayTelecom) {
        List<ContactPoint> listOfTelecom = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArrayTelecom.length(); c++) {

                ContactPoint contactPoint = new ContactPoint("", "", "", "", "");

                JSONObject jsonObject = jsonArrayTelecom.getJSONObject(c);

                if (jsonObject.has(Properties.KEY_SYSTEM)) {
                    String system = jsonObject.getString(Properties.KEY_SYSTEM);
                    contactPoint.setSystem(system);
                }

                if (jsonObject.has(Properties.KEY_VALUE)) {
                    String value = jsonObject.getString(Properties.KEY_VALUE);
                    contactPoint.setValue(value);
                }

                if (jsonObject.has(Properties.KEY_USE)) {
                    String use = jsonObject.getString(Properties.KEY_USE);
                    contactPoint.setUse(use);
                }

                if (jsonObject.has(Properties.KEY_RANK)) {
                    String rank = jsonObject.getString(Properties.KEY_RANK);
                    contactPoint.setRank(rank);
                }

                if (jsonObject.has(Properties.KEY_PERIOD)) {
                    String period = jsonObject.getString(Properties.KEY_PERIOD);
                    contactPoint.setPeriod(period);
                }

                listOfTelecom.add(contactPoint);
            }
        } catch (Exception e) {
            Log.d("TEST", "createSuffix Exception : " + e.toString());
        }
        return listOfTelecom;
    }

    @Override
    public List<HumanName> createHumanName(JSONArray jsonArrayName) {
        List<HumanName> humanNameList = new ArrayList<>();
        try {

            for (int c = 0; c < jsonArrayName.length(); c++) {

                HumanName humanName = new HumanName("", "", "", null, null, null, null);

                JSONObject jsonObject = jsonArrayName.getJSONObject(c);

                if (jsonObject.has(Properties.KEY_FAMILY)) {
                    String family = jsonObject.getString(Properties.KEY_FAMILY);
                    humanName.setFamily(family);
                }

                if (jsonObject.has(Properties.KEY_GIVEN)) {
                    JSONArray jsonArrayGiven = jsonObject.getJSONArray(Properties.KEY_GIVEN);
                    List<String> givenList = createGiven(jsonArrayGiven);
                    humanName.setGiven(givenList);
                }

                if (jsonObject.has(Properties.KEY_PREFIX)) {
                    JSONArray jsonArrayPrefix = jsonObject.getJSONArray(Properties.KEY_PREFIX);
                    List<String> prefixList = createPrefix(jsonArrayPrefix);
                    humanName.setPrefix(prefixList);
                }

                if (jsonObject.has(Properties.KEY_SUFFIX)) {
                    JSONArray jsonArraySuffix = jsonObject.getJSONArray(Properties.KEY_SUFFIX);
                    List<String> suffixList = createSuffix(jsonArraySuffix);
                    humanName.setSuffix(suffixList);
                }

                if (jsonObject.has(Properties.KEY_PERIOD)) {
                    JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_PERIOD);
                    Period period = createPeriod(jsonPeriod);
                    humanName.setPeriod(period);
                }

                //INFO: if json object has PERIOD is still missing
                humanNameList.add(humanName);
            }
        } catch (Exception e) {
            Log.d("TEST", "createHumanName Exception : " + e.toString());
        }
        return humanNameList;
    }

    @Override
    public List<String> createSuffix(JSONArray jsonArraySuffix) {
        List<String> suffixList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArraySuffix.length(); c++) {

                String suffix = jsonArraySuffix.getString(c);
                suffixList.add(suffix);
            }
        } catch (Exception e) {
            Log.d("TEST", "createSuffix Exception : " + e.toString());
        }
        return suffixList;
    }

    @Override
    public List<String> createPrefix(JSONArray jsonArrayPrefix) {
        List<String> prefixList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArrayPrefix.length(); c++) {

                String prefix = jsonArrayPrefix.getString(c);
                prefixList.add(prefix);
            }
        } catch (Exception e) {
            Log.d("TEST", "createPrefix Exception : " + e.toString());
        }
        return prefixList;
    }

    @Override
    public List<String> createGiven(JSONArray jsonArrayGiven) {
        List<String> givenNameList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArrayGiven.length(); c++) {

                String givenName = jsonArrayGiven.getString(c);
                givenNameList.add(givenName);
            }
        } catch (Exception e) {
            Log.d("TEST", "createHumanName Exception : " + e.toString());
        }
        return givenNameList;
    }

    @Override
    public List<Identifier> createIdentifierList(JSONArray jsonArrayIdentifier) {
        List<Identifier> listOfIdentifier = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArrayIdentifier.length(); c++) {
                JSONObject jsonIdentifier = jsonArrayIdentifier.getJSONObject(c);
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
        } catch (Exception e) {
            Log.d("TEST", "createIdentifier Exception : " + e.toString());
        }
        return identifier;
    }


}
