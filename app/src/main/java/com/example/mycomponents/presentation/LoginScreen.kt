package com.example.mycomponents.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycomponents.R
import com.example.mycomponents.infastracture.navigation.screen.MAIN_GRAPH_ROUTE
import com.example.mycomponents.presentation.component.AddVerticalSpace
import com.example.mycomponents.presentation.component.MyTitle


@Composable
fun LoginScreen(
    navController: NavController
) {
    
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
    ) {

        AddVerticalSpace(50)
        MyTitle(title = "Login Screen")


        AddVerticalSpace(100)

        MyTitle(
            title = "LOGIN",
            modifier = Modifier.clickable {
                navController.navigate(route = MAIN_GRAPH_ROUTE)
            }
        )


    }
    
}



@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        navController = rememberNavController()
    )
}
        