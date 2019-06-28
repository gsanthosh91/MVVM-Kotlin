package com.lenovo.mvvm.data;

import com.lenovo.mvvm.data.network.APIClient;
import com.lenovo.mvvm.data.network.ApiHelper;
import com.lenovo.mvvm.data.sharedpref.SharedPrefsHelper;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AppDataManager implements DataManageHelper {
    private SharedPrefsHelper mSharedPrefsHelper;
    private ApiHelper mApiClient;

    public AppDataManager(SharedPrefsHelper sharedPrefsHelper, APIClient apiClient) {
        mSharedPrefsHelper = sharedPrefsHelper;
        mApiClient = apiClient;
    }

    @Override
    public ApiHelper getApiHelper() {
        return mApiClient;
    }

    @Override
    public void clear() {
        mSharedPrefsHelper.clear();
    }

    @Override
    public void setLoggedIn() {
        mSharedPrefsHelper.setLoggedInMode(true);
    }

    @Override
    public Boolean getLoggedInMode() {
        return mSharedPrefsHelper.getLoggedInMode();
    }
}
