package com.android.dependencyinjection_android.helpers;

import com.android.dependencyinjection_android.MyRetrofitApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static RetrofitHelper mRetrofitHelper = null;
    private MyRetrofitApi api;

    private RetrofitHelper() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(MyRetrofitApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        api = retrofit.create(MyRetrofitApi.class);
    }

    public static synchronized RetrofitHelper getInstance() {
        if (mRetrofitHelper == null)
            mRetrofitHelper = new RetrofitHelper();
        return mRetrofitHelper;
    }

    public MyRetrofitApi getApi(){
        return api;
    }
}
