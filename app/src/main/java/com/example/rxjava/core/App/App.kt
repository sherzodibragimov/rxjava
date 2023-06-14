package com.example.rxjava.core.App

import android.app.Application

class App:Application() {
    companion object{
        var instance:Application?=null
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
    }
}