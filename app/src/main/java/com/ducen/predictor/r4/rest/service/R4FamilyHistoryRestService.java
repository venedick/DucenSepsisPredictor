package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.view.home.defaultdata.Properties;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface R4FamilyHistoryRestService {

    @GET(Properties.RESOURCES_FAMILY_HISTORY + "/")
    Call<ResponseBody> getFamilyHistoryByPatientId(@Query(Properties.SP_PATIENT) String id);

}