package project.com.inflix_android.model

import android.text.TextUtils
import android.util.Patterns

class User (override val email:String, override val password:String) : UserInterface {
    override fun isDataValid(): Int {
        return when {
            TextUtils.isEmpty(email) -> 0 //0 error code is email empty
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> 1 //1 error code is wrong pattern
            password.length != 8 -> 2 //2 error code is password length must be equals to 8
            else -> -1 //success code
        }
    }
}
