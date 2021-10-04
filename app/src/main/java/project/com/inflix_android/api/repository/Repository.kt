package project.com.inflix_android.api.repository

import project.com.inflix_android.api.InfoWebClient
import project.com.inflix_android.api.dataclass.LoginRequest
import project.com.inflix_android.api.dataclass.LoginResponse

class Repository : RepositoryContract {
    override fun loginRequest(loginRequest: LoginRequest){
        InfoWebClient().infoCall(loginRequest)
    }
}