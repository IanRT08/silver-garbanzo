package mx.edu.utez.silvergarbanzo.viewmodel

import androidx.compose.runtime.mutableStateOf

class ChangePasswordTwoViewModel {
    var newPassword = mutableStateOf("")
    var confirmNewPassword = mutableStateOf("")
}