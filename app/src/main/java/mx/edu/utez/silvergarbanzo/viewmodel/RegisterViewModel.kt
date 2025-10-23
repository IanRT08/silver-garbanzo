package mx.edu.utez.silvergarbanzo.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    var password = mutableStateOf("")
    var confirmPassword = mutableStateOf("") // Agregué este campo
    var username = mutableStateOf("")
    var email = mutableStateOf("")
    var acceptTerms = mutableStateOf(false)
    var registerError = mutableStateOf("")

    fun register(onSuccess: () -> Unit) {

        if (email.value.isEmpty() || username.value.isEmpty() ||
            password.value.isEmpty() || confirmPassword.value.isEmpty()) {
            registerError.value = "Todos los campos son obligatorios"
            return
        }

        if (password.value != confirmPassword.value) {
            registerError.value = "Las contraseñas no coinciden"
            return
        }

        if (!acceptTerms.value) {
            registerError.value = "Debes aceptar los términos y condiciones"
            return
        }

        if (!isValidEmail(email.value)) {
            registerError.value = "Ingresa un email válido"
            return
        }
        registerError.value = ""
        onSuccess()
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}