package com.ducen.predictor.r4.service;

import android.util.Log;

import com.ducen.predictor.defaultdata.Properties;
import com.ducen.predictor.r4.entity.R4RiskAssessment;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Prediction;
import com.ducen.predictor.r4.types.Range;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.SimpleQuantity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class R4RiskAssessmentServiceImpl implements R4RiskAssessmentService {
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
    public List<R4RiskAssessment> createR4RiskAssessmentList(JSONObject jsonObject) {
        List<R4RiskAssessment> riskAssessmentList = new ArrayList<>();
        try {
            if(jsonObject.has(Properties.KEY_ENTRY)){
                JSONArray jsonEntry = jsonObject.getJSONArray(Properties.KEY_ENTRY);
                for (int i = 0; i < jsonEntry.length();i++){
                    JSONObject jsonResource = jsonObject.getJSONArray(Properties.KEY_RESOURCE).getJSONObject(i);
                    R4RiskAssessment riskAssessment = createR4RiskAssessment(jsonResource);
                    riskAssessmentList.add(riskAssessment);
                }

            }
        } catch (Exception e) {
            Log.d("TEST", "createR4RiskAssessmentList Exception : " + e.toString());
            e.printStackTrace();
        }
        return riskAssessmentList;
    }

    @Override
    public R4RiskAssessment createR4RiskAssessment(JSONObject jsonObject) {
        R4RiskAssessment riskAssessment = new R4RiskAssessment();

        try {
            //initialize META
            if(jsonObject.has(Properties.KEY_META)){
                JSONObject jsonMeta = jsonObject.getJSONObject(Properties.KEY_META);
                Meta meta = createMeta(jsonMeta);
                riskAssessment.setMetaPractitioner(meta);
            }

            //initialize IDENTIFIER
            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> listOfIdentifier = createIdentifierList(jsonArrayIdentifier);
                riskAssessment.setIdentifier(listOfIdentifier);
            }
            //initialize basedOn
            if (jsonObject.has(Properties.KEY_BASED_ON)) {
                JSONObject jsonBasedOn = jsonObject.getJSONObject(Properties.KEY_BASED_ON);
                Reference basedOn = createReference(jsonBasedOn);
                riskAssessment.setBasedOn(basedOn);
            }

            //initialize parent
            if (jsonObject.has(Properties.KEY_PARENT)) {
                JSONObject jsonParent = jsonObject.getJSONObject(Properties.KEY_PARENT);
                Reference parent = createReference(jsonParent);
                riskAssessment.setParent(parent);
            }

            //initialize status
            if (jsonObject.has(Properties.KEY_STATUS)) {
                String status = jsonObject.getString(Properties.KEY_STATUS);
                riskAssessment.setStatus(status);
            }
            //initialize category
            if (jsonObject.has(Properties.KEY_METHOD)) {
                JSONObject jsonMethod = jsonObject.getJSONObject(Properties.KEY_METHOD);
                CodeableConcept method = createCodeableConcept(jsonMethod);
                riskAssessment.setMethod(method);
            }
            //init code
            if(jsonObject.has(Properties.KEY_CODE)){
                JSONObject jsonCode = jsonObject.getJSONObject(Properties.KEY_CODE);
                CodeableConcept code = createCodeableConcept(jsonCode);
                riskAssessment.setCode(code);
            }

            //initialize subject
            if (jsonObject.has(Properties.KEY_SUBJECT)) {
                JSONObject jsonSubject = jsonObject.getJSONObject(Properties.KEY_SUBJECT);
                Reference subject = createReference(jsonSubject);
                riskAssessment.setSubject(subject);
            }

            //initialize encounter
            if (jsonObject.has(Properties.KEY_ENCOUNTER)) {
                JSONObject jsonEncounter = jsonObject.getJSONObject(Properties.KEY_ENCOUNTER);
                Reference encounter = createReference(jsonEncounter);
                riskAssessment.setEncounter(encounter);
            }

            //init occurrenceDateTime
            if(jsonObject.has(Properties.KEY_OCCURRENCE_DATETIME)){
                String occurrenceDateTime = jsonObject.getString(Properties.KEY_OCCURRENCE_DATETIME);
                riskAssessment.setOccurrenceDateTime(occurrenceDateTime);
            }

            //occurrencePeriod
            if(jsonObject.has(Properties.KEY_OCCURRENCE_PERIOD)){
                JSONObject jsonOccurrencePeriod = jsonObject.getJSONObject(Properties.KEY_OCCURRENCE_PERIOD);
                Period occurrencePeriod = createPeriod(jsonOccurrencePeriod);
                riskAssessment.setOccurrencePeriod(occurrencePeriod);
            }

            //initialize performer
            if (jsonObject.has(Properties.KEY_PERFORMER)) {
                JSONObject jsonPerformer = jsonObject.getJSONObject(Properties.KEY_PERFORMER);
                Reference performer = createReference(jsonPerformer);
                riskAssessment.setPerformer(performer);
            }

            //initialize reasonCode
            if(jsonObject.has(Properties.KEY_REASON_CODE)){
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_REASON_CODE);
                List<CodeableConcept> reasonCode = createCodeableConceptList(jsonArray);
                riskAssessment.setReasonCode(reasonCode);
            }

            //initialize reasonReference
            if(jsonObject.has(Properties.KEY_REASON_REFERENCE)){
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_REASON_REFERENCE);
                List<Reference> reasonReference = createReferenceList(jsonArray);
                riskAssessment.setReasonReference(reasonReference);
            }

            //initialize basis
            if(jsonObject.has(Properties.KEY_BASIS)){
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_BASIS);
                List<Reference> basis = createReferenceList(jsonArray);
                riskAssessment.setBasis(basis);
            }

            //initialize prediction
            if(jsonObject.has(Properties.KEY_PREDICTION)){
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_PREDICTION);
                List<Prediction> predictions = createPredictionList(jsonArray);
                riskAssessment.setPrediction(predictions);
            }

            //init mitigation
            if(jsonObject.has(Properties.KEY_MITIGATION)){
                String mitigation = jsonObject.getString(Properties.KEY_MITIGATION);
                riskAssessment.setMitigation(mitigation);
            }

            //initialize note
            if (jsonObject.has(Properties.KEY_NOTE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_NOTE);
                List<Annotation> note = createAnnotationList(jsonArray);
                riskAssessment.setNote(note);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("TEST", "createR4RiskAssessment Exception : " + e.toString());
        }
        return riskAssessment;
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
    public Prediction createPrediction(JSONObject jsonObject) {

        Prediction prediction = new Prediction();

        try {

            //outcome
            if(jsonObject.has(Properties.KEY_OUTCOME)){
                JSONObject jsonOutcome = jsonObject.getJSONObject(Properties.KEY_OUTCOME);
                CodeableConcept outcome = createCodeableConcept(jsonOutcome);
                prediction.setOutcome(outcome);
            }

            //probabilityDecimal
            if(jsonObject.has(Properties.KEY_PROBABILITY_DECIMAL)){
                String probabilityDecimal = jsonObject.getString(Properties.KEY_PROBABILITY_DECIMAL);
                prediction.setProbabilityDecimal(probabilityDecimal);
            }

            //probabilityRange
            if(jsonObject.has(Properties.KEY_PROBABILITY_RANGE)){
                JSONObject jsonProbRange = jsonObject.getJSONObject(Properties.KEY_PROBABILITY_RANGE);
                Range range = createRange(jsonProbRange);
                prediction.setProbabilityRange(range);
            }

            //qualitativeRisk
            if(jsonObject.has(Properties.KEY_QUALITATIVE_RISK)){
                JSONObject jsonQualitativeRisk = jsonObject.getJSONObject(Properties.KEY_QUALITATIVE_RISK);
                CodeableConcept qualitativeRisk = createCodeableConcept(jsonQualitativeRisk);
                prediction.setQualitativeRisk(qualitativeRisk);
            }

            //relativeRisk
            if(jsonObject.has(Properties.KEY_RELATIVE_RISK)){
                String jsonRelativeRisk = jsonObject.getString(Properties.KEY_RELATIVE_RISK);
                prediction.setRelativeRisk(jsonRelativeRisk);

            }

            //whenPeriod
            if(jsonObject.has(Properties.KEY_WHEN_PERIOD)){
                JSONObject jsonWhenPeriod = jsonObject.getJSONObject(Properties.KEY_WHEN_PERIOD);
                Period period = createPeriod(jsonWhenPeriod);
                prediction.setWhenPeriod(period);
            }

            //whenRange
            if(jsonObject.has(Properties.KEY_WHEN_RANGE)){
                JSONObject jsonWhenRange = jsonObject.getJSONObject(Properties.KEY_WHEN_RANGE);
                Range range = createRange(jsonWhenRange);
                prediction.setWhenRange(range);
            }

            //rationale
            if(jsonObject.has(Properties.KEY_RATIONALE)){
                String rationale = jsonObject.getString(Properties.KEY_RATIONALE);
                prediction.setRationale(rationale);
            }


        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("TEST", "createPrediction Exception : " + e.toString());
        }

        return prediction;
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
        return null;
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
    public List<Prediction> createPredictionList(JSONArray jsonArray) {
        List<Prediction> predictionList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Prediction prediction = createPrediction(jsonObject);
                predictionList.add(prediction);
            }
        } catch (
                Exception e) {
            Log.d("TEST", "createPredictionList Exception : " + e.toString());
        }
        return predictionList;
    }
}
