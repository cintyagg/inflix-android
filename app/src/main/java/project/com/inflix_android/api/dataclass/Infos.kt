package project.com.inflix_android.api.dataclass

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginRequest(
    @SerializedName("email") val email : String,
    @SerializedName("password") val password : String
) : Serializable

data class LoginResponse(
    @SerializedName("success") val success : Boolean,
    @SerializedName("user") val user : User
) : Serializable

data class User(
    @SerializedName("id") val id : String,
    @SerializedName("email") val email : String,
    @SerializedName("name") val name : String,
    @SerializedName("phone") val phone : String
) : Serializable

data class InfoRegister(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String,
    @SerializedName("name") var name: String,
    @SerializedName("phone") var phone: String
) : Serializable
