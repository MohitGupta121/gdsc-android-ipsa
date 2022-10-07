package com.mohit.gdsc.ipsacademy.ui.screens.aboutScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ContentOfAboutUs() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        GoogleAnimation()
        CardViewContentAboutUs()
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            SocialMediaContent()
        }
        CardViewContentForJoinCommunity()
        TechnologyStackContent()
        EventsWeConduct()
        Spacer(modifier = Modifier.height(100.dp))
    }
}
