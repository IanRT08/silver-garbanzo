package mx.edu.utez.silvergarbanzo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.silvergarbanzo.R
import mx.edu.utez.silvergarbanzo.ui.components.buttons.PrimaryButton
import mx.edu.utez.silvergarbanzo.ui.components.images.ImageLogin
import mx.edu.utez.silvergarbanzo.ui.components.inputs.UserInputField
import mx.edu.utez.silvergarbanzo.ui.theme.SilverGarbanzoTheme
import mx.edu.utez.silvergarbanzo.viewmodel.RecuperarPasswordViewModel

@Composable
fun RecuperarPasswordScreen(viewModel: RecuperarPasswordViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1b1d23))
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Recuperar contraseña",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "1. Ingrese el correo electrónico de su cuenta",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(10.dp))

        UserInputField(
            value = viewModel.email.value,
            onValueChange = { viewModel.email.value = it },
            label = "Correo electrónico"
        )

        Spacer(modifier = Modifier.height(15.dp))

        PrimaryButton(
            text = "Enviar código de recuperación",
            onClick = {  },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(25.dp))


        Text(
            text = "2. Revise su correo, busque el correo que enviamos",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(20.dp))

        ImageLogin(R.drawable.codeexample)

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "3. Ingrese el código adjunto en el correo",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(10.dp))

        UserInputField(
            value = viewModel.code.value,
            onValueChange = { viewModel.code.value = it },
            label = "Código de recuperación"
        )

        Spacer(modifier = Modifier.height(20.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PrimaryButton(
                text = "Reenviar código",
                onClick = { },
                modifier = Modifier.weight(1f)
            )

            PrimaryButton(
                text = "Siguiente →",
                onClick = {
                    navController.navigate("forgot_passwordTwo")
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecuperarPasswordScreen() {
    SilverGarbanzoTheme {
        val navController = rememberNavController()
        val viewModel = RecuperarPasswordViewModel()
        RecuperarPasswordScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}