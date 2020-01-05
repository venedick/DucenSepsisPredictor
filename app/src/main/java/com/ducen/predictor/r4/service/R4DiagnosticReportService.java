package com.ducen.predictor.r4.service;

import com.ducen.predictor.r4.entity.R4DiagnosticReport;
import com.ducen.predictor.r4.types.Media;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Attachment;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Coding;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface R4DiagnosticReportService {

    boolean checkExist(JSONObject jsonObject);

    List<R4DiagnosticReport> createR4DiagnosticReportList(JSONObject jsonObject);

    R4DiagnosticReport createR4DiagnosticReport(JSONObject jsonObject);

    Meta createR4MetaPractitioner(JSONObject jsonObject);

    CodeableConcept createCodeableConcept(JSONObject jsonObject);

    Coding createCoding(JSONObject jsonObject);

    Identifier createIdentifier(JSONObject jsonObject);

    Period createPeriod(JSONObject jsonObject);

    Reference createReference(JSONObject jsonObject);

    Attachment createAttachment(JSONObject jsonObject);

    Media createR4Media(JSONObject jsonObject);

    List<Attachment> createAttachmentList(JSONArray jsonArray);

    List<Media> createR4MediaList(JSONArray jsonArray);

    List<Identifier> createIdentifierList(JSONArray jsonArray);

    List<Coding> createCodingList(JSONArray jsonArray);

    List<CodeableConcept> createCodeableConceptList(JSONArray jsonArray);

    List<Reference> createReferenceList(JSONArray jsonArray);

}
