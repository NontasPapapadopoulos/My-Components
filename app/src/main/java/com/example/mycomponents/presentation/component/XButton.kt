package com.example.mycomponents.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycomponents.R



@Composable
fun XButton(
    onButtonClicked: () ->Unit,
    modifier: Modifier = Modifier) {

    MyImage(
        imageId = R.drawable.x_button,
        modifier = modifier
            .size(14.dp)
            .clickable { onButtonClicked() }

    )
}