package com.example.weathercleanarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.SaveUserNameParam
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
): ViewModel() {
    private val resultMutableLiveData = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = resultMutableLiveData

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData = saveUserNameUseCase.execute(params)
        resultMutableLiveData.value = "Save result = $resultData"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        resultMutableLiveData.value = "${userName.firstName} ${userName.lastName}"
    }
}
