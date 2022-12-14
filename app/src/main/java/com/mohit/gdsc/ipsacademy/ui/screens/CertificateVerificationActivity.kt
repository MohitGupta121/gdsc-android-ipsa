package com.mohit.gdsc.ipsacademy.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
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
import androidx.compose.material.IconButton
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohit.gdsc.ipsacademy.R
import com.mohit.gdsc.ipsacademy.ui.screens.aboutScreen.GoogleLine
import com.mohit.gdsc.ipsacademy.ui.theme.GDSCGreen

class CertificateVerificationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CertificateVerificationUI()
        }
    }
}

@Preview
@Composable
fun CertificateVerificationUI() {

    val dispatcher = LocalOnBackPressedDispatcherOwner.current!!.onBackPressedDispatcher

    Scaffold(topBar = {

        TopAppBar(backgroundColor = Color.White, modifier = Modifier.height(80.dp), title = {
            Column() {
                Row() {
                    Text(text = "Developer Student Club", fontSize = 22.sp, color = Color.Black)
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


        }, navigationIcon =
        {
            IconButton(onClick = { dispatcher.onBackPressed() }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back_button),
                    contentDescription = "Back",
                    colorFilter = ColorFilter.tint(Color.Red)
                )
            }
        })
    }, content = {
        ActivityContent(it)
    })

}

@Composable
fun ActivityContent(paddingValues: PaddingValues) {
    var textFieldState by remember {
        mutableStateOf("")
    }
    GoogleLine()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
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
            value = textFieldState,
            label = { Text(text = "Ex : GDSC00228Z79HKE") },
            onValueChange = {
                textFieldState = it
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                verifyCertificate(textFieldState)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            border = BorderStroke(1.dp, Color.Gray),
        ) {
            Text(text = "VERIFY", color = GDSCGreen, fontWeight = FontWeight.ExtraBold)
        }
    }

}

fun verifyCertificate(textFieldState: String) {
    if (textFieldState.isEmpty()) {
        return
    }
}
