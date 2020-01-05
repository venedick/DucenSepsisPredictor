package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.defaultdata.Properties;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface R4MedicationStatementRestService {

    @GET(Properties.RESOURCES_MEDICATION_STATEMENT + "/")
    Call<ResponseBody> getMedicationStatementByPatientID(@Query(Properties.SP_PATIENT) String id);

}
