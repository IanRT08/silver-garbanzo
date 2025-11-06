package mx.edu.utez.silvergarbanzo.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.text.style.TextAlign
import mx.edu.utez.silvergarbanzo.ui.components.buttons.Checkbox
import mx.edu.utez.silvergarbanzo.ui.components.buttons.LikeButton
import mx.edu.utez.silvergarbanzo.ui.components.buttons.PrimaryButton
import mx.edu.utez.silvergarbanzo.ui.components.buttons.RatingStars
import mx.edu.utez.silvergarbanzo.ui.components.inputs.UserInputField
import mx.edu.utez.silvergarbanzo.viewmodel.EditarViewModel

@Composable
fun EditarScreen(
    viewModel: EditarViewModel,
    navController: NavController,
    reseniaId: Int
) {
    println("📱 EDITARSCREEN COMPUESTO - ID: $reseniaId")
    println("📱 ESTADOS ACTUALES:")
    println("   - Título: ${viewModel.tituloPelicula.value}")
    println("   - Reseña: ${viewModel.resena.value}")
    println("   - Calificación: ${viewModel.calificacion.value}")
    println("   - Like: ${viewModel.like.value}")
    println("   - Ya la vi: ${viewModel.yaLaVi.value}")
    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(viewModel.mostrarError.value, viewModel.mensajeError.value) {
        if (viewModel.mostrarError.value) {
            snackbarHostState.showSnackbar(
                message = viewModel.mensajeError.value,
                duration = SnackbarDuration.Short
            )
            viewModel.limpiarError()
        }
    }
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        containerColor = Color(0xFF1b1d23)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Text(
                text = "Editar Reseña",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                textAlign = TextAlign.Start
            )
            UserInputField(
                value = viewModel.tituloPelicula.value,
                onValueChange = { viewModel.tituloPelicula.value = it },
                label = "Título de la película*",
            )
            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Calificación*", color = Color.White, style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(8.dp))
                    RatingStars(
                        rating = viewModel.calificacion.value,
                        onRatingChanged = viewModel::onCalificacionChanged
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Like", color = Color.White, style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(8.dp))
                    LikeButton(
                        isLiked = viewModel.like.value,
                        onLikeChanged = viewModel::onLikeChanged
                    )
                }
            }
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Reseña (opcional)",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = viewModel.resena.value,
                onValueChange = { viewModel.resena.value = it },
                label = { Text("Escribe tu reseña aquí...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedLabelColor = Color(0xFF4CAF50),
                    unfocusedLabelColor = Color.Gray,
                    focusedIndicatorColor = Color(0xFF4CAF50),
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.White
                )
            )
            Spacer(Modifier.height(16.dp))
            Checkbox(
                label = "Ya he visto esta película antes",
                checked = viewModel.yaLaVi.value,
                onCheckedChange = { viewModel.yaLaVi.value = it }
            )
            Text(
                text = "* Campos obligatorios",
                color = Color.Gray,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )
            Spacer(Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                PrimaryButton(
                    text = "Actualizar Reseña",
                    onClick = {
                        println("💾 INTENTANDO GUARDAR:")
                        println("   - Nuevo título: ${viewModel.tituloPelicula.value}")
                        println("   - Nueva calificación: ${viewModel.calificacion.value}")
                        viewModel.onGuardarClick {
                            println("✅ GUARDADO EXITOSO, REGRESANDO...")
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier.weight(1f)
                )
                OutlinedButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White
                    ),
                    border = BorderStroke(1.dp, Color(0xFF4CAF50))
                ) {
                    Text("Cancelar")
                }
            }
        }
    }
}