package mx.edu.utez.silvergarbanzo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.silvergarbanzo.ui.components.buttons.PrimaryButton
import mx.edu.utez.silvergarbanzo.ui.components.images.ImageLogin
import mx.edu.utez.silvergarbanzo.ui.components.inputs.PasswordField
import mx.edu.utez.silvergarbanzo.ui.components.inputs.UserInputField
import mx.edu.utez.silvergarbanzo.viewmodel.RegisterViewModel
import mx.edu.utez.silvergarbanzo.R
import mx.edu.utez.silvergarbanzo.ui.components.buttons.Checkbox
import mx.edu.utez.silvergarbanzo.ui.theme.SilverGarbanzoTheme

@Composable
fun RegisterScreen(viewModel: RegisterViewModel, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1b1d23))
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            ImageLogin(R.drawable.registerimage)

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Crear cuenta",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start,
                color = Color.White
            )


            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                UserInputField(
                    value = viewModel.email.value,
                    onValueChange = { viewModel.email.value = it },
                    label = "Correo electrónico"
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                UserInputField(
                    value = viewModel.username.value,
                    onValueChange = { viewModel.username.value = it },
                    label = "Nombre de usuario"
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                PasswordField(
                    value = viewModel.password.value,
                    onValueChange = { viewModel.password.value = it },
                    label = "Contraseña"
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                PasswordField(
                    value = viewModel.confirmPassword.value,
                    onValueChange = { viewModel.confirmPassword.value = it },
                    label = "Confirmar contraseña"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Checkbox(
                label = "Acepto los términos y condiciones",
                checked = viewModel.acceptTerms.value,
                onCheckedChange = { viewModel.acceptTerms.value = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                PrimaryButton(
                    text = "Crear cuenta",
                    onClick = {
                        viewModel.register {
                            navController.navigate("login")
                        }
                    },
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(8.dp))

                PrimaryButton(
                    text = "Ya tengo cuenta",
                    onClick = { navController.navigate("login") },
                    modifier = Modifier.weight(1f)
                )


            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Imagen de: K-POP Demon Hunters (2025)",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White
                )
            }

            if (viewModel.registerError.value.isNotEmpty()) {
                Text(
                    text = viewModel.registerError.value,
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }

        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    SilverGarbanzoTheme {
        val navController = rememberNavController()
        val viewModel = RegisterViewModel()
        RegisterScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}