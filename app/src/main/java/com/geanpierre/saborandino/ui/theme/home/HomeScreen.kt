package com.geanpierre.saborandino.ui.theme.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    Column {

        Text("Bienvenido 👋")

        Button(onClick = {
            navController.navigate("menu")
        }) {
            Text("Ver Menú")
        }

        Button(onClick = {
            navController.navigate("profile")
        }) {
            Text("Mi Perfil")
        }
    }
}