package com.mohit.gdsc.ipsacademy.ui.screens.homeScreen

import com.google.firebase.database.*
import com.mohit.gdsc.ipsacademy.data.models.PastEventModel
import com.mohit.gdsc.ipsacademy.data.models.UpcomingEventModel
import com.mohit.gdsc.ipsacademy.data.response.Response
import com.mohit.gdsc.ipsacademy.utils.Constants.PAST_EVENTS_REF
import com.mohit.gdsc.ipsacademy.utils.Constants.UPCOMING_EVENTS_REF
import kotlinx.coroutines.tasks.await

class HomeScreenRepository(
    private val dbRef: DatabaseReference = FirebaseDatabase.getInstance().reference,
    private val pastEventsRef: DatabaseReference = dbRef.child(PAST_EVENTS_REF),
    private val upcomingEventsRef: DatabaseReference = dbRef.child(UPCOMING_EVENTS_REF)
) {

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

    suspend fun fetchUpcomingEvents(): Response {
        val response = Response()
        try {
            response.upcomingEventItems = upcomingEventsRef.get().await().children.map { snapShot ->
                snapShot.getValue(UpcomingEventModel::class.java)!!
            }
        } catch (exception: Exception) {
            response.exception = exception
        }
        return response
    }

}