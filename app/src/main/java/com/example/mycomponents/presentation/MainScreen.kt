package com.example.mycomponents.presentation


import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycomponents.infastracture.navigation.screen.BottomNavBarScreen
import com.example.mycomponents.infastracture.navigation.navigationGraph.BottomNavGraph
import com.example.mycomponents.R


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->
        // this is used in order to prevent the navigation bar to cut portion of the displayed screen
        Box(modifier = Modifier
            .windowInsetsPadding(WindowInsets.statusBars) // <-- This is used in order to prevent the status bar to overlap with the components.
            .padding(innerPadding)) {
                BottomNavGraph(navController = navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomNavBarScreen.Home,
        BottomNavBarScreen.Settings,
        BottomNavBarScreen.Profile,
    )


    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    // this is in order to hide bottom nav bar when we navigate to a nested nav graph.
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {


        BottomNavigation (
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, color = Color(0xFFE9EFF6))
                .padding(0.dp, 15.dp),
            backgroundColor = colorResource(id = R.color.white),
            elevation = 0.dp,
        ) {

                screens.forEach { screen ->
                    AddItem(
                        screen = screen,
                        currentDestination = currentDestination,
                        navController = navController
                    )
                }
            }
        }
    }

@Composable
fun RowScope.AddItem(
    screen: BottomNavBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.image),
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        selectedContentColor = colorResource(id = R.color.purple),
        unselectedContentColor = colorResource(id = R.color.grey),

        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}


@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}