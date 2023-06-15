package com.example.rxjava.core.network

import com.example.rxjava.core.model.home.WeatherResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {


    @GET("v1/current.json")
    fun getWeather(@Query("key") key:String,
                   @Query("q") location:String,
                   @Query("lang") lang:String): Single<Response<WeatherResponse>>
}