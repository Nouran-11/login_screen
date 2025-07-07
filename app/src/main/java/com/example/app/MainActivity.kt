package com.example.app


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app.loginScreen.LoginScreen
import com.example.app.loginScreen.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                LoginApp()
            }
        }
    }
}

@Composable
fun LoginApp() {
    val viewModel: LoginViewModel = viewModel()

    val uiState by viewModel.uiState.collectAsState()

    val context = LocalContext.current

    if (uiState.loginSuccess) {
            Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LoginScreen(
            email = uiState.email,
            password = uiState.password,
            rememberMe = uiState.rememberMe,
            isPasswordVisible = uiState.isPasswordVisible,
            emailError = uiState.emailError,
            passwordError = uiState.passwordError,
            onEmailChange = viewModel::onEmailChange,
            onPasswordChange = viewModel::onPasswordChange,
            onRememberMeToggle = viewModel::onRememberMeToggle,
            onTogglePasswordVisibility = viewModel::onTogglePasswordVisibility,
            onLoginClick = viewModel::onLoginClick,
            onForgotPasswordClick = viewModel::onForgotPasswordClick,
            onSignUpClick = viewModel::onSignUpClick
        )
    }
}