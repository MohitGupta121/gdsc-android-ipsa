package com.mohit.gdsc.ipsacademy.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.google.gson.Gson
import com.mohit.gdsc.ipsacademy.R
import com.mohit.gdsc.ipsacademy.data.models.Users
import com.mohit.gdsc.ipsacademy.ui.navigation.Navigation
import com.mohit.gdsc.ipsacademy.ui.theme.GDSCIPSATheme
import com.mohit.gdsc.ipsacademy.utils.loadContentsOfFile

class MainActivity : ComponentActivity() {

    lateinit var fakeUserData: Users

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getFakeUserData()
        setContent {
            GDSCIPSATheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation()
                }
            }
        }
    }

    private fun getFakeUserData() {
        fakeUserData = Gson().fromJson(loadContentsOfFile(this, R.raw.users), Users::class.java)
    }
}
