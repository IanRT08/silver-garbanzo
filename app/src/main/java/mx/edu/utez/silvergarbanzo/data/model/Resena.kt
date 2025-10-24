package mx.edu.utez.silvergarbanzo.data.model

import androidx.annotation.DrawableRes

class Resena (
    val id: Int,
    @DrawableRes val imagen: Int,
    val nombrePeli: String,
    val userName: String,
    val desc: String
)