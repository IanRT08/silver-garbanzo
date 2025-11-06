package mx.edu.utez.silvergarbanzo.viewmodel

import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mx.edu.utez.silvergarbanzo.data.model.ReseniaPelicula
import mx.edu.utez.silvergarbanzo.data.repository.ReseniaPeliculaRepository


class AgregarViewModel(private val repository: ReseniaPeliculaRepository) {

    val tituloPelicula = mutableStateOf("")
    val resena = mutableStateOf("")
    val calificacion = mutableStateOf(0f)
    val like = mutableStateOf(false)
    val yaLaVi = mutableStateOf(false)
    val mensajeError = mutableStateOf("")
    val mostrarError = mutableStateOf(false)

    fun onCalificacionChanged(nuevaCalificacion: Float) {
        calificacion.value = nuevaCalificacion
    }

    fun onLikeChanged(nuevoLike: Boolean) {
        like.value = nuevoLike
    }

    fun onGuardarClick(onSuccess: () -> Unit) {
        if (tituloPelicula.value.isBlank()) {
            mensajeError.value = "¡El título de la película es obligatorio!"
            mostrarError.value = true
            return
        }

        if (calificacion.value == 0f) {
            mensajeError.value = "¡Debes calificar la película con al menos 1 estrella!"
            mostrarError.value = true
            return
        }

        val nuevaResenia = ReseniaPelicula(
            tituloPelicula = tituloPelicula.value,
            resenia = resena.value,
            calificacion = calificacion.value,
            like = like.value,
            yaLaVi = yaLaVi.value
        )

        CoroutineScope(Dispatchers.IO).launch {
            repository.insertResenia(nuevaResenia)
            withContext(Dispatchers.Main) {
                mensajeError.value = "¡Reseña guardada exitosamente!"
                mostrarError.value = true
                CoroutineScope(Dispatchers.Main).launch {
                    delay(1500)
                    onSuccess()
                }
            }
        }
    }

    fun limpiarError() {
        mostrarError.value = false
        mensajeError.value = ""
    }
}