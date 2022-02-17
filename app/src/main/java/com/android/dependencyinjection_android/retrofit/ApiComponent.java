package com.android.dependencyinjection_android.retrofit;

import com.android.dependencyinjection_android.activities.MainActivity;
import com.android.dependencyinjection_android.dagger.ApiModule;
import com.android.dependencyinjection_android.dagger.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(MainActivity activity);
}
