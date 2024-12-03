package com.example.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crm.R

@Composable
fun ForgotPasswordScreen(onSendLinkClick: () -> Unit, onBackClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Caja contenedora para la parte superior con el ícono de retroceso y el logo
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            // Botón de retroceso (esquina izquierda)
            Image(
                painter = painterResource(id = R.drawable.ic_back), //  icono de retroceso
                contentDescription = "Atrás",
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.CenterStart)
                    .clickable { onBackClick() }
            )

            // Logo de la cruz (centrado)
            Image(
                painter = painterResource(id = R.drawable.cross_image), // la cruz
                contentDescription = "Logo de SaludConnect",
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Título de la pantalla
        Text(
            text = "Olvidaste tu contraseña",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            color = Color(0xFF001F54),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Subtítulo de la pantalla
        Text(
            text = "Selecciona los detalles de contacto donde deseas restablecer tu contraseña",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(50.dp))

        // Opción de Email
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(80.dp)
                .clickable { /* Acción futura para seleccionar el email */ },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_email), //  con el icono de email
                contentDescription = "Opción de email",
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Email",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFF001F54)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Opción de SMS
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(80.dp)
                .clickable { /* Acción futura para seleccionar SMS */ },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_sms), // el icono de SMS
                contentDescription = "Opción de SMS",
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "SMS",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFF001F54)
            )
        }

        Spacer(modifier = Modifier.height(250.dp))

        // Botón de Enviar Enlace (abajo con suficiente espacio si no a cambairlo)
        Button(
            onClick = {
                // Acción para enviar enlace de recuperación
                onSendLinkClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(48.dp)
        ) {
            Text(
                text = "Enviar enlace",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
