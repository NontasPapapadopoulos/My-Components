package com.example.mycomponents.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomponents.R



@Composable
fun OtpEntry(
    otpValue: String = "",
    otpLength: Int = 6,
    modifier: Modifier,

) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .height(48.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until otpLength) {
            val isFilled = i < otpValue.length
            val isCurrent = i == otpValue.length-1


            Box(
                modifier = Modifier
                    .size(48.dp)
//                    .border(
//                        width = if (isCurrent) 2.dp else 1.dp,
//                      //  color = colorResource(id = getBorderColorForPasscode(isFocused = isCurrent)),
//                        shape = CircleShape
//                    )
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {

                if (isFilled) {
                    val digit = otpValue[i].toString()
                    MyText(
                        textAlignment = TextAlign.Center,
                        text = digit,
                        fontSize = 24.sp,
                        color = R.color.black,
                        fillMaxWidth = false
                    )
                }
            }

            // i want to prevent to add space at the right of the last circle.
            val isNotTheLastCircle =  i < otpLength-1
            if (isNotTheLastCircle) {
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }


}




@Preview
@Composable
fun OtpEntryPreview() {
    OtpEntry(otpLength = 6, modifier = Modifier )
}