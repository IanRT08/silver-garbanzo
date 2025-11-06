package mx.edu.utez.silvergarbanzo.ui.screens

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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mx.edu.utez.silvergarbanzo.R
import mx.edu.utez.silvergarbanzo.data.model.ReseniaPelicula
import mx.edu.utez.silvergarbanzo.ui.components.SearchField
import mx.edu.utez.silvergarbanzo.ui.components.buttons.PrimaryButton
import mx.edu.utez.silvergarbanzo.ui.components.cards.ReseniaPeliculaCard
import mx.edu.utez.silvergarbanzo.ui.components.images.IconImage
import mx.edu.utez.silvergarbanzo.ui.components.images.IconSmall
import mx.edu.utez.silvergarbanzo.ui.components.texts.Link
import mx.edu.utez.silvergarbanzo.viewmodel.RecordViewModel

@Composable
fun RecordScreen(viewModel: RecordViewModel, navController: NavController) {
    val resenias by viewModel.reseniasState.collectAsState()
    var reseniaAEliminar by remember { mutableStateOf<ReseniaPelicula?>(null) }
    val showDeleteDialog = remember { mutableStateOf(false) }
    if (showDeleteDialog.value) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog.value = false },
            title = { Text("Eliminar reseña") },
            text = { Text("¿Estás seguro de que quieres eliminar la reseña de \"${reseniaAEliminar?.tituloPelicula}\"?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        reseniaAEliminar?.let { viewModel.eliminarResenia(it) }
                        showDeleteDialog.value = false
                        reseniaAEliminar = null
                    }
                ) {
                    Text("Eliminar", color = Color.Red)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDeleteDialog.value = false
                        reseniaAEliminar = null
                    }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1b1d23))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconImage(R.drawable.icon)
                Spacer(modifier = Modifier.width(10.dp))
                Link("@silvergarbanzo") { navController.navigate("user") }
                Spacer(modifier = Modifier.width(35.dp))
                IconSmall(
                    R.drawable.salir,
                    size = 25,
                    navController = navController,
                    navigateTo = "login"
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            // Título y búsqueda
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Historial de películas",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
                SearchField(
                    modifier = Modifier
                        .height(30.dp)
                        .width(90.dp),
                    onClick = { navController.navigate("search") }
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            if (resenias.isEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "No hay reseñas guardadas",
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    PrimaryButton(
                        text = "Agregar primera reseña",
                        onClick = { navController.navigate("add") }
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(
                        items = resenias,
                        key = { it.id }
                    ) { resenia ->
                        ReseniaPeliculaCard(
                            resenia = resenia,
                            onEditClick = {
                                // navController.navigate("edit/${resenia.id}")
                            },
                            onDeleteClick = {
                                reseniaAEliminar = resenia
                                showDeleteDialog.value = true
                            }
                        )
                    }
                }
            }
        }
    }
}