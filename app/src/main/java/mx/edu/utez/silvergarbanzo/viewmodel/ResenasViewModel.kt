package mx.edu.utez.silvergarbanzo.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import mx.edu.utez.silvergarbanzo.R
import mx.edu.utez.silvergarbanzo.data.model.Resena

class ResenasViewModel: ViewModel() {
    val _resenas = MutableStateFlow<List<Resena>>(emptyList())
    val resenas: StateFlow<List<Resena>> = _resenas

    init {
        _resenas.value = listOf(
            Resena(
                1,
                R.drawable.ironman,
                "Iron-Man",
                "IanRT08",
                "Siempre sera de mis favoritas en el mundo 10/10"
            ),
            Resena(
                2,
                R.drawable.cars3,
                "Cars 3",
                "PP45",
                "Me gusta por partes pero aprendi a quererla"
            ),
            Resena(
                3,
                R.drawable.yourname,
                "Your Name",
                "IanRT08",
                "La mejor película de romance"
            ),
            Resena(
                4,
                R.drawable.tss,
                "The Suicide Squad",
                "manzana_",
                "Te quiero mucho James Gunn"
            ),
            Resena(
                5,
                R.drawable.quintillizas,
                "Las Quintillizas: La película",
                "IanRT08",
                "Team miku por siempre!!"
            )
        )
    }

    fun clickResena(resena: Resena){
        println("Has hecho click en: ${resena.nombrePeli}")
    }

}