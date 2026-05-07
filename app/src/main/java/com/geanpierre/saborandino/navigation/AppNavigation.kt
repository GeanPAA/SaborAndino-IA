package com.geanpierre.saborandino.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.geanpierre.saborandino.ui.theme.detail.DetailScreen
import com.geanpierre.saborandino.ui.theme.home.HomeScreen
import com.geanpierre.saborandino.ui.theme.login.LoginScreen
import com.geanpierre.saborandino.ui.theme.menu.MenuScreen
import com.geanpierre.saborandino.ui.theme.profile.ProfileScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {

        composable(Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(Screen.Menu.route) {
            MenuScreen(navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("dishId") {
                type = NavType.IntType
            })
        ) { backStackEntry ->

            val dishId = backStackEntry.arguments?.getInt("dishId") ?: 0
            DetailScreen(navController, dishId)

        }

        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}