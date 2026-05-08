package com.geanpierre.saborandino.ui.theme.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.geanpierre.saborandino.data.dishes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavController) {

    var selectedCategory by remember { mutableStateOf("Todos") }

    val filtered = if (selectedCategory == "Todos") dishes
    else dishes.filter { it.category == selectedCategory }

    Scaffold(
        topBar = { TopBar("Menú", navController) }
    ) { padding ->

        Column(modifier = Modifier.padding(padding)) {

            Row(modifier = Modifier.padding(8.dp)) {
                listOf("Todos","Entradas","Fondo","Postres","Bebidas").forEach {
                    Button(
                        onClick = { selectedCategory = it },
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(it)
                    }
                }
            }

            LazyColumn {
                items(filtered) { dish ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                navController.navigate("detail/${dish.id}")
                            }
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(dish.name, style = MaterialTheme.typography.titleMedium)
                            Text("S/. ${dish.price}")
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String, navController: NavController) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
            }
        }
    )
}