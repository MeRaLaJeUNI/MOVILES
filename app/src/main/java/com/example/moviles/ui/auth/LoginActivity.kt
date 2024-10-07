package com.example.moviles.ui.auth

import android.content.Intent // Agregar esta importación
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.moviles.R
import com.example.moviles.ui.recipes.RecipesActivity // Asegúrate de importar la nueva actividad
import com.example.moviles.viewmodel.AuthViewModel

class LoginActivity : AppCompatActivity() {

    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            authViewModel.loginUser(email, password)
        }

        authViewModel.user.observe(this) { user ->
            if (user != null) {
                Toast.makeText(this, "Login exitoso", Toast.LENGTH_SHORT).show()

                // Iniciar la RecipesActivity
                val intent = Intent(this, RecipesActivity::class.java)
                startActivity(intent)
                finish() // Cerrar LoginActivity si es necesario
            }
        }

        authViewModel.error.observe(this) { error ->
            error?.let {
                Toast.makeText(this, "Error: $it", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


