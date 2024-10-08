package com.example.moviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moviles.ui.recipes.RecipesScreen
import com.example.moviles.viewmodel.AuthViewModel
import com.example.moviles.viewmodel.ThemeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val authViewModel: AuthViewModel = viewModel()
            val themeViewModel: ThemeViewModel = viewModel()

            // Observa el tema actual
            val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()
            val user = authViewModel.user.observeAsState()

            // Configura el tema aquí para toda la aplicación
            MaterialTheme(
                colorScheme = if (isDarkTheme) darkColorScheme() else lightColorScheme()
            ) {
                if (user.value == null) {
                    // Pantalla de login (implementa tu lógica aquí)
                } else {
                    Scaffold(
                        topBar = {
                            TopAppBarWithMenu(
                                onLogout = { authViewModel.logoutUser() },
                                onSettingsClick = { themeViewModel.toggleTheme() }
                            )
                        }
                    ) { innerPadding ->
                        RecipesScreen(
                            onLogout = { authViewModel.logoutUser() },
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithMenu(onLogout: () -> Unit, onSettingsClick: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text("Mis Recetas", fontWeight = FontWeight.Bold) },
        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Menu")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = {
                        expanded = false
                        onSettingsClick()
                    }
                )
                DropdownMenuItem(
                    text = { Text("Logout") },
                    onClick = {
                        expanded = false
                        onLogout()
                    }
                )
            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}
