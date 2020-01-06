package com.ducen.predictor.r4.converter;

import android.util.Log;

import com.ducen.predictor.defaultdata.Properties;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Stage;
import com.ducen.predictor.r4.entity.R4Condition;
import com.ducen.predictor.r4.entity.R4Evidence;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.OnSet;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class R4ConditionConverterImpl implements R4ConditionConverter {

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
    public List<R4Condition> createR4ConditionList(JSONObject jsonObject) {
        List<R4Condition> r4ConditionList = new ArrayList<>();

        try {
            if (jsonObject.has(Properties.KEY_ENTRY)) {
                JSONArray jsonEntry = jsonObject.getJSONArray(Properties.KEY_ENTRY);
                for (int c = 0; c < jsonEntry.length(); c++) {

                    JSONObject jsonResources = jsonObject.getJSONArray(Properties.KEY_ENTRY).getJSONObject(c);

                    if (jsonResources.has(Properties.KEY_RESOURCE)) {
                        JSONObject jsonResource = jsonResources.getJSONObject(Properties.KEY_RESOURCE);
                        R4Condition r4Condition = createR4Condition(jsonResource);
                        r4ConditionList.add(r4Condition);
                    }

                }

            }
        } catch (Exception e) {
            Log.d("TEST", "createListOfCondition Exception : " + e.toString());
        }

        return r4ConditionList;
    }

    @Override
    public R4Condition createR4Condition(JSONObject jsonObject) {
        R4Condition r4Condition = new R4Condition(null, null, null, null, null, null, null, null, null, null, null, null, "", null, null, null, null, null);

        try {

            //initialize META
            if (jsonObject.has(Properties.KEY_META)) {
                JSONObject jsonMeta = jsonObject.getJSONObject(Properties.KEY_META);
                Meta meta = createR4MetaPractitioner(jsonMeta);
                r4Condition.setMeta(meta);
            }

            //initialize IDENTIFIER
            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> identifierList = createIdentifierList(jsonArrayIdentifier);
                r4Condition.setIdentifier(identifierList);
            }

            //initialize CLINICAL STATUS
            if (jsonObject.has(Properties.KEY_CLINICAL_STATUS)) {
                JSONObject jsonClinicalStatus = jsonObject.getJSONObject(Properties.KEY_CLINICAL_STATUS);
                CodeableConcept clinicalStatus = createCodeableConcept(jsonClinicalStatus);
                r4Condition.setClinicalStatus(clinicalStatus);
            }

            //initialize VERIFICATION STATUS
            if (jsonObject.has(Properties.KEY_VERIFICATION_STATUS)) {
                JSONObject jsonVerificationStatus = jsonObject.getJSONObject(Properties.KEY_VERIFICATION_STATUS);
                CodeableConcept verificationStatus = createCodeableConcept(jsonVerificationStatus);
                r4Condition.setVerificationStatus(verificationStatus);
            }

            //initialize CATEGORY
            if (jsonObject.has(Properties.KEY_CATEGORY)) {
                JSONArray jsonArrayCategory = jsonObject.getJSONArray(Properties.KEY_CATEGORY);
                List<CodeableConcept> categoryList = createCodeableConceptList(jsonArrayCategory);
                r4Condition.setCategory(categoryList);
            }

            //initialize SEVERITY
            if (jsonObject.has(Properties.KEY_SEVERITY)) {
                JSONObject jsonSeverity = jsonObject.getJSONObject(Properties.KEY_SEVERITY);
                CodeableConcept severity = createCodeableConcept(jsonSeverity);
                r4Condition.setSeverity(severity);
            }

            //initialize CODE
            if (jsonObject.has(Properties.KEY_CODE)) {
                JSONObject jsonCode = jsonObject.getJSONObject(Properties.KEY_CODE);
                CodeableConcept code = createCodeableConcept(jsonCode);
                r4Condition.setCode(code);
            }

            //initialize BODYSITE
            if (jsonObject.has(Properties.KEY_BODYSITE)) {
                JSONArray jsonArrayBodySite = jsonObject.getJSONArray(Properties.KEY_BODYSITE);
                List<CodeableConcept> bodySiteList = createCodeableConceptList(jsonArrayBodySite);
                r4Condition.setBodySite(bodySiteList);
            }

            //initialize SUBJECT
            if (jsonObject.has(Properties.KEY_SUBJECT)) {
                JSONObject jsonReference = jsonObject.getJSONObject(Properties.KEY_SUBJECT);
                Reference subject = createReference(jsonReference);
                r4Condition.setSubject(subject);
            }

            //initialize ENCOUNTER
            if (jsonObject.has(Properties.KEY_ENCOUNTER)) {
                JSONObject jsonEncounter = jsonObject.getJSONObject(Properties.KEY_ENCOUNTER);
                Reference encounter = createReference(jsonEncounter);
                r4Condition.setEncounter(encounter);
            }

            //initialize ONSET
            OnSet onSet = createOnSet(jsonObject);
            r4Condition.setOnSet(onSet);

            //initialize ABATEMENT
            OnSet abatement = createAbatement(jsonObject);
            r4Condition.setAbatement(abatement);

            //initialize RECORDED DATE
            if (jsonObject.has(Properties.KEY_RECORDED_DATE)) {
                String recordedDate = jsonObject.getString(Properties.KEY_RECORDED_DATE);
                r4Condition.setRecordedDate(recordedDate);
            }

            //initialize RECORDER
            if (jsonObject.has(Properties.KEY_RECORDER)) {
                JSONObject jsonRecorder = jsonObject.getJSONObject(Properties.KEY_RECORDER);
                Reference recorder = createReference(jsonRecorder);
                r4Condition.setRecorder(recorder);
            }

            //initialize ASSERTER
            if (jsonObject.has(Properties.KEY_ASSERTER)) {
                JSONObject jsonAsserter = jsonObject.getJSONObject(Properties.KEY_ASSERTER);
                Reference asserter = createReference(jsonAsserter);
                r4Condition.setAsserter(asserter);
            }

            //initialize STAGE
            if (jsonObject.has(Properties.KEY_STAGE)) {
                JSONArray jsonArrayStage = jsonObject.getJSONArray(Properties.KEY_STAGE);
                List<Stage> stageList = createR4StageList(jsonArrayStage);
                r4Condition.setStage(stageList);
            }

            //initialize EVIDENCE
            if (jsonObject.has(Properties.KEY_EVIDENCE)) {
                JSONArray jsonArrayEvidence = jsonObject.getJSONArray(Properties.KEY_EVIDENCE);
                List<R4Evidence> r4EvidenceList = createR4EvidenceList(jsonArrayEvidence);
                r4Condition.setR4Evidence(r4EvidenceList);
            }

            //initialize NOTE
            if (jsonObject.has(Properties.KEY_NOTE)) {
                JSONArray jsonArrayNote = jsonObject.getJSONArray(Properties.KEY_NOTE);
                List<Annotation> noteList = createAnnotationList(jsonArrayNote);
                r4Condition.setNote(noteList);
            }

        } catch (Exception e) {
            Log.d("TEST", "createR4Condition Exception : " + e.toString());
        }

        return r4Condition;
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
    public R4Evidence createR4Evidence(JSONObject jsonObject) {
        R4Evidence r4Evidence = new R4Evidence(null, null);
        try {
            if (jsonObject.has(Properties.KEY_CODE)) {
                JSONArray jsonArrayCode = jsonObject.getJSONArray(Properties.KEY_CODE);
                List<CodeableConcept> codeableConceptList = createCodeableConceptList(jsonArrayCode);
                r4Evidence.setCode(codeableConceptList);
            }

            if (jsonObject.has(Properties.KEY_DETAIL)) {
                JSONArray jsonArrayDetail = jsonObject.getJSONArray(Properties.KEY_DETAIL);
                List<Reference> detailList = createReferenceList(jsonArrayDetail);
                r4Evidence.setDetail(detailList);
            }
        } catch (
                Exception e) {
            Log.d("TEST", "createR4Evidence Exception : " + e.toString());
        }
        return r4Evidence;

    }

    @Override
    public Stage createR4Stage(JSONObject jsonObject) {
        Stage stage = new Stage(null, null, null);
        try {

            //initialize SUMMARY
            if (jsonObject.has(Properties.KEY_SUMMARY)) {
                JSONObject jsonSummary = jsonObject.getJSONObject(Properties.KEY_SUMMARY);
                CodeableConcept summary = createCodeableConcept(jsonSummary);
                stage.setSummary(summary);
            }

            //initialize ASSESSMENT
            if (jsonObject.has(Properties.KEY_ASSESSMENT)) {
                JSONArray jsonArrayAssessment = jsonObject.getJSONArray(Properties.KEY_ASSESSMENT);
                List<Reference> assessmentList = createReferenceList(jsonArrayAssessment);
                stage.setAssessment(assessmentList);
            }

            //initialize TYPE
            if (jsonObject.has(Properties.KEY_TYPE)) {
                JSONObject jsonType = jsonObject.getJSONObject(Properties.KEY_TYPE);
                CodeableConcept type = createCodeableConcept(jsonType);
                stage.setType(type);
            }

        } catch (Exception e) {
            Log.d("TEST", "createStageList Exception : " + e.toString());
        }
        return stage;
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
    public OnSet createOnSet(JSONObject jsonObject) {
        OnSet onSet = new OnSet(null, null, null, null, null);

        try {

            //initialize DATETIME
            if (jsonObject.has(Properties.KEY_ONSET_DATETIME)) {
                String dateTime = jsonObject.getString(Properties.KEY_ONSET_DATETIME);
                onSet.setOnsetDateTime(dateTime);
            }

            //initialize AGE
            if (jsonObject.has(Properties.KEY_ONSET_AGE)) {
                String age = jsonObject.getString(Properties.KEY_ONSET_AGE);
                onSet.setOnsetAge(age);
            }

            //initialize PERIOD
            if (jsonObject.has(Properties.KEY_ONSET_PERIOD)) {
                JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_ONSET_PERIOD);
                Period period = createPeriod(jsonPeriod);
                onSet.setOnsetPeriod(period);
            }

            //initialize RANGE
            if (jsonObject.has(Properties.KEY_ONSET_RANGE)) {
                String range = jsonObject.getString(Properties.KEY_ONSET_RANGE);
                onSet.setOnsetRange(range);
            }

            //initialize STRING
            if (jsonObject.has(Properties.KEY_ONSET_STRING)) {
                String string = jsonObject.getString(Properties.KEY_ONSET_STRING);
                onSet.setOnsetString(string);
            }

        } catch (Exception e) {
            Log.d("TEST", "createOnSet Exception : " + e.toString());
        }
        return onSet;
    }

    @Override
    public OnSet createAbatement(JSONObject jsonObject) {
        OnSet onSet = new OnSet(null, null, null, null, null);

        try {

            //initialize DATETIME
            if (jsonObject.has(Properties.KEY_ABATEMENT_DATETIME)) {
                String dateTime = jsonObject.getString(Properties.KEY_ABATEMENT_DATETIME);
                onSet.setOnsetDateTime(dateTime);
            }

            //initialize AGE
            if (jsonObject.has(Properties.KEY_ABATEMENT_AGE)) {
                String age = jsonObject.getString(Properties.KEY_ABATEMENT_AGE);
                onSet.setOnsetAge(age);
            }

            //initialize PERIOD
            if (jsonObject.has(Properties.KEY_ABATEMENT_PERIOD)) {
                JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_ABATEMENT_PERIOD);
                Period period = createPeriod(jsonPeriod);
                onSet.setOnsetPeriod(period);
            }

            //initialize RANGE
            if (jsonObject.has(Properties.KEY_ABATEMENT_RANGE)) {
                String range = jsonObject.getString(Properties.KEY_ABATEMENT_RANGE);
                onSet.setOnsetRange(range);
            }

            //initialize STRING
            if (jsonObject.has(Properties.KEY_ABATEMENT_STRING)) {
                String string = jsonObject.getString(Properties.KEY_ABATEMENT_STRING);
                onSet.setOnsetString(string);
            }

        } catch (Exception e) {
            Log.d("TEST", "createAbatement Exception : " + e.toString());
        }
        return onSet;
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
    public List<Annotation> createAnnotationList(JSONArray jsonArray) {
        List<Annotation> annotationList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Annotation annotation = createAnnotation(jsonObject);
                annotationList.add(annotation);
            }
        } catch (Exception e) {
            Log.d("TEST", "createAnnotationList Exception : " + e.toString());
        }
        return annotationList;
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
    public List<Stage> createR4StageList(JSONArray jsonArray) {
        List<Stage> stageList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Stage stage = createR4Stage(jsonObject);
                stageList.add(stage);
            }
        } catch (Exception e) {
            Log.d("TEST", "createStageList Exception : " + e.toString());
        }
        return stageList;
    }

    @Override
    public List<R4Evidence> createR4EvidenceList(JSONArray jsonArray) {
        List<R4Evidence> r4EvidenceList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                R4Evidence r4Evidence = createR4Evidence(jsonObject);
                r4EvidenceList.add(r4Evidence);
            }

        } catch (Exception e) {
            Log.d("TEST", "createR4EvidenceList Exception : " + e.toString());
        }

        return r4EvidenceList;
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
