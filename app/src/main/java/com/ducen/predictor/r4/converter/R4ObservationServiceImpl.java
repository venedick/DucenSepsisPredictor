package com.ducen.predictor.r4.converter;

import android.util.Log;

import com.ducen.predictor.defaultdata.Properties;
import com.ducen.predictor.r4.entity.R4Observation;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Component;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Quantity;
import com.ducen.predictor.r4.types.Range;
import com.ducen.predictor.r4.types.Ratio;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.ReferenceRange;
import com.ducen.predictor.r4.types.Repeat;
import com.ducen.predictor.r4.types.SampledData;
import com.ducen.predictor.r4.types.SimpleQuantity;
import com.ducen.predictor.r4.types.Timing;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class R4ObservationServiceImpl implements R4ObservationService {

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
    public List<R4Observation> createR4ObservationList(JSONObject jsonObject) {
        List<R4Observation> r4ObservationList = new ArrayList<>();

        try {
            if (jsonObject.has(Properties.KEY_ENTRY)) {
                JSONArray jsonEntry = jsonObject.getJSONArray(Properties.KEY_ENTRY);
                Log.d("TEST", "createR4ObservationList: " + jsonEntry.toString());
                for (int i = 0; i < jsonEntry.length(); i++) {

                    JSONObject jsonResources = jsonObject.getJSONArray(Properties.KEY_ENTRY).getJSONObject(i);

                    if (jsonResources.has(Properties.KEY_RESOURCE)) {
                        JSONObject jsonResource = jsonResources.getJSONObject(Properties.KEY_RESOURCE);
                        R4Observation r4Observation = createR4Observation(jsonResource);
                        r4ObservationList.add(r4Observation);
                    }
                }
            }

        } catch (Exception e) {
            Log.d("TEST", "createR4ObservationList Exception: " + e.getMessage());
        }
        return r4ObservationList;
    }

    @Override
    public R4Observation createR4Observation(JSONObject jsonObject) {

        R4Observation r4Observation = new R4Observation();

        try {

            //initialize IDENTIFIER
            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> identifierList = createIdentifierList(jsonArrayIdentifier);
                r4Observation.setIdentifierList(identifierList);
            }

            //basedON
            if (jsonObject.has(Properties.KEY_BASED_ON)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_BASED_ON);
                List<Reference> basedOnResult = createReferenceList(jsonArray);
                r4Observation.setBasedOn(basedOnResult);
            }

            //partOf
            if (jsonObject.has(Properties.KEY_PART_OF)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_PART_OF);
                List<Reference> partOfResult = createReferenceList(jsonArray);
                r4Observation.setPartOf(partOfResult);
            }
            //status
            if (jsonObject.has(Properties.KEY_STATUS)) {
                r4Observation.setStatus(jsonObject.getString(Properties.KEY_STATUS));
            }
            //initialize CATEGORY
            if (jsonObject.has(Properties.KEY_CATEGORY)) {
                JSONArray jsonArrayCategory = jsonObject.getJSONArray(Properties.KEY_CATEGORY);
                List<CodeableConcept> categoryList = createCodeableConceptList(jsonArrayCategory);
                r4Observation.setCategory(categoryList);
            }

            //focus
            if (jsonObject.has(Properties.KEY_FOCUS)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_FOCUS);
                List<Reference> focusResult = createReferenceList(jsonArray);
                r4Observation.setPartOf(focusResult);
            }

            //initialize CODE
            if (jsonObject.has(Properties.KEY_CODE)) {
                JSONObject jsonCode = jsonObject.getJSONObject(Properties.KEY_CODE);
                CodeableConcept code = createCodeableConcept(jsonCode);
                r4Observation.setCode(code);
            }

            //initialize SUBJECT
            if (jsonObject.has(Properties.KEY_SUBJECT)) {
                JSONObject jsonReference = jsonObject.getJSONObject(Properties.KEY_SUBJECT);
                Reference subject = createReference(jsonReference);
                r4Observation.setSubject(subject);
            }

            //initialize ENCOUNTER
            if (jsonObject.has(Properties.KEY_ENCOUNTER)) {
                JSONObject jsonEncounter = jsonObject.getJSONObject(Properties.KEY_ENCOUNTER);
                Reference encounter = createReference(jsonEncounter);
                r4Observation.setEncounter(encounter);
            }

            //initialize effectiveDateTime
            if (jsonObject.has(Properties.KEY_EFFECTIVE_DATETIME)) {
                String effectiveDateTime = jsonObject.getString(Properties.KEY_EFFECTIVE_DATETIME);
                r4Observation.setEffectiveDateTime(effectiveDateTime);
            }

            //initialize effectivePeriod
            if (jsonObject.has(Properties.KEY_EFFECTIVE_PERIOD)) {
                JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_EFFECTIVE_PERIOD);
                Period period = createPeriod(jsonPeriod);
                r4Observation.setEffectivePeriod(period);
            }

            //initialize effectiveTiming
            if (jsonObject.has(Properties.KEY_EFFECTIVE_TIMING)) {
                JSONObject jsonTiming = jsonObject.getJSONObject(Properties.KEY_EFFECTIVE_TIMING);
                Timing effectiveTiming = createTiming(jsonTiming);
                r4Observation.setEffectiveTiming(effectiveTiming);
            }

            //initialize ISSUED
            if (jsonObject.has(Properties.KEY_ISSUED)) {
                String issued = jsonObject.getString(Properties.KEY_ISSUED);
                r4Observation.setIssued(issued);
            }
            //initialize INSTANT
            if (jsonObject.has(Properties.KEY_INSTANT)) {
                String issued = jsonObject.getString(Properties.KEY_ISSUED);
                r4Observation.setIssued(issued);
            }
            //initialize PERFORMER
            if (jsonObject.has(Properties.KEY_PERFORMER)) {
                JSONArray jsonArrayPerformer = jsonObject.getJSONArray(Properties.KEY_PERFORMER);
                List<Reference> performerList = createReferenceList(jsonArrayPerformer);
                r4Observation.setPerformer(performerList);
            }

            /*if (jsonObject.has(Properties.KEY_EFFECTIVE_PERIOD)) {
                JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_ABATEMENT_PERIOD);
                Period period = createPeriod(jsonPeriod);
                r4Observation.setEffectivePeriod(period);
            }*/


            //valueQuantity
            if (jsonObject.has(Properties.KEY_VALUE_QUANTITY)) {
                JSONObject jsonQuantity = jsonObject.getJSONObject(Properties.KEY_VALUE_QUANTITY);
                Quantity quantity = createQuantity(jsonQuantity);
                r4Observation.setValueQuantity(quantity);
            }

            //valueCodeableConcept
            if (jsonObject.has(Properties.KEY_VALUE_CODEABLE_CONCEPT)) {
                JSONObject jsonCodeableConcept = jsonObject.getJSONObject(Properties.KEY_VALUE_CODEABLE_CONCEPT);
                CodeableConcept codeableConcept = createCodeableConcept(jsonCodeableConcept);
                r4Observation.setValueCodeableConcept(codeableConcept);
            }
            //valueString
            if (jsonObject.has(Properties.KEY_VALUE_STRING)) {
                r4Observation.setValueString(jsonObject.getString(Properties.KEY_VALUE_STRING));
            }
            //valueBoolean
            if (jsonObject.has(Properties.KEY_VALUE_BOOLEAN)) {
                r4Observation.setValueBoolean(jsonObject.getString(Properties.KEY_VALUE_BOOLEAN));
            }
            //valueInteger
            if (jsonObject.has(Properties.KEY_VALUE_INTEGER)) {
                r4Observation.setValueInteger(jsonObject.getString(Properties.KEY_VALUE_INTEGER));
            }

            //valueRange
            if (jsonObject.has(Properties.KEY_VALUE_RANGE)) {
                JSONObject jsonRange = jsonObject.getJSONObject(Properties.KEY_VALUE_RANGE);
                Range range = createRange(jsonRange);
                r4Observation.setValueRange(range);
            }
            //valueRatio
            if (jsonObject.has(Properties.KEY_VALUE_RATIO)) {
                JSONObject jsonRatio = jsonObject.getJSONObject(Properties.KEY_VALUE_RATIO);
                Ratio ratio = createRatio(jsonRatio);
                r4Observation.setValueRatio(ratio);
            }
            //valueTime
            if (jsonObject.has(Properties.KEY_VALUE_TIME)) {
                r4Observation.setValueTime(jsonObject.getString(Properties.KEY_VALUE_TIME));
            }
            //sampledData
            if (jsonObject.has(Properties.KEY_VALUE_SAMPLED_DATA)) {
                JSONObject jsonSampledData = jsonObject.getJSONObject(Properties.KEY_VALUE_SAMPLED_DATA);
                SampledData sampledData = createSampledData(jsonSampledData);
                r4Observation.setValueSampledData(sampledData);
            }
            //valueDateTime
            if (jsonObject.has(Properties.KEY_VALUE_DATE_TIME)) {
                r4Observation.setValueDateTime(jsonObject.getString(Properties.KEY_VALUE_DATE_TIME));
            }
            //period
            if (jsonObject.has(Properties.KEY_VALUE_PERIOD)) {
                JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_VALUE_PERIOD);
                Period period = createPeriod(jsonPeriod);
                r4Observation.setValuePeriod(period);
            }

            //dataAbsentReason
            if (jsonObject.has(Properties.KEY_DATA_ABSENT_REASON)) {
                JSONObject jsonAbsentReason = jsonObject.getJSONObject(Properties.KEY_DATA_ABSENT_REASON);
                CodeableConcept codeableConcept = createCodeableConcept(jsonAbsentReason);
                r4Observation.setDataAbsentReason(codeableConcept);
            }
            //interpretation
            if (jsonObject.has(Properties.KEY_INTERPRETAION)) {
                JSONArray jsonArrayInterpretation = jsonObject.getJSONArray(Properties.KEY_INTERPRETAION);
                List<CodeableConcept> codeableConceptList = createCodeableConceptList(jsonArrayInterpretation);
                r4Observation.setInterpretation(codeableConceptList);
            }
            //interpretation
            if (jsonObject.has(Properties.KEY_NOTE)) {
                JSONArray jsonArrayNote = jsonObject.getJSONArray(Properties.KEY_NOTE);
                List<Annotation> annotationList = createAnnotationList(jsonArrayNote);
                r4Observation.setNote(annotationList);
            }
            //bodySite
            if (jsonObject.has(Properties.KEY_BODY_SITE)) {
                JSONObject jsonBodySite = jsonObject.getJSONObject(Properties.KEY_BODY_SITE);
                CodeableConcept codeableConcept = createCodeableConcept(jsonBodySite);
                r4Observation.setBodySite(codeableConcept);
            }
            //method
            if (jsonObject.has(Properties.KEY_METHOD)) {
                JSONObject jsonMethod = jsonObject.getJSONObject(Properties.KEY_METHOD);
                CodeableConcept codeableConcept = createCodeableConcept(jsonMethod);
                r4Observation.setMethod(codeableConcept);
            }
            //initialize specimen
            if (jsonObject.has(Properties.KEY_SPECIMEN)) {
                JSONArray jsonArraySpecimen = jsonObject.getJSONArray(Properties.KEY_SPECIMEN);
                List<Reference> specimenList = createReferenceList(jsonArraySpecimen);
                r4Observation.setSpecimen(specimenList);
            }
            //referenceRange
            if (jsonObject.has(Properties.KEY_REFERENCE_RANGE)) {
                JSONArray jsonArrayRefRange = jsonObject.getJSONArray(Properties.KEY_REFERENCE_RANGE);
                List<ReferenceRange> referenceRangeList = createReferenceRangeList(jsonArrayRefRange);
                r4Observation.setReferenceRange(referenceRangeList);
            }
            //initialize hasMember
            if (jsonObject.has(Properties.KEY_HAS_MEMBER)) {
                JSONArray jsonArrayHasMember = jsonObject.getJSONArray(Properties.KEY_HAS_MEMBER);
                List<Reference> jsonHasMemberList = createReferenceList(jsonArrayHasMember);
                r4Observation.setHasMember(jsonHasMemberList);
            }
            //derivedFrom
            if (jsonObject.has(Properties.KEY_DERIVED_FROM)) {
                JSONArray jsonArrayDerivedFrom = jsonObject.getJSONArray(Properties.KEY_DERIVED_FROM);
                List<Reference> jsonDerivedFromList = createReferenceList(jsonArrayDerivedFrom);
                r4Observation.setDerivedFrom(jsonDerivedFromList);
            }

            if (jsonObject.has(Properties.KEY_COMPONENT)) {
                JSONArray jsonArrayComponent = jsonObject.getJSONArray(Properties.KEY_COMPONENT);
                List<Component> componentList = createComponentList(jsonArrayComponent);
                r4Observation.setComponent(componentList);
            }

        } catch (Exception e) {
            Log.d("TEST", "Exception: " + e.getMessage());
        }
        Log.d("TEST", "observation: " + r4Observation.toString());
        return r4Observation;
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
    public Quantity createQuantity(JSONObject jsonObject) {
        Quantity quantity = new Quantity(
                ""
                , ""
                , ""
                , ""
                , "");
        try {
            if (jsonObject.has(Properties.KEY_VALUE)) {
                quantity.setValue(jsonObject.getString(Properties.KEY_VALUE));
            }

            if (jsonObject.has(Properties.KEY_COMPARATOR)) {
                quantity.setComparator(jsonObject.getString(Properties.KEY_COMPARATOR));
            }
            if (jsonObject.has(Properties.KEY_UNIT)) {
                quantity.setUnit(jsonObject.getString(Properties.KEY_UNIT));
            }
            if (jsonObject.has(Properties.KEY_SYSTEM)) {
                quantity.setSystem(jsonObject.getString(Properties.KEY_SYSTEM));
            }
            if (jsonObject.has(Properties.KEY_CODE)) {
                String code = jsonObject.getString(Properties.KEY_CODE);
                quantity.setCode(code);
            }

        } catch (Exception e) {
            Log.d("TEST", "createQuantity Exception: " + e.getMessage());
        }
        return quantity;
    }

    @Override
    public Range createRange(JSONObject jsonObject) {
        Range range = new Range(null, null);
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

        } catch (Exception e) {
            Log.d("TEST", "createSimpleQuantity Exception: " + e.getMessage());
        }
        return range;
    }

    @Override
    public Ratio createRatio(JSONObject jsonObject) {
        Ratio ratio = new Ratio(null, null);
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
        } catch (Exception e) {
            Log.d("TEST", "createRatio Exception: " + e.getMessage());
        }
        return ratio;
    }

    @Override
    public SampledData createSampledData(JSONObject jsonObject) {
        SampledData sampledData = new SampledData(
                null,
                "",
                "",
                "",
                "",
                "",
                "");
        try {
            if (jsonObject.has(Properties.KEY_ORIGIN)) {
                JSONObject jsonOrigin = jsonObject.getJSONObject(Properties.KEY_ORIGIN);
                Quantity origin = createQuantity(jsonOrigin);
                sampledData.setOrigin(origin);
            }
            if (jsonObject.has(Properties.KEY_PERIOD)) {
                sampledData.setPeriod(jsonObject.getString(Properties.KEY_PERIOD));
            }

            if (jsonObject.has(Properties.KEY_FACTOR)) {
                sampledData.setFactor(jsonObject.getString(Properties.KEY_FACTOR));
            }
            if (jsonObject.has(Properties.KEY_LOWER_LIMIT)) {
                sampledData.setLowerLimit(jsonObject.getString(Properties.KEY_LOWER_LIMIT));
            }
            if (jsonObject.has(Properties.KEY_UPPER_LIMIT)) {
                sampledData.setUpperLimit(jsonObject.getString(Properties.KEY_UPPER_LIMIT));
            }

            if (jsonObject.has(Properties.KEY_DIMENSIONS)) {
                sampledData.setDimensions(jsonObject.getString(Properties.KEY_DIMENSIONS));
            }

            if (jsonObject.has(Properties.KEY_DATA)) {
                sampledData.setData(jsonObject.getString(Properties.KEY_DATA));
            }

        } catch (Exception e) {
            Log.d("TEST", "createSampledData Exception: " + e.getMessage());
        }
        return sampledData;
    }

    public Timing createTiming(JSONObject jsonObject) {
        Timing timing = new Timing(null, null, null);
        try {
            if (jsonObject.has(Properties.KEY_EVENT)) {
                JSONArray jsonEvent = jsonObject.getJSONArray(Properties.KEY_EVENT);
                List<String> eventList = createEventList(jsonEvent);
                timing.setEvent(eventList);
            }

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

        } catch (Exception e) {
            Log.d("TEST", "createTiming Exception : " + e.toString());
        }
        return timing;
    }

    @Override
    public List<Annotation> createAnnotationList(JSONArray jsonArray) {
        List<Annotation> annotationList = new ArrayList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Annotation annotation = createAnnotation(jsonObject);
                annotationList.add(annotation);
            }
        } catch (Exception e) {
            Log.d("TEST", "createAnnotationList Exception : " + e.toString());
        }
        return annotationList;
    }

    @Override
    public List<ReferenceRange> createReferenceRangeList(JSONArray jsonArray) {
        List<ReferenceRange> referenceRangeList = new ArrayList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                ReferenceRange referenceRange = createReferenceRange(jsonObject);
                referenceRangeList.add(referenceRange);
            }
        } catch (Exception e) {
            Log.d("TEST", "createReferenceRangeList Exception: " + e.getMessage());
        }
        return referenceRangeList;
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
    public List<String> createEventList(JSONArray jsonArray) {
        List<String> evenList = new ArrayList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                String data = jsonArray.getString(i);
                evenList.add(data);
            }
        } catch (Exception e) {
            Log.d("TEST", "createEventList Exception: " + e.getMessage());
        }
        return evenList;
    }

    @Override
    public Repeat createRepeat(JSONObject jsonObject) {
        Repeat repeat = new Repeat();
        try {

            if (jsonObject.has(Properties.KEY_BOUNDS_DURATION)) {
                repeat.setBoundsDuration(jsonObject.getString(Properties.KEY_BOUNDS_DURATION));
            }

            if (jsonObject.has(Properties.KEY_BOUNDS_RANGE)) {
                JSONObject jsonRange = jsonObject.getJSONObject(Properties.KEY_BOUNDS_RANGE);
                Range range = createRange(jsonRange);
                repeat.setBoundsRange(range);
            }

            if (jsonObject.has(Properties.KEY_BOUNDS_PERIOD)) {
                JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_BOUNDS_PERIOD);
                Period period = createPeriod(jsonPeriod);
                repeat.setBoundsPeriod(period);
            }

            if (jsonObject.has(Properties.KEY_COUNT)) {
                repeat.setCount(jsonObject.getString(Properties.KEY_COUNT));
            }

            if (jsonObject.has(Properties.KEY_COUNT_MAX)) {
                repeat.setCountMax(jsonObject.getString(Properties.KEY_COUNT_MAX));
            }

            if (jsonObject.has(Properties.KEY_DURATION_MAX)) {
                repeat.setDurationMax(jsonObject.getString(Properties.KEY_DURATION_MAX));
            }

            if (jsonObject.has(Properties.KEY_DURATION_UNIT)) {
                repeat.setDurationUnit(jsonObject.getString(Properties.KEY_DURATION_UNIT));
            }

            if (jsonObject.has(Properties.KEY_FREQUENCY)) {
                repeat.setFrequency(jsonObject.getString(Properties.KEY_FREQUENCY));
            }

            if (jsonObject.has(Properties.KEY_FREQUENCY_MAX)) {
                repeat.setFrequencyMax(jsonObject.getString(Properties.KEY_FREQUENCY_MAX));
            }

            if (jsonObject.has(Properties.KEY_PERIOD)) {
                repeat.setPeriod(jsonObject.getString(Properties.KEY_PERIOD));
            }

            if (jsonObject.has(Properties.KEY_PERIOD_MAX)) {
                repeat.setPeriodMax(jsonObject.getString(Properties.KEY_PERIOD_MAX));
            }

            if (jsonObject.has(Properties.KEY_PERIOD_UNIT)) {
                repeat.setPeriodUnit(jsonObject.getString(Properties.KEY_PERIOD_UNIT));
            }

            if (jsonObject.has(Properties.KEY_DAY_OF_WEEK)) {
                JSONArray jsonDOW = jsonObject.getJSONArray(Properties.KEY_DAY_OF_WEEK);
                List<String> DOW = createCodeList(jsonDOW);
                repeat.setDayOfWeek(DOW);
            }

            if (jsonObject.has(Properties.KEY_TIME_OF_DAY)) {
                JSONArray jsonTOD = jsonObject.getJSONArray(Properties.KEY_TIME_OF_DAY);
                List<String> DOW = createCodeList(jsonTOD);
                repeat.setTimeOfDay(DOW);
            }

            if (jsonObject.has(Properties.KEY_WHEN)) {
                JSONArray jsonWhen = jsonObject.getJSONArray(Properties.KEY_WHEN);
                List<String> when = createCodeList(jsonWhen);
                repeat.setWhen(when);
            }

            if (jsonObject.has(Properties.KEY_OFFSET)) {
                repeat.setOffset(jsonObject.getString(Properties.KEY_OFFSET));
            }

        } catch (Exception e) {
            Log.d("TEST", "createRepeat Exception : " + e.toString());
        }
        return repeat;
    }

    @Override
    public List<String> createCodeList(JSONArray jsonArray) {
        List<String> codeList = new ArrayList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                String data = jsonArray.getString(i);
                codeList.add(data);
            }
        } catch (Exception e) {
            Log.d("TEST", "createCodeList Exception: " + e.getMessage());
        }
        return codeList;
    }

    @Override
    public Annotation createAnnotation(JSONObject jsonObject) {
        Annotation annotation = new Annotation(null, "", "");
        try {
            if (jsonObject.has(Properties.KEY_AUTHOR)) {
                JSONObject jsonAuthor = jsonObject.getJSONObject(Properties.KEY_AUTHOR);
                Reference author = createReference(jsonAuthor);
                annotation.setAuthor(author);
            }
            if (jsonObject.has(Properties.KEY_TIME)) {
                annotation.setTime(jsonObject.getString(Properties.KEY_TIME));
            }
            if (jsonObject.has(Properties.KEY_TEXT)) {
                annotation.setText(jsonObject.getString(Properties.KEY_TEXT));
            }

        } catch (Exception e) {
            Log.d("TEST", "createAnnotation Exception: " + e.getMessage());
        }
        return annotation;
    }

    @Override
    public ReferenceRange createReferenceRange(JSONObject jsonObject) {
        ReferenceRange referenceRange = new ReferenceRange(null,
                null,
                null,
                null,
                null,
                "");
        try {
            if (jsonObject.has(Properties.KEY_LOW)) {
                JSONObject jsonLow = jsonObject.getJSONObject(Properties.KEY_LOW);
                Quantity low = createQuantity(jsonLow);
                referenceRange.setLow(low);
            }
            if (jsonObject.has(Properties.KEY_HIGH)) {
                JSONObject jsonHigh = jsonObject.getJSONObject(Properties.KEY_LOW);
                Quantity high = createQuantity(jsonHigh);
                referenceRange.setHigh(high);

            }
            if (jsonObject.has(Properties.KEY_TYPE)) {
                JSONObject jsonType = jsonObject.getJSONObject(Properties.KEY_TYPE);
                CodeableConcept type = createCodeableConcept(jsonType);
                referenceRange.setType(type);
            }
            if (jsonObject.has(Properties.KEY_APPLIES_TO)) {
                JSONArray jsonArrayAppliesTo = jsonObject.getJSONArray(Properties.KEY_TYPE);
                List<CodeableConcept> appliesToList = createCodeableConceptList(jsonArrayAppliesTo);
                referenceRange.setAppliesTo(appliesToList);
            }
            if (jsonObject.has(Properties.KEY_AGE)) {
                JSONObject jsonObjectAge = jsonObject.getJSONObject(Properties.KEY_AGE);
                Range age = createRange(jsonObjectAge);
                referenceRange.setAge(age);
            }
            if (jsonObject.has(Properties.KEY_TEXT)) {
                referenceRange.setText(jsonObject.getString(Properties.KEY_TEXT));
            }

        } catch (Exception e) {
            Log.d("TEST", "createReferenceRange Exception: " + e.getMessage());
        }
        return referenceRange;
    }

    @Override
    public List<Component> createComponentList(JSONArray jsonArray) {
        List<Component> componentLists = new ArrayList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Component component = createComponent(jsonObject);
                componentLists.add(component);
            }

        } catch (Exception e) {
            Log.d("TEST", "createReferenceRange Exception: " + e.getMessage());
        }
        return componentLists;
    }

    @Override
    public Component createComponent(JSONObject jsonObject) {
        Component component = new Component(
                null,
                null,
                null,
                "",
                "",
                "",
                null,
                null,
                "",
                null,
                "",
                null,
                null,
                null,
                null);
        try {
            if (jsonObject.has(Properties.KEY_CODE)) {
                JSONObject jsonCode = jsonObject.getJSONObject(Properties.KEY_CODE);
                CodeableConcept code = createCodeableConcept(jsonCode);
                component.setCode(code);
            }
            if (jsonObject.has(Properties.KEY_VALUE_QUANTITY)) {
                JSONObject jsonQuantity = jsonObject.getJSONObject(Properties.KEY_VALUE_QUANTITY);
                Quantity quantity = createQuantity(jsonQuantity);
                component.setValueQuantity(quantity);
            }

            //valueCodeableConcept
            if (jsonObject.has(Properties.KEY_VALUE_CODEABLE_CONCEPT)) {
                JSONObject jsonCodeableConcept = jsonObject.getJSONObject(Properties.KEY_VALUE_CODEABLE_CONCEPT);
                CodeableConcept codeableConcept = createCodeableConcept(jsonCodeableConcept);
                component.setValueCodeableConcept(codeableConcept);
            }

            //valueString
            if (jsonObject.has(Properties.KEY_VALUE_STRING)) {
                component.setValueString(jsonObject.getString(Properties.KEY_VALUE_STRING));
            }

            //valueBoolean
            if (jsonObject.has(Properties.KEY_VALUE_BOOLEAN)) {
                component.setValueBoolean(jsonObject.getString(Properties.KEY_VALUE_BOOLEAN));
            }

            //valueInteger
            if (jsonObject.has(Properties.KEY_VALUE_INTEGER)) {
                component.setValueInteger(jsonObject.getString(Properties.KEY_VALUE_INTEGER));
            }

            //valueRange
            if (jsonObject.has(Properties.KEY_VALUE_RANGE)) {
                JSONObject jsonRange = jsonObject.getJSONObject(Properties.KEY_VALUE_RANGE);
                Range range = createRange(jsonRange);
                component.setValueRange(range);
            }

            //valueRatio
            if (jsonObject.has(Properties.KEY_VALUE_RATIO)) {
                JSONObject jsonRatio = jsonObject.getJSONObject(Properties.KEY_VALUE_RATIO);
                Ratio ratio = createRatio(jsonRatio);
                component.setValueRatio(ratio);
            }

            //valueTime
            if (jsonObject.has(Properties.KEY_VALUE_TIME)) {
                component.setValueTime(jsonObject.getString(Properties.KEY_VALUE_TIME));
            }

            //sampledData
            if (jsonObject.has(Properties.KEY_VALUE_SAMPLED_DATA)) {
                JSONObject jsonSampledData = jsonObject.getJSONObject(Properties.KEY_VALUE_SAMPLED_DATA);
                SampledData sampledData = createSampledData(jsonSampledData);
                component.setValueSampledData(sampledData);
            }

            //valueDateTime
            if (jsonObject.has(Properties.KEY_VALUE_DATE_TIME)) {
                component.setValueDateTime(jsonObject.getString(Properties.KEY_VALUE_DATE_TIME));
            }

            //period
            if (jsonObject.has(Properties.KEY_VALUE_PERIOD)) {
                JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_VALUE_PERIOD);
                Period period = createPeriod(jsonPeriod);
                component.setValuePeriod(period);
            }

            //dataAbsentReason
            if (jsonObject.has(Properties.KEY_DATA_ABSENT_REASON)) {
                JSONObject jsonAbsentReason = jsonObject.getJSONObject(Properties.KEY_DATA_ABSENT_REASON);
                CodeableConcept codeableConcept = createCodeableConcept(jsonAbsentReason);
                component.setDataAbsentReason(codeableConcept);
            }

            //interpretation
            if (jsonObject.has(Properties.KEY_INTERPRETAION)) {
                JSONArray jsonArrayInterpretation = jsonObject.getJSONArray(Properties.KEY_INTERPRETAION);
                List<CodeableConcept> codeableConceptList = createCodeableConceptList(jsonArrayInterpretation);
                component.setInterpretation(codeableConceptList);
            }

            //referenceRange
            if (jsonObject.has(Properties.KEY_REFERENCE_RANGE)) {
                JSONArray jsonArrayRefRange = jsonObject.getJSONArray(Properties.KEY_REFERENCE_RANGE);
                List<ReferenceRange> referenceRangeList = createReferenceRangeList(jsonArrayRefRange);
                component.setReferenceRange(referenceRangeList);
            }

        } catch (Exception e) {
            Log.d("TEST", "createComponent Exception: " + e.getMessage());
        }
        return component;
    }
}
