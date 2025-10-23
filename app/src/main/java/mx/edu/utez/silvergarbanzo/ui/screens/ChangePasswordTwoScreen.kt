package mx.edu.utez.silvergarbanzo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import mx.edu.utez.silvergarbanzo.R
import mx.edu.utez.silvergarbanzo.ui.components.buttons.PrimaryButton
import mx.edu.utez.silvergarbanzo.ui.components.images.IconImage
import mx.edu.utez.silvergarbanzo.ui.components.inputs.PasswordField
import mx.edu.utez.silvergarbanzo.ui.theme.SilverGarbanzoTheme
import mx.edu.utez.silvergarbanzo.viewmodel.ChangePasswordTwoViewModel

@Composable
fun ChangePasswordTwoScreen(viewModel: ChangePasswordTwoViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1b1d23))
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconImage(R.drawable.icon)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Ingrese correo de su cuenta",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = Color.White
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            PasswordField(
                value = viewModel.newPassword.value,
                onValueChange = { viewModel.newPassword.value = it },
                label = "Ingrese nueva contraseña"
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            PasswordField(
                value = viewModel.confirmNewPassword.value,
                onValueChange = { viewModel.confirmNewPassword.value = it },
                label = "Confirmar nueva contraseña"
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        PrimaryButton(
            text = "Cambiar contraseña",
            onClick = {
                navController.navigate("login")
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewChangePasswordTwoScreen() {
    SilverGarbanzoTheme {
        val navController = rememberNavController()
        val viewModel = ChangePasswordTwoViewModel()
        ChangePasswordTwoScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}