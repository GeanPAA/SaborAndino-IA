package com.geanpierre.saborandino.ui.theme.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.geanpierre.saborandino.data.Cart
import com.geanpierre.saborandino.ui.theme.menu.TopBar

@Composable
fun ProfileScreen(navController: NavController) {

    val total = Cart.items.sumOf { it.price }

    Scaffold(
        topBar = { TopBar("Mi Pedido", navController) }
    ) { padding ->

        Column(modifier = Modifier.padding(padding)) {

            LazyColumn {
                items(Cart.items) {
                    Text(it.name, modifier = Modifier.padding(8.dp))
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Total: S/. $total",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}