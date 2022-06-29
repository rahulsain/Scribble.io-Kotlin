package com.rahuls.scribbleio.ui.main.group

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rahuls.scribbleio.R
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.rahuls.scribbleio.ui.components.AppTextField
import com.rahuls.scribbleio.ui.components.PrimaryButton
import com.rahuls.scribbleio.ui.main.MainViewModel
import com.rahuls.scribbleio.utils.DEFAULT_LIMIT_TIME
import com.rahuls.scribbleio.utils.DEFAULT_LIMIT_USER

@Composable
fun CreateGroupForm(viewModel: MainViewModel){
    var displayName by remember { mutableStateOf("") }
    var limitUser by remember { mutableStateOf(DEFAULT_LIMIT_USER) }
    var limitTime by remember { mutableStateOf(DEFAULT_LIMIT_TIME) }

    ConstraintLayout (
        modifier = Modifier.fillMaxSize()
            ) {
        val column = createRef()
        Column (
            modifier = Modifier.constrainAs(column) {
                top.linkTo(parent.top, 12.dp)
                bottom.linkTo(parent.bottom, 12.dp)
                start.linkTo(parent.start, 12.dp)
                end.linkTo(parent.end, 12.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            AppTextField(
                label = stringResource(id = R.string.display_name),
                marginTop = 16.dp,
                onValueChange = { displayName = it },
                value = displayName
            )

            AppTextField(
                label = stringResource(id = R.string.limit_user),
                keyboardType = KeyboardType.Number,
                marginTop = 16.dp,
                onValueChange = { limitUser = it.toInt() },
                value = limitUser.toString()
            )

            AppTextField(
                label = stringResource(id = R.string.limit_time),
                keyboardType = KeyboardType.Number,
                marginTop = 16.dp,
                onValueChange = { limitTime = it.toInt() },
                value = limitTime.toString()
            )

            PrimaryButton(
                onClick = {
                    viewModel.createGameGroup(displayName, limitUser, limitTime)
                },
                text = stringResource(id = R.string.create_group),
                marginTop = 24.dp
            )
        }
    }
}