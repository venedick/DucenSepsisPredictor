package com.ducen.predictor.r4.service;


import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.entity.R4AllergyIntolerance;
import com.ducen.predictor.r4.entity.R4Reaction;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Reference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface R4AllergyIntoleranceService {

    boolean checkExist(JSONObject jsonObject);

    List<R4AllergyIntolerance> createR4AllergyIntoleranceList(JSONObject jsonObject);

    R4AllergyIntolerance createR4AllergyIntolerance(JSONObject jsonObject);

    Meta createMeta(JSONObject jsonObject);

    R4Reaction createR4Reaction(JSONObject jsonObject);

    Annotation createAnnotation(JSONObject jsonObject);

    CodeableConcept createCodeableConcept(JSONObject jsonObject);

    Coding createCoding(JSONObject jsonObject);

    Identifier createIdentifier(JSONObject jsonObject);

    Reference createReference(JSONObject jsonObject);

    List<Annotation> createAnnotationList(JSONArray jsonArray);

    List<String> createCategoryList(JSONArray jsonArray);

    List<CodeableConcept> createCodeableConceptList(JSONArray jsonArray);

    List<Coding> createCodingList(JSONArray jsonArray);

    List<Identifier> createIdentifierList(JSONArray jsonArray);

    List<R4Reaction> createReactionList(JSONArray jsonArray);



}
