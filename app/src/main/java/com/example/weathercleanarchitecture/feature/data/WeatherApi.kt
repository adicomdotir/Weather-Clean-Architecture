package com.example.weathercleanarchitecture.feature.data

import com.example.weathercleanarchitecture.base.Constant.API_KEY
import com.example.weathercleanarchitecture.feature.data.model.WeatherRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("appid") apiKey: String = API_KEY,
        @Query("units") units: String = "metric"
    ): WeatherRemoteModel
}