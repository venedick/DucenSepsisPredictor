package com.ducen.predictor.r4.webservice;

import com.ducen.predictor.defaultdata.Properties;
import com.ducen.predictor.defaultdata.SearchParameters;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface R4AllergyIntoleranceRestService {

    @GET(Properties.RESOURCES_ALLERGY_INTOLERANCE + "/")
    Observable<ResponseBody> getAllergyIntoleranceByPatientID(@Query(SearchParameters.COUNT) int resultCount, @Query(SearchParameters.PATIENT) String id);

}
