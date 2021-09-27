package project.com.inflix_android.presenter

import project.com.inflix_android.R
import project.com.inflix_android.model.User
import project.com.inflix_android.view.LoginViewInterface

class LoginPresenter(private var loginViewInterface: LoginViewInterface) : LoginPresenterInterface{
    override fun onLogin(email: String, password: String) {
        val user = User(email,password)
        when (user.isDataValid()) {
            0 -> loginViewInterface.onLoginError(R.string.email_not_null)
            1 -> loginViewInterface.onLoginError(R.string.wrong_email)
            2 -> loginViewInterface.onLoginError(R.string.wrong_password)
            else -> loginViewInterface.onLoginSuccess(R.string.login_success)
        }
    }
}