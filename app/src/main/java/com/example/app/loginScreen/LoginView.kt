package com.example.app.loginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.dp
import com.example.app.ui.theme.Black
import com.example.app.ui.theme.Dimens
import com.example.app.ui.theme.Yellow
import com.example.app.R


@Composable
fun LoginScreen(
    email: String,
    password: String,
    rememberMe: Boolean,
    isPasswordVisible: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    onRememberMeToggle: (Boolean) -> Unit,
    onLoginClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onSignUpClick: () -> Unit,
    emailError: String? = null,
    passwordError: String? = null
) {
    val textFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        focusedIndicatorColor = Yellow,
        focusedLabelColor = Yellow,
        unfocusedLeadingIconColor = Yellow,
        focusedLeadingIconColor = Yellow,
        cursorColor = Yellow
    )

    LoginContent(
        email = email,
        password = password,
        rememberMe = rememberMe,
        isPasswordVisible = isPasswordVisible,
        onEmailChange = onEmailChange,
        onPasswordChange = onPasswordChange,
        onTogglePasswordVisibility = onTogglePasswordVisibility,
        onRememberMeToggle = onRememberMeToggle,
        onLoginClick = onLoginClick,
        onForgotPasswordClick = onForgotPasswordClick,
        onSignUpClick = onSignUpClick,
        emailError = emailError,
        passwordError = passwordError,
        textFieldColors = textFieldColors
    )
}

@Composable
private fun LoginContent(
    email: String,
    password: String,
    rememberMe: Boolean,
    isPasswordVisible: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    onRememberMeToggle: (Boolean) -> Unit,
    onLoginClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onSignUpClick: () -> Unit,
    emailError: String?,
    passwordError: String?,
    textFieldColors: TextFieldColors
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

            LoginHeader()
            LoginTitle()

            Spacer(modifier = Modifier.height(Dimens.SpacerExtraLarge))

            EmailInputField(
                email = email,
                onEmailChange = onEmailChange,
                emailError = emailError,
                colors = textFieldColors
            )

            Spacer(modifier = Modifier.height(Dimens.SpacerSmall))

            PasswordInputField(
                password = password,
                isPasswordVisible = isPasswordVisible,
                onPasswordChange = onPasswordChange,
                onTogglePasswordVisibility = onTogglePasswordVisibility,
                passwordError = passwordError,
                colors = textFieldColors
            )

            LoginOptionsRow(
                rememberMe = rememberMe,
                onRememberMeToggle = onRememberMeToggle,
                onForgotPasswordClick = onForgotPasswordClick
            )

            Spacer(modifier = Modifier.height(Dimens.SpacerLarge))

            LoginButton(onClick = onLoginClick)

            Spacer(modifier = Modifier.height(Dimens.SpacerMedium))

            SignUpPrompt(onClick = onSignUpClick)
        }
    }
}




@Composable
private fun LoginHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Dimens.PaddingExtraLarge, bottom = Dimens.PaddingMedium),
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
private fun LoginTitle() {
    Text(
        text = stringResource(id = R.string.login_title),
        fontSize = Dimens.TitleFontSize,
        fontWeight = FontWeight.Bold,
        color = Black,
        modifier = Modifier.paddingFromBaseline(top = 200.dp, bottom = 0.dp)
    )
}

@Composable
private fun EmailInputField(
    email: String,
    onEmailChange: (String) -> Unit,
    emailError: String?,
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
                Text(text = it, color = MaterialTheme.colorScheme.error)
            }
        },
        colors = colors
    )
}

@Composable
private fun PasswordInputField(
    password: String,
    onPasswordChange: (String) -> Unit,
    isPasswordVisible: Boolean,
    onTogglePasswordVisibility: () -> Unit,
    passwordError: String?,
    colors: TextFieldColors
) {
    TextField(
        value = password,
        onValueChange = onPasswordChange,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(stringResource(id = R.string.password_label), color = Yellow) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = stringResource(id = R.string.password_icon_desc)
            )
        },
        trailingIcon = {
            IconButton(onClick = onTogglePasswordVisibility) {
                Icon(
                    painter = painterResource(id = if (isPasswordVisible) R.drawable.ic_visibility_on else R.drawable.ic_visibility_off),
                    contentDescription = stringResource(if (isPasswordVisible) R.string.hide_password_desc else R.string.show_password_desc),
                    modifier = Modifier.size(Dimens.IconSizeSmall),
                    tint = Black
                )
            }
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        singleLine = true,
        isError = passwordError != null,
        supportingText = {
            passwordError?.let {
                Text(text = it, color = MaterialTheme.colorScheme.error)
            }
        },
        colors = colors
    )
}

@Composable
private fun LoginOptionsRow(
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
private fun LoginButton(
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
            text = stringResource(id = R.string.login_button),
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.ButtonFontSize,
            color = Black
        )
    }
}

@Composable
private fun SignUpPrompt(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.dont_have_account),
            color = Black
        )
        TextButton(onClick = onClick) {
            Text(
                text = stringResource(id = R.string.sign_up),
                fontWeight = FontWeight.Bold,
                color = Yellow,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}
