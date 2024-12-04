package app.loococo.presentation.screen.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.loococo.presentation.screen.AppRoute

fun NavGraphBuilder.homeScreen() {
    composable<AppRoute.Home> {
        HomeRoute()
    }
}