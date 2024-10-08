package com.example.moviles.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val _user = MutableLiveData<FirebaseUser?>()
    val user: LiveData<FirebaseUser?> get() = _user

    init {
        _user.value = auth.currentUser // Chequea si hay un usuario logueado al iniciar
    }

    fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                _user.value = auth.currentUser // Actualiza el usuario logueado
            } else {
                _user.value = null // Si hay un error, asegúrate de que el valor sea null
            }
        }
    }

    fun logoutUser() {
        auth.signOut()
        _user.value = null // Actualiza el estado del usuario tras cerrar sesión
    }
}

