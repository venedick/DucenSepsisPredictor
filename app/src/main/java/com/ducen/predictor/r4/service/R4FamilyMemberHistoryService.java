package com.ducen.predictor.r4.service;

import com.ducen.predictor.r4.entity.R4FamilyMemberHistory;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Condition;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Range;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.SimpleQuantity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface R4FamilyMemberHistoryService {

    boolean checkExist(JSONObject jsonObject);

    List<R4FamilyMemberHistory> createR4FamilyMemberList(JSONObject jsonObject);

    R4FamilyMemberHistory createR4FamilyMember(JSONObject jsonObject);

    Meta createMeta(JSONObject jsonObject);

    Identifier createIdentifier(JSONObject jsonObject);

    List<Identifier> createIdentifierList(JSONArray jsonArray);

    List<String> createStringList(JSONArray jsonArray);

    CodeableConcept createCodeableConcept(JSONObject jsonObject);

    List<CodeableConcept> createCodeableConceptList(JSONArray jsonArray);

    Reference createReference(JSONObject jsonObject);

    List<Reference> createReferenceList(JSONArray jsonArray);

    Period createPeriod(JSONObject jsonObject);

    Range createRange(JSONObject jsonObject);

    SimpleQuantity createSimpleQuantity(JSONObject jsonObject);

    Annotation createAnnotation(JSONObject jsonObject);

    List<Annotation> createAnnotationList(JSONArray jsonArray);

    Condition createCondition(JSONObject jsonObject);

    List<Condition> createConditionList(JSONArray jsonArray);

    Coding createCoding(JSONObject jsonObject);

    List<Coding> createCodingList(JSONArray jsonArray);
}
