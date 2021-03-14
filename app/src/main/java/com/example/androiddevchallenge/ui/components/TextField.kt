/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            InputTextField(onValueChange = {}, placeHolderText = "Password")
        }
    }
}

@Preview
@Composable
fun InputTextFieldPreviewDark() {
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            InputTextField(onValueChange = {}, placeHolderText = "Password")
        }
    }
}
