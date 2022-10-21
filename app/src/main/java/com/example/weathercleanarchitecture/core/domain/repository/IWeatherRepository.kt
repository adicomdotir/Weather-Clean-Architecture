package com.example.weathercleanarchitecture.core.domain.repository

import com.example.weathercleanarchitecture.core.data.Resource
import com.example.weathercleanarchitecture.core.domain.model.currentforecast.CurrentWeather
import com.example.weathercleanarchitecture.core.domain.model.forecast.Forecast
import kotlinx.coroutines.flow.Flow

interface IWeatherRepository {

    fun getForecast(lat: Double, lon: Double): Flow<Resource<Forecast>>

    fun getCurrentForecast(lat: Double, lon: Double): Flow<Resource<CurrentWeather>>
}