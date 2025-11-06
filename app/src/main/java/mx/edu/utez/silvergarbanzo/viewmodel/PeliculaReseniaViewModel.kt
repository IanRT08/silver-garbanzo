package mx.edu.utez.silvergarbanzo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import mx.edu.utez.silvergarbanzo.data.model.ReseniaPelicula
import mx.edu.utez.silvergarbanzo.data.repository.ReseniaPeliculaRepository

class PeliculaReseniaViewModel(private val repository: ReseniaPeliculaRepository) : ViewModel() {
    val reseniaUiState: StateFlow<List<ReseniaPelicula>> = repository.allResenias
        .stateIn(
            scope = viewModelScope,
            started = kotlinx.coroutines.flow.SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addNewResenia(titulo: String, resenia: String, calif: Float, lik: Boolean, ya: Boolean){
        viewModelScope.launch{
            val newResenia = ReseniaPelicula(
                tituloPelicula = titulo,
                resenia = resenia,
                calificacion = calif,
                like = lik,
                yaLaVi = ya
            )
            repository.insertResenia(newResenia)
        }
    }
}