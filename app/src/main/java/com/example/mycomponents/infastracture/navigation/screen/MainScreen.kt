package com.example.mycomponents.infastracture.navigation.screen

const val MAIN_GRAPH_ROUTE = "main"

sealed class MainScreen(val route: String) {

    object Screen: MainScreen(route = "main_screen")



}
