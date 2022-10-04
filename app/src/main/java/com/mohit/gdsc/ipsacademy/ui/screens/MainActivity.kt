package com.mohit.gdsc.ipsacademy.ui.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mohit.gdsc.ipsacademy.R
import com.mohit.gdsc.ipsacademy.homeFragmentUI
import com.mohit.gdsc.ipsacademy.ui.theme.GDSCIPSATheme
import com.mohit.gdsc.ipsacademy.ui.theme.NavigationItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GDSCIPSATheme {
                // A surface container using the 'background' color from the theme
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


@Composable
fun NavigationController(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.rout) {

        composable(NavigationItem.Home.rout) {
            home()
        }

        composable(NavigationItem.aboutus.rout) {
            aboutus()
        }

        composable(NavigationItem.team.rout) {
            team()
        }

    }


}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Navigation() {

    val navController = rememberNavController()

    val items = listOf(
        NavigationItem.aboutus,
        NavigationItem.Home,
        NavigationItem.team
    )

    Scaffold(

        topBar = {

            TopAppBar(backgroundColor = Color.White, modifier = Modifier
                .height(80.dp)
                .fillMaxWidth(), title = {
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
                    Row(modifier = Modifier.padding(vertical = 3.dp)) {
                        Text(text = "IPS Academy Indore", fontSize = 15.sp, color = Color.Black)
                    }
                    GoogleLines()
                }


            })
        },
        bottomBar = {
            BottomNavigation(backgroundColor = MaterialTheme.colors.background) {

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route


                items.forEach {
                    BottomNavigationItem(selected = currentRoute == it.rout,
                        label = {
                            Text(
                                text = it.label,
                                color = if (currentRoute == it.rout) Color.DarkGray else Color.LightGray
                            )
                        },
                        icon = {
                            Icon(
                                painterResource(id = it.icons),
                                contentDescription = it.label
                            )
                        },
                        selectedContentColor = Color.Green,
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
fun home() {
homeFragmentUI()

}


@Composable
fun aboutus() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "About Us")
    }
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

@Composable
fun GoogleLines(){

    Row(modifier =Modifier.height(3.dp)) {

        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Red)
                .weight(1f)
        )
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Blue)
                .weight(1f)
        )
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Green)
                .weight(1f)
        )
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Yellow)
                .weight(1f)
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {

}