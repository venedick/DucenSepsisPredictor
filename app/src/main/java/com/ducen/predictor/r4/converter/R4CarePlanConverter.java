package com.ducen.predictor.r4.converter;

import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Activity;
import com.ducen.predictor.r4.types.Detail;
import com.ducen.predictor.r4.entity.R4CarePlan;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface R4CarePlanConverter {

    boolean checkExist(JSONObject jsonObject);

    List<R4CarePlan> createR4CarePlanList(JSONObject jsonObject);

    R4CarePlan createR4CarePlan(JSONObject jsonObject);

    Activity createR4Activity(JSONObject jsonObject);

    Detail createR4Detail(JSONObject jsonObject);

    Meta createMeta(JSONObject jsonObject);

    Annotation createAnnotation(JSONObject jsonObject);

    CodeableConcept createCodeableConcept(JSONObject jsonObject);

    Coding createCoding(JSONObject jsonObject);

    Identifier createIdentifier(JSONObject jsonObject);

    Period createPeriod(JSONObject jsonObject);

    Reference createReference(JSONObject jsonObject);

    String createGoal(JSONObject jsonObject);

    List<Annotation> createAnnotationList(JSONArray jsonArray);

    List<Identifier> createIdentifierList(JSONArray jsonArray);

    List<Coding> createCodingList(JSONArray jsonArray);

    List<CodeableConcept> createCodeableConceptList(JSONArray jsonArray);

    List<Reference> createReferenceList(JSONArray jsonArray);

    List<String> createStringList(JSONArray jsonArray);

    List<Activity> createR4ActivityList(JSONArray jsonArray);

    List<String> createGoalList(JSONArray jsonArray);




}
