package com.mohit.gdsc.ipsacademy.ui.theme

import com.mohit.gdsc.ipsacademy.R

sealed class NavigationItem( val rout:String,val label:String,val icons:Int){
    object Home:NavigationItem("home","Home",R.drawable.homeicon )
    object aboutus:NavigationItem("aboutus","aboutus",R.drawable.aboutus)
    object team:NavigationItem("team","team",R.drawable.team)

}
