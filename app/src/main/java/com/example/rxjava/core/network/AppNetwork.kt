package com.example.rxjava.core.network


import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.example.rxjava.core.App.App
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object AppNetwork {



    private fun getRetrofit():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://api.weatherapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client())
            .build()
    }

    private fun client()=OkHttpClient.Builder().addInterceptor(checkerInterceptor()).build()



   private fun chuckerCollector() = ChuckerCollector(
        context = App.instance!!,
        showNotification = true,
        retentionPeriod = RetentionManager.Period.ONE_HOUR
    )

    fun checkerInterceptor() = ChuckerInterceptor.Builder(App.instance!!)
        .collector(chuckerCollector())
        .maxContentLength(250_000L)
        .redactHeaders("Auth-Token", "Bearer")
        .alwaysReadResponseBody(true)
        .build()

    fun getWeatherService():WeatherService = getRetrofit().create(WeatherService::class.java)

}