package com.ducen.predictor.r4.rest.service;

import android.util.Log;

import com.ducen.predictor.view.home.defaultdata.Properties;
import com.ducen.predictor.r4.entity.R4MedicationStatement;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Dosage;
import com.ducen.predictor.r4.types.DoseAndRate;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Quantity;
import com.ducen.predictor.r4.types.Range;
import com.ducen.predictor.r4.types.Ratio;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.Repeat;
import com.ducen.predictor.r4.types.SimpleQuantity;
import com.ducen.predictor.r4.types.Timing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class R4MedicationStatementServiceImpl implements R4MedicationStatementService {
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
    public List<R4MedicationStatement> createR4MedicationStatementList(JSONObject jsonObject) {
        List<R4MedicationStatement> medicationStatementList = new ArrayList<>();
        try {
            if(jsonObject.has(Properties.KEY_ENTRY)){

                JSONArray jsonEntry = jsonObject.getJSONArray(Properties.KEY_ENTRY);


                for(int i = 0; i < jsonEntry.length(); i++){

                    JSONObject jsonResource = jsonObject.getJSONArray(Properties.KEY_RESOURCE).getJSONObject(i);

                    R4MedicationStatement r4MedicationStatement = createR4MedicationStatement(jsonResource);

                    medicationStatementList.add(r4MedicationStatement);

                }
            }
        } catch (Exception e) {
            Log.d("TEST", "createR4MedicationStatementList Exception : " + e.toString());
            e.printStackTrace();
        }
        return medicationStatementList;
    }

    @Override
    public R4MedicationStatement createR4MedicationStatement(JSONObject jsonObject) {
        R4MedicationStatement r4MedicationStatement = new R4MedicationStatement();
        try {
            //initialize META
            if (jsonObject.has(Properties.KEY_META)) {
                JSONObject jsonMeta = jsonObject.getJSONObject(Properties.KEY_META);
                Meta meta = createMetaPractitioner(jsonMeta);
                r4MedicationStatement.setMeta(meta);
            }

            //initialize IDENTIFIER
            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> listOfIdentifier = createIdentifierList(jsonArrayIdentifier);
                r4MedicationStatement.setIdentifier(listOfIdentifier);
            }

            //initialize basedOn
            if (jsonObject.has(Properties.KEY_BASED_ON)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_BASED_ON);
                List<Reference> basedOn = createReferenceList(jsonArray);
                r4MedicationStatement.setPartOf(basedOn);
            }

            //initialize partOf
            if (jsonObject.has(Properties.KEY_PART_OF)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_PART_OF);
                List<Reference> partOf = createReferenceList(jsonArray);
                r4MedicationStatement.setPartOf(partOf);
            }

            //initialize status
            if (jsonObject.has(Properties.KEY_STATUS)) {
                String status = jsonObject.getString(Properties.KEY_STATUS);
                r4MedicationStatement.setStatus(status);
            }

            //status reason;
            if(jsonObject.has(Properties.KEY_STATUS_REASON)){
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_STATUS_REASON);
                List<CodeableConcept> statusReason = createCodeableConceptList(jsonArray);
                r4MedicationStatement.setStatusReason(statusReason);
            }

            //initialize category
            if (jsonObject.has(Properties.KEY_CATEGORY)) {
                JSONObject jsonCategory = jsonObject.getJSONObject(Properties.KEY_CATEGORY);
                CodeableConcept category = createCodeableConcept(jsonCategory);
                r4MedicationStatement.setCategory(category);
            }

            //initialize medicationCodeableConcept
            if (jsonObject.has(Properties.KEY_MEDICATION_CODEABLE_CONCEPT)) {
                JSONObject jsonmedicationCodeableConcept = jsonObject.getJSONObject(Properties.KEY_MEDICATION_CODEABLE_CONCEPT);
                CodeableConcept medicationCodeableConcept = createCodeableConcept(jsonmedicationCodeableConcept);
                r4MedicationStatement.setMedicationCodeableConcept(medicationCodeableConcept);
            }

            //initialize medicationReference
            if (jsonObject.has(Properties.KEY_MEDICATION_REFERENCE)) {
                JSONObject jsonMedicationReference = jsonObject.getJSONObject(Properties.KEY_MEDICATION_REFERENCE);
                Reference medicationReference = createReference(jsonMedicationReference);
                r4MedicationStatement.setMedicationReference(medicationReference);
            }

            //initialize subject
            if (jsonObject.has(Properties.KEY_SUBJECT)) {
                JSONObject jsonSubject = jsonObject.getJSONObject(Properties.KEY_SUBJECT);
                Reference subject = createReference(jsonSubject);
                r4MedicationStatement.setSubject(subject);
            }


            //initialize context
            if (jsonObject.has(Properties.KEY_CONTEXT)) {
                JSONObject jsonContext = jsonObject.getJSONObject(Properties.KEY_CONTEXT);
                Reference context = createReference(jsonContext);
                r4MedicationStatement.setContext(context);
            }

            //initialize effectiveDateTime
            if(jsonObject.has(Properties.KEY_EFFECTIVE_DATETIME )){
                String effectiveDateTime = jsonObject.getString(Properties.KEY_EFFECTIVE_DATETIME);
                r4MedicationStatement.setEffectiveDateTime(effectiveDateTime);
            }

            //initialize effectivePeriod
            if(jsonObject.has(Properties.KEY_EFFECTIVE_PERIOD )){
                JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_EFFECTIVE_PERIOD);
                Period period = createPeriod(jsonPeriod);
                r4MedicationStatement.setEffectivePeriod(period);
            }

            //initialize dateAsserted
            if(jsonObject.has(Properties.KEY_DATE_ASSERTED )){
                String dateAsserted = jsonObject.getString(Properties.KEY_DATE_ASSERTED);
                r4MedicationStatement.setEffectiveDateTime(dateAsserted);
            }

            //initialize informationSource
            if (jsonObject.has(Properties.KEY_INFORMATION_SOURCE)) {
                JSONObject jsonInformationSource = jsonObject.getJSONObject(Properties.KEY_INFORMATION_SOURCE);
                Reference context = createReference(jsonInformationSource);
                r4MedicationStatement.setInformationSource(context);
            }

            //initialize derivedFrom
            if(jsonObject.has(Properties.KEY_DERIVED_FROM)){
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_DERIVED_FROM);
                List<Reference> derivedFrom = createReferenceList(jsonArray);
                r4MedicationStatement.setDerivedFrom(derivedFrom);
            }

            //initialize reasonCode
            if(jsonObject.has(Properties.KEY_REASON_CODE)){
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_REASON_CODE);
                List<CodeableConcept> reasonCode = createCodeableConceptList(jsonArray);
                r4MedicationStatement.setStatusReason(reasonCode);
            }

            //initialize reasonReference
            if(jsonObject.has(Properties.KEY_REASON_REFERENCE)){
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_REASON_REFERENCE);
                List<Reference> reasonReference = createReferenceList(jsonArray);
                r4MedicationStatement.setReasonReference(reasonReference);
            }

            //initialize note
            if(jsonObject.has(Properties.KEY_NOTE)){
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_NOTE);
                List<Annotation> note = createAnnotationList(jsonArray);
                r4MedicationStatement.setNote(note);
            }

            //initialize dosage
            if(jsonObject.has(Properties.KEY_DOSAGE)){
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_DOSAGE);
                List<Dosage> dosage = createDosageList(jsonArray);
                r4MedicationStatement.setDosage(dosage);
            }

        } catch (JSONException e) {
            Log.d("TEST", "createR4MedicalStatement Exception : " + e.toString());
        }
        return r4MedicationStatement;
    }

    @Override
    public Meta createMetaPractitioner(JSONObject jsonObject) {
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
    public Timing createTiming(JSONObject jsonObject) {
        Timing timing = new Timing();
        try {

//            initialize event
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
