package com.mohit.gdsc.ipsacademy.data.response

import com.mohit.gdsc.ipsacademy.data.models.PastEventModel
import com.mohit.gdsc.ipsacademy.data.models.UpcomingEventModel

data class Response(
    var pastEventItems: List<PastEventModel>? = null,
    var upcomingEventItems: List<UpcomingEventModel>? = null,
    var exception: Exception? = null
)
