package com.example.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.crm.R
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        tonalElevation = 8.dp
    ) {
        // Home Navigation Item
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home), // Reemplaza con tu ícono de Home
                    contentDescription = "Home"
                )
            },
            label = { Text("Home") },
            selected = false,
            onClick = {
                navController.navigate("dashboard") {
                    popUpTo("dashboard") { inclusive = true }
                }
            }
        )

        // Calendario Navigation Item
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calendar), // Reemplaza con tu ícono de Calendario
                    contentDescription = "Calendario"
                )
            },
            label = { Text("Calendario") },
            selected = false,
            onClick = {
                navController.navigate("calendar") // Navega a la pantalla del calendario
            }
        )

        // Perfil Navigation Item
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Perfil"
                )
            },
            label = { Text("Perfil") },
            selected = false,
            onClick = {
                navController.navigate("profile") {
                    popUpTo("profile") { inclusive = true }
                }
            }
        )
    }
}
