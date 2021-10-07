package project.com.inflix_android.api.repository

import project.com.inflix_android.api.InfoWebClient
import project.com.inflix_android.api.dataclass.LoginRequest
import project.com.inflix_android.model.LoginResponseModel
import project.com.inflix_android.model.Mapper
import rx.Observable

class Repository(private val mapper : Mapper = Mapper()) : RepositoryContract {
    override fun loginRequest(loginRequest: LoginRequest): Observable<LoginResponseModel> {
        return InfoWebClient().infoCall(loginRequest)
            .map{mapper.transform(it)}
    }
}