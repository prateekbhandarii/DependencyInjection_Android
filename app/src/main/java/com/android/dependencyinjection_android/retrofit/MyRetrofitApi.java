package com.android.dependencyinjection_android.retrofit;

import com.android.dependencyinjection_android.data.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyRetrofitApi {

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel/")
    Call<List<Hero>> getHeroes();
}
