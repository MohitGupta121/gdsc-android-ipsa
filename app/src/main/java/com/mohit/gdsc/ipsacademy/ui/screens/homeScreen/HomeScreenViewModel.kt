package com.mohit.gdsc.ipsacademy.ui.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class HomeScreenViewModel(
    private val repository: HomeScreenRepository = HomeScreenRepository()
) : ViewModel() {

    val responseLiveData = liveData(Dispatchers.IO) {
        emit(repository.fetchPastEvents())
    }
}