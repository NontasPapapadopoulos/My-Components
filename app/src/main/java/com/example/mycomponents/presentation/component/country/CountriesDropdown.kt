package com.example.mycomponents.presentation.component.country

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomponents.domain.model.Country
import com.example.mycomponents.presentation.component.AddVerticalSpace
import com.example.mycomponents.presentation.component.FieldLabel
import com.example.mycomponents.presentation.component.MyPlaceholder
import com.example.mycomponents.presentation.component.MyText
import com.example.mycomponents.presentation.component.inputText.PairImagesEnd
import com.example.mycomponents.presentation.util.CountriesUtil.Companion.getCountriesFromJsonFile

import com.example.mycomponents.R


@Composable
fun CountriesDropdown(
    labelTitle: String = "",
    modifier: Modifier = Modifier,
    selectedCountry: Country,
    onCountrySelected: (Country) -> Unit,
    ) {

    // TODO: Find a way to switch expanded to false when the user taps on the screen.

    var expanded by remember { mutableStateOf(false) }

    val countries  = getCountriesFromJsonFile()

    Column(
        modifier
            .fillMaxWidth()
    ) {

        if (labelTitle.isNotEmpty()) {
            FieldLabel(labelTitle = labelTitle)
            AddVerticalSpace(6)
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp)
                .clickable(
                    onClick = { expanded = true })
                .border(
                    1.dp,
                    color = colorResource(id = R.color.black),
                    shape = RoundedCornerShape(36.dp)
                )
                .background(
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(36.dp)
                )
                .padding(14.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {


            if (selectedCountry.name.isEmpty())
                MyPlaceholder(placeholder = "Select country")
            else {
                MyText(
                    text = selectedCountry.name,
                    color = R.color.black,
                    fontSize = 16.sp,
                    fillMaxWidth = false
                )
            }

            PairImagesEnd(
                imageEndId = if (expanded)  R.drawable.grey_up_arrow else R.drawable.dropdown_arrow,
                imageEndWidth = 16,
                imageEndHeight = 8,
                spaceBetween = 13,
                endImageHasVerticalLine = true
            )

        }

        if (expanded) {
            CountriesContainer(
                countries = countries,
                onOptionSelected = { onCountrySelected(it) },
                onExpandedChange = { isExpanded -> expanded = isExpanded }
            )
        }
    }
}



@Composable
fun CountriesContainer(
    countries: List<Country>,
    onOptionSelected: (Country) -> Unit,
    onExpandedChange: (Boolean) -> Unit,
    withDialCode: Boolean = false,
) {

    AddVerticalSpace()

    Box(
        Modifier
            .fillMaxWidth()
            .height(330.dp)
            .border(
                1.dp,
                color = colorResource(id = R.color.black),
                shape = RoundedCornerShape(24.dp)
            )
            .background(
                color = colorResource(id = R.color.white),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(0.dp, 20.dp)
    ) {

        LazyColumn {
            items(countries.size) { index ->
                CountryItem(
                    country = countries[index],
                    withDialCode = withDialCode,
                    onClick = {
                        onOptionSelected(countries[index])
                        onExpandedChange(false)
                    }
                )
            }
        }
    }
}





@Preview
@Composable
fun CountriesDropdownPreview() {
   // CountriesDropdown("Country of residence", "Select country", Modifier, "")
    val country = Country(name = "Greece", code = "CY", dialCode = "+30")
    CountryItem(country = country , onClick = {})

    CountriesDropdown(
        labelTitle = "asdasda",
        modifier = Modifier,
        selectedCountry = country ,
        onCountrySelected = {}
    )

}