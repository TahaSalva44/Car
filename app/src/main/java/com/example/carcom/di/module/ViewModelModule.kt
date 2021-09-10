package com.example.carcom.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.carcom.base.ViewModelFactory
import com.example.carcom.di.qualifiers.ViewModelKey
import com.example.carcom.ui.CarDetailViewModel
import com.example.carcom.ui.CarListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(CarListViewModel::class)
    abstract fun carListBindViewModel(carListViewModel: CarListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CarDetailViewModel::class)
    abstract fun carDetailBindViewModel(carDetailViewModel: CarDetailViewModel): ViewModel

}