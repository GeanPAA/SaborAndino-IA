package com.geanpierre.saborandino.ui.theme.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Bienvenido 👋", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate("menu") }
        ) {
            Text("Ver Menú", modifier = Modifier.padding(16.dp))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate("profile") }
        ) {
            Text("Mi Pedido", modifier = Modifier.padding(16.dp))
        }
    }
}