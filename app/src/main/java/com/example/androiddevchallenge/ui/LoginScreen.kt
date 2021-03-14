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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.BackgroundScreen
import com.example.androiddevchallenge.ui.components.InputTextField
import com.example.androiddevchallenge.ui.theme.MyTheme

/**
 * Created by Kevin Macharia on 3/13/21.
 * Turnkey Africa LTD
 * kevin.macharia@turnkeyafrica.com
 */

@Composable
fun LoginScreen(onClickLogin: () -> Unit = {}) {
    Surface(color = MaterialTheme.colors.background) {
        BackgroundScreen(painterRes = R.drawable.ic_login) {
            val textLogin = stringResource(id = R.string.log_in)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp),
            ) {
                Text(
                    textLogin,
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.paddingFromBaseline(top = 200.dp, bottom = 32.dp),
                )

                InputTextField(
                    modifier = Modifier.padding(top = 32.dp),
                    placeHolderText = stringResource(id = R.string.email_address),
                    onValueChange = {}
                )
                InputTextField(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    placeHolderText = stringResource(id = R.string.email_address),
                    onValueChange = {}
                )

                Button(
                    onClick = onClickLogin,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(72.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primary
                    ),
                    shape = MaterialTheme.shapes.medium,
                ) {
                    Text(
                        textLogin,
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onPrimary,
                    )
                }

                Text(
                    with(AnnotatedString.Builder()) {
                        append(stringResource(id = R.string.dont_have_account))
                        pushStyle(
                            SpanStyle(
                                textDecoration = TextDecoration.Underline,
                            )
                        )
                        append(" Sign up")
                        pop()
                        toAnnotatedString()
                    },
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.paddingFromBaseline(top = 32.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            LoginScreen {}
        }
    }
}

@Preview
@Composable
fun LoginScreenPreviewDark() {
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            LoginScreen {}
        }
    }
}
