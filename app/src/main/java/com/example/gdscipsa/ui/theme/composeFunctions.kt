package com.example.gdscipsa.ui.theme

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
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gdscipsa.Details
import com.example.gdscipsa.EventsDetails

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EmployeeCard(emp: EventsDetails) {
    Card(
        modifier = Modifier
            .padding(horizontal = 2.dp, vertical = 5.dp).padding(2.dp),
        elevation = 3.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        onClick = {

        }

    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.height(170.dp).width(200.dp)) {
            Spacer(modifier = Modifier.height(25.dp))
            Image( painter = painterResource(id = emp.ImageId), contentDescription = emp.title, modifier = Modifier.size(60.dp).padding(horizontal = 10.dp))
            Text(
                    text = "Android Study Jams\nDay 04",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                modifier = Modifier.padding(10.dp)
                )
            Text(
                text = "Dec 17th, 2021",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                )
            )


        }
    }
}
@Composable
fun DetailsContent() {

    val employees = remember { Details.EventsDetailsLists }
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            employees
        ) {
            EmployeeCard(emp = it)
        }
    }
}
@Preview
@Composable
fun Preview() {
    DetailsContent()
}