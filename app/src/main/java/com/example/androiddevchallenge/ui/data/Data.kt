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
package com.example.androiddevchallenge.ui.data

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

/**
 * Created by Kevin Macharia on 3/13/21.
 * Turnkey Africa LTD
 * kevin.macharia@turnkeyafrica.com
 */

data class Data(
    val title: String,
    @DrawableRes val image: Int
)

val favoriteCollections = listOf(
    Data("Short mantras", R.drawable.short_mantra),
    Data("Stress and anxiety", R.drawable.stress_and_anxiety),
    Data("Overwhelmed", R.drawable.overwhelmed),
    Data("Nature meditations", R.drawable.nature_meditations),
    Data("Self-massage", R.drawable.self_massage),
    Data("Nightly wind down", R.drawable.nightly_wind_down),
)

val alignYourBody = listOf(
    Data("Inversions", R.drawable.inversions),
    Data("Quick Yoga", R.drawable.quick_yoga),
    Data("Stretching", R.drawable.stretching),
    Data("Tabata", R.drawable.tabata),
    Data("HIIT", R.drawable.hiit),
    Data("Pre-natal Yoga", R.drawable.pre_natal_yoga),
)

val alignYourMind = listOf(
    Data("Meditate", R.drawable.meditate),
    Data("With kids", R.drawable.with_kids),
    Data("Aromatherapy", R.drawable.aeromatherapy),
    Data("On the go", R.drawable.on_the_go),
    Data("With pets", R.drawable.with_pets),
    Data("High stress", R.drawable.high_stress)
)
