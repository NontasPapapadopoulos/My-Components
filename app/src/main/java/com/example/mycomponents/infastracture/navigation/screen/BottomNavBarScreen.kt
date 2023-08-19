package com.example.mycomponents.infastracture.navigation.screen

import com.example.mycomponents.R


const val HOME_GRAPH_ROUTE = "bottom_nav_bar_route"

sealed class BottomNavBarScreen(
    val route: String,
    val title: String,
    val image: Int
) {

    object Home: BottomNavBarScreen(
        route = "home",
        title = "Home",
        image = R.drawable.home
    )

    object Settings: BottomNavBarScreen(
        route = "settings",
        title = "Settings",
        image = R.drawable.settings
    )


    object Profile: BottomNavBarScreen(
        route = "profile",
        title = "Profile",
        image = R.drawable.profile_edit
    )


}
