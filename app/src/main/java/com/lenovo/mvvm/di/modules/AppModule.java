package com.lenovo.mvvm.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.lenovo.mvvm.BuildConfig;
import com.lenovo.mvvm.MVVMApplication;
import com.lenovo.mvvm.data.AppDataManager;
import com.lenovo.mvvm.data.network.APIClient;
import com.lenovo.mvvm.data.network.APIInterface;
import com.lenovo.mvvm.data.network.ApiHelper;
import com.lenovo.mvvm.data.sharedpref.SharedPrefsHelper;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lenovo on 24-02-2018.
 */
@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    // Application reference must come from AppModule.class
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    APIInterface provideRetrofit() {
        return new Retrofit
                .Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(getHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(APIInterface.class);
    }

    private OkHttpClient getHttpClient() {
        return new OkHttpClient().newBuilder()
                .cache(new Cache(mApplication.getCacheDir(), 10 * 1024 * 1024)) // 10 MB
                .connectTimeout(10, TimeUnit.MINUTES)
                .readTimeout(10, TimeUnit.MINUTES)
                .writeTimeout(10, TimeUnit.MINUTES)
                .build();
    }
    @Provides
    @Singleton
     ApiHelper provideApiClient(){
        return new APIClient();
    }




    @Provides
    @Singleton
    SharedPrefsHelper sharedPrefsHelper(){
        return new SharedPrefsHelper(mApplication);
    }


    @Provides
    Context provideContext() {
        return mApplication;
    }



    @Provides
    @Singleton
     AppDataManager provideAppDataManager(APIClient apiClient,SharedPrefsHelper sharedPrefsHelper){
        return new AppDataManager(sharedPrefsHelper, apiClient);
    }
}
