package com.geanpierre.saborandino.ui.theme.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {

    Column {

        Text("Mi Perfil")

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Volver")
        }
    }
}