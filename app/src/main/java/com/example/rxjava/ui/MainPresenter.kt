package com.example.rxjava.ui


import com.example.rxjava.core.model.WeatherResponse
import com.example.rxjava.core.network.AppNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver


import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response


class MainPresenter(private val view: MainMVP.View): MainMVP.Presenter {

    private val service=AppNetwork.getWeatherService()

    override fun getData() {
      service.getWeather("c0d3041fd35e400390b104722231406","tashkent","ru")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<Response<WeatherResponse>>(){
                override fun onSuccess(response: Response<WeatherResponse>) {
                    if (response.isSuccessful){
                        view.setData(data = response.body()!!)
                    }else
                        view.setError(response.code().toString())
                }

                override fun onError(e: Throwable) {
                    view.setError(e.message.toString())                }

            })
    }

    override fun onStopVIew() {

    }
}