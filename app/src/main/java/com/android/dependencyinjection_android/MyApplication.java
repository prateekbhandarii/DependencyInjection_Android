package com.android.dependencyinjection_android;

import android.app.Application;

import com.android.dependencyinjection_android.dagger.ApiModule;
import com.android.dependencyinjection_android.dagger.AppModule;
import com.android.dependencyinjection_android.retrofit.ApiComponent;
import com.android.dependencyinjection_android.retrofit.DaggerApiComponent;

public class MyApplication extends Application {

    private static final String BASE_URL = "https://simplifiedcoding.net/demos/";
    private ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        apiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule(BASE_URL)).build();

    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
