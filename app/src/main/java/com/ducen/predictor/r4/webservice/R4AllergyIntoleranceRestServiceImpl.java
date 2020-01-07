package com.ducen.predictor.r4.webservice;


import android.content.Context;

import com.ducen.predictor.api.R4APIClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class R4AllergyIntoleranceRestServiceImpl {

    private R4AllergyIntoleranceRestService r4AllergyIntoleranceRestService;

    public R4AllergyIntoleranceRestServiceImpl(Context context) {
        R4APIClient r4APIClient = new R4APIClient(context);
        this.r4AllergyIntoleranceRestService = r4APIClient.getClient().create(R4AllergyIntoleranceRestService.class);
    }

    public Observable<ResponseBody> getAllergyIntoleranceByPatientID(int resultCount, String practitioner) {
        return r4AllergyIntoleranceRestService.getAllergyIntoleranceByPatientID(resultCount, practitioner)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
