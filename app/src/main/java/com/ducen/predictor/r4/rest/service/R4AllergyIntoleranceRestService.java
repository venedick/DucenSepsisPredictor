package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.view.home.defaultdata.Properties;
import com.ducen.predictor.view.home.defaultdata.SearchParameters;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface R4AllergyIntoleranceRestService {

    @GET(Properties.RESOURCES_ALLERGY_INTOLERANCE + "/")
    Call<ResponseBody> getAllergyIntoleranceByPatientID(@Query(SearchParameters.PATIENT) String id);

}
