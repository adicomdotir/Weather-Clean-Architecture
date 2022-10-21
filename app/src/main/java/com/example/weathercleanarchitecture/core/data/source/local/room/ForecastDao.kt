package com.example.weathercleanarchitecture.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weathercleanarchitecture.core.data.source.local.entity.currentforecast.CurrentWeatherEntity
import com.example.weathercleanarchitecture.core.data.source.local.entity.forecast.ForecastEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ForecastDao {

    @Query("SELECT * FROM forecast_entity")
    fun getForecast(): Flow<ForecastEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecast(forecast: ForecastEntity)

    @Query("SELECT * FROM current_weather_entity")
    fun getCurrentForecast(): Flow<CurrentWeatherEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrentForecast(forecast: CurrentWeatherEntity)
}