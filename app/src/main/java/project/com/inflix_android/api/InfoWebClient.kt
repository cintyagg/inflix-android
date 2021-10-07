package project.com.inflix_android.api

import project.com.inflix_android.api.dataclass.LoginRequest
import project.com.inflix_android.api.dataclass.LoginResponse
import rx.Observable

class InfoWebClient {

    fun infoCall(loginRequest: LoginRequest) : Observable<LoginResponse> {
        return RetrofitConfig().userInformationService()
            .getInformations(loginRequest)
    }
}
