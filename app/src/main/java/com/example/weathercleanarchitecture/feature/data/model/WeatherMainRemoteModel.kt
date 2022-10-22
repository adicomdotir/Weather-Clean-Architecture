package com.example.weathercleanarchitecture.feature.data.model

import com.google.gson.annotations.SerializedName

data class WeatherMainRemoteModel(
    @SerializedName("temp")
    val temperature: String,
    @SerializedName("temp_min")
    val temp_min: String,
    @SerializedName("temp_max")
    val temp_max: String,
    @SerializedName("pressure")
    val pressure: String,
    @SerializedName("humidity")
    val humidity: String
)