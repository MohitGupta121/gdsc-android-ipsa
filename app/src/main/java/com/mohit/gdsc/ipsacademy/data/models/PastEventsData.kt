package com.mohit.gdsc.ipsacademy.data.models

data class PastEventModel(
    val date: String? = "",
    val eventId: String? = "",
    val eventLink: String? = "",
    val mode: String? = "",
    val posterLink: String? = "",
    val shortDesc: String? = "",
    val thumbnailLink: String? = "",
    val time: String? = "",
    val title: String? = "",
    val videoLink: String? = ""
)

object PastEventDetails {
    var EventsDetailsLists: ArrayList<PastEventModel> = arrayListOf()
}