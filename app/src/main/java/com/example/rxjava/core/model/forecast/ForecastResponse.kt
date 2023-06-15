package com.example.rxjava.core.model.forecast

data class ForecastResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)