package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.r4.rest.api.R4APIClient;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class R4EncounterRestServiceImpl {

    R4EncounterRestService r4EncounterRestService = R4APIClient.getClient().create(R4EncounterRestService.class);

    public Call<ResponseBody> getEncounterByPatientId(String id) {
        return r4EncounterRestService.getEncounterByPatientId(id);
    }

}
