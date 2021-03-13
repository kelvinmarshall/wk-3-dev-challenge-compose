package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.WelcomeScreen
import com.example.androiddevchallenge.ui.theme.MyTheme


/**
 * Created by Kevin Macharia on 3/13/21.
 * Turnkey Africa LTD
 * kevin.macharia@turnkeyafrica.com
 */
@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    leadingIcon: @Composable () -> Unit = {},
    onValueChange: (String) -> Unit = {},
    placeHolderText: String,
) {
    TextField(
        value = value,
        leadingIcon = leadingIcon,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                placeHolderText,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
            )
        },
        modifier = modifier.fillMaxWidth()
            .height(56.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            cursorColor = MaterialTheme.colors.onSurface
        )
    )
}

@Preview
@Composable
fun InputTextFieldPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            InputTextField(onValueChange = {} ,placeHolderText = "Password")
        }

    }
}

@Preview
@Composable
fun InputTextFieldPreviewDark() {
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            InputTextField(onValueChange = {} ,placeHolderText = "Password")
        }

    }
}