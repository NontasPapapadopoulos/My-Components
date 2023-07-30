package com.example.mycomponents

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun MyImage(
    imageId: Int,
    modifier: Modifier
) {

    Image(
        painter = painterResource(imageId) ,
        contentDescription = null,
        modifier = modifier
    )

}