package com.example.moviles.ui.recipes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.moviles.R

class RecipesActivity : AppCompatActivity() {

    private lateinit var recipesListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)

        // Botón de cerrar sesión
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        recipesListView = findViewById(R.id.recipesListView)

        // Ejemplo de recetas
        val recipes = listOf(
            Recipe(R.drawable.recipe_image_1, "Receta pizza"),
            Recipe(R.drawable.recipe_image_2, "Receta secodepollo")
            // Agrega más recetas aquí
        )

        val adapter = RecipesAdapter(recipes)
        recipesListView.adapter = adapter

        btnLogout.setOnClickListener {
            // Cierra sesión
            finish() // Regresa a la pantalla de inicio de sesión
        }
    }
}
