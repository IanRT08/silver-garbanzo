package mx.edu.utez.silvergarbanzo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resenia_pelicula")
class ReseniaPelicula (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val tituloPelicula: String,
    val resenia: String,
    val calificacion: Float,
    val like: Boolean,
    val yaLaVi: Boolean
)