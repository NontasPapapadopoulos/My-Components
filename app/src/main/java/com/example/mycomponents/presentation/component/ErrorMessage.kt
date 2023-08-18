package com.example.mycomponents.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomponents.R



@Composable
fun ErrorMessage(errorMessage: String) {
    MyText(
        text = errorMessage,
        fontSize = 12.sp,
        color = R.color.black,
        fillMaxWidth = false,
        modifier = Modifier
            .padding(20.dp, 0.dp)

    )
}