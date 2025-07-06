package com.example.loginscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen(
    email: String,
    password: String,
    rememberMe: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    isPasswordVisible: Boolean,
    onRememberMeToggle: (Boolean) -> Unit,
    onLoginClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onSignUpClick: () -> Unit,
    emailError: String? = null,
    passwordError: String? = null
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(

            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(40.dp)
                        .offset(x= 24.dp,y= 25.dp),
                    tint = Color.Unspecified

                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(30.dp)
                        .offset(x= (-12).dp, y = 30.dp),
                    tint = Color.Black
                )
            }


            Spacer(modifier = Modifier.height(60.dp))

            Text(
                text = "Login",
                fontSize = 50.sp,
                modifier = Modifier.offset(x=20.dp,y=130.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(160.dp))

            TextField(
                value = email,
                onValueChange = onEmailChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                label = {
                    Text("Email", color = Color(0xFFFFC107))
                },
                        leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon",
                        tint = Color(0xFFFFC107)
                    )
                },
                singleLine = true,
                isError = emailError != null,
                supportingText = {
                    emailError?.let {
                        Text(text = it, color = MaterialTheme.colorScheme.error)
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color(0xFFFFC107),
                    focusedLabelColor = Color(0xFFFFC107),
                    unfocusedLeadingIconColor = Color(0xFFFFC107),
                    focusedLeadingIconColor = Color(0xFFFFC107),
                    )
            )

            Spacer(modifier = Modifier.height(10.dp))


            TextField(
                value = password,
                onValueChange = onPasswordChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 0.dp),
                label = {
                    Text("Password", color = Color(0xFFFFC107))
                },
                leadingIcon = {   //leadingIcon means at the start
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password Icon",
                        tint = Color(0xFFFFC107)
                    )
                },
                trailingIcon = {      //trailingIcon means at the end
                    IconButton(onClick = onTogglePasswordVisibility) {
                        Icon(
                            painter = painterResource(id = if (isPasswordVisible) R.drawable.ic_visibility_on else R.drawable.ic_visibility_off),
                            contentDescription = if (isPasswordVisible) "Hide password" else "Show password",
                            modifier = Modifier.size(20.dp),
                            tint = Color.Black
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
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color(0xFFFFC107),
                    focusedLabelColor = Color(0xFFFFC107),
                    unfocusedLeadingIconColor = Color(0xFFFFC107),
                    focusedLeadingIconColor = Color(0xFFFFC107)
                )
            )


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = rememberMe,
                        onCheckedChange = onRememberMeToggle,
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFFFFC107),
                            uncheckedColor = Color(0xFFFFC107),
                        )
                    )
                    Text(text = "Remember me", color = Color.Black, fontSize = 15.sp)
                }

                TextButton(onClick = onForgotPasswordClick) {
                    Text("Forgot password?", color = Color.Black, fontSize = 15.sp)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))


            Button(
                onClick = onLoginClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107))
            ) {
                Text(
                    "LOGIN",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Don't have an account? ", color = Color.Black, modifier = Modifier.offset(x=12.dp, y = 15.dp))
                TextButton(onClick = onSignUpClick) {
                    Text(
                        "Sign Up",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFC107),
                        textDecoration = TextDecoration.Underline,
                    )
                }
            }
        }
    }
}

