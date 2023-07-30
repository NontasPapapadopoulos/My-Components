package com.example.mycomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputText(
    inputText: String,
    onValueChanged: (String) -> Unit,
    fontSize: Int = 16,
    fontWeight: FontWeight = FontWeight(400),
    textColor: Int = R.color.black,
    labelTitle: String = "",
    errorMessage: String = "",
    placeHolder: String,
    hasError: Boolean,
    hasImageStart: Boolean = true,
    imageStartId: Int?,
    imageStartWidth: Int?,
    imageStartHeight: Int?,
    hasImageEnd: Boolean = false,
    imageEndId: Int?,
    imageEndWidth: Int?,
    imageEndHeight: Int?,
    visualTransformation: VisualTransformation = VisualTransformation.None,
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
                    PairImagesStart(
                        startImageId = imageStartId!!,
                        startImageHeight = imageStartHeight!!,
                        startImageWidth = imageStartWidth!!
                    )

                MyBasicTextField(
                    inputText = inputText,
                    onValueChanged = onValueChanged,
                    fontSize = fontSize,
                    fontWeight = fontWeight,
                    color = textColor,
                    placeHolder = placeHolder,
                    visualTransformation = visualTransformation
                )
            }


            if (hasImageEnd)
                PairImagesEnd(
                    imageEndId = imageEndId!!,
                    imageEndWidth = imageEndWidth!!,
                    imageEndHeigh = imageEndHeight!!
                )
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
    onValueChanged: (String) -> Unit,
    placeHolder: String,
    fontSize: Int,
    fontWeight: FontWeight,
    color: Int,
    visualTransformation: VisualTransformation) {

    BasicTextField(
        value = inputText,
        onValueChange = { onValueChanged(it) },
        textStyle = TextStyle(
            fontSize = fontSize.sp,
            fontWeight = fontWeight,
            color = colorResource(id = color)
        ),
        singleLine = true,
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
        },
        visualTransformation = visualTransformation
    )
}


@Composable
fun PairImagesStart(
    startImageId: Int,
    startImageWidth: Int,
    startImageHeight: Int,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {


        MyImage(
            imageId = startImageId,
            modifier = Modifier
                .width(startImageWidth.dp)
                .height(startImageHeight.dp)
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
fun PairImagesEnd(
    imageEndId: Int,
    imageEndWidth: Int,
    imageEndHeigh: Int
) {

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
            imageId = imageEndId,
            modifier = Modifier
                .height(imageEndHeigh.dp)
                .width(imageEndWidth.dp)
        )

    }
}



@Preview
@Composable
private fun InputTextPreview() {
    InputText(
        inputText = "input value",
        onValueChanged = {},
        textColor = R.color.black,
        fontSize = 20,
        fontWeight = FontWeight(400),
        labelTitle = "My label",
        errorMessage = " error message ",
        placeHolder = "this is my input text ",
        hasImageStart = true,
        hasImageEnd = true,
        hasError = true,
        imageStartId = R.drawable.ic_launcher_background,
        imageStartWidth = 20,
        imageStartHeight = 20,
        imageEndId = R.drawable.ic_launcher_background,
        imageEndWidth = 20,
        imageEndHeight = 20,
    )
}



/*
    1. Add Util classes for colors, drawables, etc
    2. add modules for di and cache
    3. add ApiResponse sealed class
    4. add bottom navigation bar
    5. example of navgraph and screens
    6. splash screen
    7. shared view model code

 */
