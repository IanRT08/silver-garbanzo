package mx.edu.utez.silvergarbanzo.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AgregarViewModel {

    var titulo = mutableStateOf("")
    var anioEstreno = mutableStateOf("")
    var director = mutableStateOf("")
    var actores = mutableStateOf("")
    var fechaVista = mutableStateOf("")
    var calificacion = mutableStateOf(0)
    var resena = mutableStateOf("")
    var like = mutableStateOf(false)
    var vista = mutableStateOf(false)

    fun onGuardarClick(onFinish: () -> Unit) {
        // Aquí se guardaría la película en base de datos o lista
        onFinish()
    }

    fun limpiarCampos() {
        titulo.value = ""
        anioEstreno.value = ""
        director.value = ""
        actores.value = ""
        fechaVista.value = ""
        calificacion.value = 0
        resena.value = ""
        like.value = false
        vista.value = false
    }


}