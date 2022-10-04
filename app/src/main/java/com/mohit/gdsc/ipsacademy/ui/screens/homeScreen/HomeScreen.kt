package com.mohit.gdsc.ipsacademy

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun homeFragmentUI() {

    val mContext = LocalContext.current

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text(
            text = "Upcoming Events",
            style = TextStyle(
                fontSize = 22.sp
            ),
            modifier = Modifier.padding(5.dp)
        )
        PastEventsDetailsDetailsContent()
        Text(
            text = "Past Events",
            style = TextStyle(
                fontSize = 22.sp
            ),
            modifier = Modifier.padding(5.dp)
        )
        FutureEventsDetailsDetailsContent()

    }

}