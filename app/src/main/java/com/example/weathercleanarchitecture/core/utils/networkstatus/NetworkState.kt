package com.example.weathercleanarchitecture.core.utils.networkstatus

sealed class NetworkState {
    object Fetched : NetworkState()
    object Error : NetworkState()
}