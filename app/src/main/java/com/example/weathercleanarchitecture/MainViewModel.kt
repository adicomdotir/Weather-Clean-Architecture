package com.example.weathercleanarchitecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.weathercleanarchitecture.core.domain.usecase.WeatherUseCase
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCase
): ViewModel() {
    fun forecast(lat: Double, lon: Double) = weatherUseCase.getForecast(lat, lon).asLiveData()

    fun currentForecast(lat: Double, lon: Double) = weatherUseCase.getCurrentForecast(lat, lon).asLiveData()
}