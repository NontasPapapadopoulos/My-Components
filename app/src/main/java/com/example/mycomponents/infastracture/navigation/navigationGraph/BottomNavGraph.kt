package com.example.mycomponents.infastracture.navigation.navigationGraph

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mycomponents.infastracture.navigation.screen.BottomNavBarScreen
import com.example.mycomponents.infastracture.navigation.screen.HOME_GRAPH_ROUTE
import com.example.mycomponents.presentation.HomeScreen
import com.example.mycomponents.presentation.ProfileScreen
import com.example.mycomponents.presentation.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = BottomNavBarScreen.Home.route,
        route = HOME_GRAPH_ROUTE
    ) {


        composable(
            route = BottomNavBarScreen.Home.route
        ) {

            HomeScreen()
        }


        composable(
            route = BottomNavBarScreen.Settings.route
        ) {

            SettingsScreen()
        }


        composable(
            route = BottomNavBarScreen.Profile.route
        ) {
            ProfileScreen()
        }

    }
}