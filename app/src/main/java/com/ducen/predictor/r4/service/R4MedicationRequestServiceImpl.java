package com.ducen.predictor.r4.service;

import android.util.Log;

import com.ducen.predictor.defaultdata.Properties;
import com.ducen.predictor.r4.entity.R4MedicationRequest;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.DispenseRequest;
import com.ducen.predictor.r4.types.Dosage;
import com.ducen.predictor.r4.types.DoseAndRate;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.InitialFill;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Performer;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Quantity;
import com.ducen.predictor.r4.types.Range;
import com.ducen.predictor.r4.types.Ratio;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.Repeat;
import com.ducen.predictor.r4.types.RequestSubstitution;
import com.ducen.predictor.r4.types.SimpleQuantity;
import com.ducen.predictor.r4.types.Timing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class R4MedicationRequestServiceImpl implements R4MedicationRequestService{
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
    public List<R4MedicationRequest> createR4MedicationRequestList(JSONObject jsonObject) {
        List<R4MedicationRequest> medicationRequestList = new ArrayList<>();

        try {

            if (jsonObject.has(Properties.KEY_ENTRY)) {

                JSONArray jsonEntry = jsonObject.getJSONArray(Properties.KEY_ENTRY);

                for (int c = 0; c < jsonEntry.length(); c++) {

                    JSONObject jsonResources = jsonObject.getJSONArray(Properties.KEY_ENTRY).getJSONObject(c);

                    if (jsonResources.has(Properties.KEY_RESOURCE)) {

                        JSONObject jsonResource = jsonResources.getJSONObject(Properties.KEY_RESOURCE);

                        R4MedicationRequest r4MedicationRequest = createR4MedicationRequest(jsonResource);

                        medicationRequestList.add(r4MedicationRequest);

                    }

                }

            }
        } catch (Exception e) {
            Log.d("TEST", "createAllergyIntoleranceList Exception : " + e.toString());
        }

        return medicationRequestList;
    }

    @Override
    public R4MedicationRequest createR4MedicationRequest(JSONObject jsonObject) {
        R4MedicationRequest r4MedicationRequest = new R4MedicationRequest();
        try {
            //initialize META
            if (jsonObject.has(Properties.KEY_META)) {
                JSONObject jsonMeta = jsonObject.getJSONObject(Properties.KEY_META);
                Meta meta = createMeta(jsonMeta);
                r4MedicationRequest.setMeta(meta);
            }
            //initialize IDENTIFIER
            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> listOfIdentifier = createIdentifierList(jsonArrayIdentifier);
                r4MedicationRequest.setIdentifier(listOfIdentifier);
            }

            //initialize status
            if (jsonObject.has(Properties.KEY_STATUS)) {
                String status = jsonObject.getString(Properties.KEY_STATUS);
                r4MedicationRequest.setStatus(status);
            }

            //initialize statusReason
            if (jsonObject.has(Properties.KEY_STATUS_REASON_CODEABLE_CONCEPT)) {
                JSONObject jsonStatusReasonCodeableConcept = jsonObject.getJSONObject(Properties.KEY_STATUS_REASON_CODEABLE_CONCEPT);
                CodeableConcept statusReasonCodeableConcept = createCodeableConcept(jsonStatusReasonCodeableConcept);
                r4MedicationRequest.setStatusReason(statusReasonCodeableConcept);
            }

            //initialize intent
            if (jsonObject.has(Properties.KEY_INTENT)) {
                String intent = jsonObject.getString(Properties.KEY_INTENT);
                r4MedicationRequest.setIntent(intent);
            }

            //initialize category
            if (jsonObject.has(Properties.KEY_CATEGORY)) {
                JSONObject jsonCategory = jsonObject.getJSONObject(Properties.KEY_CATEGORY);
                CodeableConcept category = createCodeableConcept(jsonCategory);
                r4MedicationRequest.setCategory(category);
            }

            //initialize priority
            if (jsonObject.has(Properties.KEY_PRIORITY)) {
                String priority = jsonObject.getString(Properties.KEY_PRIORITY);
                r4MedicationRequest.setPriority(priority);
            }

            //initialize doNotPerform
            if (jsonObject.has(Properties.KEY_DO_NOT_PERFORM)) {
                String doNotPerform = jsonObject.getString(Properties.KEY_DO_NOT_PERFORM);
                r4MedicationRequest.setDoNotPerform(doNotPerform);
            }

            //initialize reportedBoolean
            if (jsonObject.has(Properties.KEY_REPORTED_BOOLEAN)) {
                String reportedBoolean = jsonObject.getString(Properties.KEY_REPORTED_BOOLEAN);
                r4MedicationRequest.setReportedBoolean(reportedBoolean);
            }

            //init reportedReference
            if(jsonObject.has(Properties.KEY_REPORTED_REFERENCE)){
                JSONObject jsonReportedReference = jsonObject.getJSONObject(Properties.KEY_REPORTED_REFERENCE);
                Reference reportedReference = createReference(jsonReportedReference);
                r4MedicationRequest.setReportedReference(reportedReference);
            }

            //initialize medicationCodeableConcept
            if (jsonObject.has(Properties.KEY_MEDICATION_CODEABLE_CONCEPT)) {
                JSONObject jsonMedicationCodeableConcept = jsonObject.getJSONObject(Properties.KEY_MEDICATION_CODEABLE_CONCEPT);
                CodeableConcept medicationCodeableConcept = createCodeableConcept(jsonMedicationCodeableConcept);
                r4MedicationRequest.setMedicationCodeableConcept(medicationCodeableConcept);
            }

            //initialize medicationReference
            if (jsonObject.has(Properties.KEY_MEDICATION_REFERENCE)) {
                JSONObject jsonMedicationReference = jsonObject.getJSONObject(Properties.KEY_MEDICATION_REFERENCE);
                Reference medicationReference = createReference(jsonMedicationReference);
                r4MedicationRequest.setMedicationReference(medicationReference);
            }

            //initialize subject
            if (jsonObject.has(Properties.KEY_SUBJECT)) {
                JSONObject jsonSubject = jsonObject.getJSONObject(Properties.KEY_SUBJECT);
                Reference subject = createReference(jsonSubject);
                r4MedicationRequest.setSubject(subject);
            }

            //initialize encounter
            if (jsonObject.has(Properties.KEY_ENCOUNTER)) {
                JSONObject jsonEncounter = jsonObject.getJSONObject(Properties.KEY_ENCOUNTER);
                Reference encounter = createReference(jsonEncounter);
                r4MedicationRequest.setEncounter(encounter);
            }

            //initialize supportingInformation
            if (jsonObject.has(Properties.KEY_SUPPORTING_INFORMATION)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_SUPPORTING_INFORMATION);
                List<Reference> supportingInformation = createReferenceList(jsonArray);
                r4MedicationRequest.setSupportingInformation(supportingInformation);
            }

            //init authoredOn
            if(jsonObject.has(Properties.KEY_AUTHORED_ON)){
                String authoredOn = jsonObject.getString(Properties.KEY_AUTHORED_ON);
                r4MedicationRequest.setAuthoredOn(authoredOn);
            }

            //initialize requester
            if (jsonObject.has(Properties.KEY_REQUESTER)) {
                JSONObject jsonRequester = jsonObject.getJSONObject(Properties.KEY_REQUESTER);
                Reference requester = createReference(jsonRequester);
                r4MedicationRequest.setRequester(requester);
            }

            //initialize performer
            if (jsonObject.has(Properties.KEY_PERFORMER)) {
                JSONObject jsonPerformer = jsonObject.getJSONObject(Properties.KEY_PERFORMER);
                Reference performer = createReference(jsonPerformer);
                r4MedicationRequest.setPerformer(performer);
            }

            //performerType
            if(jsonObject.has(Properties.KEY_PERFORMER_TYPE)){
                JSONObject jsonPerformerType = jsonObject.getJSONObject(Properties.KEY_PERFORMER_TYPE);
                CodeableConcept performerType = createCodeableConcept(jsonPerformerType);
                r4MedicationRequest.setPerformerType(performerType);
            }

            //initialize recorder
            if (jsonObject.has(Properties.KEY_RECORDER)) {
                JSONObject jsonRecorder = jsonObject.getJSONObject(Properties.KEY_RECORDER);
                Reference recorder = createReference(jsonRecorder);
                r4MedicationRequest.setRecorder(recorder);
            }

            //initialize reasonCode
            if(jsonObject.has(Properties.KEY_REASON_CODE)){
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_REASON_CODE);
                List<CodeableConcept> reasonCode = createCodeableConceptList(jsonArray);
                r4MedicationRequest.setReasonCode(reasonCode);
            }

            //initialize reasonReference
            if(jsonObject.has(Properties.KEY_REASON_REFERENCE)){
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_REASON_REFERENCE);
                List<Reference> reasonReference = createReferenceList(jsonArray);
                r4MedicationRequest.setReasonReference(reasonReference);
            }

            //init canonical
            if(jsonObject.has(Properties.KEY_INSTANTIATES_CANONICAL)){
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_INSTANTIATES_CANONICAL);
                List<String> canonical = createStringList(jsonArray);
                r4MedicationRequest.setInstantiatesCanonical(canonical);
            }

            //init instantiates
            if(jsonObject.has(Properties.KEY_INSTANTIATES_URI)){
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_INSTANTIATES_URI);
                List<String> uri = createStringList(jsonArray);
                r4MedicationRequest.setInstantiatesUri(uri);
            }

            //initialize basedOn
            if (jsonObject.has(Properties.KEY_BASED_ON)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_BASED_ON);
                List<Reference> basedOn = createReferenceList(jsonArray);
                r4MedicationRequest.setBasedOn(basedOn);
            }

            //init groupIdentifier
            if(jsonObject.has(Properties.KEY_GROUP_IDENTIFIER)){
                JSONObject jsonIdentifier = jsonObject.getJSONObject(Properties.KEY_GROUP_IDENTIFIER);
                Identifier groupIdentifier = createIdentifier(jsonIdentifier);
                r4MedicationRequest.setGroupIdentifier(groupIdentifier);

            }

            //init courseOfTherapyType
            if(jsonObject.has(Properties.KEY_COURSE_OF_THERAPY_TYPE)){
                JSONObject jsonCourse = jsonObject.getJSONObject(Properties.KEY_COURSE_OF_THERAPY_TYPE);
                CodeableConcept courseOfTherapyType = createCodeableConcept(jsonCourse);
                r4MedicationRequest.setCourseOfTherapyType(courseOfTherapyType);
            }

            //init insurance
            if(jsonObject.has(Properties.KEY_INSURANCE)){
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_INSURANCE);
                List<Reference> insurance = createReferenceList(jsonArray);
                r4MedicationRequest.setInsurance(insurance);
            }

            //initialize note
            if (jsonObject.has(Properties.KEY_NOTE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_NOTE);
                List<Annotation> note = createAnnotationList(jsonArray);
                r4MedicationRequest.setNote(note);
            }
            //initialize dosageInstruction
            if (jsonObject.has(Properties.KEY_DOSAGE_INSTRUCTION)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_DOSAGE_INSTRUCTION);
                List<Dosage> dosageInstruction = createDosageList(jsonArray);
                r4MedicationRequest.setDosageIntruction(dosageInstruction);
            }

            //init dispenseRequest
            if(jsonObject.has(Properties.KEY_DISPENSE_REQUEST)){
                JSONObject jsonDispenseRequest = jsonObject.getJSONObject(Properties.KEY_DISPENSE_REQUEST);
                DispenseRequest dispenseRequest = createDispenseRequest(jsonDispenseRequest);
                r4MedicationRequest.setDispenseRequest(dispenseRequest);
            }

            //initialize substitution
            if (jsonObject.has(Properties.KEY_SUBSTITUTION)) {
                JSONObject jsonSubstitution = jsonObject.getJSONObject(Properties.KEY_SUBSTITUTION);
                RequestSubstitution substitution = createSubstitution(jsonSubstitution);
                r4MedicationRequest.setSubstitution(substitution);
            }

            //init priorPrescription
            if (jsonObject.has(Properties.KEY_PRIOR_PRESCRIPTION)) {
                JSONObject jsonPrescription = jsonObject.getJSONObject(Properties.KEY_PRIOR_PRESCRIPTION);
                Reference priorPrescription = createReference(jsonPrescription);
                r4MedicationRequest.setPriorPrescription(priorPrescription);
            }

            //initialize detectedIssue
            if (jsonObject.has(Properties.KEY_DETECTED_ISSUE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_DETECTED_ISSUE);
                List<Reference> detectedIssue = createReferenceList(jsonArray);
                r4MedicationRequest.setDetectedIssue(detectedIssue);
            }

            //initialize eventHistory
            if (jsonObject.has(Properties.KEY_EVENT_HISTORY)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_EVENT_HISTORY);
                List<Reference> eventHistory = createReferenceList(jsonArray);
                r4MedicationRequest.setEventHistory(eventHistory);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("TEST", "createR4MedicationRequest Exception : " + e.toString());
        }
        return r4MedicationRequest;
    }

    @Override
    public Meta createMeta(JSONObject jsonObject) {
        Meta metaPractitioner = new Meta("", "", "");
        try {

            if (jsonObject.has(Properties.KEY_VERSIONID)) {
                String versionId = jsonObject.getString(Properties.KEY_VERSIONID);
                metaPractitioner.setVersionId(versionId);
            }

            if (jsonObject.has(Properties.KEY_LAST_UPDATED)) {
                String lastUpdated = jsonObject.getString(Properties.KEY_LAST_UPDATED);
                metaPractitioner.setLastUpdated(lastUpdated);
            }

            if (jsonObject.has(Properties.KEY_SOURCE)) {
                String source = jsonObject.getString(Properties.KEY_SOURCE);
                metaPractitioner.setSource(source);
            }
        } catch (Exception e) {
            Log.d("TEST", "createMeta Exception : " + e.toString());
        }
        return metaPractitioner;
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
    public DispenseRequest createDispenseRequest(JSONObject jsonObject) {
        DispenseRequest dispenseRequest = new DispenseRequest();

        try {

            //init initialFill
            if(jsonObject.has(Properties.KEY_INITIAL_FILL)){
                JSONObject jsonObjectInitFill = jsonObject.getJSONObject(Properties.KEY_INITIAL_FILL);
                InitialFill initialFill = createInitialFill(jsonObjectInitFill);
                dispenseRequest.setInitialFill(initialFill);
            }
            //dispenseInterval
            if(jsonObject.has(Properties.KEY_DISPENSE_INTERVAL)){
                String dispenseInterval = jsonObject.getString(Properties.KEY_DISPENSE_INTERVAL);
                dispenseRequest.setDispenseInterval(dispenseInterval);
            }

            //validityPeriod
            if(jsonObject.has(Properties.KEY_VALIDITY_PERIOD)){
                JSONObject jsonValidityPeriod = jsonObject.getJSONObject(Properties.KEY_VALIDITY_PERIOD);
                Period period = createPeriod(jsonValidityPeriod);
                dispenseRequest.setValidityPeriod(period);
            }

            if(jsonObject.has(Properties.KEY_NUMBER_OF_REPEAT_ALLOWED)){
                String numberOfRepeatAllow = jsonObject.getString(Properties.KEY_NUMBER_OF_REPEAT_ALLOWED);
                dispenseRequest.setNumberOfRepeatsAllowed(numberOfRepeatAllow);
            }

            if(jsonObject.has(Properties.KEY_QUANTITY)){
                JSONObject jsonQuantity = jsonObject.getJSONObject(Properties.KEY_QUANTITY);
                SimpleQuantity quantity = createSimpleQuantity(jsonQuantity);
                dispenseRequest.setQuantity(quantity);
            }

            //expectedSupplyDuration
            if(jsonObject.has(Properties.KEY_EXPECTED_SUPPLY_DURATION)){
                String expectedSupplyDuration = jsonObject.getString(Properties.KEY_EXPECTED_SUPPLY_DURATION);
                dispenseRequest.setDispenseInterval(expectedSupplyDuration);
            }
            //performer
            if(jsonObject.has(Properties.KEY_PERFORMER)){
                JSONObject jsonPerformer = jsonObject.getJSONObject(Properties.KEY_PERFORMER);
                Reference performer = createReference(jsonPerformer);
                dispenseRequest.setPerformer(performer);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return dispenseRequest;
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
    public Quantity createQuantity(JSONObject jsonObject) {
        Quantity quantity = new Quantity();
        try {

            if (jsonObject.has(Properties.KEY_VALUE)) {
                String value = jsonObject.getString(Properties.KEY_VALUE);
                quantity.setValue(value);
            }

            if (jsonObject.has(Properties.KEY_COMPARATOR)) {
                String comparator = jsonObject.getString(Properties.KEY_COMPARATOR);
                quantity.setComparator(comparator);
            }

            if (jsonObject.has(Properties.KEY_UNIT)) {
                String unit = jsonObject.getString(Properties.KEY_UNIT);
                quantity.setUnit(unit);
            }

            if (jsonObject.has(Properties.KEY_SYSTEM)) {
                String system = jsonObject.getString(Properties.KEY_SYSTEM);
                quantity.setSystem(system);
            }

            if (jsonObject.has(Properties.KEY_CODE)) {
                String code = jsonObject.getString(Properties.KEY_CODE);
                quantity.setCode(code);
            }


        } catch (
                Exception e) {
            Log.d("TEST", "createReference Exception : " + e.toString());
        }
        return quantity;
    }

    @Override
    public Performer createPerformer(JSONObject jsonObject) {
        Performer performer = new Performer();
        try {

            if (jsonObject.has(Properties.KEY_FUNCTION)) {
                JSONObject jsonFunction = jsonObject.getJSONObject(Properties.KEY_FUNCTION);
                CodeableConcept function = createCodeableConcept(jsonFunction);
                performer.setFunction(function);
            }

            if (jsonObject.has(Properties.KEY_ACTOR)) {
                JSONObject jsonActor = jsonObject.getJSONObject(Properties.KEY_ACTOR);
                Reference actor = createReference(jsonActor);
                performer.setActor(actor);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createReference Exception : " + e.toString());
        }
        return performer;
    }

    @Override
    public InitialFill createInitialFill(JSONObject jsonObject) {
        InitialFill initialFill = new InitialFill();

        try {
            if(jsonObject.has(Properties.KEY_QUANTITY)){
                JSONObject jsonQuantity = jsonObject.getJSONObject(Properties.KEY_QUANTITY);
                SimpleQuantity quantity = createSimpleQuantity(jsonQuantity);
                initialFill.setQuantity(quantity);
            }

            if(jsonObject.has(Properties.KEY_DURATION)){
                String duration = jsonObject.getString(Properties.KEY_DURATION);
                initialFill.setDuration(duration);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return initialFill;
    }

    @Override
    public Dosage createDosage(JSONObject jsonObject) {
        Dosage dosage = new Dosage();
        try {

            //initialize sequence
            if (jsonObject.has(Properties.KEY_SEQUENCE)) {
                String sequence = jsonObject.getString(Properties.KEY_SEQUENCE);
                dosage.setSequence(sequence);
            }

            //initialize text
            if (jsonObject.has(Properties.KEY_TEXT)) {
                String text = jsonObject.getString(Properties.KEY_TEXT);
                dosage.setText(text);
            }

            //initialize additionalInstruction
            if (jsonObject.has(Properties.KEY_ADDITIONAL_INSTRUCTION)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_ADDITIONAL_INSTRUCTION);
                List<CodeableConcept> additionalInstruction = createCodeableConceptList(jsonArray);
                dosage.setAdditionalInstruction(additionalInstruction);
            }

            //initialize patientInstruction
            if (jsonObject.has(Properties.KEY_PATIENT_INSTRUCTION)) {
                String patientInstruction = jsonObject.getString(Properties.KEY_PATIENT_INSTRUCTION);
                dosage.setPatientInstruction(patientInstruction);
            }

            //initialize timing
            if (jsonObject.has(Properties.KEY_TIMING)) {
                JSONObject jsonTiming = jsonObject.getJSONObject(Properties.KEY_TIMING);
                Timing timing = createTiming(jsonTiming);
                dosage.setTiming(timing);
            }

            //initialize asNeededBoolean
            if (jsonObject.has(Properties.KEY_AS_NEEDED_BOOLEAN)) {
                String asNeededBoolean = jsonObject.getString(Properties.KEY_AS_NEEDED_BOOLEAN);
                dosage.setAsNeededBoolean(asNeededBoolean);
            }

            //initialize asNeededCodeableConcept
            if (jsonObject.has(Properties.KEY_AS_NEEDED_CODEABLE_CONCEPT)) {
                JSONObject jsonAsNeededCodeableConcept = jsonObject.getJSONObject(Properties.KEY_AS_NEEDED_CODEABLE_CONCEPT);
                CodeableConcept asNeededCodeableConcept = createCodeableConcept(jsonAsNeededCodeableConcept);
                dosage.setAsNeededCodeableConcept(asNeededCodeableConcept);
            }

            //initialize site
            if (jsonObject.has(Properties.KEY_SITE)) {
                JSONObject jsonSite = jsonObject.getJSONObject(Properties.KEY_SITE);
                CodeableConcept site = createCodeableConcept(jsonSite);
                dosage.setSite(site);
            }

            //initialize route
            if (jsonObject.has(Properties.KEY_ROUTE)) {
                JSONObject jsonRoute = jsonObject.getJSONObject(Properties.KEY_ROUTE);
                CodeableConcept route = createCodeableConcept(jsonRoute);
                dosage.setRoute(route);
            }

            //initialize route
            if (jsonObject.has(Properties.KEY_ROUTE)) {
                JSONObject jsonRoute = jsonObject.getJSONObject(Properties.KEY_ROUTE);
                CodeableConcept route = createCodeableConcept(jsonRoute);
                dosage.setRoute(route);
            }

            //initialize method
            if (jsonObject.has(Properties.KEY_METHOD)) {
                JSONObject jsonMethod = jsonObject.getJSONObject(Properties.KEY_METHOD);
                CodeableConcept method = createCodeableConcept(jsonMethod);
                dosage.setMethod(method);
            }

            //initialize doseAndRate
            if (jsonObject.has(Properties.KEY_DOSE_AND_RATE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_DOSE_AND_RATE);
                List<DoseAndRate> doseAndRate = createDoseAndRateList(jsonArray);
                dosage.setDoseAndRate(doseAndRate);
            }

            //initialize maxDosePerPeriod
            if (jsonObject.has(Properties.KEY_MAX_DOSE_PER_PERIOD)) {
                JSONObject jsonMaxDosePerPeriod = jsonObject.getJSONObject(Properties.KEY_MAX_DOSE_PER_PERIOD);
                Ratio maxDosePerPeriod = createRatio(jsonMaxDosePerPeriod);
                dosage.setMaxDosePerPeriod(maxDosePerPeriod);
            }

            //initialize maxDosePerAdministration
            if (jsonObject.has(Properties.KEY_MAX_DOSE_PER_ADMINISTRATION)) {
                JSONObject jsonMaxDosePerAdministration = jsonObject.getJSONObject(Properties.KEY_MAX_DOSE_PER_ADMINISTRATION);
                Quantity maxDosePerAdministration = createQuantity(jsonMaxDosePerAdministration);
                dosage.setMaxDosePerAdministration(maxDosePerAdministration);
            }

            //initialize maxDosePerLifetime
            if (jsonObject.has(Properties.KEY_MAX_DOSE_PER_LIFETIME)) {
                JSONObject jsonMaxDosePerLifetime = jsonObject.getJSONObject(Properties.KEY_MAX_DOSE_PER_LIFETIME);
                Quantity maxDosePerLifetime = createQuantity(jsonMaxDosePerLifetime);
                dosage.setMaxDosePerLifetime(maxDosePerLifetime);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createReference Exception : " + e.toString());
        }
        return dosage;
    }

    @Override
    public DoseAndRate createDoseAndRate(JSONObject jsonObject) {
        DoseAndRate doseAndRate = new DoseAndRate();

        try {

            //initialize KEY_TYPE
            if (jsonObject.has(Properties.KEY_TYPE)) {
                JSONObject jsonType = jsonObject.getJSONObject(Properties.KEY_TYPE);
                CodeableConcept type = createCodeableConcept(jsonType);
                doseAndRate.setType(type);
            }

            //initialize doseRange
            if (jsonObject.has(Properties.KEY_DOSE_RANGE)) {
                String doseRange = jsonObject.getString(Properties.KEY_DOSE_RANGE);
                doseAndRate.setDoseRange(doseRange);
            }

            //initialize KEY_DOSE_QUANTITY
            if (jsonObject.has(Properties.KEY_DOSE_QUANTITY)) {
                JSONObject jsonDoseQuantity = jsonObject.getJSONObject(Properties.KEY_DOSE_QUANTITY);
                Quantity doseQuantity = createQuantity(jsonDoseQuantity);
                doseAndRate.setDoseQuantity(doseQuantity);
            }

            //initialize rateRatio
            if (jsonObject.has(Properties.KEY_RATE_RATIO)) {
                JSONObject jsonRateRatio = jsonObject.getJSONObject(Properties.KEY_RATE_RATIO);
                Ratio rateRatio = createRatio(jsonRateRatio);
                doseAndRate.setRateRatio(rateRatio);
            }

            //initialize rateRange
            if (jsonObject.has(Properties.KEY_RATE_RANGE)) {
                JSONObject jsonRateRange = jsonObject.getJSONObject(Properties.KEY_RATE_RANGE);
                Range rateRange = createRange(jsonRateRange);
                doseAndRate.setRateRange(rateRange);
            }

            if (jsonObject.has(Properties.KEY_RATE_QUANTITY)) {
                JSONObject jsonRateQuantity = jsonObject.getJSONObject(Properties.KEY_RATE_QUANTITY);
                Quantity rateQuantity = createQuantity(jsonRateQuantity);
                doseAndRate.setRateQuantity(rateQuantity);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createReference Exception : " + e.toString());
        }
        return doseAndRate;
    }

    @Override
    public Ratio createRatio(JSONObject jsonObject) {
        Ratio ratio = new Ratio();

        try {

            if (jsonObject.has(Properties.KEY_NUMERATOR)) {
                JSONObject jsonNumerator = jsonObject.getJSONObject(Properties.KEY_NUMERATOR);
                Quantity numerator = createQuantity(jsonNumerator);
                ratio.setNumerator(numerator);
            }

            if (jsonObject.has(Properties.KEY_DENOMINATOR)) {
                JSONObject jsonDenominator = jsonObject.getJSONObject(Properties.KEY_DENOMINATOR);
                Quantity denominator = createQuantity(jsonDenominator);
                ratio.setDenominator(denominator);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createReference Exception : " + e.toString());
        }
        return ratio;
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

    private SimpleQuantity createSimpleQuantity(JSONObject jsonObject) {
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
    public RequestSubstitution createSubstitution(JSONObject jsonObject) {
        RequestSubstitution substitution = new RequestSubstitution();

        try {

            //allowedBoolean
            if(jsonObject.has(Properties.KEY_ALLOWED_BOOLEAN)){
                String allowedBoolean = jsonObject.getString(Properties.KEY_ALLOWED_BOOLEAN);
                substitution.setAllowedBoolean(allowedBoolean);
            }
            if(jsonObject.has(Properties.KEY_ALLOWED_CODEABLE_CONCEPT)){
                JSONObject jsonAllowedCodeableConcept = jsonObject.getJSONObject(Properties.KEY_ALLOWED_CODEABLE_CONCEPT);
                CodeableConcept codeableConcept = createCodeableConcept(jsonAllowedCodeableConcept);
                substitution.setAllowedCodeableConcept(codeableConcept);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("TEST", "createSubstitution Exception : " + e.toString());
        }
        return substitution;
    }

    @Override
    public Repeat createRepeat(JSONObject jsonObject) {
        Repeat repeat = new Repeat();
        try {

            if (jsonObject.has(Properties.KEY_BOUND_DURATION)) {
                String boundsDuration = jsonObject.getString(Properties.KEY_BOUND_DURATION);
                repeat.setBoundsDuration(boundsDuration);
            }

            if (jsonObject.has(Properties.KEY_BOUND_RANGE)) {
                JSONObject jsonBoundRange = jsonObject.getJSONObject(Properties.KEY_BOUND_RANGE);
                Range boundsRange = createRange(jsonBoundRange);
                repeat.setBoundsRange(boundsRange);
            }

            if (jsonObject.has(Properties.KEY_BOUND_PERIOD)) {
                JSONObject jsonBoundPeriod = jsonObject.getJSONObject(Properties.KEY_BOUND_PERIOD);
                Period boundsPeriod = createPeriod(jsonBoundPeriod);
                repeat.setBoundsPeriod(boundsPeriod);
            }

            if (jsonObject.has(Properties.KEY_COUNT)) {
                String count = jsonObject.getString(Properties.KEY_COUNT);
                repeat.setCount(count);
            }

            if (jsonObject.has(Properties.KEY_COUNT_MAX)) {
                String countMax = jsonObject.getString(Properties.KEY_COUNT_MAX);
                repeat.setCountMax(countMax);
            }

            if (jsonObject.has(Properties.KEY_DURATION)) {
                String duration = jsonObject.getString(Properties.KEY_DURATION);
                repeat.setDuration(duration);
            }

            if (jsonObject.has(Properties.KEY_DURATION_MAX)) {
                String durationMax = jsonObject.getString(Properties.KEY_DURATION_MAX);
                repeat.setDurationMax(durationMax);
            }

            if (jsonObject.has(Properties.KEY_DURATION_UNIT)) {
                String durationUnit = jsonObject.getString(Properties.KEY_DURATION_UNIT);
                repeat.setDurationUnit(durationUnit);
            }

            if (jsonObject.has(Properties.KEY_FREQUENCY)) {
                String frequency = jsonObject.getString(Properties.KEY_FREQUENCY);
                repeat.setFrequency(frequency);
            }

            if (jsonObject.has(Properties.KEY_FREQUENCY_MAX)) {
                String frequencyMax = jsonObject.getString(Properties.KEY_FREQUENCY_MAX);
                repeat.setFrequencyMax(frequencyMax);
            }

            if (jsonObject.has(Properties.KEY_PERIOD)) {
                String period = jsonObject.getString(Properties.KEY_PERIOD);
                repeat.setPeriod(period);
            }

            if (jsonObject.has(Properties.KEY_PERIOD_MAX)) {
                String periodMax = jsonObject.getString(Properties.KEY_PERIOD_MAX);
                repeat.setPeriodMax(periodMax);
            }

            if (jsonObject.has(Properties.KEY_PERIOD_UNIT)) {
                String periodUnit = jsonObject.getString(Properties.KEY_PERIOD_UNIT);
                repeat.setPeriodUnit(periodUnit);
            }

            if (jsonObject.has(Properties.KEY_DAY_OF_WEEK)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_DAY_OF_WEEK);
                List<String> dayOfWeek = createStringList(jsonArray);
                repeat.setDayOfWeek(dayOfWeek);
            }

            if (jsonObject.has(Properties.KEY_TIME_OF_DAY)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_TIME_OF_DAY);
                List<String> timeOfDay = createStringList(jsonArray);
                repeat.setTimeOfDay(timeOfDay);
            }

            if (jsonObject.has(Properties.KEY_WHEN)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_WHEN);
                List<String> when = createStringList(jsonArray);
                repeat.setWhen(when);
            }

            if (jsonObject.has(Properties.KEY_OFF_SET)) {
                String offset = jsonObject.getString(Properties.KEY_OFF_SET);
                repeat.setOffset(offset);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createSubstitution Exception : " + e.toString());
        }
        return repeat;
    }

    @Override
    public Timing createTiming(JSONObject jsonObject) {
        Timing timing = new Timing();
        try {

            //  initialize event
            if (jsonObject.has(Properties.KEY_EVENT)) {
                JSONArray jsonEvent = jsonObject.getJSONArray(Properties.KEY_EVENT);
                List<String> eventList = createStringList(jsonEvent);
                timing.setEvent(eventList);
            }

            // initialize repeat
            if (jsonObject.has(Properties.KEY_REPEAT)) {
                JSONObject jsonRepeat = jsonObject.getJSONObject(Properties.KEY_REPEAT);
                Repeat repeat = createRepeat(jsonRepeat);
                timing.setRepeat(repeat);
            }

            if (jsonObject.has(Properties.KEY_CODE)) {
                JSONObject jsonCode = jsonObject.getJSONObject(Properties.KEY_CODE);
                CodeableConcept code = createCodeableConcept(jsonCode);
                timing.setCode(code);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createSubstitution Exception : " + e.toString());
        }
        return timing;
    }

    @Override
    public List<String> createStringList(JSONArray jsonArray) {
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
    public List<Performer> createPerformerList(JSONArray jsonArray) {
        List<Performer> performerList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Performer performer = createPerformer(jsonObject);
                performerList.add(performer);
            }
        } catch (Exception e) {
            Log.d("TEST", "createPerformerList Exception : " + e.toString());
        }
        return performerList;
    }

    @Override
    public List<Dosage> createDosageList(JSONArray jsonArray) {
        List<Dosage> dosageList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Dosage dosage = createDosage(jsonObject);
                dosageList.add(dosage);
            }
        } catch (Exception e) {
            Log.d("TEST", "createPerformerList Exception : " + e.toString());
        }
        return dosageList;
    }

    @Override
    public List<DoseAndRate> createDoseAndRateList(JSONArray jsonArray) {
        List<DoseAndRate> doseAndRateList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                DoseAndRate doseAndRate = createDoseAndRate(jsonObject);
                doseAndRateList.add(doseAndRate);
            }
        } catch (Exception e) {
            Log.d("TEST", "createDoseAndRateList Exception : " + e.toString());
        }
        return doseAndRateList;
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
}
