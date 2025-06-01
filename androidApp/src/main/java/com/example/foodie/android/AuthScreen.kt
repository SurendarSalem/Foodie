package com.example.foodie.android

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {

    var password by remember { mutableStateOf(value = "") }
    var email by remember { mutableStateOf(value = "") }
    var showPassword by remember { mutableStateOf(value = false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .padding(40.dp)
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { newText ->
                email = newText
            },
            label = {
                Text(text = "Email")
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Type email here") },
            shape = RoundedCornerShape(percent = 10),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email, contentDescription = "enter_email"
                )
            })

        OutlinedTextField(
            value = password,
            onValueChange = { newText ->
                password = newText
            },
            label = {
                Text(text = "Password")
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Type Password here") },
            shape = RoundedCornerShape(percent = 10),
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                if (showPassword) {
                    IconButton(onClick = { showPassword = false }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = "hide_password"
                        )
                    }
                } else {
                    IconButton(
                        onClick = { showPassword = true }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "hide_password"
                        )
                    }
                }
            })

        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(0.dp, 10.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(percent = 20),
        ) {
            Text(text = "Login", modifier = Modifier.padding(8.dp))
        }

        Text("Sign up", modifier = Modifier.clickable {
            email = ""
            password = ""
            navController.navigate(Screen.Detail.route)
        })
    }
}

@Composable
fun SignUpScreen(navController: NavController) {

    var password by remember { mutableStateOf(value = "") }
    var email by remember { mutableStateOf(value = "") }
    var showPassword by remember { mutableStateOf(value = false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .padding(40.dp)
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { newText ->
                email = newText
            },
            label = {
                Text(text = "Email")
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Type email here") },
            shape = RoundedCornerShape(percent = 10),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email, contentDescription = "enter_email"
                )
            })

        OutlinedTextField(
            value = password,
            onValueChange = { newText ->
                password = newText
            },
            label = {
                Text(text = "Password")
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Type Password here") },
            shape = RoundedCornerShape(percent = 10),
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                if (showPassword) {
                    IconButton(onClick = { showPassword = false }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = "hide_password"
                        )
                    }
                } else {
                    IconButton(
                        onClick = { showPassword = true }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "hide_password"
                        )
                    }
                }
            })

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .padding(0.dp, 10.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(percent = 20),
        ) {
            Text(text = "Sign Up", modifier = Modifier.padding(8.dp))
        }

        Text("Login", modifier = Modifier.clickable {
            email = ""
            password = ""
        })
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    //LoginScreen()
}