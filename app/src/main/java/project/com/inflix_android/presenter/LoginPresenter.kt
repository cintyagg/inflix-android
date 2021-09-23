package project.com.inflix_android.presenter

import project.com.inflix_android.model.User
import project.com.inflix_android.ui.fragment.LoginFragment

class LoginPresenter(private var LoginViewInterface: LoginFragment) : LoginPresenterInterface{
    override fun onLogin(email: String, password: String) {
        val user = User(email,password)
        val loginCode = user.isDataValid()
        if(loginCode == 0)
            LoginViewInterface.onLoginError("Email must not be null")
        else if(loginCode == 1)
            LoginViewInterface.onLoginError("Wrong email address")
        else if(loginCode == 2)
            LoginViewInterface.onLoginError("Password must have to contain 8 numbers")
        else
            LoginViewInterface.onLoginSuccess("Login Success")
    }
}