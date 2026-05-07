package com.geanpierre.saborandino.ui.theme.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.geanpierre.saborandino.data.dishes

@Composable
fun DetailScreen(navController: NavController, dishId: Int) {

    val dish = dishes.find { it.id == dishId }

    Column {

        Text(dish?.name ?: "")
        Text(dish?.description ?: "")
        Text("S/. ${dish?.price}")

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Volver")
        }
    }
}