package com.example.carcom.di.module

import android.app.Application
import android.content.Context
import com.example.carcom.BuildConfig
import com.example.carcom.di.qualifiers.BaseUrlQualifier
import com.example.carcom.di.scope.AppScope
import dagger.Module
import dagger.Provides


@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @AppScope
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @AppScope
    @BaseUrlQualifier
    fun provideBaseUrl(): String {
        return BuildConfig.BASE_URL
    }

}