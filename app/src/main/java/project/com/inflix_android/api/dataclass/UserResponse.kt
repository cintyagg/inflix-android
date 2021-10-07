package project.com.inflix_android.api.dataclass

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserResponse(
    @SerializedName("id") val id : String,
    @SerializedName("email") val email : String,
    @SerializedName("name") val name : String,
    @SerializedName("phone") val phone : String
) : Serializable