package com.ducen.predictor.r4.converter;

import android.util.Log;

import com.ducen.predictor.defaultdata.Properties;
import com.ducen.predictor.r4.types.Media;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.entity.R4DiagnosticReport;
import com.ducen.predictor.r4.types.Attachment;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class R4DiagnosticReportServiceImpl implements R4DiagnosticReportService {

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
    public List<R4DiagnosticReport> createR4DiagnosticReportList(JSONObject jsonObject) {
        List<R4DiagnosticReport> r4DiagnosticReportList = new ArrayList<>();
        try {
            if (jsonObject.has(Properties.KEY_ENTRY)) {
                JSONArray jsonEntry = jsonObject.getJSONArray(Properties.KEY_ENTRY);
                for (int c = 0; c < jsonEntry.length(); c++) {

                    JSONObject jsonResources = jsonObject.getJSONArray(Properties.KEY_ENTRY).getJSONObject(c);

                    if (jsonResources.has(Properties.KEY_RESOURCE)) {
                        JSONObject jsonResource = jsonResources.getJSONObject(Properties.KEY_RESOURCE);
                        R4DiagnosticReport r4DiagnosticReport = createR4DiagnosticReport(jsonResource);
                        r4DiagnosticReportList.add(r4DiagnosticReport);
                    }

                }

            }
        } catch (Exception e) {
            Log.d("TEST", "createListOfCondition Exception : " + e.toString());
        }
        return r4DiagnosticReportList;
    }

    @Override
    public R4DiagnosticReport createR4DiagnosticReport(JSONObject jsonObject) {
        R4DiagnosticReport r4DiagnosticReport = new R4DiagnosticReport();
        try {

            //initialize META
            if (jsonObject.has(Properties.KEY_META)) {
                JSONObject jsonMeta = jsonObject.getJSONObject(Properties.KEY_META);
                Meta meta = createR4MetaPractitioner(jsonMeta);
                r4DiagnosticReport.setMeta(meta);
            }

            //initialize IDENTIFIER
            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> identifierList = createIdentifierList(jsonArrayIdentifier);
                r4DiagnosticReport.setIdentifier(identifierList);
            }

            //initialize basedOn
            if (jsonObject.has(Properties.KEY_BASED_ON)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_BASED_ON);
                List<Reference> basedOnList = createReferenceList(jsonArray);
                r4DiagnosticReport.setBasedOn(basedOnList);
            }

            //initialize STATUS
            if (jsonObject.has(Properties.KEY_STATUS)) {
                String status = jsonObject.getString(Properties.KEY_STATUS);
                r4DiagnosticReport.setStatus(status);
            }

            //initialize CATEGORY
            if (jsonObject.has(Properties.KEY_CATEGORY)) {
                JSONArray jsonArrayCategory = jsonObject.getJSONArray(Properties.KEY_CATEGORY);
                List<CodeableConcept> categoryList = createCodeableConceptList(jsonArrayCategory);
                r4DiagnosticReport.setCategory(categoryList);
            }

            //initialize CODE
            if (jsonObject.has(Properties.KEY_CODE)) {
                JSONObject jsonCode = jsonObject.getJSONObject(Properties.KEY_CODE);
                CodeableConcept code = createCodeableConcept(jsonCode);
                r4DiagnosticReport.setCode(code);
            }

            //initialize SUBJECT
            if (jsonObject.has(Properties.KEY_SUBJECT)) {
                JSONObject jsonReference = jsonObject.getJSONObject(Properties.KEY_SUBJECT);
                Reference subject = createReference(jsonReference);
                r4DiagnosticReport.setSubject(subject);
            }

            //initialize ENCOUNTER
            if (jsonObject.has(Properties.KEY_ENCOUNTER)) {
                JSONObject jsonEncounter = jsonObject.getJSONObject(Properties.KEY_ENCOUNTER);
                Reference encounter = createReference(jsonEncounter);
                r4DiagnosticReport.setEncounter(encounter);
            }

            //initialize effectiveDateTime
            if (jsonObject.has(Properties.KEY_EFFECTIVE_DATETIME)) {
                String effectiveDateTime = jsonObject.getString(Properties.KEY_EFFECTIVE_DATETIME);
                r4DiagnosticReport.setEffectiveDateTime(effectiveDateTime);
            }

            //initialize effectivePeriod
            if (jsonObject.has(Properties.KEY_EFFECTIVE_PERIOD)) {
                JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_ABATEMENT_PERIOD);
                Period period = createPeriod(jsonPeriod);
                r4DiagnosticReport.setEffectivePeriod(period);
            }

            //initialize ISSUED
            if (jsonObject.has(Properties.KEY_ISSUED)) {
                String issued = jsonObject.getString(Properties.KEY_ISSUED);
                r4DiagnosticReport.setIssued(issued);
            }

            //initialize PERFORMER
            if (jsonObject.has(Properties.KEY_PERFORMER)) {
                JSONArray jsonArrayPerformer = jsonObject.getJSONArray(Properties.KEY_PERFORMER);
                List<Reference> performerList = createReferenceList(jsonArrayPerformer);
                r4DiagnosticReport.setPerformer(performerList);
            }

            //initialize resultsInterpreter
            if (jsonObject.has(Properties.KEY_RESULTS_INTERPRETER)) {
                JSONArray jsonArrayResultsInterpreter = jsonObject.getJSONArray(Properties.KEY_RESULTS_INTERPRETER);
                List<Reference> resultsInterpreterList = createReferenceList(jsonArrayResultsInterpreter);
                r4DiagnosticReport.setResultsInterpreter(resultsInterpreterList);
            }

            //initialize specimen
            if (jsonObject.has(Properties.KEY_SPECIMEN)) {
                JSONArray jsonArraySpecimen = jsonObject.getJSONArray(Properties.KEY_SPECIMEN);
                List<Reference> specimenList = createReferenceList(jsonArraySpecimen);
                r4DiagnosticReport.setSpecimen(specimenList);
            }

            //initialize result
            if (jsonObject.has(Properties.KEY_RESULT)) {
                JSONArray jsonArrayResult = jsonObject.getJSONArray(Properties.KEY_RESULT);
                List<Reference> resultList = createReferenceList(jsonArrayResult);
                r4DiagnosticReport.setResult(resultList);
            }

            //initialize imagingStudy
            if (jsonObject.has(Properties.KEY_IMAGING_STUDY)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_IMAGING_STUDY);
                List<Reference> imagingStudyList = createReferenceList(jsonArray);
                r4DiagnosticReport.setImagingStudy(imagingStudyList);
            }

            //initialize media
            if (jsonObject.has(Properties.KEY_MEDIA)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_MEDIA);
                List<Media> mediaList = createR4MediaList(jsonArray);
                r4DiagnosticReport.setMedia(mediaList);
            }

            //initialize CONCLUSION
            if (jsonObject.has(Properties.KEY_CONCLUSION)) {
                String conclusion = jsonObject.getString(Properties.KEY_CONCLUSION);
                r4DiagnosticReport.setConclusion(conclusion);
            }

            //initialize CONCLUSION CODE
            if (jsonObject.has(Properties.KEY_CONCLUSION_CODE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_CONCLUSION_CODE);
                List<CodeableConcept> conclusionCodeList = createCodeableConceptList(jsonArray);
                r4DiagnosticReport.setConclusionCode(conclusionCodeList);
            }

            //initialize presentedForm
            if (jsonObject.has(Properties.KEY_PRESENTED_FORM)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_PRESENTED_FORM);
                List<Attachment> presentedForm = createAttachmentList(jsonArray);
                r4DiagnosticReport.setPresentedForm(presentedForm);
            }


        } catch (Exception e) {
            Log.d("TEST", "createR4DiagnosticReport Exception : " + e.toString());
        }

        return r4DiagnosticReport;
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
    public Attachment createAttachment(JSONObject jsonObject) {
        Attachment attachment = new Attachment();
        try {

            // this fields are not yet finished
//            private Base64 data;
//            private Base64 hash;

            if (jsonObject.has(Properties.KEY_CONTENT_TYPE)) {
                String contentType = jsonObject.getString(Properties.KEY_CONTENT_TYPE);
                attachment.setContentType(contentType);
            }

            if (jsonObject.has(Properties.KEY_LANGUAGE)) {
                String language = jsonObject.getString(Properties.KEY_LANGUAGE);
                attachment.setLanguage(language);
            }

            if (jsonObject.has(Properties.KEY_URL)) {
                String url = jsonObject.getString(Properties.KEY_URL);
                attachment.setUrl(url);
            }

            if (jsonObject.has(Properties.KEY_SIZE)) {
                String size = jsonObject.getString(Properties.KEY_SIZE);
                attachment.setSize(size);
            }

            if (jsonObject.has(Properties.KEY_TITLE)) {
                String title = jsonObject.getString(Properties.KEY_TITLE);
                attachment.setTitle(title);
            }

            if (jsonObject.has(Properties.KEY_CREATION)) {
                String creation = jsonObject.getString(Properties.KEY_CREATION);
                attachment.setCreation(creation);
            }

        } catch (Exception e) {
            Log.d("TEST", "createAnnotation Exception : " + e.toString());
        }
        return attachment;
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
    public Media createR4Media(JSONObject jsonObject) {
        Media media = new Media();
        try {

            if (jsonObject.has(Properties.KEY_COMMENT)) {
                String comment = jsonObject.getString(Properties.KEY_COMMENT);
                media.setComment(comment);
            }

            if (jsonObject.has(Properties.KEY_LINK)) {
                JSONObject jsonLink = jsonObject.getJSONObject(Properties.KEY_LINK);
                Reference link = createReference(jsonLink);
                media.setLink(link);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createIdentifier Exception : " + e.toString());
        }
        return media;
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
    public List<Attachment> createAttachmentList(JSONArray jsonArray) {
        List<Attachment> attachmentList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Attachment attachment = createAttachment(jsonObject);
                attachmentList.add(attachment);
            }
        } catch (Exception e) {
            Log.d("TEST", "createAttachmentList Exception : " + e.toString());
        }
        return attachmentList;
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
    public List<Media> createR4MediaList(JSONArray jsonArray) {
        List<Media> mediaList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Media media = createR4Media(jsonObject);
                mediaList.add(media);
            }
        } catch (Exception e) {
            Log.d("TEST", "createR4MediaList Exception : " + e.toString());
        }
        return mediaList;
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
