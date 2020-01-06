package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.r4.rest.api.R4APIClient;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class R4MedicationRestServiceImpl {

    R4MedicationRestService r4MedicationRestService = R4APIClient.getClient().create(R4MedicationRestService.class);

    public Call<ResponseBody> getMedicationAdministrationByPatientId(String id) {
        return r4MedicationRestService.getMedicationByPatientID(id);
    }

}