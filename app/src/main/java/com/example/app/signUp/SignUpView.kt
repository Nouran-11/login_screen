package com.example.app.signUp

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app.R
import com.example.app.ui.theme.Black
import com.example.app.ui.theme.Dimens
import com.example.app.ui.theme.Yellow

//spacer not favourable

@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel = viewModel(),
    uiState: SignUpUiState = signUpViewModel.uiState.collectAsState().value,
    onLoginClick: () -> Unit
) {
//    val uiState by signUpViewModel.uiState.collectAsState()


    val textFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        focusedIndicatorColor = Yellow,
        focusedLabelColor = Yellow,
        unfocusedLeadingIconColor = Yellow,
        focusedLeadingIconColor = Yellow,
        cursorColor = Yellow
    )

    SignUpContent(
        uiState = uiState,
        textFieldColors = textFieldColors,
        onNameChange = signUpViewModel::onNameChange,
        onEmailChange = signUpViewModel::onEmailChange,
        onPasswordChange = signUpViewModel::onPasswordChange,
        onConfirmPasswordChange = signUpViewModel::onConfirmPasswordChange,
        onTogglePasswordVisibility = signUpViewModel::onTogglePasswordVisibility,
        onToggleConfirmPasswordVisibility = signUpViewModel::onToggleConfirmPasswordVisibility,
        onSignUpClick = signUpViewModel::onSignUpClick,
        onLoginClick = signUpViewModel::onLoginClick,
        onForgotPasswordClick = {  },
        onRememberMeToggle = signUpViewModel::onRememberMeToggle,
        rememberMe = uiState.rememberMe
    )
}



@Composable
private fun SignUpContent(
    uiState: SignUpUiState,
    textFieldColors: TextFieldColors,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    onToggleConfirmPasswordVisibility: () -> Unit,
    onSignUpClick: () -> Unit,
    onLoginClick: () -> Unit,
    onRememberMeToggle: (Boolean) -> Unit,
    onForgotPasswordClick: () -> Unit,
    rememberMe: Boolean
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = stringResource(id = R.string.background_image_desc),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Dimens.PaddingLarge)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(Dimens.SpacerMedium))

            ScreenHeader()

            Text(
                text = stringResource(id = R.string.create_account_title),
                fontSize = Dimens.TitleFontSize,
                fontWeight = FontWeight.Bold,
                color = Black,
                modifier = Modifier.padding(top = Dimens.PaddingExtraExtraLarge, bottom = Dimens.PaddingSmall)
            )


            NameInputField(
                name = uiState.name,
                onNameChange = onNameChange,
                nameError = uiState.nameError,
                colors = textFieldColors
            )
            Spacer(modifier = Modifier.height(Dimens.SpacerSmall))


            EmailInputField(
                email = uiState.email,
                onEmailChange = onEmailChange,
                emailError = uiState.emailError,
                colors = textFieldColors
            )
            Spacer(modifier = Modifier.height(Dimens.SpacerSmall))


            PasswordInputField(
                label = stringResource(R.string.password_label),
                password = uiState.password,
                onPasswordChange = onPasswordChange,
                isPasswordVisible = uiState.isPasswordVisible,
                onTogglePasswordVisibility = onTogglePasswordVisibility,
                passwordError = uiState.passwordError,
                colors = textFieldColors,
                        showVisibilityToggle = false
            )
            Spacer(modifier = Modifier.height(Dimens.SpacerSmall))


            PasswordInputField(
                label = stringResource(R.string.confirm_password_label),
                password = uiState.confirmPassword,
                onPasswordChange = onConfirmPasswordChange,
                isPasswordVisible = uiState.isConfirmPasswordVisible,
                onTogglePasswordVisibility = onToggleConfirmPasswordVisibility,
                passwordError = uiState.confirmPasswordError,
                colors = textFieldColors,
                        showVisibilityToggle = true
            )
            SignUpOptionsRow(
                rememberMe = rememberMe,
                onRememberMeToggle = onRememberMeToggle,
                onForgotPasswordClick = onForgotPasswordClick
            )
            Spacer(modifier = Modifier.height(Dimens.SpacerLarge))

            PrimaryButton(
                text = stringResource(R.string.sign_up_button),
                onClick = onSignUpClick
            )

            Spacer(modifier = Modifier.height(Dimens.SpacerMedium))

            LoginPrompt(onClick = onLoginClick)
        }
    }
}

@Composable
private fun EmailInputField(
    email: String,
    onEmailChange: (String) -> Unit,
    @StringRes emailError: Int?,
    colors: TextFieldColors
) {
    TextField(
        value = email,
        onValueChange = onEmailChange,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(stringResource(id = R.string.email_label), color = Yellow) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = stringResource(id = R.string.email_icon_desc)
            )
        },
        singleLine = true,
        isError = emailError != null,
        supportingText = {
            emailError?.let {
                Text(text = stringResource(id = it), color = MaterialTheme.colorScheme.error)
            }
        },
        colors = colors
    )
}


@Composable
private fun ScreenHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Dimens.PaddingLarge, bottom = Dimens.PaddingMedium),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(id = R.string.logo_desc),
            modifier = Modifier.size(Dimens.IconSizeLarge),
            tint = Black
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = stringResource(id = R.string.menu_desc),
            modifier = Modifier.size(Dimens.IconSizeMedium),
            tint = Black
        )
    }
}

@Composable
private fun NameInputField(
    name: String,
    onNameChange: (String) -> Unit,
    @StringRes nameError: Int?,
    colors: TextFieldColors
) {
    TextField(
        value = name,
        onValueChange = onNameChange,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(stringResource(id = R.string.name_label), color = Yellow) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = stringResource(id = R.string.name_icon_desc)
            )
        },
        singleLine = true,
        isError = nameError != null,
        supportingText = {
            nameError?.let {
                Text(text = stringResource(id = it), color = MaterialTheme.colorScheme.error)
            }
        },
        colors = colors
    )
}



@Composable
private fun PasswordInputField(
    label: String,
    password: String,
    onPasswordChange: (String) -> Unit,
    isPasswordVisible: Boolean,
    onTogglePasswordVisibility: () -> Unit,
    @StringRes passwordError: Int?,
    colors: TextFieldColors,
    showVisibilityToggle: Boolean
) {
    TextField(
        value = password,
        onValueChange = onPasswordChange,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(label, color = Yellow) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = stringResource(id = R.string.password_icon_desc)
            )
        },
        trailingIcon = {
            if (showVisibilityToggle) {
                IconButton(onClick = onTogglePasswordVisibility) {
                    Icon(
                        painter = painterResource(id = if (isPasswordVisible) R.drawable.ic_visibility_on else R.drawable.ic_visibility_off),
                        contentDescription = stringResource(if (isPasswordVisible) R.string.show_password_desc else R.string.hide_password_desc),
                        modifier = Modifier.size(Dimens.IconSizeSmall),
                        tint = Black
                    )
                }
            }
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        singleLine = true,
        isError = passwordError != null,
        supportingText = {
            passwordError?.let {
                Text(text = stringResource(id = it), color = MaterialTheme.colorScheme.error)
            }
        },
        colors = colors
    )
}

@Composable
private fun SignUpOptionsRow(
    rememberMe: Boolean,
    onRememberMeToggle: (Boolean) -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = rememberMe,
                onCheckedChange = onRememberMeToggle,
                colors = CheckboxDefaults.colors(checkedColor = Yellow, uncheckedColor = Yellow)
            )
            Text(
                text = stringResource(id = R.string.remember_me),
                color = Black,
                fontSize = Dimens.BodyFontSize
            )
        }
        TextButton(onClick = onForgotPasswordClick) {
            Text(
                text = stringResource(id = R.string.forgot_password),
                color = Black,
                fontSize = Dimens.BodyFontSize
            )
        }
    }
}

@Composable
private fun PrimaryButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.ButtonHeight),
        shape = RoundedCornerShape(Dimens.CornerRadius),
        colors = ButtonDefaults.buttonColors(containerColor = Yellow)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.ButtonFontSize,
            color = Black
        )
    }
}

@Composable
private fun LoginPrompt(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.already_have_account),
            color = Black
        )
        TextButton(onClick = onClick) {
            Text(
                text = stringResource(id = R.string.login_link),
                fontWeight = FontWeight.Bold,
                color = Yellow,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}
