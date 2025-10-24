package mx.edu.utez.silvergarbanzo.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.silvergarbanzo.ui.screens.ChangePasswordScreen
import mx.edu.utez.silvergarbanzo.ui.screens.ChangePasswordTwoScreen
import mx.edu.utez.silvergarbanzo.ui.screens.HomeScreen
import mx.edu.utez.silvergarbanzo.ui.screens.LoginScreen
import mx.edu.utez.silvergarbanzo.ui.screens.UserScreen
import mx.edu.utez.silvergarbanzo.ui.screens.RecuperarPasswordScreen
import mx.edu.utez.silvergarbanzo.ui.screens.RegisterScreen
import mx.edu.utez.silvergarbanzo.viewmodel.ChangePasswordTwoViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.ChangePasswordViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.HomeViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.LoginViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.RecuperarPasswordViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.RegisterViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.UserViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val viewModel: LoginViewModel = viewModel() //instancia del ViewModel
            LoginScreen(viewModel = viewModel, navController = navController)
        }
        composable("forgot_password") { ChangePasswordScreen(ChangePasswordViewModel(), navController) }
        composable("register") { RegisterScreen(RegisterViewModel(), navController) }
        composable("forgot_passwordTwo") { ChangePasswordTwoScreen(ChangePasswordTwoViewModel(), navController) }
        composable("recuperar"){ RecuperarPasswordScreen(RecuperarPasswordViewModel(), navController) }
        composable("home") { HomeScreen(HomeViewModel(), navController) }
        composable("user") { UserScreen(UserViewModel(), navController) }

    }
}