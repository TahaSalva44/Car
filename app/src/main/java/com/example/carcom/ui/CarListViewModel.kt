package com.example.carcom.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carcom.base.BaseViewModel
import com.example.carcom.model.Car
import com.example.carcom.service.helper.DataHolder
import kotlinx.coroutines.launch
import javax.inject.Inject

class CarListViewModel @Inject constructor(private val carListRepository: CarListRepository) :
    BaseViewModel() {

    val carList:MutableLiveData<List<Car>> = MutableLiveData()
        fun getCars(){
            viewModelScope.launch {
                val response = carListRepository.getCars(this@CarListViewModel)

                response.let {
                    if (it is DataHolder.Success){
                       carList.postValue(it.body)
                    }
                }
            }
        }

    fun getCarsMore(page:Int){
        viewModelScope.launch {
            val response = carListRepository.getCarsMore(page,this@CarListViewModel)

            response.let {
                if (it is DataHolder.Success){
                    carList.postValue(it.body)
                }
            }
        }
    }
}