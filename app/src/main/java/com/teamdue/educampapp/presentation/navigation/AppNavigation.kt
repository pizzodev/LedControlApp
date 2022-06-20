package com.teamdue.educampapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.teamdue.educampapp.presentation.screens.MainScreen

enum class AppScreens {
    MainScreen
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.MainScreen.name
    ) {

        composable(route = AppScreens.MainScreen.name) {
            MainScreen(navController)
        }

    }
}