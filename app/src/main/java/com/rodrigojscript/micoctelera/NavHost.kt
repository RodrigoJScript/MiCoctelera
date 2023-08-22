package com.rodrigojscript.micoctelera

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodrigojscript.micoctelera.ui.screens.Inicio
import com.rodrigojscript.micoctelera.ui.screens.RandomDrinkScreen


sealed class Screen(val route: String) {
    object Inicio: Screen("inicio")
    object Random : Screen("random")
}

@Composable
fun NavGraph() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Inicio.route) {
        composable(Screen.Inicio.route) { Inicio(navController) }
        composable(Screen.Random.route) { RandomDrinkScreen() }
    }
}