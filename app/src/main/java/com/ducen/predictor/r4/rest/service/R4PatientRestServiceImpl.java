package com.ducen.predictor.r4.rest.service;

import com.ducen.predictor.r4.rest.api.R4APIClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class R4PatientRestServiceImpl {

    private R4PatientRestService R4patientRestService = R4APIClient.getClient().create(R4PatientRestService.class);

    public Observable<ResponseBody> getPatientById(String practitioner) {
        String resultCount = "1";
        return R4patientRestService.getPatientById(resultCount, practitioner)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ResponseBody> getPatientByName(String resultCount, String name) {
        return R4patientRestService.getPatientByName(resultCount, name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ResponseBody> getAllPatient(){
        return  R4patientRestService.getAllPatient()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
