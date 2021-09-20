package project.com.inflix_android.model

interface UserInterface {
    val email : String;
    val password : String;
    fun isDataValid() : Int
}