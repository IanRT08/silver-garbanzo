package mx.edu.utez.silvergarbanzo.viewmodel

import androidx.compose.runtime.mutableStateOf

class RecuperarPasswordViewModel {
    var email = mutableStateOf("")
    var code = mutableStateOf("")
}