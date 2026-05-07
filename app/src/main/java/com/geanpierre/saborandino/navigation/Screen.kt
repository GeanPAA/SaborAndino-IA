package com.geanpierre.saborandino.navigation

sealed class Screen(val route: String) {

    object Login : Screen("login")
    object Home : Screen("home")
    object Menu : Screen("menu")
    object Detail : Screen("detail/{dishId}") {
        fun createRoute(dishId: Int) = "detail/$dishId"
    }
    object Profile : Screen("profile")

}