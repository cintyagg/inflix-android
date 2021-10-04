package project.com.inflix_android.api.repository

import project.com.inflix_android.api.dataclass.LoginRequest
import project.com.inflix_android.api.dataclass.LoginResponse

interface RepositoryContract {
    fun loginRequest(loginRequest: LoginRequest)
}