package project.com.inflix_android.model

import android.text.TextUtils
import android.util.Patterns

class User (override val email:String, override val password:String) : UserInterface {
    override fun isDataValid(): Int {
        if(TextUtils.isEmpty(email))
            return 0 //0 error code is email empty
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return 1 //1 error code is wrong pattern
        else if(password.length != 8)
            return 2 //2 error code is password length must be equals to 8
        else
            return -1 //success code
    }
}
