package com.rahuls.scribbleio.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppTextField(
    onValueChange: ((input: String) -> Unit)? = null,
    value: String = "",
    label: String,
    enabled: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    marginTop: Dp = 0.dp,
    marginBottom: Dp = 0.dp,
    marginLeft: Dp = 0.dp,
    marginRight: Dp = 0.dp
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = marginTop, bottom = marginBottom, start = marginLeft, end = marginRight),
        textStyle = TextStyle(color = Color.Black),
        value = value,
        enabled = enabled,
        onValueChange = { onValueChange?.invoke(it) },
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}

@Preview
@Composable
fun TextFieldPreview() {
    AppTextField(
        label = "Sample Text Field",
        value = "Sample Input"
    )
}
