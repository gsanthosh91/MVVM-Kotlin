package com.lenovo.mvvm.di.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    public Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }
}
