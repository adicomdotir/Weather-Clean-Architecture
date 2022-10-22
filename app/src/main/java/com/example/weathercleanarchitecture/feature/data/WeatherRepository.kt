package com.example.weathercleanarchitecture.feature.data

import com.example.weathercleanarchitecture.feature.domain.WeatherModel

interface WeatherRepository {
    suspend fun getWeather(city: String): WeatherModel
}