package mx.edu.utez.silvergarbanzo.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BuscarViewModel : ViewModel() {
    var searchText = mutableStateOf("")
    var selectedCategory = mutableStateOf("Películas")
    var searchHistory = mutableStateListOf(
        "Película buscada",
        "Actor buscado",
        "Perfil buscado",
        "Director buscado"
    )

    fun updateCategory(category: String) {
        selectedCategory.value = category
    }

    fun updateSearchText(text: String) {
        searchText.value = text
    }

    fun clearSearch() {
        searchText.value = ""
    }
}