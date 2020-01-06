package com.ducen.predictor.r4.converter;

import android.util.Log;

import com.ducen.predictor.defaultdata.Properties;
import com.ducen.predictor.r4.entity.R4Medication;
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

import java.util.ArrayList;
import java.util.List;

public class R4MedicationConverterImpl implements R4MedicationConverter {

    @Override
    public boolean checkExist(JSONObject jsonObject) {
        boolean status = false;
        try {
            if (jsonObject.has(Properties.KEY_TOTAL)) {
                String total = jsonObject.getString(Properties.KEY_TOTAL);
                if (Integer.parseInt(total) > 0) {
                    status = true;
                } else {
                    status = false;
                }
            }
        } catch (Exception e) {
            Log.d("TEST", "checkExist Exception : " + e.toString());
            status = false;
        }
        return status;
    }

    public List<R4Medication> createR4MedicationList(JSONObject jsonObject) {
        List<R4Medication> r4MedicationList = new ArrayList<>();

        try {

            if (jsonObject.has(Properties.KEY_ENTRY)) {

                JSONArray jsonEntry = jsonObject.getJSONArray(Properties.KEY_ENTRY);

                for (int c = 0; c < jsonEntry.length(); c++) {

                    JSONObject jsonResources = jsonObject.getJSONArray(Properties.KEY_ENTRY).getJSONObject(c);

                    if (jsonResources.has(Properties.KEY_RESOURCE)) {

                        JSONObject jsonResource = jsonResources.getJSONObject(Properties.KEY_RESOURCE);

                        R4Medication r4Medication = createR4Medication(jsonResource);

                        r4MedicationList.add(r4Medication);

                    }

                }

            }
        } catch (Exception e) {
            Log.d("TEST", "createAllergyIntoleranceList Exception : " + e.toString());
        }

        return r4MedicationList;
    }

    public R4Medication createR4Medication(JSONObject jsonObject) {
        R4Medication r4Medication = new R4Medication();

        try {

            //initialize META
            if (jsonObject.has(Properties.KEY_META)) {
                JSONObject jsonMeta = jsonObject.getJSONObject(Properties.KEY_META);
                Meta meta = createR4MetaPractitioner(jsonMeta);
                r4Medication.setMeta(meta);
            }

            //initialize IDENTIFIER
            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> listOfIdentifier = createIdentifierList(jsonArrayIdentifier);
                r4Medication.setIdentifier(listOfIdentifier);
            }

            //initialize code
            if (jsonObject.has(Properties.KEY_CODE)) {
                JSONObject jsonCode = jsonObject.getJSONObject(Properties.KEY_CODE);
                CodeableConcept code = createCodeableConcept(jsonCode);
                r4Medication.setCode(code);
            }

            //initialize status
            if (jsonObject.has(Properties.KEY_STATUS)) {
                String status = jsonObject.getString(Properties.KEY_STATUS);
                r4Medication.setStatus(status);
            }

            //initialize manufacturer
            if (jsonObject.has(Properties.KEY_MANUFACTURER)) {
                JSONObject jsonManufacturer = jsonObject.getJSONObject(Properties.KEY_MANUFACTURER);
                Reference manufacturer = createReference(jsonManufacturer);
                r4Medication.setManufacturer(manufacturer);
            }

            //initialize form
            if (jsonObject.has(Properties.KEY_FORM)) {
                JSONObject jsonForm = jsonObject.getJSONObject(Properties.KEY_FORM);
                CodeableConcept form = createCodeableConcept(jsonForm);
                r4Medication.setForm(form);
            }

            //initialize amount
            if (jsonObject.has(Properties.KEY_AMOUNT)) {
                JSONObject jsonAmount = jsonObject.getJSONObject(Properties.KEY_AMOUNT);
                Ratio amount = createRatio(jsonAmount);
                r4Medication.setAmount(amount);
            }


            //initialize ingredient
            if (jsonObject.has(Properties.KEY_INGREDIENT)) {
                JSONArray jsonArray = jsonObject.getJSONArray(Properties.KEY_INGREDIENT);
                List<Ingredient> ingredient = createIngredientList(jsonArray);
                r4Medication.setIngredient(ingredient);
            }

            //initialize batch
            if (jsonObject.has(Properties.KEY_BATCH)) {
                JSONObject jsonBatch = jsonObject.getJSONObject(Properties.KEY_BATCH);
                Batch batch = createBatch(jsonBatch);
                r4Medication.setBatch(batch);
            }


        } catch (Exception e) {
            Log.d("TEST", "createR4AllergyIntolerance Exception : " + e.toString());
        }
        return r4Medication;
    }

    @Override
    public Meta createR4MetaPractitioner(JSONObject jsonObject) {
        Meta meta = new Meta("", "", "");
        try {

            if (jsonObject.has(Properties.KEY_VERSIONID)) {
                String versionId = jsonObject.getString(Properties.KEY_VERSIONID);
                meta.setVersionId(versionId);
            }

            if (jsonObject.has(Properties.KEY_LAST_UPDATED)) {
                String lastUpdated = jsonObject.getString(Properties.KEY_LAST_UPDATED);
                meta.setLastUpdated(lastUpdated);
            }

            if (jsonObject.has(Properties.KEY_SOURCE)) {
                String source = jsonObject.getString(Properties.KEY_SOURCE);
                meta.setSource(source);
            }
        } catch (Exception e) {
            Log.d("TEST", "createMeta Exception : " + e.toString());
        }
        return meta;
    }

    @Override
    public CodeableConcept createCodeableConcept(JSONObject jsonObject) {
        CodeableConcept clinicalStatus = new CodeableConcept(null, "");
        try {

            if (jsonObject.has(Properties.KEY_CODING)) {
                JSONArray jsonArrayCoding = jsonObject.getJSONArray(Properties.KEY_CODING);
                List<Coding> listOfCoding = createCodingList(jsonArrayCoding);
                clinicalStatus.setCoding(listOfCoding);
            }

            if (jsonObject.has(Properties.KEY_TEXT)) {
                String text = jsonObject.getString(Properties.KEY_TEXT);
                clinicalStatus.setText(text);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createCodeableConcept Exception : " + e.toString());
        }
        return clinicalStatus;
    }

    @Override
    public Coding createCoding(JSONObject jsonObject) {
        Coding coding = new Coding("", "", "", "", "");
        try {

            if (jsonObject.has(Properties.KEY_SYSTEM)) {
                String system = jsonObject.getString(Properties.KEY_SYSTEM);
                coding.setSystem(system);
            }

            if (jsonObject.has(Properties.KEY_VERSION)) {
                String version = jsonObject.getString(Properties.KEY_VERSION);
                coding.setVersion(version);
            }

            if (jsonObject.has(Properties.KEY_CODE)) {
                String code = jsonObject.getString(Properties.KEY_CODE);
                coding.setCode(code);
            }

            if (jsonObject.has(Properties.KEY_DISPLAY)) {
                String display = jsonObject.getString(Properties.KEY_DISPLAY);
                coding.setDisplay(display);
            }

            if (jsonObject.has(Properties.KEY_USER_SELECTED)) {
                String userSelected = jsonObject.getString(Properties.KEY_USER_SELECTED);
                coding.setUserSelected(userSelected);
            }

        } catch (Exception e) {
            Log.d("TEST", "createCoding Exception : " + e.toString());
        }
        return coding;
    }

    @Override
    public Period createPeriod(JSONObject jsonObject) {
        Period period = new Period("", "");
        try {

            if (jsonObject.has(Properties.KEY_START)) {
                String start = jsonObject.getString(Properties.KEY_START);
                period.setStart(start);
            }

            if (jsonObject.has(Properties.KEY_END)) {
                String end = jsonObject.getString(Properties.KEY_END);
                period.setEnd(end);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createPeriod Exception : " + e.toString());
        }
        return period;
    }

    @Override
    public Identifier createIdentifier(JSONObject jsonObject) {
        Identifier identifier = new Identifier();
        try {

            if (jsonObject.has(Properties.KEY_USE)) {
                String use = jsonObject.getString(Properties.KEY_USE);
                identifier.setUse(use);
            }

            if (jsonObject.has(Properties.KEY_TYPE)) {
                String type = jsonObject.getString(Properties.KEY_TYPE);
                identifier.setType(type);
            }

            if (jsonObject.has(Properties.KEY_SYSTEM)) {
                String system = jsonObject.getString(Properties.KEY_SYSTEM);
                identifier.setSystem(system);
            }

            if (jsonObject.has(Properties.KEY_VALUE)) {
                String value = jsonObject.getString(Properties.KEY_VALUE);
                identifier.setValue(value);
            }

            if (jsonObject.has(Properties.KEY_PERIOD)) {
                String period = jsonObject.getString(Properties.KEY_PERIOD);
                identifier.setPeriod(period);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createIdentifier Exception : " + e.toString());
        }
        return identifier;
    }

    @Override
    public Reference createReference(JSONObject jsonObject) {
        Reference patient = new Reference("", "", null, "");
        try {

            if (jsonObject.has(Properties.KEY_REFERENCE)) {
                String reference = jsonObject.getString(Properties.KEY_REFERENCE);
                patient.setReference(reference);
            }

            if (jsonObject.has(Properties.KEY_TYPE)) {
                String type = jsonObject.getString(Properties.KEY_TYPE);
                patient.setType(type);
            }

            if (jsonObject.has(Properties.KEY_IDENTIFIER)) {
                JSONArray jsonArrayIdentifier = jsonObject.getJSONArray(Properties.KEY_IDENTIFIER);
                List<Identifier> listOfIdentifier = createIdentifierList(jsonArrayIdentifier);
                patient.setIdentifier(listOfIdentifier);
            }

            if (jsonObject.has(Properties.KEY_DISPLAY)) {
                String display = jsonObject.getString(Properties.KEY_DISPLAY);
                patient.setDisplay(display);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createReference Exception : " + e.toString());
        }
        return patient;
    }

    @Override
    public Quantity createQuantity(JSONObject jsonObject) {
        Quantity quantity = new Quantity();
        try {

            if (jsonObject.has(Properties.KEY_VALUE)) {
                String value = jsonObject.getString(Properties.KEY_VALUE);
                quantity.setValue(value);
            }

            if (jsonObject.has(Properties.KEY_COMPARATOR)) {
                String comparator = jsonObject.getString(Properties.KEY_COMPARATOR);
                quantity.setComparator(comparator);
            }

            if (jsonObject.has(Properties.KEY_UNIT)) {
                String unit = jsonObject.getString(Properties.KEY_UNIT);
                quantity.setUnit(unit);
            }

            if (jsonObject.has(Properties.KEY_SYSTEM)) {
                String system = jsonObject.getString(Properties.KEY_SYSTEM);
                quantity.setSystem(system);
            }

            if (jsonObject.has(Properties.KEY_CODE)) {
                String code = jsonObject.getString(Properties.KEY_CODE);
                quantity.setCode(code);
            }


        } catch (
                Exception e) {
            Log.d("TEST", "createReference Exception : " + e.toString());
        }
        return quantity;
    }

    @Override
    public Ratio createRatio(JSONObject jsonObject) {
        Ratio ratio = new Ratio();

        try {

            if (jsonObject.has(Properties.KEY_NUMERATOR)) {
                JSONObject jsonNumerator = jsonObject.getJSONObject(Properties.KEY_NUMERATOR);
                Quantity numerator = createQuantity(jsonNumerator);
                ratio.setNumerator(numerator);
            }

            if (jsonObject.has(Properties.KEY_DENOMINATOR)) {
                JSONObject jsonDenominator = jsonObject.getJSONObject(Properties.KEY_DENOMINATOR);
                Quantity denominator = createQuantity(jsonDenominator);
                ratio.setDenominator(denominator);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createReference Exception : " + e.toString());
        }
        return ratio;
    }

    @Override
    public Range createRange(JSONObject jsonObject) {
        Range range = new Range();
        try {

            if (jsonObject.has(Properties.KEY_LOW)) {
                JSONObject jsonLow = jsonObject.getJSONObject(Properties.KEY_LOW);
                SimpleQuantity simpleQuantity = createSimpleQuantity(jsonLow);
                range.setLow(simpleQuantity);
            }

            if (jsonObject.has(Properties.KEY_HIGH)) {
                JSONObject jsonHigh = jsonObject.getJSONObject(Properties.KEY_HIGH);
                SimpleQuantity simpleQuantity = createSimpleQuantity(jsonHigh);
                range.setHigh(simpleQuantity);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createReference Exception : " + e.toString());
        }
        return range;
    }

    @Override
    public SimpleQuantity createSimpleQuantity(JSONObject jsonObject) {
        SimpleQuantity simpleQuantity = new SimpleQuantity("", "");
        try {
            if (jsonObject.has(Properties.KEY_VALUE)) {
                simpleQuantity.setValue(jsonObject.getString(Properties.KEY_VALUE));
            }
            if (jsonObject.has(Properties.KEY_CURRENCY)) {
                simpleQuantity.setCurrency(jsonObject.getString(Properties.KEY_CURRENCY));
            }

        } catch (Exception e) {
            Log.d("TEST", "createSimpleQuantity Exception : " + e.toString());
        }
        return simpleQuantity;
    }

    @Override
    public Ingredient createIngredient(JSONObject jsonObject) {
        Ingredient ingredient = new Ingredient();
        try {

            //initialize itemCodeableConcept
            if (jsonObject.has(Properties.KEY_ITEM_CODEABLE_CONCEPT)) {
                JSONObject jsonItemCodeableConcept = jsonObject.getJSONObject(Properties.KEY_ITEM_CODEABLE_CONCEPT);
                CodeableConcept itemCodeableConcept = createCodeableConcept(jsonItemCodeableConcept);
                ingredient.setItemCodeableConcept(itemCodeableConcept);
            }

            //initialize itemReference
            if (jsonObject.has(Properties.KEY_ITEM_REFERENCE)) {
                JSONObject jsonItemReference = jsonObject.getJSONObject(Properties.KEY_ITEM_REFERENCE);
                Reference itemReference = createReference(jsonItemReference);
                ingredient.setItemReference(itemReference);
            }

            //initialize isActive
            if (jsonObject.has(Properties.KEY_IS_ACTIVE)) {
                String isActive = jsonObject.getString(Properties.KEY_IS_ACTIVE);
                ingredient.setIsActive(isActive);
            }

            //initialize strength
            if (jsonObject.has(Properties.KEY_STRENGTH)) {
                JSONObject jsonStrength = jsonObject.getJSONObject(Properties.KEY_STRENGTH);
                Ratio strength = createRatio(jsonStrength);
                ingredient.setStrength(strength);
            }

        } catch (
                Exception e) {
            Log.d("TEST", "createReference Exception : " + e.toString());
        }
        return ingredient;
    }

    @Override
    public Batch createBatch(JSONObject jsonObject) {
        Batch batch = new Batch();
        try {

            //initialize lotNumber
            if (jsonObject.has(Properties.KEY_LOT_NUMBER)) {
                String lotNumber = jsonObject.getString(Properties.KEY_LOT_NUMBER);
                batch.setLotNumber(lotNumber);
            }

            //initialize expirationDate
            if (jsonObject.has(Properties.KEY_LOT_NUMBER)) {
                String expirationDate = jsonObject.getString(Properties.KEY_LOT_NUMBER);
                batch.setExpirationDate(expirationDate);
            }


        } catch (
                Exception e) {
            Log.d("TEST", "createBatch Exception : " + e.toString());
        }
        return batch;
    }

    @Override
    public List<String> createStringList(JSONArray jsonArray) {
        List<String> categoryList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {

                String category = jsonArray.getString(c);
                categoryList.add(category);
            }
        } catch (Exception e) {
            Log.d("TEST", "createCategory Exception : " + e.toString());
        }
        return categoryList;
    }

    @Override
    public List<CodeableConcept> createCodeableConceptList(JSONArray jsonArray) {
        List<CodeableConcept> codeableConceptList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                CodeableConcept codeableConcept = createCodeableConcept(jsonObject);
                codeableConceptList.add(codeableConcept);
            }
        } catch (Exception e) {
            Log.d("TEST", "createCodeableConceptList Exception : " + e.toString());
        }
        return codeableConceptList;
    }

    @Override
    public List<Coding> createCodingList(JSONArray jsonArray) {
        List<Coding> codingList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Coding coding = createCoding(jsonObject);
                codingList.add(coding);
            }
        } catch (
                Exception e) {
            Log.d("TEST", "createCoding Exception : " + e.toString());
        }
        return codingList;
    }

    @Override
    public List<Identifier> createIdentifierList(JSONArray jsonArray) {
        List<Identifier> listOfIdentifier = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonIdentifier = jsonArray.getJSONObject(c);
                Identifier identifier = createIdentifier(jsonIdentifier);
                listOfIdentifier.add(identifier);
            }
        } catch (
                Exception e) {
            Log.d("TEST", "createIdentifier Exception : " + e.toString());
        }
        return listOfIdentifier;
    }

    @Override
    public List<Reference> createReferenceList(JSONArray jsonArray) {
        List<Reference> referenceList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Reference reference = createReference(jsonObject);
                referenceList.add(reference);
            }
        } catch (Exception e) {
            Log.d("TEST", "createReferenceList Exception : " + e.toString());
        }
        return referenceList;
    }

    @Override
    public List<Ingredient> createIngredientList(JSONArray jsonArray) {
        List<Ingredient> ingredientList = new ArrayList<>();
        try {
            for (int c = 0; c < jsonArray.length(); c++) {
                JSONObject jsonObject = jsonArray.getJSONObject(c);
                Ingredient ingredient = createIngredient(jsonObject);
                ingredientList.add(ingredient);
            }
        } catch (Exception e) {
            Log.d("TEST", "createIngredientList Exception : " + e.toString());
        }
        return ingredientList;
    }



}
