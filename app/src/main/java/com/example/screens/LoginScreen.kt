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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crm.R

@Composable
fun LoginScreen(onLoginClick: () -> Unit, onRegisterClick: () -> Unit, onForgotPasswordClick: () -> Unit) {
    // Estados para los campos de inicio de sesión
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    // Manejador de enlaces externos
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen del logo de la cruz
        Image(
            painter = painterResource(id = R.drawable.cross_image), // Reemplaza con tu recurso de la cruz
            contentDescription = "Logo de SaludConnect",
            modifier = Modifier.size(48.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Título de la pantalla
        Text(
            text = "Iniciar Sesión con SaludConnect",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            color = Color(0xFF001F54)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Imagen de encabezado
        Image(
            painter = painterResource(id = R.drawable.welcome_image), // Reemplaza con la imagen correspondiente
            contentDescription = "Imagen de Iniciar Sesión",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

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
                            text = "Correo Electrónico",
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

        Spacer(modifier = Modifier.height(24.dp))

        // Botón de Iniciar Sesión
        Button(
            onClick = {
                // Aquí se maneja la navegación al perfil después del login
                onLoginClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(48.dp)
        ) {
            Text(
                text = "Iniciar Sesión",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Iconos de Redes Sociales
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            // Facebook Icon
            Image(
                painter = painterResource(id = R.drawable.ic_facebook),
                contentDescription = "Facebook",
                modifier = Modifier
                    .size(48.dp)
                    .clickable { uriHandler.openUri("https://www.facebook.com/maydajohanna.quimbayahernandez") }
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Google Icon con enlace
            Image(
                painter = painterResource(id = R.drawable.ic_google), // Reemplaza con el icono de Google
                contentDescription = "Google",
                modifier = Modifier
                    .size(48.dp)
                    .clickable { uriHandler.openUri("https://rockcontent.com/es/blog/que-es-crm/") }
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Instagram Icon
            Image(
                painter = painterResource(id = R.drawable.ic_instagram),
                contentDescription = "Instagram",
                modifier = Modifier
                    .size(48.dp)
                    .clickable { uriHandler.openUri("https://www.instagram.com/may_lun06?igsh=ZDdiMG52M3FiMGoy") }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Texto para registrarse e iniciar sesión
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "¿No tienes una cuenta? Regístrate.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable { onRegisterClick() }
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "¿Olvidaste tu contraseña?",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable { onForgotPasswordClick() }
            )
        }
    }
}


