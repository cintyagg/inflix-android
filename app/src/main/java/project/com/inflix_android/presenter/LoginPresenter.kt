package project.com.inflix_android.presenter

import project.com.inflix_android.model.User
import project.com.inflix_android.view.LoginViewInterface

class LoginPresenter(private var LoginViewInterface: LoginViewInterface) : LoginPresenterInterface{
    override fun onLogin(email: String, password: String) {
        val user = User(email,password)
        when (user.isDataValid()) {
            0 -> LoginViewInterface.onLoginError("Email must not be null")
            1 -> LoginViewInterface.onLoginError("Wrong email address")
            2 -> LoginViewInterface.onLoginError("Password must have to contain 8 numbers")
            else -> LoginViewInterface.onLoginSuccess("Login Success")
        }
    }
}