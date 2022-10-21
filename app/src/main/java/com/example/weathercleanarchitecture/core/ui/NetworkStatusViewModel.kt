package com.example.weathercleanarchitecture.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.weathercleanarchitecture.core.utils.networkstatus.NetworkState
import com.example.weathercleanarchitecture.core.utils.networkstatus.NetworkStatusTracker
import com.example.weathercleanarchitecture.core.utils.networkstatus.map
import kotlinx.coroutines.Dispatchers

class NetworkStatusViewModel(
    networkStatusTracker: NetworkStatusTracker,
) : ViewModel() {

    val state =
        networkStatusTracker.networkStatus
            .map(
                onUnavailable = { NetworkState.Error },
                onAvailable = { NetworkState.Fetched },
            )
            .asLiveData(Dispatchers.IO)
}