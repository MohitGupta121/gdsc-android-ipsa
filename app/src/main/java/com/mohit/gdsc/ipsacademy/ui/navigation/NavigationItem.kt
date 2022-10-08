package com.mohit.gdsc.ipsacademy.ui.navigation

import com.mohit.gdsc.ipsacademy.R

sealed class NavigationItem(val rout: String, val label: String, val icons: Int) {
    object Home : NavigationItem("GDSC", "GDSC", R.drawable.homeicon)
    object AboutUs : NavigationItem("AboutUs", "AboutUs", R.drawable.aboutus)
    object Team : NavigationItem("Team", "Team", R.drawable.team)
}
