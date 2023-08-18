package com.example.mycomponents.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomponents.R


@Composable
fun Keyboard(
    numberButtonClicked: (String)-> Unit,
    backspaceClicked: ()-> Unit,
    continueButtonClicked: ()-> Unit = {},
    isButtonEnabled: Boolean = true,
    modifier: Modifier = Modifier,
    hasButton: Boolean = false) {
    val keyboard = remember { listOf("1", "2", "3",
                                     "4","5", "6",
                                     "7","8", "9",
                                     "", "0", R.drawable.backspace_keyboard) }


    Column(
        modifier = modifier
            .wrapContentSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
        ) {

            items(keyboard) { item ->

                if (item == R.drawable.backspace_keyboard)
                    BackSpaceButton(
                        onClick = { backspaceClicked() }
                    )
                else if (item == "") {  }
                else
                    KeyboardButton(
                        digit = item.toString(),
                        onClick = {  numberButtonClicked(item.toString()) }
                    )

            }
        }

        if (hasButton) {
            PrimaryButton(
                buttonTitle = "Continue",
                isEnabled = isButtonEnabled,
                onButtonClicked = { continueButtonClicked() },
                modifier = Modifier)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}


@Preview
@Composable
private fun KeyboardPreview() {
    Keyboard(
        numberButtonClicked = {},
        continueButtonClicked = {},
        backspaceClicked = {},
        modifier = Modifier,
        hasButton = true)
}




@Composable
fun KeyboardButton(digit: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(4.dp),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            colorResource(id = R.color.white)
        ),
        shape = RoundedCornerShape(5.dp),
        ) {

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .size(107.dp, 46.dp)
                .background(color = colorResource(id = R.color.white))
        ) {
            MyText(
                text = digit,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                textAlignment = TextAlign.Center,
                color = R.color.black,
                fillMaxWidth = false,
                modifier = Modifier.padding(bottom = 2.dp)
            )
        }

    }
}


@Composable
fun BackSpaceButton (onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .size(107.dp, 46.dp),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            Color.Transparent
        ),
        shape = RoundedCornerShape(5.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.backspace_keyboard),
            contentDescription = null,
            modifier = Modifier.size(22.dp, 18.dp)
        )
    }
}



