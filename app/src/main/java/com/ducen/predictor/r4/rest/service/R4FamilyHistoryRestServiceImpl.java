package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.r4.rest.api.R4APIClient;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class R4FamilyHistoryRestServiceImpl {

    R4FamilyHistoryRestService familyHistoryRestService = R4APIClient.getClient().create(R4FamilyHistoryRestService.class);

    //
    public Call<ResponseBody> getFamilyHistoryByPatientId(String id) {
        return familyHistoryRestService.getFamilyHistoryByPatientId(id);
    }

}
