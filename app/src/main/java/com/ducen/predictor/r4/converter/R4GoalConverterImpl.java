package com.ducen.predictor.r4.converter;

        import android.util.Log;

        import com.ducen.predictor.defaultdata.Properties;
        import com.ducen.predictor.r4.entity.R4Goal;
        import com.ducen.predictor.r4.types.Meta;
        import com.ducen.predictor.r4.types.Annotation;
        import com.ducen.predictor.r4.types.CodeableConcept;
        import com.ducen.predictor.r4.types.Coding;
        import com.ducen.predictor.r4.types.Identifier;
        import com.ducen.predictor.r4.types.Period;
        import com.ducen.predictor.r4.types.Quantity;
        import com.ducen.predictor.r4.types.Range;
        import com.ducen.predictor.r4.types.Ratio;
        import com.ducen.predictor.r4.types.Reference;
        import com.ducen.predictor.r4.types.SimpleQuantity;
        import com.ducen.predictor.r4.types.Target;

        import org.json.JSONArray;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.List;

public class R4GoalConverterImpl implements R4GoalConverter {

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
    public List<R4Goal> createR4GoalList(JSONObject jsonObject) {
        List<R4Goal> r4GoalList = new ArrayList<>();

        try {
            if (jsonObject.has(Properties.KEY_ENTRY)) {
                JSONArray jsonEntry = jsonObject.getJSONArray(Properties.KEY_ENTRY);
                for (int c = 0; c < jsonEntry.length(); c++) {

                    JSONObject jsonResources = jsonObject.getJSONArray(Properties.KEY_ENTRY).getJSONObject(c);

                    if (jsonResources.has(Properties.KEY_RESOURCE)) {
                        JSONObject jsonResource = jsonResources.getJSONObject(Properties.KEY_RESOURCE);
                        R4Goal r4Goal = createR4Goal(jsonResource);
                        r4GoalList.add(r4Goal);
                    }

                }

            }
        } catch (Exception e) {
            Log.d("TEST", "createListOfCondition Exception : " + e.toString());
        }

        return r4GoalList;
    }

    @Override
    public R4Goal createR4Goal(JSONObject jsonObject) {
        R4Goal r4Goal = new R4Goal();

        try {

            //initialize META
            if (jsonObject.has(Properties.KEY_META)) {
                JSONObject jsonMeta = jsonObject.getJSONObject(Properties.KEY_META);
                Meta meta = createR4MetaPractitioner(jsonMeta);
                r4Goal.setMeta(meta);
            }

            //initialize IDENTIFIER
            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> identifierList = createIdentifierList(jsonArrayIdentifier);
                r4Goal.setIdentifier(identifierList);
            }

            //initialize lifecycleStatus
            if (jsonObject.has(Properties.KEY_LIFECYCLE_STATUS)) {
                String lifecycleStatus = jsonObject.getString(Properties.KEY_LIFECYCLE_STATUS);
                r4Goal.setLifecycleStatus(lifecycleStatus);
            }

            //initialize achievementStatus
            if (jsonObject.has(Properties.KEY_ACHIEVEMENT_STATUS)) {
                JSONObject jsonAchivementStatus = jsonObject.getJSONObject(Properties.KEY_ACHIEVEMENT_STATUS);
                CodeableConcept achievementStatus = createCodeableConcept(jsonAchivementStatus);
                r4Goal.setAchievementStatus(achievementStatus);
            }

            //initialize category
            if (jsonObject.has(Properties.KEY_CATEGORY)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_CATEGORY);
                List<CodeableConcept> category = createCodeableConceptList(jsonArray);
                r4Goal.setCategory(category);
            }

            //initialize priority
            if (jsonObject.has(Properties.KEY_PRIORITY)) {
                JSONObject jsonPriority = jsonObject.getJSONObject(Properties.KEY_PRIORITY);
                CodeableConcept priority = createCodeableConcept(jsonPriority);
                r4Goal.setPriority(priority);
            }

            //initialize description
            if (jsonObject.has(Properties.KEY_DESCRIPTION)) {
                JSONObject jsonDescription = jsonObject.getJSONObject(Properties.KEY_DESCRIPTION);
                CodeableConcept description = createCodeableConcept(jsonDescription);
                r4Goal.setDescription(description);
            }

            //initialize subject
            if (jsonObject.has(Properties.KEY_SUBJECT)) {
                JSONObject jsonSubject = jsonObject.getJSONObject(Properties.KEY_SUBJECT);
                Reference subject = createReference(jsonSubject);
                r4Goal.setSubject(subject);
            }

            //initialize startDate
            if (jsonObject.has(Properties.KEY_START_DATE)) {
                String startDate = jsonObject.getString(Properties.KEY_START_DATE);
                r4Goal.setStartDate(startDate);
            }

            //initialize startCodeableConcept
            if (jsonObject.has(Properties.KEY_START_CODEABLE_CONCEPT)) {
                JSONObject jsonStartCodeableConcept = jsonObject.getJSONObject(Properties.KEY_START_CODEABLE_CONCEPT);
                CodeableConcept startCodeableConcept = createCodeableConcept(jsonStartCodeableConcept);
                r4Goal.setDescription(startCodeableConcept);
            }

            //initialize target
            if (jsonObject.has(Properties.KEY_TARGET)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_TARGET);
                List<Target> target = createTargetList(jsonArray);
                r4Goal.setTarget(target);
            }

            //initialize statusDate
            if (jsonObject.has(Properties.KEY_STATUS_DATE)) {
                String statusDate = jsonObject.getString(Properties.KEY_STATUS_DATE);
                r4Goal.setStatusDate(statusDate);
            }

            //initialize statusReason
            if (jsonObject.has(Properties.KEY_STATUS_REASON)) {
                String statusReason = jsonObject.getString(Properties.KEY_STATUS_REASON);
                r4Goal.setStatusReason(statusReason);
            }

            //initialize expressedBy
            if (jsonObject.has(Properties.KEY_EXPRESSED_BY)) {
                JSONObject jsonExpressedBy = jsonObject.getJSONObject(Properties.KEY_EXPRESSED_BY);
                Reference expressedBy = createReference(jsonExpressedBy);
                r4Goal.setExpressedBy(expressedBy);
            }

            //initialize addresses
            if (jsonObject.has(Properties.KEY_ADDRESSES)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_ADDRESSES);
                List<Reference> addresses = createReferenceList(jsonArray);
                r4Goal.setAddresses(addresses);
            }

            //initialize note
            if (jsonObject.has(Properties.KEY_NOTE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_NOTE);
                List<Annotation> note = createAnnotationList(jsonArray);
                r4Goal.setNote(note);
            }

            //initialize outcomeCode
            if (jsonObject.has(Properties.KEY_OUTCOME_CODE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_OUTCOME_CODE);
                List<CodeableConcept> outcomeCode = createCodeableConceptList(jsonArray);
                r4Goal.setOutcomeCode(outcomeCode);
            }

            //initialize outcomeReference
            if (jsonObject.has(Properties.KEY_OUTCOME_REFERENCE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_OUTCOME_REFERENCE);
                List<Reference> outcomeReference = createReferenceList(jsonArray);
                r4Goal.setOutcomeReference(outcomeReference);
            }

        } catch (Exception e) {
            Log.d("TEST", "createR4Condition Exception : " + e.toString());
        }

        return r4Goal;
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

}
