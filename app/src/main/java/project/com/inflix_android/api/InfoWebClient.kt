package project.com.inflix_android.api

import android.util.Log
import project.com.inflix_android.api.dataclass.InfoLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoWebClient {

    fun infoCall() {
        val call = RetrofitConfig().userInformationService()
            .getInformations(InfoLogin("cintyagg@gmail.com", "12345678"))
        call.enqueue(
        object : Callback<InfoLogin> {
            override fun onResponse(
                call: Call<InfoLogin>,
                response: Response<InfoLogin>
            ) {
                response.let {
                    val infos = it.body()
                }
            }

            override fun onFailure(call: Call<InfoLogin>, t: Throwable) {
                t.message?.let { Log.e("onFailure error", it) }
            }

        })
    }
}
