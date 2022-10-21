package com.example.weathercleanarchitecture.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weathercleanarchitecture.core.data.source.local.entity.currentforecast.CurrentWeatherEntity
import com.example.weathercleanarchitecture.core.data.source.local.entity.forecast.ForecastEntity

@Database(
    entities = [ForecastEntity::class, CurrentWeatherEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DataConverter::class)
abstract class ForecastDatabase: RoomDatabase() {

    abstract fun forecastDao(): ForecastDao

}