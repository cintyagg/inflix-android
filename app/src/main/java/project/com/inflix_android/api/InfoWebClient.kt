package project.com.inflix_android.api

import android.util.Log
import project.com.inflix_android.api.dataclass.LoginRequest
import project.com.inflix_android.api.dataclass.LoginResponse
import project.com.inflix_android.api.dataclass.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoWebClient {

    fun infoCall() {
        val call = RetrofitConfig().userInformationService()
            .getInformations(LoginRequest("user@gmail.com", "12345678"))
        call.enqueue(
        object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                response.let {
                    val infos = it.body()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                t.message?.let { Log.e("onFailure error", it) }
            }

        })
    }
}
