package com.example.carcom.ui

import com.example.carcom.model.Car
import com.example.carcom.model.CarDetail
import com.example.carcom.service.ApiService
import com.example.carcom.service.INetworkResponseHandling
import com.example.carcom.service.helper.DataHolder
import com.example.carcom.service.helper.RequestHelper
import javax.inject.Inject

class CarDetailRepository@Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getCarDetail(id:Long,iNetworkResponseHandling: INetworkResponseHandling): DataHolder<CarDetail>? {
        return object :RequestHelper<CarDetail>(){
            override suspend fun createNetworkRequest(): CarDetail {
                return apiService.getCarDetail(id)
            }

        }.loadRequest(iNetworkResponseHandling,true)
    }
}