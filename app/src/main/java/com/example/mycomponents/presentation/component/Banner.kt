package com.example.mycomponents.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomponents.R


@Composable
fun Banner(
    modifier: Modifier,
    image: Int,
    title:String,
    secondaryText: String,
    showRightArrowImage:Boolean = false) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(20.dp, 0.dp)
            .background(
                color = colorResource(id = R.color.white),
                shape = RoundedCornerShape(100.dp)
            ),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier.width(20.dp))
        MyImage(
            imageId = image,
            modifier = Modifier.size(36.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))


        Column(
            modifier = Modifier.weight(1f)
        ) {
            MyTitle(
                title = title,
                fontSize = 14.sp,
                textAlignment = TextAlign.Start,
                modifier = Modifier.padding(0.dp)
            )
            MyText(
                text = secondaryText,
                fontSize = 14.sp,
                textAlignment = TextAlign.Start,
                modifier = Modifier.padding(0.dp)
            )
        }

        if (showRightArrowImage) {
            MyImage(
                imageId = R.drawable.right_arrow,
                modifier = Modifier.size(9.dp, 16.dp)
            )

            Spacer(modifier = Modifier.width(15.dp))
        }


    }
}







@Preview
@Composable
fun SetUpProfileBannerPreview() {
    Banner(Modifier, R.drawable.person_image," asdad", "xaxaxa", true)
}