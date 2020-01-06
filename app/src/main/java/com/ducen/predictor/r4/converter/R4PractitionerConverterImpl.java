package com.ducen.predictor.r4.converter;

import android.util.Log;

import com.ducen.predictor.defaultdata.Properties;
import com.ducen.predictor.r4.types.Qualification;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.entity.R4Practitioner;
import com.ducen.predictor.r4.types.Address;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.ContactPoint;
import com.ducen.predictor.r4.types.HumanName;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class R4PractitionerConverterImpl implements R4PractitionerConverter {

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
    public R4Practitioner createR4Practitioner(JSONObject jsonObject) {

        R4Practitioner practitioner = new R4Practitioner(null, null, "", null, null, null, "", "", null, null, null);

        try {

            if (jsonObject.has(Properties.KEY_ENTRY)) {

                JSONObject jsonEntry = jsonObject.getJSONArray(Properties.KEY_ENTRY).getJSONObject(0);

                if (jsonEntry.has(Properties.KEY_RESOURCE)) {
                    JSONObject jsonResource = jsonEntry.getJSONObject(Properties.KEY_RESOURCE);

                    if (jsonResource.has(Properties.KEY_META)) {
                        JSONObject jsonMeta = jsonResource.getJSONObject(Properties.KEY_META);
                        Meta meta = createR4MetaPractitioner(jsonMeta);
                        practitioner.setMeta(meta);
                    }

                    if (jsonResource.has(Properties.KEY_IDENTIFIER)) {
                        JSONArray jsonArrayIdentifier = jsonResource.getJSONArray(Properties.KEY_IDENTIFIER);
                        List<Identifier> listOfIdentifier = createIdentifier(jsonArrayIdentifier);
                        practitioner.setIdentifier(listOfIdentifier);
                    }

                    //initialize ACTIVE
                    if (jsonResource.has(Properties.KEY_ACTIVE)) {
                        String active = String.valueOf(jsonResource.getBoolean(Properties.KEY_ACTIVE));
                        practitioner.setActive(active);
                    }

                    //initialize NAME
                    if (jsonResource.has(Properties.KEY_NAME)) {
                        JSONArray jsonArrayName = jsonResource.getJSONArray(Properties.KEY_NAME);
                        List<HumanName> listOfHumanName = createHumanName(jsonArrayName);
                        practitioner.setHumanName(listOfHumanName);

                    }

                    //initialize telecom
                    if (jsonResource.has(Properties.KEY_TELECOM)) {
                        JSONArray jsonArrayTelecom = jsonResource.getJSONArray(Properties.KEY_TELECOM);
                        List<ContactPoint> listOfTelecom = createTelecom(jsonArrayTelecom);
                        practitioner.setTelecom(listOfTelecom);
                    }
//
                    //initialize address
                    if (jsonResource.has(Properties.KEY_ADDRESS)) {
                        JSONArray jsonArrayAddress = jsonResource.getJSONArray(Properties.KEY_ADDRESS);
                        List<Address> listOfAddress = createAddress(jsonArrayAddress);
                        practitioner.setAddress(listOfAddress);
                    }

                    //initialize gender
                    if (jsonResource.has(Properties.KEY_GENDER)) {
                        String gender = jsonResource.getString(Properties.KEY_GENDER);
                        practitioner.setGender(gender);
                    }

                    //initialize birthdate
                    if (jsonResource.has(Properties.KEY_BIRTHDATE)) {
                        String birthDate = jsonResource.getString(Properties.KEY_BIRTHDATE);
                        practitioner.setBirthDate(birthDate);
                    }

                    //initialize qualification
                    if (jsonResource.has(Properties.KEY_QUALIFICATION)) {
                        JSONArray jsonArrayQualification = jsonResource.getJSONArray(Properties.KEY_QUALIFICATION);
                        List<Qualification> listOfQualification = createQualification(jsonArrayQualification);
                        practitioner.setQualification(listOfQualification);
                    }

                }
            }
        } catch (Exception e) {
            Log.d("TEST", "Exception : " + e.toString());
        }

        Log.d("TEST", "PRACITITIONER : " + practitioner.toString());
        return practitioner;
    }

    @Override
    public Meta createR4MetaPractitioner(JSONObject jsonObject) {
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
    public CodeableConcept createCode(JSONObject jsonObject) {
        CodeableConcept code = new CodeableConcept(null, "");
        try {

            if (jsonObject.has(Properties.KEY_CODING)) {
                JSONArray jsonArrayCoding = jsonObject.getJSONArray(Properties.KEY_CODING);
                List<Coding> listOfCoding = createCoding(jsonArrayCoding);
                code.setCoding(listOfCoding);
            }

            if (jsonObject.has(Properties.KEY_TEXT)) {
                String text = jsonObject.getString(Properties.KEY_TEXT);
                code.setText(text);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createCode Exception : " + e.toString());
        }
        return code;
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
            Log.d("TEST", "createCode Exception : " + e.toString());
        }
        return period;
    }

    @Override
    public Reference createIssuer(JSONObject jsonObject) {
        Reference issuer = new Reference("", "", null, "");
        try {

            if (jsonObject.has(Properties.KEY_REFERENCE)) {
                String reference = jsonObject.getString(Properties.KEY_REFERENCE);
                issuer.setReference(reference);
            }

            if (jsonObject.has(Properties.KEY_TYPE)) {
                String type = jsonObject.getString(Properties.KEY_TYPE);
                issuer.setType(type);
            }

            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> listOfIdentifier = createIdentifier(jsonArrayIdentifier);
                issuer.setIdentifier(listOfIdentifier);
            }

            if (jsonObject.has(Properties.KEY_DISPLAY)) {
                String display = jsonObject.getString(Properties.KEY_DISPLAY);
                issuer.setDisplay(display);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createCode Exception : " + e.toString());
        }
        return issuer;
    }

    @Override
    public List<HumanName> createHumanName(JSONArray jsonArray) {
        List<HumanName> humanNameList = new ArrayList<>();
        try {

            for (int c = 0; c < jsonArray.length(); c++) {

                HumanName humanName = new HumanName("", "", "", null, null, null, null);

                JSONObject jsonObject = jsonArray.getJSONObject(c);

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
    public List<String> createGiven(JSONArray jsonArray) {
        List<String> givenNameList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {

                String givenName = jsonArray.getString(c);
                givenNameList.add(givenName);
            }
        } catch (Exception e) {
            Log.d("TEST", "createHumanName Exception : " + e.toString());
        }
        return givenNameList;
    }

    @Override
    public List<String> createPrefix(JSONArray jsonArray) {
        List<String> prefixList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {

                String prefix = jsonArray.getString(c);
                prefixList.add(prefix);
            }
        } catch (Exception e) {
            Log.d("TEST", "createPrefix Exception : " + e.toString());
        }
        return prefixList;
    }

    @Override
    public List<String> createSuffix(JSONArray jsonArray) {
        List<String> suffixList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {

                String suffix = jsonArray.getString(c);
                suffixList.add(suffix);
            }
        } catch (Exception e) {
            Log.d("TEST", "createSuffix Exception : " + e.toString());
        }
        return suffixList;
    }

    @Override
    public List<ContactPoint> createTelecom(JSONArray jsonArray) {
        List<ContactPoint> listOfTelecom = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {

                ContactPoint contactPoint = new ContactPoint("", "", "", "", "");

                JSONObject jsonObject = jsonArray.getJSONObject(c);

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
    public List<Address> createAddress(JSONArray jsonArray) {
        List<Address> listOfAddress = new ArrayList<>();
        try {

            for (int c = 0; c < jsonArray.length(); c++) {

                Address address = new Address("", "", "", null, "", "", "", "", "", "");

                JSONObject jsonObject = jsonArray.getJSONObject(c);

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
    public List<String> createLine(JSONArray jsonArray) {
        List<String> lineList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {

                String line = jsonArray.getString(c);
                lineList.add(line);
            }
        } catch (Exception e) {
            Log.d("TEST", "createLine Exception : " + e.toString());
        }
        return lineList;
    }

    @Override
    public List<Qualification> createQualification(JSONArray jsonArray) {
        List<Qualification> listOfQualification = new ArrayList<>();
        try {

            for (int c = 0; c < jsonArray.length(); c++) {

                Qualification qualification = new Qualification(null, null, null, null);

                JSONObject jsonObject = jsonArray.getJSONObject(c);

                if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                    JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                    List<Identifier> listOfIdentifier = createIdentifier(jsonArrayIdentifier);
                    qualification.setIdentifier(listOfIdentifier);
                }

                if (jsonObject.has(Properties.KEY_CODE)) {
                    JSONObject jsonCode = jsonObject.getJSONObject(Properties.KEY_CODE);
                    CodeableConcept code = createCode(jsonCode);
                    qualification.setCode(code);
                }

                if (jsonObject.has(Properties.KEY_PERIOD)) {
                    JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_PERIOD);
                    Period period = createPeriod(jsonPeriod);
                    qualification.setPeriod(period);
                }

                if (jsonObject.has(Properties.KEY_ISSUER)) {
                    JSONObject jsonIssuer = jsonObject.getJSONObject(Properties.KEY_ISSUER);
                    Reference issuer = createIssuer(jsonIssuer);
                    qualification.setIssuer(issuer);
                }

                listOfQualification.add(qualification);
            }
        } catch (
                Exception e) {
            Log.d("TEST", "createQualification Exception : " + e.toString());
        }
        return listOfQualification;
    }

    @Override
    public List<Identifier> createIdentifier(JSONArray jsonArray) {
        List<Identifier> listOfIdentifier = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {

                Identifier identifier = new Identifier("", "", "", "", "");
                JSONObject jsonIdentifier = jsonArray.getJSONObject(c);

                if (jsonIdentifier.has(Properties.KEY_USE)) {
                    String use = jsonIdentifier.getString(Properties.KEY_USE);
                    identifier.setUse(use);
                }

                if (jsonIdentifier.has(Properties.KEY_TYPE)) {
                    String type = jsonIdentifier.getString(Properties.KEY_TYPE);
                    identifier.setType(type);
                }

                if (jsonIdentifier.has(Properties.KEY_SYSTEM)) {
                    String system = jsonIdentifier.getString(Properties.KEY_SYSTEM);
                    identifier.setSystem(system);
                }

                if (jsonIdentifier.has(Properties.KEY_VALUE)) {
                    String value = jsonIdentifier.getString(Properties.KEY_VALUE);
                    identifier.setValue(value);
                }

                if (jsonIdentifier.has(Properties.KEY_PERIOD)) {
                    String period = jsonIdentifier.getString(Properties.KEY_PERIOD);
                    identifier.setPeriod(period);
                }

                listOfIdentifier.add(identifier);
            }
        } catch (
                Exception e) {
            Log.d("TEST", "createIdentifier Exception : " + e.toString());
        }
        return listOfIdentifier;
    }

    @Override
    public List<Coding> createCoding(JSONArray jsonArray) {
        List<Coding> listOfCoding = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                Coding coding = new Coding("", "", "", "", "");
                JSONObject jsonObject = jsonArray.getJSONObject(c);

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

                //userSelected is not included, in this creation of CODING

                listOfCoding.add(coding);
            }
        } catch (
                Exception e) {
            Log.d("TEST", "createCoding Exception : " + e.toString());
        }
        return listOfCoding;
    }

}
