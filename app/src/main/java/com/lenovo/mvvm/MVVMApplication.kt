package com.lenovo.mvvm

import android.app.Application
import android.content.Context

import com.lenovo.mvvm.di.Components.AppComponent
import com.lenovo.mvvm.di.Components.DaggerAppComponent
import com.lenovo.mvvm.di.modules.AppModule

/**
 * Created by Lenovo on 24-02-2018.
 */

class MVVMApplication : Application() {
    internal lateinit var context: Context

    override fun onCreate() {
        super.onCreate()
        context = this
        if (component == null)
            component = DaggerAppComponent.builder()
                    .appModule(AppModule(this))
                    .build()
    }

    companion object {

        var component: AppComponent? = null
            internal set
    }
}
