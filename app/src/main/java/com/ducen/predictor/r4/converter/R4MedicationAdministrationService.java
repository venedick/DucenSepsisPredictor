package com.ducen.predictor.r4.converter;


import com.ducen.predictor.r4.entity.R4MedicationAdministration;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Dosage;
import com.ducen.predictor.r4.types.DoseAndRate;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Performer;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Quantity;
import com.ducen.predictor.r4.types.Range;
import com.ducen.predictor.r4.types.Ratio;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.Repeat;
import com.ducen.predictor.r4.types.SimpleQuantity;
import com.ducen.predictor.r4.types.Timing;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface R4MedicationAdministrationService {

    boolean checkExist(JSONObject jsonObject);

    List<R4MedicationAdministration> createR4MedicationAdministrationList(JSONObject jsonObject);

    R4MedicationAdministration createR4MedicationAdministration(JSONObject jsonObject);

    Meta createMeta(JSONObject jsonObject);

    Annotation createAnnotation(JSONObject jsonObject);

    CodeableConcept createCodeableConcept(JSONObject jsonObject);

    Coding createCoding(JSONObject jsonObject);

    Identifier createIdentifier(JSONObject jsonObject);

    Reference createReference(JSONObject jsonObject);

    Period createPeriod(JSONObject jsonObject);

    Quantity createQuantity(JSONObject jsonObject);

    Performer createPerformer(JSONObject jsonObject);

    Dosage createDosage(JSONObject jsonObject);

    DoseAndRate createDoseAndRate(JSONObject jsonObject);

    Ratio createRatio(JSONObject jsonObject);

    Range createRange(JSONObject jsonObject);

    Repeat createRepeat(JSONObject jsonObject);

    SimpleQuantity createSimpleQuantity(JSONObject jsonObject);

    Timing createTiming(JSONObject jsonObject);

    List<String> createStringList(JSONArray jsonArray);

    List<Performer> createPerformerList(JSONArray jsonArray);

    List<DoseAndRate> createDoseAndRateList(JSONArray jsonArray);

    List<Annotation> createAnnotationList(JSONArray jsonArray);

    List<CodeableConcept> createCodeableConceptList(JSONArray jsonArray);

    List<Coding> createCodingList(JSONArray jsonArray);

    List<Identifier> createIdentifierList(JSONArray jsonArray);

    List<Reference> createReferenceList(JSONArray jsonArray);

}
