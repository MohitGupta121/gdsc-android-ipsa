package com.mohit.gdsc.ipsacademy.ui.screens.aboutScreen

import android.content.Intent
import android.net.Uri
import android.view.Gravity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.mohit.gdsc.ipsacademy.R
import com.mohit.gdsc.ipsacademy.data.models.SocialMediaDetails
import com.mohit.gdsc.ipsacademy.data.models.TechnologyStack
import com.mohit.gdsc.ipsacademy.data.models.TechnologyStackDetails
import com.mohit.gdsc.ipsacademy.data.models.SocialMedia
import com.mohit.gdsc.ipsacademy.ui.theme.GDSCGreen

@Composable
fun GoogleAnimation(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
) {
    val visibility = remember { mutableStateOf(0) }
    val context = LocalContext.current
    val customView = remember { LottieAnimationView(context) }
    AndroidView(
        { customView }, modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) { view ->
        with(view) {
            setAnimation(R.raw.searching_lottie)
            playAnimation()
            repeatMode = LottieDrawable.RESTART
            foregroundGravity = Gravity.CENTER
        }
    }
}

@Composable
fun CardViewContentAboutUs() {
    val context = LocalContext.current
    val intent = remember {
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://gdsc.community.dev/ips-academy-indore/")
        )
    }
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
                Button(
                    onClick = { context.startActivity(intent) },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    border = BorderStroke(
                        1.dp,
                        Color.Blue
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                ) {
                    Text(text = "Learn More", color = Color.Blue)
                }
            }
        }

    }
}

@Composable
fun CardViewContentForJoinCommunity() {
    val context = LocalContext.current
    val intent = remember {
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://gdsc.community.dev/ips-academy-indore/")
        )
    }

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
            Text(
                text = "Join Our Community",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp)
            )
            Text(
                text = "Backed by a community of passionate student developers from across the globe. Get access to all our resources, attend events, work together and connect with other passionate developers.",
                style = TextStyle(
                    fontSize = 18.sp
                ),
                modifier = Modifier.padding(horizontal = 15.dp),
                textAlign = TextAlign.Justify
            )
            Row(horizontalArrangement = Arrangement.Start) {
                Button(
                    onClick = { context.startActivity(intent) },
                    colors = ButtonDefaults.buttonColors(backgroundColor = GDSCGreen),
                    modifier = Modifier.padding(horizontal = 15.dp)
                ) {
                    Text(text = "BECOME A MEMBER", color = Color.White)
                }
            }
        }

    }
}

@Composable
fun GoogleLine() {
    Row(modifier = Modifier.height(3.dp)) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Red)
                .weight(1f)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Blue)
                .weight(1f)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Green)
                .weight(1f)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Yellow)
                .weight(1f)
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardViewContentForTechnologyStack(technologystack: TechnologyStack) {

    Card(
        modifier = Modifier
            .padding(horizontal = 6.dp, vertical = 10.dp)
            .padding(2.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .height(160.dp)
                .width(120.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(id = technologystack.image),
                contentDescription = technologystack.link,
                modifier = Modifier
                    .size(100.dp)
                    .padding(horizontal = 10.dp)
            )
            Text(
                text = technologystack.name,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )
            )
        }

    }
}

@Composable
fun TechnologyStackContent() {

    val technology = remember { TechnologyStackDetails.TechnologyStackList }
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            technology
        ) {
            CardViewContentForTechnologyStack(technologystack = it)
        }
    }
}

@Composable
fun EventsWeConduct() {
    Spacer(modifier = Modifier.height(5.dp))
    Column(modifier = Modifier.padding(horizontal = 5.dp)) {
        Text(
            text = "Event We Conduct",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp)
        )
        Text(
            text = "- Android Study Jams",
            style = TextStyle(
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 2.dp)
        )
        Text(
            text = "- Google Cloud Study Jams",
            style = TextStyle(
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 2.dp)
        )
        Text(
            text = "- Open Source Projects",
            style = TextStyle(
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 2.dp)
        )
        Text(
            text = "- Hackathons",
            style = TextStyle(
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 2.dp)
        )
        Text(
            text = "- Expert Sessions",
            style = TextStyle(
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 2.dp)
        )
        Text(
            text = "- Connection Sessions",
            style = TextStyle(
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 2.dp)
        )
        Text(
            text = "- Info Sessions",
            style = TextStyle(
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 2.dp)
        )

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SocialCard(socialMedia: SocialMedia) {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(socialMedia.link)) }

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
            Image(
                painter = painterResource(id = socialMedia.image),
                contentDescription = socialMedia.link,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun SocialMediaContent() {

    val employees = remember { SocialMediaDetails.SocialMediaList }
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            employees
        ) {
            SocialCard(socialMedia = it)
        }
    }
}
