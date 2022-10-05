package com.mohit.gdsc.ipsacademy.ui.screens.homeScreen

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohit.gdsc.ipsacademy.EventsDetails
import com.mohit.gdsc.ipsacademy.FutureEventDetails
import com.mohit.gdsc.ipsacademy.R
import com.mohit.gdsc.ipsacademy.data.models.PastEventModel
import com.mohit.gdsc.ipsacademy.data.response.FirebaseCallback
import com.mohit.gdsc.ipsacademy.data.response.Response

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UpcomingEventsDetailsCard(eventDetails: EventsDetails) {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(eventDetails.Url)) }
    Card(
        modifier = Modifier
            .padding(horizontal = 6.dp, vertical = 5.dp)
            .padding(2.dp),
        elevation = 6.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        onClick = {
            if(!eventDetails.Url.isNullOrBlank()){
                context.startActivity(intent)
            }
        }

    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .height(160.dp)
            .width(175.dp)) {
            Spacer(modifier = Modifier.height(25.dp))
            Image( painter = painterResource(id = eventDetails.ImageId), contentDescription = eventDetails.title, modifier = Modifier
                .size(60.dp)
                .padding(horizontal = 10.dp))
            Text(
                text = eventDetails.title,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = eventDetails.Date,
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
fun FutureEventsDetailsCard(eventDetails: PastEventModel) {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(eventDetails.eventLink)) }
    Card(
        modifier = Modifier
            .padding(horizontal = 6.dp, vertical = 5.dp)
            .padding(2.dp),
        elevation = 6.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        onClick = {
            context.startActivity(intent)
        }

    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .height(160.dp)
            .width(175.dp)) {
            Spacer(modifier = Modifier.height(2.dp))
            Image( painter = painterResource(R.drawable.composekotlin), contentDescription = eventDetails.title, modifier = Modifier
                .size(80.dp)
                .padding(horizontal = 10.dp))
            Text(
                text = eventDetails.title.toString(),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(10.dp)
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

    val events = remember { FutureEventDetails.EventsDetailsLists }
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            events
        ) {
            UpcomingEventsDetailsCard(eventDetails = it)
        }
    }
}

var list:ArrayList<PastEventModel> = arrayListOf()

private fun getResponseUsingCallback() {
    val viewModel = HomeScreenViewModel()
    viewModel.getResponseUsingCallback(object : FirebaseCallback {
        override fun onResponse(response: Response) {
            print(response)
            list.addAll(response.pastEventItems!!)
        }
    })
}

@Composable
fun PastEventsDetailsDetailsContent() {

    getResponseUsingCallback()

    Log.e("test", list.toString())

    val events = remember { list }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            events
        ) {
            FutureEventsDetailsCard(eventDetails = it)
        }
    }
}



