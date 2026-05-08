package com.geanpierre.saborandino.ui.theme.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.geanpierre.saborandino.data.Cart
import com.geanpierre.saborandino.data.dishes
import com.geanpierre.saborandino.ui.theme.menu.TopBar

@Composable
fun DetailScreen(navController: NavController, dishId: Int) {

    val dish = dishes.find { it.id == dishId }

    Scaffold(
        topBar = { TopBar("Detalle", navController) }
    ) { padding ->

        Column(modifier = Modifier
            .padding(padding)
            .padding(16.dp)
        ) {

            Text(dish?.name ?: "", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))

            Text(dish?.description ?: "")
            Spacer(modifier = Modifier.height(8.dp))

            Text("S/. ${dish?.price}")

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                dish?.let { Cart.items.add(it) }
            }) {
                Text("Agregar al pedido")
            }
        }
    }
}