package com.example.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.app.loginScreen.LoginScreen
import com.example.app.signUp.SignUpScreen
import androidx.navigation.compose.composable
import com.example.app.loginScreen.LoginViewModel
import com.example.app.signUp.SignUpViewModel

object AppRoutes {
    const val LOGIN_SCREEN = "login"
    const val SIGNUP_SCREEN = "signup"
}
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.LOGIN_SCREEN
    ) {

        composable(AppRoutes.LOGIN_SCREEN) {
            val loginViewModel: LoginViewModel = viewModel()
            val uiState by loginViewModel.uiState.collectAsState()
            LoginScreen(
                email = uiState.email,
                password = uiState.password,
                rememberMe = uiState.rememberMe,
                isPasswordVisible = uiState.isPasswordVisible,
                emailError = uiState.emailError,
                passwordError = uiState.passwordError,
                onEmailChange = loginViewModel::onEmailChange,
                onPasswordChange = loginViewModel::onPasswordChange,
                onRememberMeToggle = loginViewModel::onRememberMeToggle,
                onTogglePasswordVisibility = loginViewModel::onTogglePasswordVisibility,
                onLoginClick = loginViewModel::onLoginClick,
                onForgotPasswordClick = loginViewModel::onForgotPasswordClick,
                onSignUpClick = {
                    navController.navigate(AppRoutes.SIGNUP_SCREEN)
                }
            )
        }


        composable(AppRoutes.SIGNUP_SCREEN) {
            val signUpViewModel: SignUpViewModel = viewModel()
            val uiState by signUpViewModel.uiState.collectAsState()
            SignUpScreen(

                onLoginClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}