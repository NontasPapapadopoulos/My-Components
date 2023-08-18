package com.example.mycomponents.presentation.component.country

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.mycomponents.presentation.util.CountriesUtil.Companion.setFlag


@Composable
fun CountryFlag(selectedCountryCode: String) {


    setFlag(countryCode = selectedCountryCode, context = LocalContext.current)?.let {
        Image(
        bitmap = it.asImageBitmap(),
        contentDescription = "",
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape)
        )
    }

}



