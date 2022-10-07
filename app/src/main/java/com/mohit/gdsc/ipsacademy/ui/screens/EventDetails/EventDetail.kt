package com.mohit.gdsc.ipsacademy.ui.screens.EventDetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.mohit.gdsc.ipsacademy.R
import com.mohit.gdsc.ipsacademy.data.models.UpcomingEventModel
import com.mohit.gdsc.ipsacademy.ui.screens.aboutScreen.GoogleLine


class EventDetail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = intent.getStringExtra("eventname")
        val poster = intent.getStringExtra("eventposter")
        val time = intent.getStringExtra("eventtime")
        val date = intent.getStringExtra("eventdate")
        val mode = intent.getStringExtra("eventmode")
        val link = intent.getStringExtra("eventlink")
        val desc = intent.getStringExtra("eventdesc")
        val tickets = intent.getStringExtra("eventtickets")
        val eventDetail=UpcomingEventModel(date,"1",link,mode,poster,desc,"",tickets,time,title)

        setContent{
            EventDetailsUI(eventDetail)
        }
    }
}



@Composable
fun EventDetailsUI(eventDetail: UpcomingEventModel) {

    Scaffold(topBar = {

        TopAppBar(backgroundColor = Color.White, modifier = Modifier.height(80.dp), title = {
            Column() {
                Row() {
                    Text(text = "Developer Student Club", fontSize = 25.sp, color = Color.Black)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.homeicon_largesize),
                            contentDescription = "homeicon"
                        )
                    }
                }
                Row() {
                    Text(text = "IES-IPS Academy Indore", fontSize = 15.sp, color = Color.Black)
                }
            }


        })
    }, content = {
        EventDetailsActivityContent(it,eventDetail)
    })

}



@Composable
fun EventDetailsActivityContent(paddingValues: PaddingValues, eventDetail: UpcomingEventModel) {

    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(eventDetail.ticketlink)) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(paddingValues)
        .verticalScroll(rememberScrollState())) {
        GoogleLine()
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center ) {
            Image(
                painter = rememberAsyncImagePainter(model = eventDetail.posterlink),
                contentDescription = "image",
                modifier = Modifier
                    .size(300.dp)
                    .padding(10.dp)
            )

        }
        GoogleLine()
        Text(
            text = eventDetail.title!!,
            style = TextStyle(
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp, horizontal = 10.dp)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.calender),
                contentDescription = "image",
                modifier = Modifier
                    .size(40.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = ": "+eventDetail.date!!,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.clock),
                contentDescription = "image",
                modifier = Modifier
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.width(18.dp))
            Text(
                text = ": "+eventDetail.time!!,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 0.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(6.dp))
            Image(
                painter = painterResource(id = R.drawable.mode),
                contentDescription = "image",
                modifier = Modifier
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = ": "+eventDetail.mode!!,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {context.startActivity(intent)},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White), border = BorderStroke(1.dp,Color.Red) ) {
                Text(text = "Book Ticket", color = Color.Red)
            }
        }
        Text(
            text = "About",
            style = TextStyle(
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        )
        Text(
            text = eventDetail.shortdesc!!,
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 15.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 5.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {context.startActivity(intent)},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White), border = BorderStroke(1.dp,Color(191,64,191)) ) {
                Text(text = "Event Page", color = Color(191,64,191))
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
    }

}