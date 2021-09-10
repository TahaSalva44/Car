package com.example.carcom.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carcom.base.BaseViewModel
import com.example.carcom.model.CarDetail
import com.example.carcom.service.helper.DataHolder
import kotlinx.coroutines.launch
import javax.inject.Inject

class CarDetailViewModel  @Inject constructor(private val carDetailListRepository: CarDetailRepository) :
    BaseViewModel() {

    var carDetail:MutableLiveData<CarDetail> = MutableLiveData()

        fun getCarDetail(id:Long?){
            viewModelScope.launch {
                val response = id?.let { carDetailListRepository.getCarDetail(it,this@CarDetailViewModel) }

                response.let {
                    if (it is DataHolder.Success){
                        carDetail.postValue(it.body)
                    }
                }
            }
        }

}