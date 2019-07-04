package com.lenovo.mvvm.di.Components;

import android.content.Context;

import com.lenovo.mvvm.data.sharedpref.SharedPrefsHelper;
import com.lenovo.mvvm.di.modules.AppModule;
import com.lenovo.mvvm.ui.EmployeesActivity;
import com.lenovo.mvvm.ui.register.RegisterActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Lenovo on 24-02-2018.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Context context();

    void inject(EmployeesActivity employeesActivity);
    void inject(RegisterActivity registerActivity);
}


