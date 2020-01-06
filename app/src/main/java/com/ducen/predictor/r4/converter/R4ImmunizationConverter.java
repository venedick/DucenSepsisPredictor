package com.ducen.predictor.r4.converter;

import com.ducen.predictor.r4.entity.R4Immunization;
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
import com.ducen.predictor.r4.types.Target;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface R4ImmunizationConverter {

    boolean checkExist(JSONObject jsonObject);

    List<R4Immunization> createR4ImmunizationList(JSONObject jsonObject);

    R4Immunization createR4Immunization(JSONObject jsonObject);

    Meta createR4MetaPractitioner(JSONObject jsonObject);

    Annotation createAnnotation(JSONObject jsonObject);

    CodeableConcept createCodeableConcept(JSONObject jsonObject);

    Coding createCoding(JSONObject jsonObject);

    Identifier createIdentifier(JSONObject jsonObject);

    Period createPeriod(JSONObject jsonObject);

    Reference createReference(JSONObject jsonObject);

    Quantity createQuantity(JSONObject jsonObject);

    Range createRange(JSONObject jsonObject);

    Ratio createRatio(JSONObject jsonObject);

    Target createTarget(JSONObject jsonObject);

    List<Annotation> createAnnotationList(JSONArray jsonArray);

    List<Identifier> createIdentifierList(JSONArray jsonArray);

    List<Coding> createCodingList(JSONArray jsonArray);

    List<CodeableConcept> createCodeableConceptList(JSONArray jsonArray);

    List<Reference> createReferenceList(JSONArray jsonArray);

    List<Target> createTargetList(JSONArray jsonArray);

}
