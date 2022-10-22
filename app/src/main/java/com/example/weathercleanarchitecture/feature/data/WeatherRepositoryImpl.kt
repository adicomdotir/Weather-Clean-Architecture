package com.example.weathercleanarchitecture.feature.data

import com.example.weathercleanarchitecture.feature.domain.WeatherModel
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val source: WeatherRemoteSource
): WeatherRepository {
    override suspend fun getWeather(city: String): WeatherModel {
        return source.getWeather(city).toDomain()
    }
}