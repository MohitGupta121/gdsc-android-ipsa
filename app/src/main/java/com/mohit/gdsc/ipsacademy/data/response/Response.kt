package com.mohit.gdsc.ipsacademy.data.response

import com.mohit.gdsc.ipsacademy.data.models.PastEventModel

data class Response(
    var pastEventItems: List<PastEventModel>? = null,
    var exception: Exception? = null
)