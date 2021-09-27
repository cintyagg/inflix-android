package project.com.inflix_android.api.dataclass

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class InfoLogin(
    @SerializedName("email") val email : String,
    @SerializedName("password") val password : String
) : Serializable

data class InfoRegister(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String,
    @SerializedName("name") var name: String,
    @SerializedName("phone") var phone: String
) : Serializable
