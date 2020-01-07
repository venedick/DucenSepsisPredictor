package com.ducen.predictor.service;

import com.ducen.predictor.model.Condition;
import com.ducen.predictor.r4.entity.R4Condition;
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

            String stCondition = extractDisplayFromCodeableConcept(r4Condition.getCode());
            condition.setCondition(stCondition);

            String clinicalStatus = extractDisplayFromCodeableConcept(r4Condition.getClinicalStatus());
            condition.setClinicalStatus(clinicalStatus);

            String verificationStatus = extractDisplayFromCodeableConcept(r4Condition.getVerificationStatus());
            condition.setVerificationStatus(verificationStatus);

            String onsetDate = extractDateTimeFromOnSet(r4Condition.getOnSet());
            condition.setOnsetDate(onsetDate);

            String abatementDateTime = extractDateTimeFromOnSet(r4Condition.getAbatement());
            condition.setAbatementDateTime(abatementDateTime);

            conditionList.add(condition);
        }
        return conditionList;
    }

    String extractDisplayFromCodeableConcept(CodeableConcept codeableConcept){
        String display = "";
        for (Coding coding : codeableConcept.getCoding()) {
            display = coding.getDisplay();
            break;
        }
        return display;
    }

    String extractDateTimeFromOnSet(OnSet onSet){
        String onsetDateTime = onSet.getOnsetDateTime();
        return onsetDateTime;
    }

}
