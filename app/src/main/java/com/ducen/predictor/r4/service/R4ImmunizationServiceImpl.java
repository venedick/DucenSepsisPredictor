package com.ducen.predictor.r4.service;

import android.util.Log;

import com.ducen.predictor.view.home.defaultdata.Properties;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.entity.R4Immunization;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Education;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Performer;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.ProtocolApplied;
import com.ducen.predictor.r4.types.Quantity;
import com.ducen.predictor.r4.types.Range;
import com.ducen.predictor.r4.types.Ratio;
import com.ducen.predictor.r4.types.Reaction;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.SimpleQuantity;
import com.ducen.predictor.r4.types.Target;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class R4ImmunizationServiceImpl implements R4ImmunizationService {

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
    public List<R4Immunization> createR4ImmunizationList(JSONObject jsonObject) {
        List<R4Immunization> r4ImmunizationList = new ArrayList<>();

        try {
            if (jsonObject.has(Properties.KEY_ENTRY)) {
                JSONArray jsonEntry = jsonObject.getJSONArray(Properties.KEY_ENTRY);
                for (int c = 0; c < jsonEntry.length(); c++) {

                    JSONObject jsonResources = jsonObject.getJSONArray(Properties.KEY_ENTRY).getJSONObject(c);

                    if (jsonResources.has(Properties.KEY_RESOURCE)) {
                        JSONObject jsonResource = jsonResources.getJSONObject(Properties.KEY_RESOURCE);
                        R4Immunization r4Immunization = createR4Immunization(jsonResource);
                        r4ImmunizationList.add(r4Immunization);
                    }

                }

            }
        } catch (Exception e) {
            Log.d("TEST", "createListOfCondition Exception : " + e.toString());
        }

        return r4ImmunizationList;
    }

    @Override
    public R4Immunization createR4Immunization(JSONObject jsonObject) {
        R4Immunization r4Immunization = new R4Immunization();

        try {

            //initialize META
            if (jsonObject.has(Properties.KEY_META)) {
                JSONObject jsonMeta = jsonObject.getJSONObject(Properties.KEY_META);
                Meta meta = createR4MetaPractitioner(jsonMeta);
                r4Immunization.setMeta(meta);
            }

            //initialize IDENTIFIER
            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> identifierList = createIdentifierList(jsonArrayIdentifier);
                r4Immunization.setIdentifier(identifierList);
            }

            //initialize code
            if (jsonObject.has(Properties.KEY_CODE)) {
                String code = jsonObject.getString(Properties.KEY_CODE);
                r4Immunization.setCode(code);
            }

            //initialize statusReason
            if (jsonObject.has(Properties.KEY_STATUS_REASON)) {
                JSONObject jsonStatusReason = jsonObject.getJSONObject(Properties.KEY_STATUS_REASON);
                CodeableConcept statusReason = createCodeableConcept(jsonStatusReason);
                r4Immunization.setStatusReason(statusReason);
            }

            //initialize vaccineCode
            if (jsonObject.has(Properties.KEY_VACCINE_CODE)) {
                JSONObject jsonVaccineCode = jsonObject.getJSONObject(Properties.KEY_VACCINE_CODE);
                CodeableConcept vaccineCode = createCodeableConcept(jsonVaccineCode);
                r4Immunization.setVaccineCode(vaccineCode);
            }

            //initialize patient
            if (jsonObject.has(Properties.KEY_PATIENT)) {
                JSONObject jsonPatient = jsonObject.getJSONObject(Properties.KEY_PATIENT);
                Reference patient = createReference(jsonPatient);
                r4Immunization.setPatient(patient);
            }

            //initialize encounter
            if (jsonObject.has(Properties.KEY_ENCOUNTER)) {
                JSONObject jsonEncounter = jsonObject.getJSONObject(Properties.KEY_ENCOUNTER);
                Reference encounter = createReference(jsonEncounter);
                r4Immunization.setEncounter(encounter);
            }

            //initialize occurenceDateTime
            if (jsonObject.has(Properties.KEY_OCCURENCE_DATETIME)) {
                String occurenceDateTime = jsonObject.getString(Properties.KEY_OCCURENCE_DATETIME);
                r4Immunization.setOccurenceDateTime(occurenceDateTime);
            }

            //initialize occurenceString
            if (jsonObject.has(Properties.KEY_OCCURENCE_STRING)) {
                String occurenceString = jsonObject.getString(Properties.KEY_OCCURENCE_STRING);
                r4Immunization.setOccurenceString(occurenceString);
            }

            //initialize recorded
            if (jsonObject.has(Properties.KEY_CODE)) {
                String recorded = jsonObject.getString(Properties.KEY_CODE);
                r4Immunization.setRecorded(recorded);
            }

            //initialize primarySource
            if (jsonObject.has(Properties.KEY_PRIMARY_SOURCE)) {
                String primarySource = jsonObject.getString(Properties.KEY_PRIMARY_SOURCE);
                r4Immunization.setPrimarySource(primarySource);
            }

            //initialize reportOrigin
            if (jsonObject.has(Properties.KEY_REPORT_ORIGIN)) {
                JSONObject jsonReportOrigin = jsonObject.getJSONObject(Properties.KEY_REPORT_ORIGIN);
                CodeableConcept reportOrigin = createCodeableConcept(jsonReportOrigin);
                r4Immunization.setReportOrigin(reportOrigin);
            }

            //initialize location
            if (jsonObject.has(Properties.KEY_LOCATION)) {
                JSONObject jsonLocation = jsonObject.getJSONObject(Properties.KEY_LOCATION);
                Reference location = createReference(jsonLocation);
                r4Immunization.setLocation(location);
            }

            //initialize manufacturer
            if (jsonObject.has(Properties.KEY_MANUFACTURER)) {
                JSONObject jsonManufacturer = jsonObject.getJSONObject(Properties.KEY_MANUFACTURER);
                Reference manufacturer = createReference(jsonManufacturer);
                r4Immunization.setManufacturer(manufacturer);
            }

            //initialize lotNumber
            if (jsonObject.has(Properties.KEY_LOT_NUMBER)) {
                String lotNumber = jsonObject.getString(Properties.KEY_LOT_NUMBER);
                r4Immunization.setLotNumber(lotNumber);
            }

            //initialize expirationDate
            if (jsonObject.has(Properties.KEY_EXPIRATION_DATE)) {
                String expirationDate = jsonObject.getString(Properties.KEY_EXPIRATION_DATE);
                r4Immunization.setExpirationDate(expirationDate);
            }

            //initialize site
            if (jsonObject.has(Properties.KEY_SITE)) {
                JSONObject jsonSite = jsonObject.getJSONObject(Properties.KEY_SITE);
                CodeableConcept site = createCodeableConcept(jsonSite);
                r4Immunization.setSite(site);
            }

            //initialize route
            if (jsonObject.has(Properties.KEY_ROUTE)) {
                JSONObject jsonRoute = jsonObject.getJSONObject(Properties.KEY_ROUTE);
                CodeableConcept route = createCodeableConcept(jsonRoute);
                r4Immunization.setRoute(route);
            }

            //initialize doseQuantity
            if (jsonObject.has(Properties.KEY_DOSE_QUANTITY)) {
                String doseQuantity = jsonObject.getString(Properties.KEY_DOSE_QUANTITY);
                r4Immunization.setDoseQuantity(doseQuantity);
            }

            //initialize performer
            if (jsonObject.has(Properties.KEY_PERFORMER)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_PERFORMER);
                List<Performer> performer = createPerformerList(jsonArray);
                r4Immunization.setPerformer(performer);
            }

            //initialize note
            if (jsonObject.has(Properties.KEY_NOTE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_NOTE);
                List<Annotation> note = createAnnotationList(jsonArray);
                r4Immunization.setNote(note);
            }

            //initialize note
            if (jsonObject.has(Properties.KEY_NOTE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_NOTE);
                List<Annotation> note = createAnnotationList(jsonArray);
                r4Immunization.setNote(note);
            }

            //initialize reasonCode
            if (jsonObject.has(Properties.KEY_REASON_CODE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_REASON_CODE);
                List<CodeableConcept> reasonCode = createCodeableConceptList(jsonArray);
                r4Immunization.setReasonCode(reasonCode);
            }

            //initialize reasonReference
            if (jsonObject.has(Properties.KEY_REASON_REFERENCE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_REASON_REFERENCE);
                List<Reference> reasonReference = createReferenceList(jsonArray);
                r4Immunization.setReasonReference(reasonReference);
            }

            //initialize isSubpotent
            if (jsonObject.has(Properties.KEY_IS_SUBPOTENT)) {
                String isSubpotent = jsonObject.getString(Properties.KEY_IS_SUBPOTENT);
                r4Immunization.setIsSubpotent(isSubpotent);
            }

            //initialize subpotentReason
            if (jsonObject.has(Properties.KEY_SUBPOTENT_REASON)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_SUBPOTENT_REASON);
                List<CodeableConcept> subpotentReason = createCodeableConceptList(jsonArray);
                r4Immunization.setSubpotentReason(subpotentReason);
            }

            //initialize education
            if (jsonObject.has(Properties.KEY_EDUCATION)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_EDUCATION);
                List<Education> education = createEducationList(jsonArray);
                r4Immunization.setEducation(education);
            }

            //initialize programEligibility
            if (jsonObject.has(Properties.KEY_PROGRAM_ELIGIBILITY)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_PROGRAM_ELIGIBILITY);
                List<CodeableConcept> programEligibility = createCodeableConceptList(jsonArray);
                r4Immunization.setProgramEligibility(programEligibility);
            }

            //initialize fundingSource
            if (jsonObject.has(Properties.KEY_FUNDING_SOURCE)) {
                JSONObject jsonFundingSource = jsonObject.getJSONObject(Properties.KEY_FUNDING_SOURCE);
                CodeableConcept fundingSource = createCodeableConcept(jsonFundingSource);
                r4Immunization.setFundingSource(fundingSource);
            }

            //initialize reaction
            if (jsonObject.has(Properties.KEY_REACTION)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_REACTION);
                List<Reaction> reaction = createReactionList(jsonArray);
                r4Immunization.setReaction(reaction);
            }

            //initialize protocolApplied
            if (jsonObject.has(Properties.KEY_PROTOCOL_APPLIED)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_PROTOCOL_APPLIED);
                List<ProtocolApplied> protocolApplied = createProtocolAppliedList(jsonArray);
                r4Immunization.setProtocolApplied(protocolApplied);
            }

        } catch (Exception e) {
            Log.d("TEST", "createR4Condition Exception : " + e.toString());
        }

        return r4Immunization;
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
    public Target createTarget(JSONObject jsonObject) {
        Target target = new Target();
        try {

            if (jsonObject.has(Properties.KEY_MEASURE)) {
                JSONObject jsonMeasure = jsonObject.getJSONObject(Properties.KEY_MEASURE);
                CodeableConcept measure = createCodeableConcept(jsonMeasure);
                target.setMeasure(measure);
            }

            if (jsonObject.has(Properties.KEY_DETAIL_QUANTITY)) {
                JSONObject jsonDetailQuantity = jsonObject.getJSONObject(Properties.KEY_DETAIL_QUANTITY);
                Quantity detailQuantity = createQuantity(jsonDetailQuantity);
                target.setDetailQuantity(detailQuantity);
            }

            if (jsonObject.has(Properties.KEY_DETAIL_RANGE)) {
                JSONObject jsonRange = jsonObject.getJSONObject(Properties.KEY_DETAIL_RANGE);
                Range detailRange = createRange(jsonRange);
                target.setDetailRange(detailRange);
            }

            if (jsonObject.has(Properties.KEY_DETAIL_CODEABLE_CONCEPT)) {
                JSONObject jsonDetailCodeableConcept = jsonObject.getJSONObject(Properties.KEY_DETAIL_CODEABLE_CONCEPT);
                CodeableConcept detailCodeableConcept = createCodeableConcept(jsonDetailCodeableConcept);
                target.setDetailCodeableConcept(detailCodeableConcept);
            }

            if (jsonObject.has(Properties.KEY_DETAIL_CODEABLE_CONCEPT)) {
                JSONObject jsonDetailCodeableConcept = jsonObject.getJSONObject(Properties.KEY_DETAIL_CODEABLE_CONCEPT);
                CodeableConcept detailCodeableConcept = createCodeableConcept(jsonDetailCodeableConcept);
                target.setDetailCodeableConcept(detailCodeableConcept);
            }

            if (jsonObject.has(Properties.KEY_DETAIL_STRING)) {
                String detailString = jsonObject.getString(Properties.KEY_DETAIL_STRING);
                target.setDetailString(detailString);
            }

            if (jsonObject.has(Properties.KEY_DETAIL_BOOLEAN)) {
                String detailBoolean = jsonObject.getString(Properties.KEY_DETAIL_BOOLEAN);
                target.setDetailBoolean(detailBoolean);
            }

            if (jsonObject.has(Properties.KEY_DETAIL_INTEGER)) {
                String detailInteger = jsonObject.getString(Properties.KEY_DETAIL_INTEGER);
                target.setDetailInteger(detailInteger);
            }

            if (jsonObject.has(Properties.KEY_DETAIL_RATIO)) {
                JSONObject jsonDetailRatio = jsonObject.getJSONObject(Properties.KEY_DETAIL_RATIO);
                Ratio detailRatio = createRatio(jsonDetailRatio);
                target.setDetailRatio(detailRatio);
            }

            if (jsonObject.has(Properties.KEY_DUE_DATE)) {
                String dueDate = jsonObject.getString(Properties.KEY_DUE_DATE);
                target.setDueDate(dueDate);
            }

            if (jsonObject.has(Properties.KEY_DUE_DURATION)) {
                String dueDuration = jsonObject.getString(Properties.KEY_DUE_DURATION);
                target.setDueDuration(dueDuration);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createReference Exception : " + e.toString());
        }
        return target;
    }

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

    public Education createEducation(JSONObject jsonObject) {
        Education education = new Education();
        try {

            if (jsonObject.has(Properties.KEY_DOCUMENT_TYPE)) {
                String documentType = jsonObject.getString(Properties.KEY_DOCUMENT_TYPE);
                education.setDocumentType(documentType);
            }

            if (jsonObject.has(Properties.KEY_REFERENCE)) {
                String reference = jsonObject.getString(Properties.KEY_REFERENCE);
                education.setReference(reference);
            }

            if (jsonObject.has(Properties.KEY_PUBLICATION_DATE)) {
                String publicationDate = jsonObject.getString(Properties.KEY_PUBLICATION_DATE);
                education.setPublicationDate(publicationDate);
            }

            if (jsonObject.has(Properties.KEY_PRESENTATION_DATE)) {
                String presentationDate = jsonObject.getString(Properties.KEY_PRESENTATION_DATE);
                education.setPresentationDate(presentationDate);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createEducation Exception : " + e.toString());
        }
        return education;
    }

    public Reaction createReaction(JSONObject jsonObject) {
        Reaction reaction = new Reaction();
        try {

            if (jsonObject.has(Properties.KEY_DATE)) {
                String date = jsonObject.getString(Properties.KEY_DATE);
                reaction.setDate(date);
            }

            if (jsonObject.has(Properties.KEY_DETAIL)) {
                JSONObject jsonDetail = jsonObject.getJSONObject(Properties.KEY_DETAIL);
                Reference detail = createReference(jsonDetail);
                reaction.setDetail(detail);
            }

            if (jsonObject.has(Properties.KEY_REPORTED)) {
                String reported = jsonObject.getString(Properties.KEY_REPORTED);
                reaction.setReported(reported);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createReaction Exception : " + e.toString());
        }
        return reaction;
    }

    public ProtocolApplied createProtocolApplied(JSONObject jsonObject) {
        ProtocolApplied protocolApplied = new ProtocolApplied();
        try {

            if (jsonObject.has(Properties.KEY_SERIES)) {
                String series = jsonObject.getString(Properties.KEY_SERIES);
                protocolApplied.setSeries(series);
            }

            if (jsonObject.has(Properties.KEY_AUTHORITY)) {
                JSONObject jsonAuthority = jsonObject.getJSONObject(Properties.KEY_AUTHORITY);
                Reference authority = createReference(jsonAuthority);
                protocolApplied.setAuthority(authority);
            }

            if (jsonObject.has(Properties.KEY_TARGET_DISEASE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_TARGET_DISEASE);
                List<CodeableConcept> targetDisease = createCodeableConceptList(jsonArray);
                protocolApplied.setTargetDisease(targetDisease);
            }

            if (jsonObject.has(Properties.KEY_DOSE_NUMBER_POSITIVE_INT)) {
                String doseNumberPositiveInt = jsonObject.getString(Properties.KEY_DOSE_NUMBER_POSITIVE_INT);
                protocolApplied.setDoseNumberPositiveInt(doseNumberPositiveInt);
            }

            if (jsonObject.has(Properties.KEY_DOSE_NUMBER_POSITIVE_STRING)) {
                String doseNumberPositiveString = jsonObject.getString(Properties.KEY_DOSE_NUMBER_POSITIVE_STRING);
                protocolApplied.setDoseNumberPositiveString(doseNumberPositiveString);
            }

            if (jsonObject.has(Properties.KEY_SERIES_DOSES_POSITIVE_INT)) {
                String seriesDosesPositiveInt = jsonObject.getString(Properties.KEY_SERIES_DOSES_POSITIVE_INT);
                protocolApplied.setSeriesDosesPositiveInt(seriesDosesPositiveInt);
            }

            if (jsonObject.has(Properties.KEY_SERIES_DOSES_POSITIVE_STRING)) {
                String seriesDosesPositiveString = jsonObject.getString(Properties.KEY_SERIES_DOSES_POSITIVE_STRING);
                protocolApplied.setSeriesDosesPositiveString(seriesDosesPositiveString);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createReaction Exception : " + e.toString());
        }
        return protocolApplied;
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
    public List<Target> createTargetList(JSONArray jsonArray) {
        List<Target> targetList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Target target = createTarget(jsonObject);
                targetList.add(target);
            }
        } catch (Exception e) {
            Log.d("TEST", "createTargetList Exception : " + e.toString());
        }
        return targetList;
    }

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

    public List<Education> createEducationList(JSONArray jsonArray) {
        List<Education> educationList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Education education = createEducation(jsonObject);
                educationList.add(education);
            }
        } catch (Exception e) {
            Log.d("TEST", "createEducationList Exception : " + e.toString());
        }
        return educationList;
    }

    public List<Reaction> createReactionList(JSONArray jsonArray) {
        List<Reaction> reactionList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Reaction reaction = createReaction(jsonObject);
                reactionList.add(reaction);
            }
        } catch (Exception e) {
            Log.d("TEST", "createReactionList Exception : " + e.toString());
        }
        return reactionList;
    }

    public List<ProtocolApplied> createProtocolAppliedList(JSONArray jsonArray) {
        List<ProtocolApplied> protocolAppliedList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                ProtocolApplied protocolApplied = createProtocolApplied(jsonObject);
                protocolAppliedList.add(protocolApplied);
            }
        } catch (Exception e) {
            Log.d("TEST", "createProtocolAppliedList Exception : " + e.toString());
        }
        return protocolAppliedList;
    }

}
