package com.ducen.predictor.r4.rest.service;

import com.ducen.predictor.view.home.defaultdata.Resources;
import com.ducen.predictor.view.home.defaultdata.SearchParameters;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface R4PatientRestService {

    @GET(Resources.RESOURCES_PATIENT + "/")
    Observable<ResponseBody> getPatientById(@Query(SearchParameters.COUNT) String resultCount, @Query(SearchParameters._ID) String id);

    @GET(Resources.RESOURCES_PATIENT + "/")
    Observable<ResponseBody> getPatientByName(@Query(SearchParameters.COUNT) String resultCount, @Query(SearchParameters.NAME) String name);

    @GET(Resources.RESOURCES_PATIENT + "/")
    Observable<ResponseBody> getAllPatient();


}
