package mx.edu.utez.silvergarbanzo.data.model

import androidx.annotation.DrawableRes
import mx.edu.utez.silvergarbanzo.R

data class Usuario(
    val id: Int,
    @DrawableRes val imagen: Int,
    val correo: String,
    val nombreUsuario: String,
    val contrasenia: String
)