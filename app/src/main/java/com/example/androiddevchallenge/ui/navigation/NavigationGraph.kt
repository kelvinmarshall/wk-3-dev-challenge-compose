package com.example.androiddevchallenge.ui.navigation

import android.view.Window
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.HomeScreen
import com.example.androiddevchallenge.ui.LoginScreen
import com.example.androiddevchallenge.ui.WelcomeScreen


/**
 * Created by Kevin Macharia on 3/13/21.
 * Turnkey Africa LTD
 * kevin.macharia@turnkeyafrica.com
 */

@Composable
fun NavigationGraph(startDestination: String = Destinations.WELCOME) {
    val navController = rememberNavController()
    val actions = remember(navController) { NavigationActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Destinations.WELCOME) { WelcomeScreen(onClickLogin = actions.login) }

        composable(Destinations.LOGIN) { LoginScreen(onClickLogin = actions.home) }

        composable(Destinations.HOME) { HomeScreen() }
    }
}