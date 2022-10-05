package com.mohit.gdsc.ipsacademy.ui.screens.homeScreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohit.gdsc.ipsacademy.data.models.PastEventModel

@Composable
fun HomeFragmentUI() {

    val mContext = LocalContext.current

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text(
            text = "Upcoming Events",
            style = TextStyle(
                fontSize = 22.sp
            ),
            modifier = Modifier.padding(5.dp)
        )
        FutureEventsDetailsDetailsContent()
        Text(
            text = "Past Events",
            style = TextStyle(
                fontSize = 22.sp
            ),
            modifier = Modifier.padding(5.dp)
        )
        PastEventsDetailsDetailsContent()

    }

}