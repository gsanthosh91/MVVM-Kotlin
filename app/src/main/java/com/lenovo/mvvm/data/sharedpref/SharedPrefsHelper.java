package com.lenovo.mvvm.data.sharedpref;


import android.content.Context;
import android.content.SharedPreferences;

import com.lenovo.mvvm.BuildConfig;
import com.lenovo.mvvm.MVVMApplication;

import javax.inject.Inject;

import static android.content.Context.MODE_PRIVATE;


public class SharedPrefsHelper {
    SharedPreferences mSharedPreferences;
    public static final String MY_PREFS = BuildConfig.APPLICATION_ID;

 /*   public SharedPrefsHelper() {

    }*/


    @Inject
    public SharedPrefsHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
    }

    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }

    public boolean getLoggedInMode() {
        return mSharedPreferences.getBoolean("IS_LOGGED_IN", false);
    }

    public void setLoggedInMode(boolean loggedIn) {
        mSharedPreferences.edit().putBoolean("IS_LOGGED_IN", loggedIn).apply();
    }

    public void putString(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getString(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

}

