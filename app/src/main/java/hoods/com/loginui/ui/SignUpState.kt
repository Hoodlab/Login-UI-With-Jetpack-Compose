package hoods.com.loginui.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class SignUpState {
    var firstName: String by mutableStateOf("")
        private set
    var lastName: String by mutableStateOf("")

    var emailAddress: String by mutableStateOf("")
        private set
    var password: String by mutableStateOf("")
        private set
    var confirmPassword: String by mutableStateOf("")
        private set
    var checked: Boolean by mutableStateOf(false)
        private set

    val enableButton = firstName.isNotBlank() && lastName.isNotBlank() &&
            confirmPassword.isNotBlank() && password.isNotBlank()

   fun firstNameChenged(newValue: String){
       firstName = newValue

   }

    fun lastNameChange(newValue: String) {
        lastName = newValue
    }

    fun emailAddressChange(newValue: String) {
        emailAddress = newValue
    }

    fun password(newValue: String) {
        password = newValue
    }

    fun confirmPasswordChange(newValue: String) {
        confirmPassword = newValue
    }
    fun checkedChange(newValue: Boolean) {
        checked = newValue
    }


}