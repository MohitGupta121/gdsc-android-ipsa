package com.finite.gdscphcet.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

data class PastEvents(
    val title: String = "bruh",
    val date: String = "bruh",
    val time: String = "bruh",
    val mode: String = "bruh",
    val shortdesc: String = "bruh",
    val eventlink: String = "bruh",
    val posterlink: String = "bruh",
    val videolink: String = "bruh"
)

class EventDetailViewModel : ViewModel(){

}