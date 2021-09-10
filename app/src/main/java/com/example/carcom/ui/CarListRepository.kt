package com.example.carcom.ui

import com.example.carcom.model.Car
import com.example.carcom.service.ApiService
import com.example.carcom.service.INetworkResponseHandling
import com.example.carcom.service.helper.DataHolder
import com.example.carcom.service.helper.RequestHelper
import com.example.carcom.util.DefaultCarUtil
import javax.inject.Inject

class CarListRepository@Inject constructor(
    private val apiService: ApiService
) {
    var sort = DefaultCarUtil.sort
    var filter = DefaultCarUtil.filter
    suspend fun getCars(iNetworkResponseHandling: INetworkResponseHandling): DataHolder<List<Car>>? {
        return object :RequestHelper<List<Car>>(){
            override suspend fun createNetworkRequest(): List<Car> {
                return apiService.getCars(sort.sort,sort.sortDirection,filter.minDate,filter.maxDate,filter.minYear,filter.maxYear,0,20)
            }

        }.loadRequest(iNetworkResponseHandling,true)
    }

    suspend fun getCarsMore(page:Int,iNetworkResponseHandling: INetworkResponseHandling): DataHolder<List<Car>>? {
        return object :RequestHelper<List<Car>>(){
            override suspend fun createNetworkRequest(): List<Car> {
                return apiService.getCars(sort.sort,sort.sortDirection,filter.minDate,filter.maxDate,filter.minYear,filter.maxYear,0,page)
            }

        }.loadRequest(iNetworkResponseHandling,true)
    }


}