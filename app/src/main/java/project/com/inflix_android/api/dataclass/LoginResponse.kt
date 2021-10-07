package project.com.inflix_android.api.dataclass

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginResponse(
    @SerializedName("success") val success : Boolean,
    @SerializedName("user") val userResponse : UserResponse
) : Serializable
