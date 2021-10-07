package project.com.inflix_android.model

import project.com.inflix_android.api.dataclass.LoginResponse
import project.com.inflix_android.api.dataclass.UserResponse

class Mapper {
    fun transform(loginResponse : LoginResponse) : LoginResponseModel{
        return LoginResponseModel(success = loginResponse.success,
            user = transform(loginResponse.userResponse))
    }

    private fun transform(userResponse : UserResponse) : User{
        return User(email = userResponse.email)
    }
}