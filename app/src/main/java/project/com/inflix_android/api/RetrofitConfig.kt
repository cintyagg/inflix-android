package project.com.inflix_android.api

import project.com.inflix_android.api.service.UserInformationService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitConfig {

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.43.122:3001/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun userInformationService() = retrofit.create(UserInformationService::class.java)
}
