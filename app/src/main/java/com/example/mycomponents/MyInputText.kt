package com.example.mycomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputText(
    inputText: String,
    labelTitle: String,
    errorMessage: String,
    placeHolder: String,
    hasError: Boolean,
    hasImageStart: Boolean,
    hasImageEnd: Boolean,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp, 0.dp)
    ) {

        if (labelTitle.isNotEmpty()) {
            Text(
                text = labelTitle,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(6.dp))
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(size = 16.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(size = 16.dp)
                )
                .padding(20.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {

                if (hasImageStart)
                    PairImagesStart()

                MyBasicTextField(inputText = inputText, placeHolder = placeHolder)
            }


            if (hasImageEnd)
                PairImagesEnd()

            }

        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = errorMessage)
        }


        }

    }


@Composable
fun MyBasicTextField(
    inputText: String,
    placeHolder: String) {

    BasicTextField(
        value = inputText,
        onValueChange = {},
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray
        ),
        modifier = Modifier.height(43.dp),
        decorationBox = {
            if (inputText.isEmpty()) {
                Text(
                    text = placeHolder,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.LightGray,
                    modifier  = Modifier.wrapContentSize()
                )
            }
        }
    )
}


@Composable
fun PairImagesStart() {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {


        MyImage(
            imageId = R.drawable.ic_launcher_background,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(5.dp))

        MyImage(
            imageId = R.drawable.grey_vertical_line,
            modifier = Modifier
                .width(1.dp)
                .height(20.dp)
        )

        Spacer(modifier = Modifier.width(5.dp))
    }
}

@Composable
fun PairImagesEnd() {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {


        Spacer(modifier = Modifier.width(5.dp))


        MyImage(
            imageId = R.drawable.grey_vertical_line,
            modifier = Modifier
                .width(1.dp)
                .height(20.dp)
        )

        Spacer(modifier = Modifier.width(5.dp))


        MyImage(
            imageId = R.drawable.ic_launcher_background,
            modifier = Modifier.size(20.dp)
        )

    }
}



@Preview
@Composable
private fun InputTextPreview() {
    InputText(
        inputText = "input value",
        labelTitle = "My label",
        errorMessage = " error message ",
        placeHolder = "this is my input text ",
        hasImageStart = true,
        hasImageEnd = true,
        hasError = true,
    )
}



/*
    1. Add Util classes for colors, drawables, etc
    2. add modules for di and cache
    3. add ApiResponse sealed class
    4.
 */
