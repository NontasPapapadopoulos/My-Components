package com.example.mycomponents

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.res.painterResource
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
    hasErrorMessage: Boolean,
    hasLabel: Boolean,
    hasImageStart: Boolean,
    hasImageEnd: Boolean,

) {

    Column() {

        if (hasLabel)
            Text(
                text = labelTitle
            )



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp)
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
                if (hasImageStart) {
                    MyImage(
                        imageId = R.drawable.ic_launcher_background,
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.width(10.dp))
                }

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



            if (hasImageEnd) {
                MyImage(
                    imageId = R.drawable.ic_launcher_background,
                    modifier = Modifier.size(20.dp)
                )
            }

        }

    }



}




@Preview
@Composable
private fun InputTextPreview() {
    InputText(
        inputText = "input value",
        labelTitle = "",
        errorMessage = "",
        placeHolder = "this is my input text ",
        hasErrorMessage = false,
        hasLabel = false,
        hasImageStart = true,
        hasImageEnd = true ,

    )
}
