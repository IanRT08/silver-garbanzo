package mx.edu.utez.silvergarbanzo.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mx.edu.utez.silvergarbanzo.data.model.ReseniaPelicula
import mx.edu.utez.silvergarbanzo.data.repository.ReseniaPeliculaRepository

class EditarViewModel(
    private val repository: ReseniaPeliculaRepository,
    private val reseniaId: Int = 0
) : ViewModel() {
    val tituloPelicula = mutableStateOf("")
    val resena = mutableStateOf("")
    val calificacion = mutableStateOf(0f)
    val like = mutableStateOf(false)
    val yaLaVi = mutableStateOf(false)
    //Estado para mensajes
    val mensajeError = mutableStateOf("")
    val mostrarError = mutableStateOf(false)
    //Cargar los datos de la reseña al iniciar
    init {
        cargarResenia()
    }
    private fun cargarResenia() {
        println("🟣 CARGANDO RESEÑA - ID: $reseniaId")
        viewModelScope.launch {
            try {
                val resenia = repository.getReseniaById(reseniaId)
                println("🟠 RESEÑA ENCONTRADA: ${resenia != null}")
                if (resenia != null) {
                    println("📝 DATOS CARGADOS:")
                    println("   - Título: ${resenia.tituloPelicula}")
                    println("   - Reseña: ${resenia.resenia}")
                    println("   - Calificación: ${resenia.calificacion}")
                    println("   - Like: ${resenia.like}")
                    println("   - Ya la vi: ${resenia.yaLaVi}")

                    tituloPelicula.value = resenia.tituloPelicula
                    resena.value = resenia.resenia
                    calificacion.value = resenia.calificacion
                    like.value = resenia.like
                    yaLaVi.value = resenia.yaLaVi
                } else {
                    println("❌ NO SE ENCONTRÓ RESEÑA CON ID: $reseniaId")
                }
            } catch (e: Exception) {
                println("💥 ERROR CARGANDO: ${e.message}")
            }
        }
    }
    fun onCalificacionChanged(nuevaCalificacion: Float) {
        calificacion.value = nuevaCalificacion
    }
    fun onLikeChanged(nuevoLike: Boolean) {
        like.value = nuevoLike
    }
    fun onGuardarClick(onSuccess: () -> Unit) {
        //Validaciones
        if (tituloPelicula.value.isBlank()) {
            mensajeError.value = "¡El título de la película es obligatorio!"
            mostrarError.value = true
            return
        }
        if (calificacion.value == 0f) {
            mensajeError.value = "¡Debes calificar la película!"
            mostrarError.value = true
            return
        }
        viewModelScope.launch {
            //Obtener la reseña actualizada - usa el reseniaId del constructor
            val reseniaActualizada = ReseniaPelicula(
                id = reseniaId,
                tituloPelicula = tituloPelicula.value,
                resenia = resena.value,
                calificacion = calificacion.value,
                like = like.value,
                yaLaVi = yaLaVi.value
            )
            //Actualizar en la base de datos
            repository.updateResenia(reseniaActualizada)
            withContext(Dispatchers.Main) {
                mensajeError.value = "¡Reseña actualizada exitosamente!"
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