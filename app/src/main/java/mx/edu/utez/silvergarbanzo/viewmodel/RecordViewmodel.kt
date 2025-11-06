package mx.edu.utez.silvergarbanzo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import mx.edu.utez.silvergarbanzo.data.model.ReseniaPelicula
import mx.edu.utez.silvergarbanzo.data.repository.ReseniaPeliculaRepository


class RecordViewModel(private val repository: ReseniaPeliculaRepository) : ViewModel() {
    val reseniasState: StateFlow<List<ReseniaPelicula>> = repository.allResenias
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    fun eliminarResenia(resenia: ReseniaPelicula) {
        viewModelScope.launch {
            repository.deleteResenia(resenia)
        }
    }
}