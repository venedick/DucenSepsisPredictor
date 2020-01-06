package com.ducen.predictor.r4.converter;

import android.util.Log;


import com.ducen.predictor.defaultdata.Properties;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.entity.R4AllergyIntolerance;
import com.ducen.predictor.r4.entity.R4Reaction;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Reference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class R4AllergyIntoleranceConverterImpl implements R4AllergyIntoleranceConverter {

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
    public List<R4AllergyIntolerance> createR4AllergyIntoleranceList(JSONObject jsonObject) {
        List<R4AllergyIntolerance> allergyIntoleranceList = new ArrayList<>();

        try {

            if (jsonObject.has(Properties.KEY_ENTRY)) {

                JSONArray jsonEntry = jsonObject.getJSONArray(Properties.KEY_ENTRY);

                for (int c = 0; c < jsonEntry.length(); c++) {

                    JSONObject jsonResources = jsonObject.getJSONArray(Properties.KEY_ENTRY).getJSONObject(c);

                    if (jsonResources.has(Properties.KEY_RESOURCE)) {

                        JSONObject jsonResource = jsonResources.getJSONObject(Properties.KEY_RESOURCE);

                        R4AllergyIntolerance allergyIntolerance = createR4AllergyIntolerance(jsonResource);

                        allergyIntoleranceList.add(allergyIntolerance);

                    }

                }

            }
        } catch (Exception e) {
            Log.d("TEST", "createAllergyIntoleranceList Exception : " + e.toString());
        }

        return allergyIntoleranceList;
    }

    @Override
    public R4AllergyIntolerance createR4AllergyIntolerance(JSONObject jsonObject) {
        R4AllergyIntolerance allergyIntolerance = new R4AllergyIntolerance(null, null, null, null, null, null, null, null, null, null, "", null, null, "", null, null);
        try {

            //initialize META
            if (jsonObject.has(Properties.KEY_META)) {
                JSONObject jsonMeta = jsonObject.getJSONObject(Properties.KEY_META);
                Meta meta = createMeta(jsonMeta);
                allergyIntolerance.setMeta(meta);
            }

            //initialize IDENTIFIER
            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> listOfIdentifier = createIdentifierList(jsonArrayIdentifier);
                allergyIntolerance.setIdentifier(listOfIdentifier);
            }

            //initialize CLINICAL STATUS
            if (jsonObject.has(Properties.KEY_CLINICAL_STATUS)) {
                JSONObject jsonClinicalStatus = jsonObject.getJSONObject(Properties.KEY_CLINICAL_STATUS);
                CodeableConcept clinicalStatus = createCodeableConcept(jsonClinicalStatus);
                allergyIntolerance.setClinicalStatus(clinicalStatus);
            }

            //initialize VERIFICATION STATUS
            if (jsonObject.has(Properties.KEY_VERIFICATION_STATUS)) {
                JSONObject jsonVerificationStatus = jsonObject.getJSONObject(Properties.KEY_VERIFICATION_STATUS);
                CodeableConcept verificationStatus = createCodeableConcept(jsonVerificationStatus);
                allergyIntolerance.setVerificationStatus(verificationStatus);
            }

            //initialize TYPE
            if (jsonObject.has(Properties.KEY_TYPE)) {
                String type = jsonObject.getString(Properties.KEY_TYPE);
                allergyIntolerance.setType(type);
            }

            //initialize CATEGORY
            if (jsonObject.has(Properties.KEY_CATEGORY)) {
                JSONArray jsonArrayCategory = jsonObject.getJSONArray(Properties.KEY_CATEGORY);
                List<String> listOfCategory = createCategoryList(jsonArrayCategory);
                allergyIntolerance.setCategory(listOfCategory);
            }

            //initialize CRITICALITY
            if (jsonObject.has(Properties.KEY_CRITICALITY)) {
                String criticality = jsonObject.getString(Properties.KEY_CRITICALITY);
                allergyIntolerance.setCriticality(criticality);
            }

            //initialize CODE
            if (jsonObject.has(Properties.KEY_CODE)) {
                JSONObject jsonCode = jsonObject.getJSONObject(Properties.KEY_CODE);
                CodeableConcept code = createCodeableConcept(jsonCode);
                allergyIntolerance.setCode(code);
            }

            //initialize PATIENT
            if (jsonObject.has(Properties.KEY_REFERENCE)) {
                JSONObject jsonReference = jsonObject.getJSONObject(Properties.KEY_REFERENCE);
                Reference patient = createReference(jsonReference);
                allergyIntolerance.setPatient(patient);
            }

            //initialize ENCOUNTER
            if (jsonObject.has(Properties.KEY_ENCOUNTER)) {
                JSONObject jsonEncounter = jsonObject.getJSONObject(Properties.KEY_ENCOUNTER);
                Reference encounter = createReference(jsonEncounter);
                allergyIntolerance.setEncounter(encounter);
            }

            //initialize RECORDED DATE
            if (jsonObject.has(Properties.KEY_RECORDED_DATE)) {
                String recordedDate = jsonObject.getString(Properties.KEY_RECORDED_DATE);
                allergyIntolerance.setRecordedDate(recordedDate);
            }

            //initialize RECORDER
            if (jsonObject.has(Properties.KEY_RECORDER)) {
                JSONObject jsonRecorder = jsonObject.getJSONObject(Properties.KEY_RECORDER);
                Reference recorder = createReference(jsonRecorder);
                allergyIntolerance.setRecorder(recorder);
            }

            //initialize ASSERTER
            if (jsonObject.has(Properties.KEY_ASSERTER)) {
                JSONObject jsonAsserter = jsonObject.getJSONObject(Properties.KEY_ASSERTER);
                Reference asserter = createReference(jsonAsserter);
                allergyIntolerance.setAsserter(asserter);
            }

            //initialize LAST OCCURENCE
            if (jsonObject.has(Properties.KEY_LAST_OCCURENCE)) {
                String lastOccurence = jsonObject.getString(Properties.KEY_LAST_OCCURENCE);
                allergyIntolerance.setLastOccurence(lastOccurence);
            }

            //initialize NOTE
            if (jsonObject.has(Properties.KEY_NOTE)) {
                JSONArray jsonArrayNote = jsonObject.getJSONArray(Properties.KEY_NOTE);
                List<Annotation> noteList = createAnnotationList(jsonArrayNote);
                allergyIntolerance.setNote(noteList);
            }

            //initialize REACTION
            if (jsonObject.has(Properties.KEY_REACTION)) {
                JSONArray jsonArrayReaction = jsonObject.getJSONArray(Properties.KEY_REACTION);
                List<R4Reaction> reactionList = createReactionList(jsonArrayReaction);
                allergyIntolerance.setReaction(reactionList);
            }

        } catch (Exception e) {
            Log.d("TEST", "createR4AllergyIntolerance Exception : " + e.toString());
        }
        return allergyIntolerance;
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
    public R4Reaction createR4Reaction(JSONObject jsonObject) {
        R4Reaction r4Reaction = new R4Reaction();
        try {

            if (jsonObject.has(Properties.KEY_SUBSTANCE)) {
                JSONObject json = jsonObject.getJSONObject(Properties.KEY_SUBSTANCE);
                CodeableConcept substance = createCodeableConcept(json);
                r4Reaction.setSubstance(substance);
            }

            if (jsonObject.has(Properties.KEY_MANIFESTATION)) {
                JSONArray jsonArrayManifestation = jsonObject.getJSONArray(Properties.KEY_MANIFESTATION);
                List<CodeableConcept> manifestationList = createCodeableConceptList(jsonArrayManifestation);
                r4Reaction.setManifestation(manifestationList);
            }

            if (jsonObject.has(Properties.KEY_DESCRIPTION)) {
                String description = jsonObject.getString(Properties.KEY_DESCRIPTION);
                r4Reaction.setDescription(description);
            }

            if (jsonObject.has(Properties.KEY_ONSET)) {
                String onSet = jsonObject.getString(Properties.KEY_ONSET);
                r4Reaction.setOnSet(onSet);
            }

            if (jsonObject.has(Properties.KEY_SEVERITY)) {
                String severity = jsonObject.getString(Properties.KEY_SEVERITY);
                r4Reaction.setSeverity(severity);
            }

            if (jsonObject.has(Properties.KEY_EXPOSURE_ROUTE)) {
                JSONObject json = jsonObject.getJSONObject(Properties.KEY_EXPOSURE_ROUTE);
                CodeableConcept exposureRoute = createCodeableConcept(json);
                r4Reaction.setExposureRoute(exposureRoute);
            }

            if (jsonObject.has(Properties.KEY_NOTE)) {
                JSONArray jsonArrayNote = jsonObject.getJSONArray(Properties.KEY_NOTE);
                List<Annotation> noteList = createAnnotationList(jsonArrayNote);
                r4Reaction.setNote(noteList);
            }

        } catch (Exception e) {
            Log.d("TEST", "createReaction Exception : " + e.toString());
        }
        return r4Reaction;
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
        CodeableConcept clinicalStatus = new CodeableConcept(null, "");
        try {

            if (jsonObject.has(Properties.KEY_CODING)) {
                JSONArray jsonArrayCoding = jsonObject.getJSONArray(Properties.KEY_CODING);
                List<Coding> listOfCoding = createCodingList(jsonArrayCoding);
                clinicalStatus.setCoding(listOfCoding);
            }

            if (jsonObject.has(Properties.KEY_TEXT)) {
                String text = jsonObject.getString(Properties.KEY_TEXT);
                clinicalStatus.setText(text);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createCodeableConcept Exception : " + e.toString());
        }
        return clinicalStatus;
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
    public List<String> createCategoryList(JSONArray jsonArray) {
        List<String> categoryList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {

                String category = jsonArray.getString(c);
                categoryList.add(category);
            }
        } catch (Exception e) {
            Log.d("TEST", "createCategory Exception : " + e.toString());
        }
        return categoryList;
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
    public List<R4Reaction> createReactionList(JSONArray jsonArray) {
        List<R4Reaction> reactionList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                R4Reaction annotation = createR4Reaction(jsonObject);
                reactionList.add(annotation);
            }
        } catch (Exception e) {
            Log.d("TEST", "createReaction Exception : " + e.toString());
        }
        return reactionList;
    }

}
