package com.ducen.predictor.r4.rest.service;


import com.ducen.predictor.defaultdata.Properties;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface R4PractitionerRestService {

    @GET(Properties.RESOURCES_PRACTITIONER + "/{id}")
    Observable<ResponseBody> getPractitionerById(@Path("id") String id);

    @GET(Properties.RESOURCES_PRACTITIONER + "/")
    Observable<ResponseBody> getPractitionerByIdAndEmail(@Query(Properties.SP_ID) String id, @Query(Properties.SP_EMAIL) String email);

}