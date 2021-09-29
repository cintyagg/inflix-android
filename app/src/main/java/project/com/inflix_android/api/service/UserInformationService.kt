package project.com.inflix_android.api.service

import project.com.inflix_android.api.dataclass.LoginRequest
import project.com.inflix_android.api.dataclass.LoginResponse
import project.com.inflix_android.api.dataclass.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserInformationService {
    @POST("auth/login")
    fun getInformations(
        @Body loginRequest: LoginRequest
    ) : Call<LoginResponse>
}