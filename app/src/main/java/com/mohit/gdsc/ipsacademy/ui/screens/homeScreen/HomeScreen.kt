package com.mohit.gdsc.ipsacademy.ui.screens.homeScreen

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohit.gdsc.ipsacademy.ui.screens.CertificateVerificationActivity
import com.mohit.gdsc.ipsacademy.ui.theme.GDSCGreen

@Composable
fun HomeFragmentUI() {

    val mContext = LocalContext.current

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text(
            text = "Upcoming Events",
            style = TextStyle(
                fontSize = 22.sp
            ),
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        FutureEventsDetailsDetailsContent()
        Text(
            text = "Past Events",
            style = TextStyle(
                fontSize = 22.sp
            ),
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        PastEventsDetailsDetailsContent()
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Verify Certificate",
            style = TextStyle(
                color = Color.Black,
                fontSize = 22.sp
            ),
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = "Verify the authenticity of the Certificates Issued by Google Developer Student Club IES-IPSA. Enter the verification code given on the certificates to check it's authenticity. Click Below :",
            style = TextStyle(
                fontSize = 15.sp
            ),
            modifier = Modifier.padding(horizontal = 10.dp),
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    mContext.startActivity(
                        Intent(
                            mContext,
                            CertificateVerificationActivity::class.java
                        )
                    )
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                border = BorderStroke(
                    1.dp,
                    Color.Gray
                )
            ) {
                Text(text = "Certificate Verification", color = GDSCGreen, fontWeight = FontWeight.ExtraBold)
            }
        }
        Spacer(modifier = Modifier.height(100.dp))
    }

}
