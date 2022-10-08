package com.mohit.gdsc.ipsacademy.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mohit.gdsc.ipsacademy.R
import com.mohit.gdsc.ipsacademy.ui.screens.aboutScreen.ContentOfAboutUs
import com.mohit.gdsc.ipsacademy.ui.screens.aboutScreen.GoogleLine
import com.mohit.gdsc.ipsacademy.ui.screens.homeScreen.HomeFragmentUI

@Composable
fun NavigationController(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.rout) {

        composable(NavigationItem.Home.rout) {
            Home()
        }

        composable(NavigationItem.AboutUs.rout) {
            aboutUs()
        }

        composable(NavigationItem.Team.rout) {
            team()
        }

    }


}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Navigation() {

    val navController = rememberNavController()

    val items = listOf(
        NavigationItem.AboutUs,
        NavigationItem.Home,
        NavigationItem.Team
    )

    Scaffold(

        topBar = {

            TopAppBar(backgroundColor = Color.White, modifier = Modifier
                .height(80.dp)
                .fillMaxWidth(), title = {
                Column {
                    Row() {
                        Text(
                            text = "Developer Student Club",
                            fontSize = 25.sp,
                            color = Color.Black
                        )
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
                    Row(modifier = Modifier.padding(vertical = 3.dp)) {
                        Text(text = "IPS Academy Indore", fontSize = 15.sp, color = Color.Black)
                    }
                }


            })
        },
        bottomBar = {
            BottomNavigation(backgroundColor = MaterialTheme.colors.background) {

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                
                val hue = 240F
                val sat = 1F
                val lightness = .5F

                items.forEach {
                    BottomNavigationItem(selected = currentRoute == it.rout,
                        label = {
                            Text(
                                text = it.label,
                                color = if (currentRoute == it.rout) Color.hsl(hue, sat, lightness) else Color.LightGray
                            )
                        },
                        icon = {
                            Icon(
                                painterResource(id = it.icons),
                                contentDescription = it.label
                            )
                        },
                        selectedContentColor = Color.hsl(hue, sat, lightness),
                        unselectedContentColor = Color.Black.copy(0.4f),

                        onClick = {
                            if (currentRoute != it.rout) {

                                navController.graph?.startDestinationRoute?.let {
                                    navController.popBackStack(it, true)
                                }

                                navController.navigate(it.rout) {
                                    launchSingleTop = true
                                }

                            }

                        })

                }


            }


        }) {

        NavigationController(navController = navController)

    }

}


@Composable
fun Home() {
    HomeFragmentUI()
}

@Composable
fun aboutUs() {
    ContentOfAboutUs()
}

@Composable
fun team() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Team")
    }
}
