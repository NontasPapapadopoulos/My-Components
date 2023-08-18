package com.example.mycomponents.presentation.component


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomponents.domain.model.Country
import com.example.mycomponents.presentation.component.country.CountriesContainer
import com.example.mycomponents.presentation.component.country.CountryFlag
import com.example.mycomponents.presentation.component.inputText.MyBasicTextField
import com.example.mycomponents.presentation.util.CountriesUtil.Companion.getCountriesFromJsonFile
import com.example.mycomponents.R
import com.example.mycomponents.presentation.util.ColorUtil.Companion.getBackgroundColor
import com.example.mycomponents.presentation.util.ColorUtil.Companion.getBorderColor
import com.example.mycomponents.presentation.util.ColorUtil.Companion.getTextColor


@Composable
fun FlykkMobileInputText(
    inputValue: String,
    valueEntered: (String) ->Unit,
    isValidationSuccessful: Boolean = true,
    hasLabel: Boolean = true,
    labelTitle: String = "",
    selectedCountry: Country,
    onCountrySelected: (Country) -> Unit,
    placeholder: String,
    modifier: Modifier) {

    val isFocused = remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }

    val countries = getCountriesFromJsonFile()

    Column(
        modifier = modifier
    ) {

        if (hasLabel) {
            FieldLabel(
                labelTitle = labelTitle,
                color = getTextColor(isValidationSuccessful)
            )
            Spacer(modifier = Modifier.height(6.dp))
        }


        Row(
            modifier = Modifier
                .height(43.dp)
                .fillMaxWidth()
                .focusRequester(FocusRequester())
                .onFocusChanged { isFocused.value = it.isFocused }
                .border(
                    width = if (isFocused.value) 2.dp else 1.dp,
                    color = colorResource(
                        id = getBorderColor(
                            isFocused = isFocused.value,
                            isValidationSuccessful
                        )
                    ),
                    shape = RoundedCornerShape(36.dp)
                )
                .background(
                    color = colorResource(id = getBackgroundColor(isValidationSuccessful)),
                    shape = RoundedCornerShape(36.dp)
                )
                .padding(14.dp, 0.dp),

            verticalAlignment = Alignment.CenterVertically
        )
        {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .wrapContentWidth()
                    .clickable { expanded = true }
            ) {


                if (selectedCountry.code.isNotEmpty()) {
                    CountryFlag(selectedCountry.code)

                    MyImage(
                        imageId = R.drawable.line,
                        modifier = Modifier.size(16.dp, 18.dp)
                    )
                }

                MyText(
                    text = selectedCountry.dialCode,
                    fontSize = 16.sp,
                    color = R.color.black,
                    fillMaxWidth = false
                )

                AddHorizontalSpace()

                MyBasicTextField(
                    inputText = inputValue,
                    onValueChanged = { valueEntered(it) },
                    isValidationSuccessful = isValidationSuccessful,
                    isNumberPad = true,
                    placeHolder = placeholder,
                    fontSize = 16,
                    visualTransformation = VisualTransformation.None,
                )

            }

        }

        if (expanded)
            CountriesContainer(
                countries = countries,
                onOptionSelected = { onCountrySelected(it) },
                onExpandedChange = { isExpanded -> expanded = isExpanded },
                withDialCode = true
            )
    }
}




//@Preview
//@Composable
//fun FlykkMobileInputTextPreview() {
//    FlykkMobileInputText(
//        inputValue = "",
//        {},
//        true,
//        placeholder = "place holder",
//        labelTitle = "label",
//        selectedCountry = Country(),
//        onCountrySelected = {},
//        hasLabel = true,
//        modifier = Modifier)
//}