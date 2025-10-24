package mx.edu.utez.silvergarbanzo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.silvergarbanzo.R
import mx.edu.utez.silvergarbanzo.ui.theme.SilverGarbanzoTheme
import mx.edu.utez.silvergarbanzo.viewmodel.AgregarViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgregarScreen(viewModel: AgregarViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1b1d23))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){

            Image(
                painter = painterResource(id = R.drawable.interstellar),
                contentDescription = "Foto de la película",
                modifier = Modifier
                    .size(150.dp)
                    .padding(8.dp)
            )

            Column {
                Text("Interstellar", color = Color.White, style = MaterialTheme.typography.titleLarge)
                Text("26/10/2014", color = Color.White, style = MaterialTheme.typography.titleSmall)
                Text("Christopher Nolan", color = Color.White, style = MaterialTheme.typography.titleSmall)
                Text("Anne Hathaway - Mathhew McConaughhey", color = Color.White, style = MaterialTheme.typography.titleSmall)
            }

            Spacer(Modifier.height(12.dp))

        }

        Spacer(Modifier.height(12.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text("20/09/2025", color = Color.White)

            }
        }

        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier
                .padding(vertical = 8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text("Calificación", color = Color.White)
                Row {
                        Image(
                            painter = painterResource(R.drawable.rate5),
                            contentDescription = "Rating",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .width(60.dp)
                                .height(20.dp)
                        )
                }
            }

            Column {
                Text("Like", color = Color.White)
                Image(
                    painter = painterResource(
                        id = if (viewModel.like.value)
                            R.drawable.likes else R.drawable.corazon
                    ),
                    contentDescription = "Like",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { viewModel.like.value = !viewModel.like.value }
                        .padding(2.dp)
                )
            }
        }

        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier
                .padding(vertical = 8.dp)
        )
        Spacer(Modifier.height(12.dp))

        // Reseña
        OutlinedTextField(
            value = viewModel.resena.value,
            onValueChange = { viewModel.resena.value = it },
            label = { Text("Reseña (opcional)") },
            modifier = Modifier.height(400.dp)
                .width(500.dp)
        )

        Spacer(Modifier.height(8.dp))

        // Checkbox “ya he visto esta película antes”
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = viewModel.vista.value,
                onCheckedChange = { viewModel.vista.value = it }
            )
            Text("Ya he visto esta película antes", color = Color.White)
        }

        Spacer(Modifier.height(16.dp))

        // Botones
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(
                onClick = { viewModel.onGuardarClick { navController.popBackStack() } },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2E7D32),
                    contentColor = Color.White)
            ) {
                Text("Agregar registro")
            }
            OutlinedButton(onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2E7D32),
                    contentColor = Color.White)
                ) {
                Text("Cancelar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAgregarScreen() {
    SilverGarbanzoTheme {
        val navController = rememberNavController()
        val viewModel = AgregarViewModel()
        AgregarScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}