package project.com.inflix_android.presentation

import android.text.TextUtils
import android.util.Patterns

class ValidationForm {
    fun isDataValid(email: String, password: String) {
        when {
            TextUtils.isEmpty(email) -> throw ValidationException.EmptyEmail()
            TextUtils.isEmpty(password) -> throw ValidationException.EmptyPassword()
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> throw ValidationException.WrongEmail()
            password.length != 8 -> throw ValidationException.WrongPassword()
        }
    }
}
