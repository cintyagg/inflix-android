package project.com.inflix_android.api.dataclass

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginRequest(
    @SerializedName("email") val email : String,
    @SerializedName("password") val password : String
) : Serializable
