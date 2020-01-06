package com.ducen.predictor.r4.rest.service;

import com.ducen.predictor.r4.rest.api.R4APIClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class R4AppointmentRestServiceImpl {

    private R4AppointmentRestService r4AppointmentRestService = R4APIClient.getClient().create(R4AppointmentRestService.class);

    public Observable<ResponseBody> getAppointmentByPractitioner(int resultCount, String practitioner) {
        return r4AppointmentRestService.getAppointmentByPractitioner(resultCount, practitioner)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ResponseBody> getAppointmentByPatientId(int resultCount, String practitioner) {
        return r4AppointmentRestService.getAppointmentByPatientId(resultCount, practitioner)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
