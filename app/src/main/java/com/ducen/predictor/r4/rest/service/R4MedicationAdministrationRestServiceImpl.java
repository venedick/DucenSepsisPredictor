package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.r4.rest.api.R4APIClient;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class R4MedicationAdministrationRestServiceImpl {

    R4MedicationAdministrationRestService medicationAdministrationRestService = R4APIClient.getClient().create(R4MedicationAdministrationRestService.class);

    public Call<ResponseBody> getMedicationAdministrationByPatientId(String id) {
        return medicationAdministrationRestService.getMedicationAdministrationByPatientId(id);
    }


}
