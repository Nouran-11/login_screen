package com.example.app.signUp

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.example.app.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class SignUpUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isPasswordVisible: Boolean = false,
    val isConfirmPasswordVisible: Boolean = false,
    val rememberMe: Boolean = false,

    @param:StringRes val nameError: Int? = null,
    @param:StringRes val emailError: Int? = null,
    @param:StringRes val passwordError: Int? = null,
    @param:StringRes val confirmPasswordError: Int? = null,

    val signUpSuccess: Boolean = false
)


class SignUpViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState = _uiState.asStateFlow()

    fun onNameChange(name: String) {
        _uiState.update { it.copy(name = name, nameError = null) }
    }

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email, emailError = null) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password, passwordError = null) }
    }

    fun onConfirmPasswordChange(password: String) {
        _uiState.update { it.copy(confirmPassword = password, confirmPasswordError = null) }
    }

    fun onTogglePasswordVisibility() {
        _uiState.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }

    fun onToggleConfirmPasswordVisibility() {
        _uiState.update { it.copy(isConfirmPasswordVisible = !it.isConfirmPasswordVisible) }
    }

    fun onLoginClick() {

        println("Navigate to Login Screen")
    }
    fun onRememberMeToggle(isChecked: Boolean) {
        _uiState.update { it.copy(rememberMe = isChecked) }
    }
//    fun onForgotPasswordClick() {
//        println("Forgot Password Clicked")
//    }

    fun onSignUpClick() {
        _uiState.update { it.copy(nameError = null, emailError = null, passwordError = null, confirmPasswordError = null) }

        val state = _uiState.value
        var hasError = false


        if (state.name.isBlank()) {
            _uiState.update { it.copy(nameError = R.string.signup_error_name_empty) }
            hasError = true
        }

        if (validateEmail()) {
            hasError = true
        }

        if (state.password.isBlank()) {
            _uiState.update { it.copy(passwordError = R.string.login_error_password_empty) }
            hasError = true
        }


        if (state.password != state.confirmPassword) {
            _uiState.update { it.copy(confirmPasswordError = R.string.signup_error_password_mismatch) }
            hasError = true
        }

        if (hasError) return


        _uiState.update { it.copy(signUpSuccess = true) }
        println("Sign Up Successful!")
    }
    fun validateEmail(): Boolean {
        if (_uiState.value.email.isBlank()) {
            _uiState.update { it.copy(emailError = R.string.login_error_email_empty) }
             return true
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(_uiState.value.email).matches()) {
            _uiState.update { it.copy(emailError = R.string.login_error_email_invalid) }
            return true
        }
        return false
    }
}