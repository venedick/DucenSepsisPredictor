package com.ducen.predictor.r4.service;


import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Participant;
import com.ducen.predictor.r4.entity.R4Appointment;
import com.ducen.predictor.r4.entity.R4Evidence;
import com.ducen.predictor.r4.types.Stage;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface R4AppointmentService {

    boolean checkExist(JSONObject jsonObject);

    List<R4Appointment> createR4AppointmentList(JSONObject jsonObject);

    R4Appointment createR4Appointment(JSONObject jsonObject);

    Meta createMeta(JSONObject jsonObject);

    Participant createR4Participant(JSONObject jsonObject);

    Annotation createAnnotation(JSONObject jsonObject);

    CodeableConcept createCodeableConcept(JSONObject jsonObject);

    Coding createCoding(JSONObject jsonObject);

    Identifier createIdentifier(JSONObject jsonObject);

    Period createPeriod(JSONObject jsonObject);

    Reference createReference(JSONObject jsonObject);

    List<Identifier> createIdentifierList(JSONArray jsonArray);

    List<Coding> createCodingList(JSONArray jsonArray);

    List<CodeableConcept> createCodeableConceptList(JSONArray jsonArray);

    List<Reference> createReferenceList(JSONArray jsonArray);

    List<Participant> createR4ParticipantList(JSONArray jsonArray);

    List<Period> createPeriodList(JSONArray jsonArray);


}
