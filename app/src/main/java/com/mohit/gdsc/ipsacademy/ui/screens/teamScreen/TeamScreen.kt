package com.mohit.gdsc.ipsacademy.ui.screens.teamScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.mohit.gdsc.ipsacademy.R
import com.mohit.gdsc.ipsacademy.data.models.Link
import com.mohit.gdsc.ipsacademy.ui.screens.MainActivity


@Composable
fun TeamScreen() {

    val mContext = LocalContext.current as MainActivity
    val data = remember {
        mContext.fakeUserData
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        item(span = { GridItemSpan(2) }) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                Image(
                    painter = painterResource(id = R.drawable.team_table),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Founding GDSC Lead",
                    style = TextStyle(
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center
                    ),
                )
                SingleUserCard(
                    name = data.lead.name,
                    image = data.lead.imageUrl,
                    description = data.lead.description,
                    listOfLinks = data.lead.links
                )
            }
        }
        item(span = { GridItemSpan(2) }) {
            Spacer(modifier = Modifier.height(32.dp))
        }
        item(span = { GridItemSpan(2) }) {
            Text(
                text = "GDSC Senior Core Team",
                style = TextStyle(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ),
            )
        }
        items(data.seniors.size) {
            SingleUserCard(
                name = data.seniors[it].name,
                image = data.seniors[it].imageUrl,
                description = data.seniors[it].description,
                listOfLinks = data.seniors[it].links
            )
        }
        item(span = { GridItemSpan(2) }) {
            Spacer(modifier = Modifier.height(32.dp))
        }
        item(span = { GridItemSpan(2) }) {
            Text(
                text = "GDSC Junior Core Team",
                style = TextStyle(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ),
            )
        }
        items(data.juniors.size) {
            SingleUserCard(
                name = data.juniors[it].name,
                image = data.juniors[it].imageUrl,
                description = data.juniors[it].description,
                listOfLinks = data.juniors[it].links
            )
        }
        item(span = { GridItemSpan(2) }) {
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

@Composable
fun SingleUserCard(
    image: String = "",
    name: String = "",
    description: String = "",
    listOfLinks: List<Link> = emptyList()
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp), elevation = 6.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
                    .border(width = 1.dp, color = Color.Black, shape = CircleShape),
                painter = rememberAsyncImagePainter(image),
                contentDescription = null
            )
            Text(
                text = name,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                text = description,
                style = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                listOfLinks.forEach {
                    SimpleIcon(it.imageUrl)
                    Spacer(Modifier.width(2.dp))
                }
            }
        }
    }
}

@Composable
fun SimpleIcon(imageUrl: String) {
    Image(
        modifier = Modifier
            .size(32.dp)
            .clip(RoundedCornerShape(2.dp)),
        painter = rememberAsyncImagePainter(imageUrl),
        contentDescription = null
    )
}

@Preview(showSystemUi = true)
@Composable
fun SingleUserCardPreview() {
    Column {
        SingleUserCard(
            listOfLinks = listOf(Link("", ""))
        )
    }
}