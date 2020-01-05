package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.defaultdata.Properties;
import com.ducen.predictor.defaultdata.SearchParameters;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface R4CarePlanRestService {

    @GET(Properties.RESOURCES_CARE_PLAN + "/")
    Call<ResponseBody> getCarePlanByPatientId(@Query(SearchParameters.PATIENT) String id);

}
