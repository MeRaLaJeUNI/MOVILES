package com.example.moviles.ui.recipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class RecipesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Tu contenido aquí
            Greeting()
        }
    }
}

@Composable
fun Greeting() {
    Text(text = "Bienvenido a la pantalla de recetas")
}
