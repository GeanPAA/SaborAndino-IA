package com.geanpierre.saborandino.ui.theme.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.geanpierre.saborandino.data.dishes

@Composable
fun MenuScreen(navController: NavController) {

    LazyColumn {

        items(dishes) { dish ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("detail/${dish.id}")
                    }
            ) {
                Column {
                    Text(dish.name)
                    Text("S/. ${dish.price}")
                }
            }
        }
    }
}