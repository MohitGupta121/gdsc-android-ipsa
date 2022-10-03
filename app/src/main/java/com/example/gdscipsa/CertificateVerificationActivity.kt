package com.example.gdscipsa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CertificateVerificationActivity  : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CertificateVerificationUI()
        }
    }
}

@Preview
@Composable
fun CertificateVerificationUI(){

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
        ActivityContent(it)
    })

}

@Composable
fun ActivityContent(paddingValues: PaddingValues) {
    var textFielState by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(paddingValues), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Enter the verification code mentioned on the certificate.",
            style = TextStyle(
                fontSize = 20.sp
            ),
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value =textFielState ,
            label = { Text(text = "Ex : GDSC00228Z79HKE") },
            onValueChange = {
                textFielState= it
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
                         verifyCertificate(textFielState)
        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.White), border = BorderStroke(1.dp, Color.Green),
        ) {
            Text(text = "verify", color = Color.Green)
        }
    }

}

fun verifyCertificate(textFielState: String) {
if(textFielState.isEmpty()){
    return
}
}

@Composable
fun Body() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(text = "Body Content", color = Color(0xFF0F9D58))
    }
}
