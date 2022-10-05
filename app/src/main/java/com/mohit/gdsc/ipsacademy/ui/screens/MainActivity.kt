package com.mohit.gdsc.ipsacademy.ui.screens

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.mohit.gdsc.ipsacademy.PastEventDetails
import com.mohit.gdsc.ipsacademy.data.models.PastEventModel
import com.mohit.gdsc.ipsacademy.ui.navigation.Navigation
import com.mohit.gdsc.ipsacademy.ui.screens.homeScreen.HomeScreenViewModel
import com.mohit.gdsc.ipsacademy.ui.theme.GDSCIPSATheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: HomeScreenViewModel

    private fun getPastEvents() {
        viewModel.responseLiveData.observe(this) {
            Log.e("test", it.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java)

        getPastEvents()

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
}

