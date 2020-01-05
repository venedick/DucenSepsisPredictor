package com.ducen.predictor.r4.rest.service;

import com.ducen.predictor.r4.rest.api.R4APIClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class R4PractitionerRestServiceImpl {

    private R4PractitionerRestService R4practitionerRestInterface = R4APIClient.getClient().create(R4PractitionerRestService.class);

    public Observable<ResponseBody> getPractitionerById(String practitioner) {
        return R4practitionerRestInterface.getPractitionerById(practitioner)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ResponseBody> getPractitionerByIdAndEmail(String id, String email) {
        return R4practitionerRestInterface.getPractitionerByIdAndEmail(id, email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
