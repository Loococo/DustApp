package app.loococo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.loococo.presentation.screen.AppRoute
import app.loococo.presentation.screen.home.homeScreen

@Composable
fun DustNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoute.Home
    ) {
        homeScreen()
    }
}