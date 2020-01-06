package com.ducen.predictor.r4.webservice;


import android.content.Context;

import com.ducen.predictor.api.R4APIClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class R4ConditionRestServiceImpl {

    R4ConditionRestService r4ConditionRestService;

    public R4ConditionRestServiceImpl(Context context) {
        R4APIClient r4APIClient = new R4APIClient(context);
        this.r4ConditionRestService = r4APIClient.getClient().create(R4ConditionRestService.class);
    }

    public Observable<ResponseBody> getConditionByPatientId(int resultCount, String patientId) {
        return r4ConditionRestService.getConditionByPatientId(resultCount, patientId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
