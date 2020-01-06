package com.ducen.predictor.r4.webservice;


import com.ducen.predictor.defaultdata.Properties;
import com.ducen.predictor.defaultdata.SearchParameters;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface R4AllergyIntoleranceRestService {

    @GET(Properties.RESOURCES_ALLERGY_INTOLERANCE + "/")
    Call<ResponseBody> getAllergyIntoleranceByPatientID(@Query(SearchParameters.PATIENT) String id);

}
