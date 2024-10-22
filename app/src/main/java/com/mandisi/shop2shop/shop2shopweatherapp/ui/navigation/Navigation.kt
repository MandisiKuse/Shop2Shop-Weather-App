package com.mandisi.shop2shop.shop2shopweatherapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mandisi.shop2shop.shop2shopweatherapp.ui.screen.WeatherScreen

val localNavController = compositionLocalOf<NavHostController> {
    error("No NavController provided!")
}

@Composable
fun AppNavHost() {
    val navController = localNavController.current

    NavHost(
        navController = navController,
        startDestination = Screens.WEATHER_SCREEN.name,
        modifier = Modifier
    ) {
        composable(Screens.WEATHER_SCREEN.name) { WeatherScreen() }
    }
}