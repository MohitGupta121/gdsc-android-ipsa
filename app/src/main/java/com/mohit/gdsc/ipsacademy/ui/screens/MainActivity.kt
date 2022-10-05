package com.mohit.gdsc.ipsacademy.ui.screens

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.mohit.gdsc.ipsacademy.data.models.PastEventModel
import com.mohit.gdsc.ipsacademy.ui.navigation.Navigation
import com.mohit.gdsc.ipsacademy.ui.screens.homeScreen.HomeScreenViewModel
import com.mohit.gdsc.ipsacademy.ui.theme.GDSCIPSATheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: HomeScreenViewModel
    private lateinit var list: ArrayList<PastEventModel>

    private fun getPastEvents() {
        viewModel.responseLiveData.observe(this) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java)

        setContent {

            list = arrayListOf()
            getPastEvents()

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
}
