package com.example.weathercleanarchitecture.feature.data

import com.example.weathercleanarchitecture.feature.data.model.WeatherRemoteModel
import com.example.weathercleanarchitecture.feature.domain.WeatherModel

fun WeatherRemoteModel.toDomain() = WeatherModel(
    temperature = this.mainList.temperature,
    temp_min = this.mainList.temp_min,
    temp_max = this.mainList.temp_max,
    pressure = this.mainList.pressure,
    humidity = this.mainList.humidity,
)