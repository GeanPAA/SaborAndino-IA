package com.geanpierre.saborandino.ui.theme.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            if (email.isEmpty() || password.isEmpty()) {
                error = "Completa todos los campos"
            } else {
                navController.navigate("home")
            }
        }) {
            Text("Ingresar")
        }

        if (error.isNotEmpty()) {
            Text(error, color = Color.Red)
        }
    }
}