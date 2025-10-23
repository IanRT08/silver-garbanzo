package mx.edu.utez.silvergarbanzo.viewmodel

import androidx.compose.runtime.mutableStateOf

class ChangePasswordViewModel {
    var email = mutableStateOf("")
    var code = mutableStateOf("")
}