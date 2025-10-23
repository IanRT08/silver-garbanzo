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
import mx.edu.utez.silvergarbanzo.ui.components.inputs.UserInputField
import mx.edu.utez.silvergarbanzo.ui.theme.SilverGarbanzoTheme
import mx.edu.utez.silvergarbanzo.viewmodel.ChangePasswordViewModel

@Composable
fun ChangePasswordScreen(viewModel: ChangePasswordViewModel, navController: NavController) {
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

        UserInputField(
            value = viewModel.email.value,
            onValueChange = { viewModel.email.value = it },
            label = "Correo electronico"
        )

        Spacer(modifier = Modifier.height(20.dp))

        PrimaryButton(
            text = "Enviar código",
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Ingrese el código adjunto en el correo",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Si el código no se recibió puede solicitar uno nuevo después de 5 minutos",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(15.dp))

        UserInputField(
            value = viewModel.code.value,
            onValueChange = { viewModel.code.value = it },
            label = "Código de seguridad"
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

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewChangePasswordScreen() {
    SilverGarbanzoTheme {
        val navController = rememberNavController()
        val viewModel = ChangePasswordViewModel()
        ChangePasswordScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}