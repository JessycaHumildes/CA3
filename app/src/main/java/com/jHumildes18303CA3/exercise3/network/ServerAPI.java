package com.jHumildes18303CA3.exercise3.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ServerAPI {

    @GET("weather/daily/53.3239919/-6.5258808/7/")
    Call<List<ResponseDaily>> getDailyWeather();

    @GET("warnings/types/")
    Call<List<String>> getWarningTypes();


    @GET("warnings/regions/")
    Call<List<String>> getWarningRegions();
}
