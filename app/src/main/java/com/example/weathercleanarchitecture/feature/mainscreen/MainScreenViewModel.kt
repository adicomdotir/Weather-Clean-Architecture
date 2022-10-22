package com.example.weathercleanarchitecture.feature.mainscreen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.weathercleanarchitecture.base.BaseViewModel
import com.example.weathercleanarchitecture.base.Event
import com.example.weathercleanarchitecture.feature.domain.WeatherInteractor
import com.example.weathercleanarchitecture.feature.domain.WeatherModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val interactor: WeatherInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadWeather)
    }

    override fun initialViewState() = ViewState(
        city = " ",
        mainList = WeatherModel(
            temperature = "",
            temp_min = "",
            temp_max = "",
            pressure = "",
            humidity = ""
        ),
        weatherPointsShown = WeatherModel(
            temperature = "",
            temp_min = "",
            temp_max = "",
            pressure = "",
            humidity = ""
        ),
        hasErrorHappened = false,
        isLoading = false
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnButtonClicked -> {
                viewModelScope.launch {
                    interactor.getWeather(event.city).fold(
                        onError = {
                            Log.e("ERROR", it.localizedMessage as String)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnLoadCitiesSucceed(it))
                        }
                    )
                }
                return null
            }

            is DataEvent.OnLoadCitiesSucceed -> {
                return previousState.copy(
                    mainList = event.main,
                    weatherPointsShown = event.main
                )
            }

            is DataEvent.OnLoadCitiesFailed -> {
                return previousState.copy(
                    weatherPointsShown = WeatherModel(
                        temperature = "",
                        temp_min = "",
                        temp_max = "",
                        pressure = "",
                        humidity = ""
                    ),
                    hasErrorHappened = true
                )
            }
            else -> return null
        }
    }
}