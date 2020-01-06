package com.ducen.predictor.r4.webservice;

import android.content.Context;

import com.ducen.predictor.api.R4APIClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class R4PatientRestServiceImpl {

    private R4PatientRestService R4patientRestService;

    public R4PatientRestServiceImpl(Context context) {
        R4APIClient r4APIClient = new R4APIClient(context);
        this.R4patientRestService = r4APIClient.getClient().create(R4PatientRestService.class);
    }

    public Observable<ResponseBody> getPatientById(int resultCount, String practitioner) {
        return R4patientRestService.getPatientById(resultCount, practitioner)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ResponseBody> getPatientByName(int resultCount, String name) {
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
