package com.example.moviles.ui.recipes

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon

@Composable
fun RecipesScreen(onLogout: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        // Card para mostrar un botón de menú
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp) // Especificar el parámetro defaultElevation
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Recetas")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onLogout) {
            Text("Cerrar sesión")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Aquí agregarás el código para mostrar la lista de recetas
        Text(text = "Lista de Recetas")
        // Puedes utilizar un LazyColumn para mostrar la lista de recetas
    }
}

