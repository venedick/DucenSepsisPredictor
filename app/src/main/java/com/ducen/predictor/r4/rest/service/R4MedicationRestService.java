package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.defaultdata.Properties;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface R4MedicationRestService {

    @GET(Properties.RESOURCES_MEDICATION + "/")
    Call<ResponseBody> getMedicationByPatientID(@Query(Properties.SP_PATIENT) String id);

}
