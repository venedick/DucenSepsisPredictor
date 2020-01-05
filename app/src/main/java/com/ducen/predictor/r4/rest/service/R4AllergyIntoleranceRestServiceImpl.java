package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.r4.rest.api.R4APIClient;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class R4AllergyIntoleranceRestServiceImpl {

    R4AllergyIntoleranceRestService r4AllergyIntoleranceRestService = R4APIClient.getClient().create(R4AllergyIntoleranceRestService.class);

    //
    public Call<ResponseBody> getAllergyIntoleranceByPatientID(String id) {
        return r4AllergyIntoleranceRestService.getAllergyIntoleranceByPatientID(id);
    }

}
