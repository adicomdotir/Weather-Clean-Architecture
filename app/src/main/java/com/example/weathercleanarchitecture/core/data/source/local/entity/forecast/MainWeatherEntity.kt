package com.example.weathercleanarchitecture.core.data.source.local.entity.forecast

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "main_weather_entity")
data class MainWeatherEntity (

    @ColumnInfo(name = "temp")
    val temp : Double?,

    @ColumnInfo(name = "feels_like")
    val feelsLike : Double?,

    @ColumnInfo(name = "temp_min")
    val tempMin : Double?,

    @ColumnInfo(name = "temp_max")
    val tempMax: Double?,

    @ColumnInfo(name = "pressure")
    val pressure: Int?,

    @ColumnInfo(name = "sea_level")
    val seaLevel: Int?,

    @ColumnInfo(name = "groundLevel")
    val groundLevel: Int?,

    @ColumnInfo(name = "humidity")
    val humidity: Int?,

    @ColumnInfo(name = "temp_kf")
    val tempKf: Double?

)
