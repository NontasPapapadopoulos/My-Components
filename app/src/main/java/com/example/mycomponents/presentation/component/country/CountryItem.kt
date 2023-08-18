package com.example.mycomponents.presentation.component.country

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomponents.R
import com.example.mycomponents.domain.model.Country
import com.example.mycomponents.presentation.component.MyText


@Composable
fun CountryItem(
    country: Country,
    withDialCode: Boolean = false,
    onClick: ()-> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 10.dp)
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (country.code.isNotEmpty())
            CountryFlag(selectedCountryCode = country.code)

        Spacer(modifier = Modifier.width(10.dp))

        if (withDialCode) {
            MyText(
                text = country.dialCode,
                fontSize = 16.sp,
                color = R.color.black,
                fillMaxWidth = false
            )

            Spacer(modifier = Modifier.width(10.dp))
        }

        MyText(
            text = country.name,
            fontSize = 16.sp,
            color = R.color.black,
            fillMaxWidth = false
        )
    }

}