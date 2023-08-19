package com.example.mycomponents.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycomponents.R
import com.example.mycomponents.presentation.component.MyTitle


@Composable
fun ProfileScreen() {
    
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
    ) {
        
        
        
        MyTitle(title = "Profile Screen")
        
    }
    
}



@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()
}
        