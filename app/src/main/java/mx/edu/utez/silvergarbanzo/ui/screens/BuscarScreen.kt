package mx.edu.utez.silvergarbanzo.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.silvergarbanzo.ui.theme.SilverGarbanzoTheme
import mx.edu.utez.silvergarbanzo.viewmodel.AgregarViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.BuscarViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscarScreen(viewModel: BuscarViewModel, navController: NavController) {
    val searchText by viewModel.searchText
    val selectedCategory by viewModel.selectedCategory
    val categories = listOf("Películas", "Actores/Cast", "Directores", "Perfiles")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1b1d23))
            .padding(16.dp)
    ) {
        // 🔍 Barra de búsqueda + Cancelar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = searchText,
                onValueChange = { viewModel.updateSearchText(it) },
                placeholder = { Text(text = "Buscar...", color = Color.Gray) },
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.DarkGray,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedContainerColor = Color(0xFF2A2C33),
                    unfocusedContainerColor = Color(0xFF2A2C33)
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.width(8.dp))

            TextButton(
                onClick = {
                    viewModel.clearSearch()
                    navController.popBackStack() // 🔙 Regresa al perfil
                }
            ) {
                Text("Cancelar", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // 🔹 Barra de selección de categoría
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Color.Gray), shape = MaterialTheme.shapes.small)
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            categories.forEach { category ->
                Text(
                    text = category,
                    color = if (selectedCategory == category) Color(0xFF87CEFA) else Color.White,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .clickable { viewModel.updateCategory(category) }
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 📜 Historial de búsqueda
        Text(
            text = "Historial de búsqueda",
            color = Color.LightGray,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(viewModel.searchHistory.size) { index ->
                Text(
                    text = viewModel.searchHistory[index],
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable {
                            viewModel.updateSearchText(viewModel.searchHistory[index])
                        }
                )
                Divider(color = Color(0xFF3A3A3A), thickness = 1.dp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBuscarScreen() {
    SilverGarbanzoTheme {
        val navController = rememberNavController()
        val viewModel = BuscarViewModel()
        BuscarScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}
