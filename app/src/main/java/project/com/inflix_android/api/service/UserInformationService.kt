package project.com.inflix_android.api.service

import project.com.inflix_android.api.dataclass.LoginRequest
import project.com.inflix_android.api.dataclass.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface UserInformationService {
    @POST("auth/login")
    fun getInformations(
        @Body loginRequest: LoginRequest
    ) : Observable<LoginResponse>
}