package com.ducen.predictor.r4.converter;


import com.ducen.predictor.r4.types.Batch;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Ingredient;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Quantity;
import com.ducen.predictor.r4.types.Range;
import com.ducen.predictor.r4.types.Ratio;
import com.ducen.predictor.r4.types.Reference;
import com.ducen.predictor.r4.types.SimpleQuantity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface R4MedicationService {

    boolean checkExist(JSONObject jsonObject);

    Meta createR4MetaPractitioner(JSONObject jsonObject);

    CodeableConcept createCodeableConcept(JSONObject jsonObject);

    Coding createCoding(JSONObject jsonObject);

    Identifier createIdentifier(JSONObject jsonObject);

    Reference createReference(JSONObject jsonObject);

    Period createPeriod(JSONObject jsonObject);

    Quantity createQuantity(JSONObject jsonObject);

    Ratio createRatio(JSONObject jsonObject);

    Range createRange(JSONObject jsonObject);

    SimpleQuantity createSimpleQuantity(JSONObject jsonObject);

    Ingredient createIngredient(JSONObject jsonObject);

    Batch createBatch(JSONObject jsonObject);

    List<Ingredient> createIngredientList(JSONArray jsonArray);

    List<String> createStringList(JSONArray jsonArray);

    List<CodeableConcept> createCodeableConceptList(JSONArray jsonArray);

    List<Coding> createCodingList(JSONArray jsonArray);

    List<Identifier> createIdentifierList(JSONArray jsonArray);

    List<Reference> createReferenceList(JSONArray jsonArray);

}
