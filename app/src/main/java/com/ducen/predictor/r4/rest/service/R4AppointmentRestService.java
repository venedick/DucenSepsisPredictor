package com.ducen.predictor.r4.rest.service;

import com.ducen.predictor.view.home.defaultdata.Resources;
import com.ducen.predictor.view.home.defaultdata.SearchParameters;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface R4AppointmentRestService {

    @GET(Resources.RESOURCES_APPOINTMENT + "/")
    Observable<ResponseBody> getAppointmentByPractitioner(@Query(SearchParameters.COUNT) String resultCount, @Query(SearchParameters.PRACTITIONER) String id);

    @GET(Resources.RESOURCES_APPOINTMENT + "/")
    Observable<ResponseBody> getAppointmentByPatientId(@Query(SearchParameters.COUNT) String resultCount, @Query(SearchParameters.PATIENT) String id);

}

