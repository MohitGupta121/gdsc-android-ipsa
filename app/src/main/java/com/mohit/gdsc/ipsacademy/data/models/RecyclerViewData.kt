package com.mohit.gdsc.ipsacademy

data class EventsDetails(
    val title: String,
    val Date: String,
    val ImageId: Int = 0,
    val Url:String
)
object FutureEventDetails {

    val EventsDetailsLists = listOf(
        EventsDetails(
            title = "No Upcoming Event",
            Date = "",
            ImageId = R.drawable.homeicon,
            Url = ""
        ) )
}