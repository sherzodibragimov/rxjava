package com.example.rxjava.ui

import com.example.rxjava.core.model.WeatherResponse

interface MainMVP {

interface View{
        fun setData(data:WeatherResponse)
        fun onProgress(data:Boolean)
        fun setError(str:String)
}

interface Presenter{
        fun getData()
        fun onStopVIew()
    }


}