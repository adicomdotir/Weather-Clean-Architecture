package com.example.weathercleanarchitecture.core.domain.model.forecast

import com.example.weathercleanarchitecture.core.domain.model.City

data class Forecast (

    val city: City?,
    val cnt: Int?,
    val cod: String?,
    val message: Double?,
    val list: List<ListForecast>?
)