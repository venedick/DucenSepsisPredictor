package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.r4.rest.api.R4APIClient;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class R4MedicationRequestRestServiceImpl {

    R4MedicationRequestRestService r4MedicationRequestRestService = R4APIClient.getClient().create(R4MedicationRequestRestService.class);

    //
    public Call<ResponseBody> getMedicationRequestByPatientID(String id) {
        return r4MedicationRequestRestService.getMedicationRequestByPatientID(id);
    }

}
