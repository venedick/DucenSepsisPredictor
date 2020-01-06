package com.ducen.predictor.r4.webservice;


import com.ducen.predictor.defaultdata.Resources;
import com.ducen.predictor.defaultdata.SearchParameters;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface R4ConditionRestService {

    @GET(Resources.RESOURCES_CONDITION + "/")
    Observable<ResponseBody> getConditionByPatientId(@Query(SearchParameters.COUNT) int resultCount, @Query(SearchParameters._ID) String id);

}
