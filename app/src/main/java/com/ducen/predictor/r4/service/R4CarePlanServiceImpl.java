package com.ducen.predictor.r4.service;

        import android.util.Log;


        import com.ducen.predictor.defaultdata.Properties;
        import com.ducen.predictor.r4.types.Meta;
        import com.ducen.predictor.r4.types.Stage;
        import com.ducen.predictor.r4.types.Activity;
        import com.ducen.predictor.r4.types.Detail;
        import com.ducen.predictor.r4.entity.R4CarePlan;
        import com.ducen.predictor.r4.entity.R4Evidence;
        import com.ducen.predictor.r4.types.Participant;
        import com.ducen.predictor.r4.types.Annotation;
        import com.ducen.predictor.r4.types.CodeableConcept;
        import com.ducen.predictor.r4.types.Coding;
        import com.ducen.predictor.r4.types.Identifier;
        import com.ducen.predictor.r4.types.Period;
        import com.ducen.predictor.r4.types.Reference;

        import org.json.JSONArray;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.List;

public class R4CarePlanServiceImpl implements R4CarePlanService {

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
    public List<R4CarePlan> createR4CarePlanList(JSONObject jsonObject) {
        List<R4CarePlan> r4CarePlanList = new ArrayList<>();

        try {
            if (jsonObject.has(Properties.KEY_ENTRY)) {
                JSONArray jsonEntry = jsonObject.getJSONArray(Properties.KEY_ENTRY);
                for (int c = 0; c < jsonEntry.length(); c++) {

                    JSONObject jsonResources = jsonObject.getJSONArray(Properties.KEY_ENTRY).getJSONObject(c);

                    if (jsonResources.has(Properties.KEY_RESOURCE)) {
                        JSONObject jsonResource = jsonResources.getJSONObject(Properties.KEY_RESOURCE);
                        R4CarePlan R4CarePlan = createR4CarePlan(jsonResource);
                        r4CarePlanList.add(R4CarePlan);
                    }

                }

            }
        } catch (Exception e) {
            Log.d("TEST", "createR4AppointmentList Exception : " + e.toString());
        }

        return r4CarePlanList;
    }

    @Override
    public R4CarePlan createR4CarePlan(JSONObject jsonObject) {
        R4CarePlan r4CarePlan = new R4CarePlan();

        try {

            //initialize META
            if (jsonObject.has(Properties.KEY_META)) {
                JSONObject jsonMeta = jsonObject.getJSONObject(Properties.KEY_META);
                Meta meta = createMeta(jsonMeta);
                r4CarePlan.setMeta(meta);
            }

            //initialize IDENTIFIER
            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> identifierList = createIdentifierList(jsonArrayIdentifier);
                r4CarePlan.setIdentifier(identifierList);
            }

            //initialize instantiatesCanonical
            if (jsonObject.has(Properties.KEY_INSTANTIATES_CANONICAL)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_INSTANTIATES_CANONICAL);
                List<String> instantiatesCanonicalList = createStringList(jsonArray);
                r4CarePlan.setInstantiatesCanonical(instantiatesCanonicalList);
            }

            //initialize instantiatesURI
            if (jsonObject.has(Properties.KEY_INSTANTIATES_URI)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_INSTANTIATES_URI);
                List<String> instantiatesURIList = createStringList(jsonArray);
                r4CarePlan.setInstantiatesURI(instantiatesURIList);
            }

            //initialize basedOn
            if (jsonObject.has(Properties.KEY_BASED_ON)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_BASED_ON);
                List<Reference> basedOnList = createReferenceList(jsonArray);
                r4CarePlan.setBasedOn(basedOnList);
            }

            //initialize replaces
            if (jsonObject.has(Properties.KEY_REPLACES)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_REPLACES);
                List<Reference> replacesList = createReferenceList(jsonArray);
                r4CarePlan.setReplaces(replacesList);
            }

            //initialize partOf
            if (jsonObject.has(Properties.KEY_PART_OF)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_PART_OF);
                List<Reference> partOfList = createReferenceList(jsonArray);
                r4CarePlan.setPartOf(partOfList);
            }

            //initialize code
            if (jsonObject.has(Properties.KEY_CODE)) {
                String code = jsonObject.getString(Properties.KEY_CODE);
                r4CarePlan.setCode(code);
            }

            //initialize intent
            if (jsonObject.has(Properties.KEY_INTENT)) {
                String intent = jsonObject.getString(Properties.KEY_INTENT);
                r4CarePlan.setIntent(intent);
            }

            //initialize category
            if (jsonObject.has(Properties.KEY_CATEGORY)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_CATEGORY);
                List<CodeableConcept> categoryList = createCodeableConceptList(jsonArray);
                r4CarePlan.setCategory(categoryList);
            }

            //initialize title
            if (jsonObject.has(Properties.KEY_TITLE)) {
                String title = jsonObject.getString(Properties.KEY_TITLE);
                r4CarePlan.setTitle(title);
            }

            //initialize description
            if (jsonObject.has(Properties.KEY_DESCRIPTION)) {
                String description = jsonObject.getString(Properties.KEY_DESCRIPTION);
                r4CarePlan.setDescription(description);
            }

            //initialize subject
            if (jsonObject.has(Properties.KEY_SUBJECT)) {
                JSONObject jsonSubjecet = jsonObject.getJSONObject(Properties.KEY_SUBJECT);
                Reference subject = createReference(jsonSubjecet);
                r4CarePlan.setSubject(subject);
            }

            //initialize encounter
            if (jsonObject.has(Properties.KEY_ENCOUNTER)) {
                JSONObject jsonSubjecet = jsonObject.getJSONObject(Properties.KEY_ENCOUNTER);
                Reference encounter = createReference(jsonSubjecet);
                r4CarePlan.setEncounter(encounter);
            }

            //initialize period
            if (jsonObject.has(Properties.KEY_PERIOD)) {
                JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_PERIOD);
                Period period = createPeriod(jsonPeriod);
                r4CarePlan.setPeriod(period);
            }

            //initialize created
            if (jsonObject.has(Properties.KEY_CREATED)) {
                String created = jsonObject.getString(Properties.KEY_CREATED);
                r4CarePlan.setCreated(created);
            }

            //initialize author
            if (jsonObject.has(Properties.KEY_AUTHOR)) {
                JSONObject jsonAuthor = jsonObject.getJSONObject(Properties.KEY_AUTHOR);
                Reference author = createReference(jsonAuthor);
                r4CarePlan.setAuthor(author);
            }

            //initialize contributor
            if (jsonObject.has(Properties.KEY_CONTRIBUTOR)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_CONTRIBUTOR);
                List<Reference> contributorList = createReferenceList(jsonArray);
                r4CarePlan.setContributor(contributorList);
            }

            //initialize careTeam
            if (jsonObject.has(Properties.KEY_CARE_TEAM)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_CARE_TEAM);
                List<Reference> careTeamList = createReferenceList(jsonArray);
                r4CarePlan.setCareTeam(careTeamList);
            }

            //initialize addresses
            if (jsonObject.has(Properties.KEY_ADDRESSES)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_ADDRESSES);
                List<Reference> addressesList = createReferenceList(jsonArray);
                r4CarePlan.setAddresses(addressesList);
            }

            //initialize supportingInfo
            if (jsonObject.has(Properties.KEY_SUPPORTING_INFO)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_SUPPORTING_INFO);
                List<Reference> supportingInfoList = createReferenceList(jsonArray);
                r4CarePlan.setSupportingInfo(supportingInfoList);
            }

            //initialize goal
            if (jsonObject.has(Properties.KEY_GOAL)) {

                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_GOAL);
                List<String> goalList = createGoalList(jsonArray);
                r4CarePlan.setGoal(goalList);

            }

            //initialize r4Activity
            if (jsonObject.has(Properties.KEY_ACTIVITY)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_ACTIVITY);
                List<Activity> activityList = createR4ActivityList(jsonArray);
                r4CarePlan.setActivity(activityList);
            }

            //initialize note
            if (jsonObject.has(Properties.KEY_NOTE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_NOTE);
                List<Annotation> noteList = createAnnotationList(jsonArray);
                r4CarePlan.setNote(noteList);
            }


        } catch (Exception e) {
            Log.d("TEST", "createR4Appointment Exception : " + e.toString());
        }

        return r4CarePlan;
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
    public Activity createR4Activity(JSONObject jsonObject) {
        Activity activity = new Activity();
        try {

            //initialize outcomeCodeableConcept
            if (jsonObject.has(Properties.KEY_OUTCOME_CODEABLE_CONCEPT)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_OUTCOME_CODEABLE_CONCEPT);
                List<CodeableConcept> outcomeCodeableConceptList = createCodeableConceptList(jsonArray);
                activity.setOutcomeCodeableConcept(outcomeCodeableConceptList);
            }

            //initialize outcomeReference
            if (jsonObject.has(Properties.KEY_OUTCOME_REFERENCE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_OUTCOME_REFERENCE);
                List<Reference> outcomeReferenceList = createReferenceList(jsonArray);
                activity.setOutcomeReference(outcomeReferenceList);
            }

            //initialize progress
            if (jsonObject.has(Properties.KEY_PROGRESS)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_PROGRESS);
                List<Annotation> progressList = createAnnotationList(jsonArray);
                activity.setProgress(progressList);
            }

            //initialize progress
            if (jsonObject.has(Properties.KEY_PROGRESS)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_PROGRESS);
                List<Annotation> progressList = createAnnotationList(jsonArray);
                activity.setProgress(progressList);
            }

            //initialize reference
            if (jsonObject.has(Properties.KEY_REFERENCE)) {
                JSONObject jsonReference = jsonObject.getJSONObject(Properties.KEY_REFERENCE);
                Reference reference = createReference(jsonReference);
                activity.setReference(reference);
            }

            //initialize Detail
            if (jsonObject.has(Properties.KEY_DETAIL)) {
                JSONObject jsonReference = jsonObject.getJSONObject(Properties.KEY_DETAIL);
                Detail detail = createR4Detail(jsonReference);
                activity.setDetail(detail);
            }

        } catch (Exception e) {
            Log.d("TEST", "createMeta Exception : " + e.toString());
        }
        return activity;
    }

    @Override
    public Detail createR4Detail(JSONObject jsonObject) {
        Detail detail = new Detail();
        try {

            //initialize kind
            if (jsonObject.has(Properties.KEY_KIND)) {
                String kind = jsonObject.getString(Properties.KEY_KIND);
                detail.setKind(kind);
            }

            //initialize instantiatesCanonical
            if (jsonObject.has(Properties.KEY_INSTANTIATES_CANONICAL)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_INSTANTIATES_CANONICAL);
                List<String> instantiatesCanonicalList = createStringList(jsonArray);
                detail.setInstantiatesCanonical(instantiatesCanonicalList);
            }

            //initialize instantiatesURI
            if (jsonObject.has(Properties.KEY_INSTANTIATES_URI)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_INSTANTIATES_URI);
                List<String> instantiatesURIList = createStringList(jsonArray);
                detail.setInstantiatesURI(instantiatesURIList);
            }

            //initialize code
            if (jsonObject.has(Properties.KEY_CODE)) {
                JSONObject jsonCode = jsonObject.getJSONObject(Properties.KEY_CODE);
                CodeableConcept code = createCodeableConcept(jsonCode);
                detail.setCode(code);
            }

            //initialize reasonCode
            if (jsonObject.has(Properties.KEY_REASON_CODE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_REASON_CODE);
                List<CodeableConcept> reasonCodeList = createCodeableConceptList(jsonArray);
                detail.setReasonCode(reasonCodeList);
            }

            //initialize reasonCode
            if (jsonObject.has(Properties.KEY_REASON_REFERENCE)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_REASON_REFERENCE);
                List<Reference> reasonReferenceList = createReferenceList(jsonArray);
                detail.setReasonReference(reasonReferenceList);
            }

            //initialize goal
            if (jsonObject.has(Properties.KEY_GOAL)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_GOAL);
                List<String> goalList = createGoalList(jsonArray);
                detail.setGoal(goalList);
            }

            //initialize status
            if (jsonObject.has(Properties.KEY_STATUS)) {
                String status = jsonObject.getString(Properties.KEY_STATUS);
                detail.setStatus(status);
            }

            //initialize statusReason
            if (jsonObject.has(Properties.KEY_STATUS_REASON)) {
                JSONObject jsonCode = jsonObject.getJSONObject(Properties.KEY_STATUS_REASON);
                CodeableConcept statusReason = createCodeableConcept(jsonCode);
                detail.setStatusReason(statusReason);
            }

            //initialize doNotPerform
            if (jsonObject.has(Properties.KEY_DO_NOT_PERFORM)) {
                String doNotPerform = jsonObject.getString(Properties.KEY_DO_NOT_PERFORM);
                detail.setDoNotPerform(doNotPerform);
            }

            //initialize scheduledTiming
            if (jsonObject.has(Properties.KEY_SCHEDULED_TIMING)) {
                String scheduledTiming = jsonObject.getString(Properties.KEY_SCHEDULED_TIMING);
                detail.setScheduledTiming(scheduledTiming);
            }

            //initialize scheduledPeriod
            if (jsonObject.has(Properties.KEY_SCHEDULED_PERIOD)) {
                JSONObject jsonPeriod = jsonObject.getJSONObject(Properties.KEY_SCHEDULED_PERIOD);
                Period scheduledPeriod = createPeriod(jsonPeriod);
                detail.setScheduledPeriod(scheduledPeriod);
            }

            //initialize scheduledString
            if (jsonObject.has(Properties.KEY_SCHEDULED_STRING)) {
                String scheduledString = jsonObject.getString(Properties.KEY_SCHEDULED_STRING);
                detail.setScheduledString(scheduledString);
            }

            //initialize location
            if (jsonObject.has(Properties.KEY_LOCATION)) {
                JSONObject jsonLocation = jsonObject.getJSONObject(Properties.KEY_LOCATION);
                Reference location = createReference(jsonLocation);
                detail.setLocation(location);
            }

            //initialize performer
            if (jsonObject.has(Properties.KEY_PERFORMER)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_PERFORMER);
                List<Reference> performerList = createReferenceList(jsonArray);
                detail.setPerformer(performerList);
            }

            //initialize productCodeableConcept
            if (jsonObject.has(Properties.KEY_PRODUCT_CODEABLE_CONCEPT)) {
                JSONObject jsonProductCodeableConcept = jsonObject.getJSONObject(Properties.KEY_PRODUCT_CODEABLE_CONCEPT);
                CodeableConcept productCodeableConcept = createCodeableConcept(jsonProductCodeableConcept);
                detail.setProductCodeableConcept(productCodeableConcept);
            }

            //initialize productReference
            if (jsonObject.has(Properties.KEY_PRODUCT_REFERENCE)) {
                JSONObject jsonProductReference = jsonObject.getJSONObject(Properties.KEY_PRODUCT_REFERENCE);
                Reference productReference = createReference(jsonProductReference);
                detail.setProductReference(productReference);
            }

            //initialize dailyAmount
            if (jsonObject.has(Properties.KEY_DAILY_AMOUNT)) {
                String dailyAmount = jsonObject.getString(Properties.KEY_DAILY_AMOUNT);
                detail.setDailyAmount(dailyAmount);
            }

            //initialize quantity
            if (jsonObject.has(Properties.KEY_QUANTITY)) {
                String quantity = jsonObject.getString(Properties.KEY_QUANTITY);
                detail.setQuantity(quantity);
            }

            //initialize description
            if (jsonObject.has(Properties.KEY_DESCRIPTION)) {
                String description = jsonObject.getString(Properties.KEY_DESCRIPTION);
                detail.setDescription(description);
            }

        } catch (Exception e) {
            Log.d("TEST", "createMeta Exception : " + e.toString());
        }
        return detail;
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
    public String createGoal(JSONObject jsonObject){
        String goal = "";
        try {

            if (jsonObject.has(Properties.KEY_REFERENCE)){
                goal = jsonObject.getString(Properties.KEY_REFERENCE);
            }

        } catch (Exception e) {
            Log.d("TEST", "createStringList Exception : " + e.toString());
        }
        return goal;
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
            Log.d("TEST", "createReferenceList Exception : " + e.toString());
        }
        return referenceList;
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
    public List<Activity> createR4ActivityList(JSONArray jsonArray) {
        List<Activity> activityList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Activity activity = createR4Activity(jsonObject);
                activityList.add(activity);
            }
        } catch (Exception e) {
            Log.d("TEST", "createR4ActivityList Exception : " + e.toString());
        }
        return activityList;
    }

    @Override
    public List<String> createGoalList(JSONArray jsonArray) {
        List<String> goalList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                String goal = createGoal(jsonObject);
                goalList.add(goal);
            }
        } catch (Exception e) {
            Log.d("TEST", "createStringList Exception : " + e.toString());
        }
        return goalList;
    }

}
