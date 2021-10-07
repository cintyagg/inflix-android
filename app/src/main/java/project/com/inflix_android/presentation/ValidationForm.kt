package project.com.inflix_android.presentation

import android.text.TextUtils
import android.util.Patterns

class ValidationForm {
    fun isDataValid(email: String, password: String) {
        when {
            TextUtils.isEmpty(email) || TextUtils.isEmpty(password) -> throw ValidationException.EmailOrPasswordEmpty()
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() || password.length != 8 -> throw ValidationException.EmailOrPasswordWrong()
        }
    }
}
