package com.mohit.gdsc.ipsacademy.ui.screens.homeScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mohit.gdsc.ipsacademy.data.response.FirebaseCallback
import com.mohit.gdsc.ipsacademy.data.response.Response
import kotlinx.coroutines.Dispatchers

class HomeScreenViewModel(
    private val repository: HomeScreenRepository = HomeScreenRepository()
) : ViewModel() {

    fun getResponseUsingCallback(callback: FirebaseCallback) {
        repository.getResponseUsingCallback(callback)
    }

    fun getResponseUsingLiveData() : LiveData<Response> {
        return repository.getResponseUsingLiveData()
    }

    //Using Courtines
    val responseLiveData = liveData(Dispatchers.IO) {
        emit(repository.fetchPastEvents())
    }
}