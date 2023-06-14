package com.example.rxjava.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.rxjava.core.model.WeatherResponse
import com.example.rxjava.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainMVP.View {

    private  val presenter by lazy { MainPresenter(this) }
    private  val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter.getData()
    }

    override fun setData(data: WeatherResponse) {
//        binding.imageWeather.load(data.current.condition.icon)
    }

    override fun onProgress(data: Boolean) {
        TODO("Not yet implemented")
    }

    override fun setError(str: String) {
        TODO("Not yet implemented")
    }
}