package com.example.weathercleanarchitecture.feature.data

import com.example.weathercleanarchitecture.feature.data.model.WeatherRemoteModel
import javax.inject.Inject

class WeatherRemoteSource @Inject constructor(val api: WeatherApi) {
    suspend fun getWeather(city: String): WeatherRemoteModel {
        return api.getWeather(city)
    }
}