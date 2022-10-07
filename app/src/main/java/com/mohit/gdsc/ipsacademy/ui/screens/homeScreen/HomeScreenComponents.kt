package com.mohit.gdsc.ipsacademy.ui.screens.homeScreen

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.mohit.gdsc.ipsacademy.data.models.PastEventModel
import com.mohit.gdsc.ipsacademy.data.models.UpcomingEventModel
import com.mohit.gdsc.ipsacademy.ui.screens.EventDetails.EventDetail

val viewModel = HomeScreenViewModel()

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UpcomingEventsDetailsCard(eventDetails: UpcomingEventModel) {
    val context = LocalContext.current
    val intent = Intent(context,EventDetail::class.java)
    intent.putExtra("eventname",eventDetails.title)
    intent.putExtra("eventposter",eventDetails.posterlink)
    intent.putExtra("eventtime",eventDetails.time)
    intent.putExtra("eventdate",eventDetails.date)
    intent.putExtra("eventmode",eventDetails.mode)
    intent.putExtra("eventlink",eventDetails.eventlink)
    intent.putExtra("eventdesc",eventDetails.shortdesc)
    intent.putExtra("eventtickets",eventDetails.ticketlink)


    Card(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .padding(2.dp),
        elevation = 6.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        onClick = {
            context.startActivity(intent)
        }

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .height(175.dp)
                .width(200.dp)
        ) {
            Card(elevation = 3.dp , modifier = Modifier.padding(15.dp)) {
                Image(
                    painter = rememberAsyncImagePainter(eventDetails.thumbnaillink),
                    contentDescription = eventDetails.title,
                    modifier = Modifier
                        .size(80.dp).clip(RoundedCornerShape(20.dp))
                )
            }
            Text(
                text = eventDetails.title.toString(),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.width(150.dp)
            )
            Text(
                text = eventDetails.date.toString(),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                )
            )

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PastEventsDetailsCard(eventDetails: PastEventModel) {
    val context = LocalContext.current
    val intent = Intent(context,EventDetail::class.java)
    intent.putExtra("eventname",eventDetails.title)
    intent.putExtra("eventposter",eventDetails.posterlink)
    intent.putExtra("eventtime",eventDetails.time)
    intent.putExtra("eventdate",eventDetails.date)
    intent.putExtra("eventmode",eventDetails.mode)
    intent.putExtra("eventlink",eventDetails.eventlink)
    intent.putExtra("eventdesc",eventDetails.shortdesc)
    intent.putExtra("eventtickets",eventDetails.eventlink)

    Card(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .padding(2.dp),
        elevation = 6.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        onClick = {
            context.startActivity(intent)
        }

    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .height(175.dp)
                .width(200.dp)
        ) {
            Card(elevation = 3.dp , modifier = Modifier.padding(15.dp)) {
                Image(
                    painter = rememberAsyncImagePainter(eventDetails.thumbnaillink),
                    contentDescription = eventDetails.title,
                    modifier = Modifier
                        .size(80.dp).clip(RoundedCornerShape(20.dp))
                )
            }
            Text(
                text = eventDetails.title.toString(),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.width(150.dp)
            )
            Text(
                text = eventDetails.date.toString(),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                )
            )

        }
    }
}

@Composable
fun FutureEventsDetailsDetailsContent() {

    /*
    Also Use
    var events = viewModel.pastEvents.observeAsState()  [we have to pass there list as response]
    with this line 178-180 into 1 line 176
    */

    var events by remember { mutableStateOf(listOf<UpcomingEventModel>()) }

    viewModel.upcomingEvents.observe(LocalLifecycleOwner.current) {
        events = it.upcomingEventItems!!
    }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp)
    ) {
        items(
            events
        ) {
            UpcomingEventsDetailsCard(eventDetails = it)
        }
    }
}


@SuppressLint("MutableCollectionMutableState")
@Composable
fun PastEventsDetailsDetailsContent() {

    /*
    Also Use
    var events = viewModel.pastEvents.observeAsState()  [we have to pass there list as response]
    with this line 178-180 into 1 line 176
     */

    var events by remember { mutableStateOf(listOf<PastEventModel>()) }

    viewModel.pastEvents.observe(LocalLifecycleOwner.current) {
        events = it.pastEventItems!!.reversed()
    }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp)
    ) {
        items(
            events
        ) {
            PastEventsDetailsCard(eventDetails = it)
        }
    }
}



