package com.ducen.predictor.service;

        import android.util.Log;

        import com.ducen.predictor.model.Condition;
        import com.ducen.predictor.r4.entity.R4Condition;
        import com.ducen.predictor.r4.types.Age;
        import com.ducen.predictor.r4.types.CodeableConcept;
        import com.ducen.predictor.r4.types.Coding;
        import com.ducen.predictor.r4.types.OnSet;

        import java.util.ArrayList;
        import java.util.List;

public class ConditionService {

    public List<Condition> createConditionList(List<R4Condition> r4ConditionList) {

        List<Condition> conditionList = new ArrayList<>();

        for (R4Condition r4Condition : r4ConditionList) {

            Condition condition = new Condition();

            String stCondition = "";
            if (r4Condition.getCode() != null) {
                stCondition = extractDisplayFromCodeableConcept(r4Condition.getCode());
            }
            condition.setCondition(stCondition);

            String clinicalStatus = "";
            if (r4Condition.getClinicalStatus() != null) {
                clinicalStatus = extractDisplayFromCodeableConcept(r4Condition.getClinicalStatus());
            }
            condition.setClinicalStatus(clinicalStatus);

            String verificationStatus = "";
            if (r4Condition.getVerificationStatus() != null) {
                verificationStatus = extractDisplayFromCodeableConcept(r4Condition.getVerificationStatus());
            }
            condition.setVerificationStatus(verificationStatus);

            String onsetDate = "";
            if (r4Condition.getOnSet() != null) {
                onsetDate = extractDateTimeFromOnSet(r4Condition.getOnSet());
            }
            condition.setOnsetDate(onsetDate);

            String abatementDateTime = "";
            if (r4Condition.getAbatement() != null) {
                abatementDateTime = extractDateTimeFromOnSet(r4Condition.getAbatement());
            }
            condition.setAbatementDate(abatementDateTime);

            String bodySite = "";
            if (r4Condition.getBodySite() != null) {
                bodySite = extractDisplayFromCodeableConceptList(r4Condition.getBodySite());
            }
            condition.setBodySite(bodySite);

            String severity = "";
            if (r4Condition.getSeverity() != null) {
                severity = extractDisplayFromCodeableConcept(r4Condition.getSeverity());
            }
            condition.setSeverity(severity);

            Log.d("TEST", condition.toString());

            conditionList.add(condition);
        }
        return conditionList;
    }

    String extractDisplayFromCodeableConceptList(List<CodeableConcept> codeableConceptList){
        String display = "";
        for (CodeableConcept codeableConcept : codeableConceptList) {
            if (!extractDisplayFromCodeableConcept(codeableConcept).equalsIgnoreCase("")) {
                display = extractDisplayFromCodeableConcept(codeableConcept);
                break;
            }
        }
        return display;
    }

    String extractDisplayFromCodeableConcept(CodeableConcept codeableConcept) {
        String display = "";
        for (Coding coding : codeableConcept.getCoding()) {
            if (coding.getDisplay() != null) {
                display = coding.getDisplay();
                break;
            }
        }
        return display;
    }

    String extractDateTimeFromOnSet(OnSet onSet) {

        String onsetDate = "";

        if (onSet.getOnsetDateTime() != null && onSet.getOnsetDateTime().length() != 0) {
            onsetDate = onSet.getOnsetDateTime();
        }

        if (onSet.getOnsetAge() != null) {
            Age age = onSet.getOnsetAge();
            onsetDate = extractValueFromAge(age);
        }

        if (onSet.getOnsetRange() != null && onSet.getOnsetRange().length() != 0) {
            onsetDate = onSet.getOnsetRange();
        }

        if (onSet.getOnsetString() != null && onSet.getOnsetString().length() != 0) {
            onsetDate = onSet.getOnsetString();
        }
        return onsetDate;
    }

    String extractValueFromAge(Age age) {
        String value = "";
        if (age.getValue() != null) {
            value = age.getValue() + "yrs old";
        }
        return value;
    }


}
