package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crm.ui.theme.SaludConnectTheme
import com.example.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            // Aplicamos el tema personalizado
            SaludConnectTheme {
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") {
                        SplashScreen {
                            navController.navigate("welcome") {
                                popUpTo("splash") { inclusive = true }
                            }
                        }
                    }
                    composable("welcome") {
                        WelcomeScreen(
                            onRegisterClick = { navController.navigate("register") },
                            onLoginClick = { navController.navigate("login") }
                        )
                    }
                    composable("register") {
                        RegisterScreen(
                            onRegisterClick = { navController.navigate("account_created") },
                            onLoginClick = { navController.navigate("login") }
                        )
                    }
                    composable("login") {
                        LoginScreen(
                            onLoginClick = { navController.navigate("dashboard") },
                            onRegisterClick = { navController.navigate("register") },
                            onForgotPasswordClick = { navController.navigate("forgot_password") }
                        )
                    }
                    composable("account_created") {
                        AccountCreatedScreen(
                            onLoginClick = { navController.navigate("login") }
                        )
                    }
                    composable("forgot_password") {
                        ForgotPasswordScreen(
                            onSendLinkClick = {
                                // Lógica para después de enviar el enlace de recuperación
                                navController.navigate("verification")
                            },
                            onBackClick = {
                                // Volver a la pantalla de inicio de sesión
                                navController.popBackStack()
                            }
                        )
                    }
                    composable("verification") {
                        VerificationScreen(
                            onResendClick = {
                                // Acción para reenviar el enlace de recuperación (si es necesario)
                                // Puedes manejar la lógica de reenvío aquí.
                            },
                            onCreateNewPasswordClick = {
                                // Navegar a la pantalla de restablecimiento de contraseña
                                navController.navigate("reset_password")
                            }
                        )
                    }
                    composable("reset_password") {
                        ResetPasswordScreen(
                            onFinishClick = {
                                // Navegar a la pantalla de éxito de restablecimiento de contraseña
                                navController.navigate("password_reset_success")
                            },
                            onCancelClick = {
                                // Volver a la pantalla de inicio de sesión
                                navController.popBackStack()
                            }
                        )
                    }
                    composable("password_reset_success") {
                        PasswordResetSuccessScreen(
                            onLoginClick = { navController.navigate("login") }
                        )
                    }
                    composable("dashboard") {
                        DashboardScreen(navController)
                    }
                    composable("profile") {
                        ProfileScreen(navController)
                    }
                    composable("calendar") {
                        CalendarScreen(navController)
                    }
                }
            }
        }
    }
}
