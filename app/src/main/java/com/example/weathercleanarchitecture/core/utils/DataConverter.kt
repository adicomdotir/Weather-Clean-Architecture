package com.example.weathercleanarchitecture.core.utils

import androidx.room.TypeConverter
import com.example.weathercleanarchitecture.core.data.source.local.entity.forecast.ListForecastEntity

object DataConverter {

    @TypeConverter
    @JvmStatic
    fun stringToList(data: String?): List<ListForecastEntity>? {
        if (data == null) {
            return emptyList()
        }

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val type = Types.newParameterizedType(List::class.java, ListForecastEntity::class.java)
        val adapter = moshi.adapter<List<ListForecastEntity>>(type)

        return adapter.fromJson(data)
    }

    @TypeConverter
    @JvmStatic
    fun listToString(objects: List<ListForecastEntity>): String {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val type = Types.newParameterizedType(List::class.java, ListForecastEntity::class.java)
        val adapter = moshi.adapter<List<ListForecastEntity>>(type)

        return adapter.toJson(objects)
    }

    @TypeConverter
    @JvmStatic
    fun weatherStringToList(data: String?): List<WeatherItemEntity>? {
        if (data == null) {
            return emptyList()
        }

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val type = Types.newParameterizedType(List::class.java, WeatherItemEntity::class.java)
        val adapter = moshi.adapter<List<WeatherItemEntity>>(type)

        return adapter.fromJson(data)
    }

    @TypeConverter
    @JvmStatic
    fun weatherListToString(objects: List<WeatherItemEntity>): String {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val type = Types.newParameterizedType(List::class.java, WeatherItemEntity::class.java)
        val adapter = moshi.adapter<List<WeatherItemEntity>>(type)

        return adapter.toJson(objects)
    }

}