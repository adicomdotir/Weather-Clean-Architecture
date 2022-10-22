package com.example.weathercleanarchitecture.feature.domain

import com.example.weathercleanarchitecture.base.attempt
import com.example.weathercleanarchitecture.feature.data.WeatherRepository
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend fun getWeather(city: String) = attempt {
        repository.getWeather(city)
    }
}