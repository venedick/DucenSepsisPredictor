package com.ducen.predictor.r4.webservice;


import com.ducen.predictor.defaultdata.Resources;
import com.ducen.predictor.defaultdata.SearchParameters;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface R4AppointmentRestService {

    @GET(Resources.RESOURCES_APPOINTMENT + "/")
    Observable<ResponseBody> getAppointmentByPractitioner(@Query(SearchParameters.SORT) String descendingDate, @Query(SearchParameters.COUNT) int resultCount, @Query(SearchParameters.PRACTITIONER) String id);

    @GET(Resources.RESOURCES_APPOINTMENT + "/")
    Observable<ResponseBody> getAppointmentByPatientId(@Query(SearchParameters.COUNT) int resultCount, @Query(SearchParameters.PATIENT) String id);

}

