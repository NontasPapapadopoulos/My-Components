package com.example.mycomponents.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomponents.R



@Composable
fun MyDropdown(
    labelTitle: String = "",
    hasLabel: Boolean = true,
    hint: String,
    modifier: Modifier,
    selection: String) {

    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(selection) }
    val options = listOf("Option 1", "Option 2", "Option 3")

    Column(
        modifier
            .fillMaxWidth()
            .padding(20.dp, 0.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        if (hasLabel) {
            FieldLabel(labelTitle = labelTitle)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { expanded = true })
                .border(
                    1.dp,
                    color = colorResource(id = R.color.black),
                    shape = RoundedCornerShape(36.dp)
                )
                .background(
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(36.dp)
                )
        ) {

            Box(
                modifier = Modifier.align(Alignment.CenterStart) ) {
                MyText(
                    text = if (selectedOption.isEmpty()) hint else selectedOption,
                    fillMaxWidth = false,
                    modifier = Modifier.padding(16.dp)
                )
            }


            Box(modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(46.dp, 0.dp)) {
                Image(
                    painterResource(id = R.drawable.grey_vertical_line),
                    contentDescription = null,
                    Modifier
                        .size(1.dp, 16.dp)

                )
            }

            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(18.dp, 0.dp)) {


                Image(
                    painterResource(id = R.drawable.dropdown_arrow),
                    contentDescription = null,
                    Modifier
                        .size(15.dp, 8.dp)
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        onClick = {
                            selectedOption = option
                            expanded = false
                        }
                    ) {
                        MyText(
                            text = option,
                            fontSize = 14.sp,
                            fillMaxWidth = false
                        )
                    }
                }
            }
        }
    }



}


@Preview
@Composable
fun FlykkDropdownPreview() {
    MyDropdown("Country of residence", false, "Select country", Modifier, "")
}