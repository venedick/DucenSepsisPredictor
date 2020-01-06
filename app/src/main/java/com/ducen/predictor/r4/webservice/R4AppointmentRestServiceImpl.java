package com.ducen.predictor.r4.webservice;

import android.content.Context;


import com.ducen.predictor.api.R4APIClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class R4AppointmentRestServiceImpl {

    private R4AppointmentRestService r4AppointmentRestService;

    public R4AppointmentRestServiceImpl(Context context) {
        R4APIClient r4APIClient = new R4APIClient(context);
        this.r4AppointmentRestService = r4APIClient.getClient().create(R4AppointmentRestService.class);
    }

    public Observable<ResponseBody> getAppointmentByPractitioner(int resultCount, String practitioner) {
        String descending = "-date";
        return r4AppointmentRestService.getAppointmentByPractitioner(descending, resultCount, practitioner)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ResponseBody> getAppointmentByPatientId(int resultCount, String practitioner) {
        return r4AppointmentRestService.getAppointmentByPatientId(resultCount, practitioner)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
