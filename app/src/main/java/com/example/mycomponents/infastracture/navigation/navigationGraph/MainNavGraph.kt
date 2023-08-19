package com.example.mycomponents.infastracture.navigation.navigationGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mycomponents.infastracture.navigation.screen.MainScreen
import com.example.mycomponents.presentation.MainScreen


@Composable
fun MainNavGraph(
    navController: NavHostController
) {
    NavHost(
        startDestination = MainScreen.Screen.route,
        route = "MAIN_GRAPH_ROUTE",
        navController = navController
    ) {
        composable(
            route = MainScreen.Screen.route

        ) {

            MainScreen()
        }

    }
}


//fun NavGraphBuilder.mainNavGraph(
//    navController: NavHostController
//) {
//    navigation(
//        startDestination = MainScreen.Screen.route,
//        route = MAIN_GRAPH_ROUTE
//    ) {
//        composable(
//            route = MainScreen.Screen.route
//        ) {
//            //DisplaySecurityScreen(navController = navController)
//            MainScreen()
//        }
//
//    }
//}
