package com.ducen.predictor.r4.converter;

import com.ducen.predictor.r4.entity.R4RiskAssessment;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Prediction;
import com.ducen.predictor.r4.types.Range;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.SimpleQuantity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface R4RiskAssessmentService {

    boolean checkExist(JSONObject jsonObject);

    List<R4RiskAssessment> createR4RiskAssessmentList(JSONObject jsonObject);

    R4RiskAssessment createR4RiskAssessment(JSONObject jsonObject);

    Meta createMeta(JSONObject jsonObject);

    Annotation createAnnotation(JSONObject jsonObject);

    CodeableConcept createCodeableConcept(JSONObject jsonObject);

    Coding createCoding(JSONObject jsonObject);

    Identifier createIdentifier(JSONObject jsonObject);

    Reference createReference(JSONObject jsonObject);

    Period createPeriod(JSONObject jsonObject);

    Prediction createPrediction(JSONObject jsonObject);

    Range createRange(JSONObject jsonObject);

    SimpleQuantity createSimpleQuantity(JSONObject jsonObject);

    List<Annotation> createAnnotationList(JSONArray jsonArray);

    List<CodeableConcept> createCodeableConceptList(JSONArray jsonArray);

    List<Identifier> createIdentifierList(JSONArray jsonArray);

    List<Reference> createReferenceList(JSONArray jsonArray);

    List<Coding> createCodingList(JSONArray jsonArray);

    List<Prediction> createPredictionList(JSONArray jsonArray);
}
