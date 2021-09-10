package com.example.carcom.service

import com.example.carcom.model.Car
import com.example.carcom.model.CarDetail
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/v1/listing")
    suspend fun getCars(
        @Query("sort") sort: Int,
        @Query("sortDirection") sortDirection: Int,
        @Query("minDate") minDate: String,
        @Query("maxDate") maxDate: String,
        @Query("minYear") minYear: Int,
        @Query("maxYear") maxYear: Int,
        @Query("skip") skip: Int,
        @Query("take") take: Int
    ): List<Car>

    @GET("api/v1/detail")
    suspend fun getCarDetail(@Query("id") id: Long): CarDetail
}