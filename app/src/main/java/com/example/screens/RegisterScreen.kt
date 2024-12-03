package com.example.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crm.R

@Composable
fun RegisterScreen(onRegisterClick: () -> Unit, onLoginClick: () -> Unit) {
    // Estados para los campos de registro
    val nameState = remember { mutableStateOf("") } // mutableStateOf  practicamente puedes almacenar un valor que puede cambiar a lo largo del tiempo, cuando el valor cambia todos los componentes que dependen de ese valor cambian, se actualizan.
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título de la pantalla
        Text(
            text = "Regístrate gratis",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            color = Color(0xFF001F54)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Imagen de encabezado
        Image(
            painter = painterResource(id = R.drawable.welcome_image),
            contentDescription = "Imagen de Registro",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Campo de texto para el nombre
        BasicTextField(
            value = nameState.value,
            onValueChange = { nameState.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(56.dp),
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    if (nameState.value.isEmpty()) {
                        Text(
                            text = "Introduce tu nombre...",
                            color = Color.Gray,
                            fontSize = 16.sp
                        )
                    }
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para el email
        BasicTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(56.dp),
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    if (emailState.value.isEmpty()) {
                        Text(
                            text = "Enter your email...",
                            color = Color.Gray,
                            fontSize = 16.sp
                        )
                    }
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para la contraseña
        BasicTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(56.dp),
            visualTransformation = PasswordVisualTransformation(),
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    if (passwordState.value.isEmpty()) {
                        Text(
                            text = "Introduce tu contraseña...",
                            color = Color.Gray,
                            fontSize = 16.sp
                        )
                    }
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para confirmar la contraseña
        BasicTextField(
            value = confirmPasswordState.value,
            onValueChange = { confirmPasswordState.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(56.dp),
            visualTransformation = PasswordVisualTransformation(),
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    if (confirmPasswordState.value.isEmpty()) {
                        Text(
                            text = "Confirma tu contraseña...",
                            color = Color.Gray,
                            fontSize = 16.sp
                        )
                    }
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón de Crear cuenta
        Button(
            onClick = {
                // Aquí puedes manejar la lógica de registro (como llamar a una API)
                onRegisterClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(48.dp)
        ) {
            Text(
                text = "Crear cuenta",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Texto para iniciar sesión
        Text(
            text = "¿Ya tienes cuenta? Inicia sesión.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(top = 16.dp)
                .clickable { onLoginClick() }
        )
    }
}
