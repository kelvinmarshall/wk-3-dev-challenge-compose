package com.example.androiddevchallenge.ui.navigation

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate


/**
 * Created by Kevin Macharia on 3/13/21.
 * Turnkey Africa LTD
 * kevin.macharia@turnkeyafrica.com
 */

class NavigationActions(navController: NavHostController) {
    val login: () -> Unit = { navController.navigate(Destinations.LOGIN) }

    val home: () -> Unit = { navController.navigate(Destinations.HOME) }

    val upPress: () -> Unit = { navController.navigateUp() }
}