package com.example.weathercleanarchitecture.feature.mainscreen

import com.example.weathercleanarchitecture.base.Event
import com.example.weathercleanarchitecture.feature.domain.WeatherModel

data class ViewState(
    val city: String,
    val mainList: WeatherModel,
    val weatherPointsShown: WeatherModel,
    val hasErrorHappened: Boolean,
    val isLoading: Boolean
)

sealed class UiEvent : Event {
    data class OnButtonClicked(val city: String) : UiEvent()
    data class OnWeatherPointClicked(val index: WeatherModel) : UiEvent()
}

sealed class DataEvent : Event {
    object LoadWeather : DataEvent()
    data class OnLoadCitiesSucceed(val main: WeatherModel) : DataEvent()
    object OnLoadCitiesFailed : DataEvent()
}
