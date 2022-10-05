package com.mohit.gdsc.ipsacademy.ui.screens.homeScreen

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.mohit.gdsc.ipsacademy.data.models.PastEventModel
import com.mohit.gdsc.ipsacademy.data.response.FirebaseCallback
import com.mohit.gdsc.ipsacademy.data.response.Response
import com.mohit.gdsc.ipsacademy.utils.Constants.PAST_EVENTS_REF
import kotlinx.coroutines.tasks.await

class HomeScreenRepository(
    private val dbRef: DatabaseReference = FirebaseDatabase.getInstance().reference,
    private val pastEventsRef: DatabaseReference = dbRef.child(PAST_EVENTS_REF)
) {

    //Using CallBacks
    fun getResponseUsingCallback(callback: FirebaseCallback) {
        pastEventsRef.get().addOnCompleteListener { task ->
            val response = Response()
            if (task.isSuccessful) {
                val result = task.result
                result?.let {
                    response.pastEventItems = result.children.map { snapShot ->
                        snapShot.getValue(PastEventModel::class.java)!!
                    }
                }
            } else {
                response.exception = task.exception
            }
            callback.onResponse(response)
        }
    }

    //Using LiveData
    fun getResponseUsingLiveData() : MutableLiveData<Response> {
        val mutableLiveData = MutableLiveData<Response>()
        pastEventsRef.get().addOnCompleteListener { task ->
            val response = Response()
            if (task.isSuccessful) {
                val result = task.result
                result?.let {
                    response.pastEventItems = result.children.map { snapShot ->
                        snapShot.getValue(PastEventModel::class.java)!!
                    }
                }
            } else {
                response.exception = task.exception
            }
            mutableLiveData.value = response
        }
        return mutableLiveData
    }

    // Using Courtines
    suspend fun fetchPastEvents(): Response {
        val response = Response()
        try {
            response.pastEventItems = pastEventsRef.get().await().children.map { snapShot ->
                snapShot.getValue(PastEventModel::class.java)!!
            }
        } catch (exception: Exception) {
            response.exception = exception
        }
        return response
    }

}