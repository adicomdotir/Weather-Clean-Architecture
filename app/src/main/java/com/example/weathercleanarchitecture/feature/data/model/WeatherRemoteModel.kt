package com.example.weathercleanarchitecture.feature.data.model

import com.google.gson.annotations.SerializedName

data class WeatherRemoteModel(
    @SerializedName("main")
    val mainList: WeatherMainRemoteModel
)