package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.r4.rest.api.R4APIClient;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class R4MedicationDispenseRestServiceImpl {

    R4MedicationDispenseRestService r4MedicationDispenseRestService = R4APIClient.getClient().create(R4MedicationDispenseRestService.class);

    //
    public Call<ResponseBody> getMedicationDispenseByPatientID(String id) {
        return r4MedicationDispenseRestService.getMedicationDispenseByPatientID(id);
    }

}
