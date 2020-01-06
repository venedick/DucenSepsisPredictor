package com.ducen.predictor.r4.converter;

import com.ducen.predictor.r4.types.Stage;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.entity.R4Condition;
import com.ducen.predictor.r4.entity.R4Evidence;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.OnSet;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface R4ConditionConverter {

    boolean checkExist(JSONObject jsonObject);

    List<R4Condition> createR4ConditionList(JSONObject jsonObject);

    R4Condition createR4Condition(JSONObject jsonObject);

    Meta createR4MetaPractitioner(JSONObject jsonObject);

    R4Evidence createR4Evidence(JSONObject jsonObject);

    Stage createR4Stage(JSONObject jsonObject);

    Annotation createAnnotation(JSONObject jsonObject);

    CodeableConcept createCodeableConcept(JSONObject jsonObject);

    Coding createCoding(JSONObject jsonObject);

    Identifier createIdentifier(JSONObject jsonObject);

    OnSet createOnSet(JSONObject jsonObject);

    OnSet createAbatement(JSONObject jsonObject);

    Period createPeriod(JSONObject jsonObject);

    Reference createReference(JSONObject jsonObject);

    List<Annotation> createAnnotationList(JSONArray jsonArray);

    List<Identifier> createIdentifierList(JSONArray jsonArray);

    List<Coding> createCodingList(JSONArray jsonArray);

    List<CodeableConcept> createCodeableConceptList(JSONArray jsonArray);

    List<Stage> createR4StageList(JSONArray jsonArray);

    List<R4Evidence> createR4EvidenceList(JSONArray jsonArray);

    List<Reference> createReferenceList(JSONArray jsonArray);


}
