package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.view.home.defaultdata.Properties;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface R4ServiceRequestRestService {

    @GET(Properties.RESOURCES_SERVICE_REQUEST + "/")
    Call<ResponseBody> getServiceRequestByPatientID(@Query(Properties.SP_PATIENT) String id);

}
