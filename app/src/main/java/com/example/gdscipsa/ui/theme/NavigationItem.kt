package com.example.gdscipsa.ui.theme

import android.graphics.drawable.Icon
import android.graphics.drawable.VectorDrawable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.gdscipsa.R

sealed class NavigationItem( val rout:String,val label:String,val icons:Int){
    object Home:NavigationItem("home","Home",R.drawable.homeicon )
    object aboutus:NavigationItem("aboutus","aboutus",R.drawable.aboutus)
    object team:NavigationItem("team","team",R.drawable.team)

}
