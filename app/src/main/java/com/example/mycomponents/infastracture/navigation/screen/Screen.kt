package com.example.mycomponents.infastracture.navigation.screen

sealed class Screen(val route: String) {

    object LoginScreen: Screen(route = "login_screen")
    object SplashScreen: Screen(route = "splash_screen")


// object LoginScreen: Screen(route = "login_screen")

}
