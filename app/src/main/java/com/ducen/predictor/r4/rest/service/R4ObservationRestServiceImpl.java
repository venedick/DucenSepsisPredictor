package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.r4.rest.api.R4APIClient;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class R4ObservationRestServiceImpl {

    R4ObservationRestService r4ObservationRestService = R4APIClient.getClient().create(R4ObservationRestService.class);

    //
    public Call<ResponseBody> getObservationByPatientID(String id) {
        return r4ObservationRestService.getObservationByPatientID(id);
    }

}
