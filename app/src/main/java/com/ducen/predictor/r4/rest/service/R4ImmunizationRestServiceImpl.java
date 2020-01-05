package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.r4.rest.api.R4APIClient;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class R4ImmunizationRestServiceImpl {

    R4ImmunizationRestService r4ImmunizationRestService = R4APIClient.getClient().create(R4ImmunizationRestService.class);

    public Call<ResponseBody> getImmunizationByPatientID(String id) {
        return r4ImmunizationRestService.getImmunizationByPatientID(id);
    }

}
