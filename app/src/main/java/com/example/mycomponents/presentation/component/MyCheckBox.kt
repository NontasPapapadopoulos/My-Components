package com.example.mycomponents.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycomponents.R



@Composable
fun MyCheckBox(
    text: String,
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable { onCheckedChange(!isChecked) }
    ) {


        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = colorResource(id = R.color.black),
                uncheckedColor = colorResource(id = R.color.purple_200)
            ),
            modifier = Modifier
                .clip(CircleShape)
                .padding(4.dp)
                .size(12.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = text,
            modifier = Modifier.padding(start = 8.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = LocalContentAlpha.current.let { contentAlpha ->
                if (isChecked) {
                    Color.Black
                } else {
                    Color.Gray.copy(alpha = ContentAlpha.disabled)
                }
            }
        )

    }
}


@Preview
@Composable
private fun FlykkCheckBoxPreview() {
    MyCheckBox("remember me",Modifier, true, {})
}