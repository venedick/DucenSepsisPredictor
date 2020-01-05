package com.ducen.predictor.r4.service;

import com.ducen.predictor.r4.types.Participant;
import com.ducen.predictor.r4.types.Activity;
import com.ducen.predictor.r4.types.Detail;
import com.ducen.predictor.r4.entity.R4Encounter;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.History;
import com.ducen.predictor.r4.types.Hospitalization;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Location;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface R4EncounterService {

    boolean checkExist(JSONObject jsonObject);

    List<R4Encounter> createR4EncounterList(JSONObject jsonObject);

    R4Encounter createR4Encounter(JSONObject jsonObject);

    Activity createR4Activity(JSONObject jsonObject);

    Detail createR4Detail(JSONObject jsonObject);

    Meta createR4MetaPractitioner(JSONObject jsonObject);

    Participant createR4Participant(JSONObject jsonObject);

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

    List<String> createGoalList(JSONArray jsonArray);

    History createHistory(JSONObject jsonObject);

    Hospitalization createHospitalization(JSONObject jsonObject);

    Location createLocation(JSONObject jsonObject);

    List<History> createHistoryList(JSONArray jsonArray);

    List<Participant> createR4ParticipantList(JSONArray jsonArray);

    List<Location> createLocationList(JSONArray jsonArray);



}
