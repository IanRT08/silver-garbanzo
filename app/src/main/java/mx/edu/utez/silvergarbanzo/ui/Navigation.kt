package mx.edu.utez.silvergarbanzo.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import mx.edu.utez.silvergarbanzo.data.model.VetDatabase
import mx.edu.utez.silvergarbanzo.data.repository.ReseniaPeliculaRepository
import mx.edu.utez.silvergarbanzo.ui.screens.AgregarScreen
import mx.edu.utez.silvergarbanzo.ui.screens.BuscarScreen
import mx.edu.utez.silvergarbanzo.ui.screens.ChangePasswordScreen
import mx.edu.utez.silvergarbanzo.ui.screens.ChangePasswordTwoScreen
import mx.edu.utez.silvergarbanzo.ui.screens.HomeScreen
import mx.edu.utez.silvergarbanzo.ui.screens.LikesScreen
import mx.edu.utez.silvergarbanzo.ui.screens.LoginScreen
import mx.edu.utez.silvergarbanzo.ui.screens.MovieEditScreen
import mx.edu.utez.silvergarbanzo.ui.screens.RecordScreen
import mx.edu.utez.silvergarbanzo.ui.screens.UserScreen
import mx.edu.utez.silvergarbanzo.ui.screens.RecuperarPasswordScreen
import mx.edu.utez.silvergarbanzo.ui.screens.RegisterScreen
import mx.edu.utez.silvergarbanzo.ui.screens.ResenasScreen
import mx.edu.utez.silvergarbanzo.viewmodel.AgregarViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.BuscarViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.ChangePasswordTwoViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.ChangePasswordViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.HomeViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.LikesViewmodel
import mx.edu.utez.silvergarbanzo.viewmodel.LoginViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.MovieEditViewmodel
import mx.edu.utez.silvergarbanzo.viewmodel.RecordViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.RecuperarPasswordViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.RegisterViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.ResenasViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.UserViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val context = LocalContext.current

    val database = remember {
        Room.databaseBuilder(
            context.applicationContext,
            VetDatabase::class.java,
            "vet_database"
        ).build()
    }

    val repository = remember { ReseniaPeliculaRepository(database.reseniaPeliculaDao()) }

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val viewModel: LoginViewModel = viewModel() //instancia del ViewModel
            LoginScreen(viewModel = viewModel, navController = navController)
        }
        composable("forgot_password") { ChangePasswordScreen(ChangePasswordViewModel(), navController) }
        composable("search") {
            val buscarViewModel: BuscarViewModel = viewModel()
            BuscarScreen(buscarViewModel, navController)
        }

        composable("register") {
            val registerViewModel: RegisterViewModel = viewModel()
            RegisterScreen(registerViewModel, navController)
        }
        composable("forgot_passwordTwo") { ChangePasswordTwoScreen(ChangePasswordTwoViewModel(), navController) }
        composable("recuperar"){ RecuperarPasswordScreen(RecuperarPasswordViewModel(), navController) }
        composable("home") { HomeScreen(HomeViewModel(), navController) }
        composable("user") { UserScreen(UserViewModel(), navController) }
        composable("add"){
            val viewModel = remember { AgregarViewModel(repository) }
            AgregarScreen(viewModel = viewModel, navController = navController)
        }
        composable("like") { LikesScreen(LikesViewmodel(), navController) }
        composable("profile") { UserScreen(UserViewModel(), navController) }
        composable("registros") {
            val viewModel = remember { RecordViewModel(repository) }
            RecordScreen(viewModel, navController)
        }
        composable("edit") { MovieEditScreen(MovieEditViewmodel(), navController) }
        composable("resenas") {
            val resenasViewModel: ResenasViewModel = viewModel()
            ResenasScreen(resenasViewModel, navController)
        }

    }
}