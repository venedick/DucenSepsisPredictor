package com.ducen.predictor.r4.rest.service;

import com.ducen.predictor.view.home.defaultdata.Properties;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface R4ObservationRestService {

    @GET(Properties.RESOURCES_OBSERVATION + "/")
    Call<ResponseBody> getObservationByPatientID(@Query(Properties.SP_PATIENT) String id);

}
