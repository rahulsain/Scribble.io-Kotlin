package com.rahuls.scribbleio.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rahuls.scribbleio.ui.theme.*

@Composable
fun PrimaryButton(
    onClick: (() -> Unit)? = null,
    text: String,
    enabled: Boolean = true,
    marginTop: Dp = 0.dp,
    marginBottom: Dp = 0.dp,
    marginLeft: Dp = 0.dp,
    marginRight: Dp = 0.dp
) {
    AppButton(
        onClick = onClick,
        text = text,
        enabled = enabled,
        backgroundColor = PrimaryButtonColor,
        textColor = LightTextColor,
        marginTop = marginTop,
        marginBottom = marginBottom,
        marginLeft = marginLeft,
        marginRight = marginRight
    )
}

@Composable
fun SecondaryButton(
    onClick: (() -> Unit)? = null,
    text: String,
    enabled: Boolean = true,
    marginTop: Dp = 0.dp,
    marginBottom: Dp = 0.dp,
    marginLeft: Dp = 0.dp,
    marginRight: Dp = 0.dp
) {
    AppButton(
        onClick = onClick,
        text = text,
        enabled = enabled,
        backgroundColor = SecondaryButtonColor,
        textColor = DefaultTextColor,
        marginTop = marginTop,
        marginBottom = marginBottom,
        marginLeft = marginLeft,
        marginRight = marginRight
    )
}

@Composable
private fun AppButton(
    onClick: (() -> Unit)? = null,
    text: String,
    enabled: Boolean = true,
    backgroundColor: Color = DefaultButtonColor,
    textColor: Color = DefaultTextColor,
    marginTop: Dp = 0.dp,
    marginBottom: Dp = 0.dp,
    marginLeft: Dp = 0.dp,
    marginRight: Dp = 0.dp
) {
    Button(
        onClick = { onClick?.invoke() },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = marginTop, bottom = marginBottom, start = marginLeft, end = marginRight),
        enabled = enabled,
        contentPadding = PaddingValues(vertical = 24.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
        )
    ) {
        Text(
            text = text,
            color = textColor
        )
    }
}

@Preview
@Composable
fun ButtonPreview() {
    SecondaryButton(text = "Sample Button")
}
