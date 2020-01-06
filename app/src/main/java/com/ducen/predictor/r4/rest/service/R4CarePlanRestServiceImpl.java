package com.ducen.predictor.r4.rest.service;

import android.content.Context;

import com.ducen.predictor.r4.rest.api.R4APIClient;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class R4CarePlanRestServiceImpl {

    R4CarePlanRestService r4CarePlanRestService;

    public R4CarePlanRestServiceImpl(Context context) {
        R4APIClient r4APIClient = new R4APIClient(context);
        this.r4CarePlanRestService = r4APIClient.getClient().create(R4CarePlanRestService.class);
    }

    //
    public Call<ResponseBody> getCarePlanByPatientId(String id) {
        return r4CarePlanRestService.getCarePlanByPatientId(id);
    }

}
