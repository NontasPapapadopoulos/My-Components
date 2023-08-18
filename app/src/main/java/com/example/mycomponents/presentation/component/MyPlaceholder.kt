package com.example.mycomponents.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomponents.R



@Composable
fun MyPlaceholder(placeholder: String, color: Int = R.color.black) {
    MyText(
        text = placeholder,
        color = color,
        fontSize = 14.sp,
        textAlignment = TextAlign.Start,
        fillMaxWidth = false,
        modifier = Modifier
            .padding(0.dp)
            .wrapContentHeight()
        )
}


@Preview
@Composable
fun FlykkPlaceholderPreview() {
    MyPlaceholder("place holder")
}