package com.example.moviles.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthRepository {
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun loginUser(email: String, password: String, callback: (FirebaseUser?, String?) -> Unit) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    callback(firebaseAuth.currentUser, null) // Usuario logueado correctamente
                } else {
                    callback(null, task.exception?.message) // Error
                }
            }
    }

    fun registerUser(email: String, password: String, callback: (FirebaseUser?, String?) -> Unit) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    callback(firebaseAuth.currentUser, null) // Usuario registrado correctamente
                } else {
                    callback(null, task.exception?.message) // Error
                }
            }
    }
}

