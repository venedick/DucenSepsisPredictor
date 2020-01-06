package com.ducen.predictor.r4.rest.service;

import android.content.Context;
import android.util.Log;

import com.ducen.predictor.r4.rest.api.R4APIClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class R4PractitionerRestServiceImpl {

    private R4PractitionerRestService R4practitionerRestInterface;

    public R4PractitionerRestServiceImpl(Context context) {
        R4APIClient r4APIClient = new R4APIClient(context);
        this.R4practitionerRestInterface = r4APIClient.getClient().create(R4PractitionerRestService.class);
    }

    public R4PractitionerRestServiceImpl(Context context, String serverAddressFromSession) {
        Log.d("TEST", "R4PractitionerRestServiceImpl Server Address is null : " + serverAddressFromSession);

        R4APIClient r4APIClient = new R4APIClient(context, serverAddressFromSession);

        this.R4practitionerRestInterface = r4APIClient.getClient().create(R4PractitionerRestService.class);
    }

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
