package project.com.inflix_android.api.repository

import project.com.inflix_android.api.dataclass.LoginRequest
import project.com.inflix_android.model.LoginResponseModel
import rx.Observable

interface RepositoryContract {
    fun loginRequest(loginRequest: LoginRequest) : Observable<LoginResponseModel>
}