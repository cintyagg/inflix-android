package project.com.inflix_android.presentation

import android.text.TextUtils
import android.util.Patterns

class ValidationForm {

    fun isDataValid(email: String, password: String) {
        when {
            TextUtils.isEmpty(email) -> ValidationException.EmailEmpty() //0 error code is email empty
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> ValidationException.EmailWrong() //1 error code is wrong pattern
            password.length != 8 -> ValidationException.PasswordIncorrect() //2 error code is password length must be equals to 8
        }
    }
}
