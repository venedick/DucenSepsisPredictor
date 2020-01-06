package com.ducen.predictor.r4.converter;

import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.entity.R4Practitioner;
import com.ducen.predictor.r4.types.Qualification;
import com.ducen.predictor.r4.types.Address;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.ContactPoint;
import com.ducen.predictor.r4.types.HumanName;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface R4PractitionerConverter {

    boolean checkExist(JSONObject jsonObject);

    R4Practitioner createR4Practitioner(JSONObject jsonObject);

    Meta createR4MetaPractitioner(JSONObject jsonObject);

    CodeableConcept createCode(JSONObject jsonObject);

    Period createPeriod(JSONObject jsonObject);

    Reference createIssuer(JSONObject jsonObject);

    List<HumanName> createHumanName(JSONArray jsonArray);

    List<String> createGiven(JSONArray jsonArray);

    List<String> createPrefix(JSONArray jsonArray);

    List<String> createSuffix(JSONArray jsonArray);

    List<ContactPoint> createTelecom(JSONArray jsonArray);

    List<Address> createAddress(JSONArray jsonArray);

    List<String> createLine(JSONArray jsonArray);

    List<Qualification> createQualification(JSONArray jsonArray);

    List<Identifier> createIdentifier(JSONArray jsonArray);

    List<Coding> createCoding(JSONArray jsonArray);



}
