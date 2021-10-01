package project.com.inflix_android.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import project.com.inflix_android.api.service.UserInformationService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitConfig {

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.43.122:3001/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(getHTTP())
            .build()

    private fun getHTTP() : OkHttpClient{
        val logging = HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(logging).build()

    }

    fun userInformationService() = retrofit.create(UserInformationService::class.java)
}
