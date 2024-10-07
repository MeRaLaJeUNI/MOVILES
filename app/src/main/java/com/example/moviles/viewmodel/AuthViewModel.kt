package com.example.moviles.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviles.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser

class AuthViewModel : ViewModel() {
    private val authRepository = AuthRepository()
    private val _user = MutableLiveData<FirebaseUser?>()
    val user: LiveData<FirebaseUser?> = _user
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun loginUser(email: String, password: String) {
        authRepository.loginUser(email, password) { firebaseUser, errorMsg ->
            _user.value = firebaseUser
            _error.value = errorMsg
        }
    }

    fun registerUser(email: String, password: String) {
        authRepository.registerUser(email, password) { firebaseUser, errorMsg ->
            _user.value = firebaseUser
            _error.value = errorMsg
        }
    }
}
