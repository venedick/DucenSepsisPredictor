package com.ducen.predictor.r4.webservice;



import com.ducen.predictor.defaultdata.Resources;
import com.ducen.predictor.defaultdata.SearchParameters;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface R4PractitionerRestService {

    @GET(Resources.RESOURCES_PRACTITIONER + "/{id}")
    Observable<ResponseBody> getPractitionerById(@Path("id") String id);

    @GET(Resources.RESOURCES_PRACTITIONER + "/")
    Observable<ResponseBody> getPractitionerByIdAndEmail(@Query(SearchParameters._ID) String id, @Query(SearchParameters.EMAIL) String email);

}