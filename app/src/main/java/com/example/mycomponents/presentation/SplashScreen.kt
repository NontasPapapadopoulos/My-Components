package com.example.mycomponents.presentation

import android.window.SplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycomponents.R
import com.example.mycomponents.presentation.component.AddVerticalSpace
import com.example.mycomponents.presentation.component.MyTitle


@Composable
fun SplashScreen() {
    
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
    ) {
        
        AddVerticalSpace(50)
        
        MyTitle(title = "Splash Screen")



        
    }
    
}



@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen()
}
        