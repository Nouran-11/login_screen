package com.example.app.loginScreen

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val rememberMe: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val emailError: String? = null,
    val passwordError: String? = null,
    val isLoading: Boolean = false,
    val loginSuccess: Boolean = false
)

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email, emailError = null) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password, passwordError = null) }
    }

    fun onRememberMeToggle(isChecked: Boolean) {
        _uiState.update { it.copy(rememberMe = isChecked) }
    }

    fun onTogglePasswordVisibility() {
        _uiState.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }

    fun onForgotPasswordClick() {
        println("Forgot Password Clicked")
    }

    fun onSignUpClick() {
        println("Sign Up Clicked")
    }

    fun onLoginClick() {
        _uiState.update { it.copy(emailError = null, passwordError = null) }

        val email = _uiState.value.email
        val password = _uiState.value.password

        if (email.isBlank()) {
            _uiState.update { it.copy(emailError = "Email cannot be empty") }
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _uiState.update { it.copy(emailError = "Invalid email format") }
            return
        }
        if (password.isBlank()) {
            _uiState.update { it.copy(passwordError = "Password cannot be empty") }
            return
        }


        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                _uiState.update { it.copy(loginSuccess = true)}
                println("Login Successful!")
        } else {
                println("Login Failed!")
        }
    }
}