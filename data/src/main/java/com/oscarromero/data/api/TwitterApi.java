package com.oscarromero.data.api;

import com.oscarromero.data.dto.TwitterResponseDTO;
import com.oscarromero.data.dto.TwitterTokenDTO;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Oscar on 28/4/16.
 */
public interface TwitterApi {

    @FormUrlEncoded
    @POST("/oauth2/token")
    Observable<TwitterTokenDTO> getToken (@Header("Authorization") String authorization, @Field("grant_type") String grantType);

    @GET("/1.1/search/tweets.json")
    Observable<TwitterResponseDTO> doSearch(@Header("Authorization") String authorization, @Query("q") String query);
}