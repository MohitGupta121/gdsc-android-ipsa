package com.example.gdscipsa

import android.content.Intent
import android.net.Uri
import android.view.Gravity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
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
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.gdscipsa.ui.theme.DetailsContent

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SocialCard(socialmedia: socialmedia) {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(socialmedia.link)) }

    Card(
        modifier = Modifier
            .padding(horizontal = 2.dp, vertical = 5.dp)
            .padding(2.dp)
            .size(50.dp),
        elevation = 3.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(28.dp)),
        onClick = {
            context.startActivity(intent)
        }

    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image( painter = painterResource(id = socialmedia.image), contentDescription = socialmedia.link, modifier = Modifier.fillMaxSize())
        }
    }
}
@Composable
fun DetailsContent2() {

    val employees = remember { SocialMediaDetails.SocialMediaList }
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            employees
        ) {
            SocialCard(socialmedia = it)
        }
    }
}
@Preview
@Composable
fun Preview() {
    ContentofAboutus()
}

@Composable
fun ContentofAboutus(){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        CustomView()
        CardViewContent()
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            DetailsContent2()
        }
        CardViewContentForJoinCommunity()
        Spacer(modifier = Modifier.height(100.dp))
    }
}


@Composable
fun CustomView(modifier: Modifier = Modifier
    .fillMaxWidth()
    .height(200.dp)) {
    val visibility = remember { mutableStateOf(0) }
    val context = LocalContext.current
    val customView = remember { LottieAnimationView(context) }
    // Adds view to Compose
    AndroidView({ customView },modifier= Modifier
        .fillMaxWidth()
        .height(200.dp)) { view ->
        // View's been inflated - add logic here if necessary
        with(view) {
            setAnimation(R.raw.google_loading)
            playAnimation()
            repeatMode = LottieDrawable.RESTART
            foregroundGravity = Gravity.CENTER
        }
    }
}
@Composable
fun CardViewContent(){
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://gdsc.community.dev/ips-academy-indore/")) }
    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .padding(2.dp)
            .fillMaxWidth(),
        elevation = 3.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),


        ) {
        Column() {
            Text(
                text = "Google Developer Student Clubs (GDSC) are community groups for college and university students interested in Google developer technologies. Students from all undergraduate or graduate programs with an interest in growing as a developer are welcome. By joining a GDSC, students grow their knowledge in a peer-to-peer learning environment and build solutions for local businesses and their community.",
                style = TextStyle(
                    fontSize = 18.sp
                ),
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp),
                textAlign = TextAlign.Justify
            )
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Button(onClick = {context.startActivity(intent)},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White), border = BorderStroke(1.dp,
                        Color.Blue), modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp) ) {
                    Text(text = "Learn More", color = Color.Blue)
                }
            }
        }

    }
}
@Composable
fun CardViewContentForJoinCommunity(){
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://gdsc.community.dev/ips-academy-indore/")) }

    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .padding(2.dp)
            .fillMaxWidth(),
        elevation = 3.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),


        ) {
        Column() {
            Text(text = "Join Our Community", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp))
            Text(
                text = "Backed by a community of passionate student developers from across the globe. Get access to all our resources, attend events, work together and connect with other passionate developers.",
                style = TextStyle(
                    fontSize = 18.sp
                ),
                modifier = Modifier.padding(horizontal = 15.dp),
                textAlign = TextAlign.Justify
            )
            Row(horizontalArrangement = Arrangement.Start) {
                Button(onClick = {context.startActivity(intent)},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
                        ,modifier=Modifier.padding(horizontal = 15.dp) ) {
                    Text(text = "BECOME A MEMBER", color = Color.White)
                }
            }
        }

    }
}

@Composable
fun GoogleLine(){
    Row(modifier =Modifier.height(3.dp)) {

        Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.Red)
                    .weight(1f)
            )
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Blue)
                .weight(1f)
        )
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Green)
                .weight(1f)
        )
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Yellow)
                .weight(1f)
        )
        }
}

@Composable
fun CardViewContentForTechnologyStack(Technologystack:TechnologyStack){
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://gdsc.community.dev/ips-academy-indore/")) }

    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .padding(2.dp)
            .fillMaxWidth(),
        elevation = 3.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),


        ) {
//        Column(horizontalAlignment = Alignment.CenterHorizontally) {
//            Image( painter = painterResource(id = socialmedia.image), contentDescription = socialmedia.link, modifier = Modifier.fillMaxSize())
//        }

    }
}
