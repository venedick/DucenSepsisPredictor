package com.ducen.predictor.r4.converter;

import android.util.Log;

import com.ducen.predictor.defaultdata.Properties;
import com.ducen.predictor.r4.entity.R4FamilyMemberHistory;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Condition;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Range;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.SimpleQuantity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class R4FamilyMemberHistoryConverterImpl implements R4FamilyMemberHistoryConverter {
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
    public List<R4FamilyMemberHistory> createR4FamilyMemberList(JSONObject jsonObject) {
        List<R4FamilyMemberHistory> r4FamilyMemberHistoryList = new ArrayList<>();
        try {
            if (jsonObject.has(Properties.KEY_ENTRY)) {
                JSONArray jsonEntry = jsonObject.getJSONArray(Properties.KEY_ENTRY);

                for (int c = 0; c < jsonEntry.length(); c++) {

                    JSONObject jsonResources = jsonObject.getJSONArray(Properties.KEY_ENTRY).getJSONObject(c);

                    if (jsonResources.has(Properties.KEY_RESOURCE)) {
                        JSONObject jsonResource = jsonResources.getJSONObject(Properties.KEY_RESOURCE);
                        R4FamilyMemberHistory r4FamilyMemberHistory = createR4FamilyMember(jsonResource);
                        r4FamilyMemberHistoryList.add(r4FamilyMemberHistory);
                    }
                }
            }
        } catch (Exception e) {
            Log.d("TEST", "createR4FamilyMemberList Exception : " + e.toString());
        }
        return r4FamilyMemberHistoryList;
    }

    @Override
    public R4FamilyMemberHistory createR4FamilyMember(JSONObject jsonObject) {
        R4FamilyMemberHistory r4FamilyMemberHistory = new R4FamilyMemberHistory();

        try {
            //initialize META
            if (jsonObject.has(Properties.KEY_META)) {
                JSONObject jsonMeta = jsonObject.getJSONObject(Properties.KEY_META);
                Meta metaPractitioner = createMeta(jsonMeta);
                r4FamilyMemberHistory.setMeta(metaPractitioner);
            }

            //initialize IDENTIFIER
            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> identifierList = createIdentifierList(jsonArrayIdentifier);
                r4FamilyMemberHistory.setIdentifier(identifierList);
            }

            //initialize instantiatesCanonical
            if (jsonObject.has(Properties.KEY_INSTANTIATES_CANONICAL)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_INSTANTIATES_CANONICAL);
                List<String> instantiatesCanonicalList = createStringList(jsonArray);
                r4FamilyMemberHistory.setInstantiatesCanonical(instantiatesCanonicalList);
            }

            //initialize instantiatesURI
            if (jsonObject.has(Properties.KEY_INSTANTIATES_URI)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_INSTANTIATES_URI);
                List<String> instantiatesURIList = createStringList(jsonArray);
                r4FamilyMemberHistory.setInstantiatesUri(instantiatesURIList);
            }

            //dataAbsentReason
            if(jsonObject.has(Properties.KEY_DATA_ABSENT_REASON)){
                JSONObject jsonAbsentReason = jsonObject.getJSONObject(Properties.KEY_DATA_ABSENT_REASON);
                CodeableConcept absentReason = createCodeableConcept(jsonAbsentReason);
                r4FamilyMemberHistory.setDataAbsentReason(absentReason);
            }

            //patient
            if(jsonObject.has(Properties.KEY_PATIENT)){
                JSONObject jsonPatient = jsonObject.getJSONObject(Properties.KEY_PATIENT);
                Reference patient = createReference(jsonPatient);
                r4FamilyMemberHistory.setPatient(patient);
            }

            //date
            if(jsonObject.has(Properties.KEY_DATE)){
                String date = jsonObject.getString(Properties.KEY_DATE);
                r4FamilyMemberHistory.setDate(date);
            }

            //name
            if(jsonObject.has(Properties.KEY_NAME)){
                String name = jsonObject.getString(Properties.KEY_NAME);
                r4FamilyMemberHistory.setName(name);
            }

            //relationship
            if(jsonObject.has(Properties.KEY_RELATIONSHIP)){
                JSONObject jsonRelationship = jsonObject.getJSONObject(Properties.KEY_RELATIONSHIP);
                CodeableConcept relationship = createCodeableConcept(jsonRelationship);
                r4FamilyMemberHistory.setRelationship(relationship);
            }

            //sex
            if(jsonObject.has(Properties.KEY_SEX)){
                JSONObject jsonSex = jsonObject.getJSONObject(Properties.KEY_SEX);
                CodeableConcept sex = createCodeableConcept(jsonSex);
                r4FamilyMemberHistory.setSex(sex);
            }

            //bornPeriod
            if(jsonObject.has(Properties.KEY_BORN_PERIOD)){
                JSONObject jsonBornPeriod = jsonObject.getJSONObject(Properties.KEY_BORN_PERIOD);
                Period bornPeriod = createPeriod(jsonBornPeriod);
                r4FamilyMemberHistory.setBornPeriod(bornPeriod);
            }

            //bornDate
            if(jsonObject.has(Properties.KEY_BORN_DATE)){
                String bornDate = jsonObject.getString(Properties.KEY_BORN_DATE);
                r4FamilyMemberHistory.setBornDate(bornDate);
            }

            //bornString
            if(jsonObject.has(Properties.KEY_BORN_STRING)){
                String bornString = jsonObject.getString(Properties.KEY_BORN_STRING);
                r4FamilyMemberHistory.setBornString(bornString);
            }

            //ageAge
            if(jsonObject.has(Properties.KEY_AGE_AGE)){
                String ageAge = jsonObject.getString(Properties.KEY_AGE_AGE);
                r4FamilyMemberHistory.setAgeAge(ageAge);
            }

            //ageRange
            if(jsonObject.has(Properties.KEY_AGE_RANGE)){
                JSONObject jsonRange = jsonObject.getJSONObject(Properties.KEY_AGE_RANGE);
                Range range = createRange(jsonRange);
                r4FamilyMemberHistory.setAgeRange(range);
            }

            //ageString
            if(jsonObject.has(Properties.KEY_AGE_STRING)){
                String ageString = jsonObject.getString(Properties.KEY_AGE_STRING);
                r4FamilyMemberHistory.setAgeString(ageString);
            }

            //estimatedAge
            if(jsonObject.has(Properties.KEY_ESTIMATED_AGE)){
                String estimatedAge = jsonObject.getString(Properties.KEY_ESTIMATED_AGE);
                r4FamilyMemberHistory.setEstimatedAge(estimatedAge);
            }

            //deceasedBoolean
            if(jsonObject.has(Properties.KEY_DECEASED_BOOLEAN)){
                String deceasedBoolean = jsonObject.getString(Properties.KEY_DECEASED_BOOLEAN);
                r4FamilyMemberHistory.setDeceasedBoolean(deceasedBoolean);
            }

            //deceasedAge
            if(jsonObject.has(Properties.KEY_DECEASED_AGE)){
                String deceasedAge = jsonObject.getString(Properties.KEY_DECEASED_AGE);
                r4FamilyMemberHistory.setDeceasedAge(deceasedAge);
            }

            //deceasedRange
            if(jsonObject.has(Properties.KEY_DECEASED_RANGE)){
                JSONObject jsonRange = jsonObject.getJSONObject(Properties.KEY_DECEASED_RANGE);
                Range range = createRange(jsonRange);
                r4FamilyMemberHistory.setDeceasedRange(range);
            }

            //deceasedDate
            if(jsonObject.has(Properties.KEY_DECEASED_DATE)){
                String deceasedDate = jsonObject.getString(Properties.KEY_DECEASED_DATE);
                r4FamilyMemberHistory.setDeceasedDate(deceasedDate);
            }

            //deceasedString
            if(jsonObject.has(Properties.KEY_DECEASED_STRING)){
                String deceasedString = jsonObject.getString(Properties.KEY_DECEASED_STRING);
                r4FamilyMemberHistory.setDeceasedString(deceasedString);
            }

            //reasonCode
            if(jsonObject.has(Properties.KEY_REASON_CODE)){
                JSONArray jsonReasonCode = jsonObject.getJSONArray(Properties.KEY_REASON_CODE);
                List<CodeableConcept> reasonCode = createCodeableConceptList(jsonReasonCode);
                r4FamilyMemberHistory.setReasonCode(reasonCode);
            }

            //reasonReference
            if(jsonObject.has(Properties.KEY_REASON_REFERENCE)){
                JSONArray jsonReasonReference = jsonObject.getJSONArray(Properties.KEY_REASON_REFERENCE);
                List<Reference> reasonReference = createReferenceList(jsonReasonReference);
                r4FamilyMemberHistory.setReasonReference(reasonReference);
            }

            //note
            if(jsonObject.has(Properties.KEY_NOTE)){
                JSONArray jsonNote = jsonObject.getJSONArray(Properties.KEY_NOTE);
                List<Annotation> note = createAnnotationList(jsonNote);
                r4FamilyMemberHistory.setNote(note);
            }

            //condition
            if(jsonObject.has(Properties.KEY_CONDITION)){
                JSONArray jsonCondition = jsonObject.getJSONArray(Properties.KEY_CONDITION);
                List<Condition> condition = createConditionList(jsonCondition);
                r4FamilyMemberHistory.setCondition(condition);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("TEST", "createR4FamilyMember Exception : " + e.toString());
        }

        return r4FamilyMemberHistory;
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
    public List<String> createStringList(JSONArray jsonArray) {
        List<String> stringList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {

                String prefix = jsonArray.getString(c);
                stringList.add(prefix);
            }
        } catch (Exception e) {
            Log.d("TEST", "createStringList Exception : " + e.toString());
        }
        return stringList;
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
    public List<Reference> createReferenceList(JSONArray jsonArray) {
        List<Reference> referenceList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Reference reference = createReference(jsonObject);
                referenceList.add(reference);
            }
        } catch (Exception e) {
            Log.d("TEST", "createReferenceList Exception : " + e.toString());
        }
        return referenceList;
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
    public Range createRange(JSONObject jsonObject) {
        Range range = new Range();
        try {

            if (jsonObject.has(Properties.KEY_LOW)) {
                JSONObject jsonLow = jsonObject.getJSONObject(Properties.KEY_LOW);
                SimpleQuantity simpleQuantity = createSimpleQuantity(jsonLow);
                range.setLow(simpleQuantity);
            }

            if (jsonObject.has(Properties.KEY_HIGH)) {
                JSONObject jsonHigh = jsonObject.getJSONObject(Properties.KEY_HIGH);
                SimpleQuantity simpleQuantity = createSimpleQuantity(jsonHigh);
                range.setHigh(simpleQuantity);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createReference Exception : " + e.toString());
        }
        return range;
    }

    @Override
    public SimpleQuantity createSimpleQuantity(JSONObject jsonObject) {
        SimpleQuantity simpleQuantity = new SimpleQuantity("", "");
        try {
            if (jsonObject.has(Properties.KEY_VALUE)) {
                simpleQuantity.setValue(jsonObject.getString(Properties.KEY_VALUE));
            }
            if (jsonObject.has(Properties.KEY_CURRENCY)) {
                simpleQuantity.setCurrency(jsonObject.getString(Properties.KEY_CURRENCY));
            }

        } catch (Exception e) {
            Log.d("TEST", "createSimpleQuantity Exception : " + e.toString());
        }
        return simpleQuantity;
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
    public List<Annotation> createAnnotationList(JSONArray jsonArray) {
        List<Annotation> annotationList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Annotation annotation = createAnnotation(jsonObject);
                annotationList.add(annotation);
            }
        } catch (Exception e) {
            Log.d("TEST", "createAnnotation Exception : " + e.toString());
        }
        return annotationList;
    }

    @Override
    public Condition createCondition(JSONObject jsonObject) {
        Condition condition = new Condition();

        try {
            if(jsonObject.has(Properties.KEY_CODE)){
                JSONObject jsonCode = jsonObject.getJSONObject(Properties.KEY_CODE);
                CodeableConcept code = createCodeableConcept(jsonCode);
                condition.setCode(code);
            }
            if(jsonObject.has(Properties.KEY_OUTCOME)){
                JSONObject jsonOutcome = jsonObject.getJSONObject(Properties.KEY_OUTCOME);
                CodeableConcept outcome = createCodeableConcept(jsonOutcome);
                condition.setCode(outcome);
            }
            if(jsonObject.has(Properties.KEY_CONTRIBUTED_TO_DEATH)){
                String contributedToDeath = jsonObject.getString(Properties.KEY_CONTRIBUTED_TO_DEATH);
                condition.setContributedToDeath(contributedToDeath);

            }
            if(jsonObject.has(Properties.KEY_ONSET_AGE)){
                String onSetAge = jsonObject.getString(Properties.KEY_ONSET_AGE);
                condition.setOnSetAge(onSetAge);
            }
            if(jsonObject.has(Properties.KEY_ONSET_RANGE)){
                JSONObject jsonRange = jsonObject.getJSONObject(Properties.KEY_ONSET_RANGE);
                Range range = createRange(jsonRange);
                condition.setOnSetRange(range);
            }
            if(jsonObject.has(Properties.KEY_ONSET_PERIOD)){
                JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_ONSET_PERIOD);
                Period period = createPeriod(jsonPeriod);
                condition.setOnSetPeriod(period);
            }
            if(jsonObject.has(Properties.KEY_ONSET_STRING)){
                String onSetString = jsonObject.getString(Properties.KEY_ONSET_STRING);
                condition.setOnSetString(onSetString);
            }
            if(jsonObject.has(Properties.KEY_NOTE)){
                JSONArray jsonNote = jsonObject.getJSONArray(Properties.KEY_NOTE);
                List<Annotation> note = createAnnotationList(jsonNote);
                condition.setNote(note);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("TEST", "createCondition Exception : " + e.toString());
        }
        return condition;
    }

    @Override
    public List<Condition> createConditionList(JSONArray jsonArray) {
        List<Condition> conditionList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Condition condition = createCondition(jsonObject);
                conditionList.add(condition);
            }
        } catch (Exception e) {
            Log.d("TEST", "createConditionList Exception : " + e.toString());
        }
        return conditionList;
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
}
