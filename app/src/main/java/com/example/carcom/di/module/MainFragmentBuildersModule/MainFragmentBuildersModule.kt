package com.example.carcom.di.module.MainFragmentBuildersModule

import com.example.carcom.ui.CarDetailFragment
import com.example.carcom.ui.CarListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun carListFragment(): CarListFragment

    @ContributesAndroidInjector
    abstract fun carDetailFragment(): CarDetailFragment
}