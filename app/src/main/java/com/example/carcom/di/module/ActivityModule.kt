package com.example.carcom.di.module

import com.example.carcom.MainActivity
import com.example.carcom.di.module.MainFragmentBuildersModule.MainFragmentBuildersModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainFragmentBuildersModule::class])
    abstract fun contributeHomeActivity(): MainActivity
}