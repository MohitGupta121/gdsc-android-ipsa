package com.mohit.gdsc.ipsacademy.ui.screens.homeScreen

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
fun ContentofAboutus(){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        GoogleAnimation()
        CardViewContentAboutus()
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            SocialMediaContent()
        }
        CardViewContentForJoinCommunity()
        TechnologyStackContent()
        EventsWeConduct()
        Spacer(modifier = Modifier.height(100.dp))
    }
}