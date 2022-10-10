package com.mohit.gdsc.ipsacademy.utils

import android.content.Context

fun loadContentsOfFile(context: Context, rawFileId: Int): String {
    return context.resources.openRawResource(rawFileId).bufferedReader().use { it.readText() }
}