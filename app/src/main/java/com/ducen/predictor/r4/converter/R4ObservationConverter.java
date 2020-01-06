package com.ducen.predictor.r4.converter;

import com.ducen.predictor.r4.entity.R4Observation;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Component;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Quantity;
import com.ducen.predictor.r4.types.Range;
import com.ducen.predictor.r4.types.Ratio;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.ReferenceRange;
import com.ducen.predictor.r4.types.Repeat;
import com.ducen.predictor.r4.types.SampledData;
import com.ducen.predictor.r4.types.SimpleQuantity;
import com.ducen.predictor.r4.types.Timing;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface R4ObservationConverter {

    boolean checkExist(JSONObject jsonObject);

    List<R4Observation> createR4ObservationList(JSONObject jsonObject);

    R4Observation createR4Observation(JSONObject jsonObject);

    CodeableConcept createCodeableConcept(JSONObject jsonObject);

    Identifier createIdentifier(JSONObject jsonObject);

    Period createPeriod(JSONObject jsonObject);

    Reference createReference(JSONObject jsonObject);

    List<CodeableConcept> createCodeableConceptList(JSONArray jsonArray);

    List<Reference> createReferenceList(JSONArray jsonArray);

    List<Identifier> createIdentifierList(JSONArray jsonArray);

    Quantity createQuantity(JSONObject jsonObject);

    Range createRange(JSONObject jsonObject);

    Ratio createRatio(JSONObject jsonObject);

    SampledData createSampledData(JSONObject jsonObject);

    Timing createTiming(JSONObject jsonObject);

    List<Annotation> createAnnotationList(JSONArray jsonArray);

    List<ReferenceRange> createReferenceRangeList(JSONArray jsonArray);

    List<Coding> createCodingList(JSONArray jsonArray);

    Coding createCoding(JSONObject jsonObject);

    SimpleQuantity createSimpleQuantity(JSONObject jsonObject);

    List<String> createEventList(JSONArray jsonArray);

    Repeat createRepeat(JSONObject jsonObject);

    List<String> createCodeList(JSONArray jsonArray);

    Annotation createAnnotation(JSONObject jsonObject);

    ReferenceRange createReferenceRange(JSONObject jsonObject);

    List<Component> createComponentList(JSONArray jsonArray);

    Component createComponent(JSONObject jsonObject);

}
