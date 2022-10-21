package com.example.weathercleanarchitecture.core.domain.model.currentforecast

import com.example.weathercleanarchitecture.core.data.source.remote.response.forecast.WeatherItemResponse
import com.example.weathercleanarchitecture.core.domain.model.*
import com.example.weathercleanarchitecture.core.domain.model.forecast.MainWeather
import com.example.weathercleanarchitecture.core.domain.model.forecast.WeatherItem

data class CurrentWeather(

    val id: Int?,
    val cod: Int?,
    val base: String?,
    val name: String?,
    val visibility: String?,
    val coord: Coord?,
    val date: Int?,
    val timezone: Int?,
    val main: MainWeather?,
    val wind: Wind?,
    val clouds: Clouds?,
    val rain: Rain?,
    val weather: List<WeatherItem>?,
    val sys: CurrentWeatherSys?
)
