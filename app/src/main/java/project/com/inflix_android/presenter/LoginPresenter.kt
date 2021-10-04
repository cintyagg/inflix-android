package project.com.inflix_android.presenter

import project.com.inflix_android.R
import project.com.inflix_android.api.dataclass.LoginRequest
import project.com.inflix_android.api.repository.Repository
import project.com.inflix_android.api.repository.RepositoryContract
import project.com.inflix_android.model.User
import project.com.inflix_android.presentation.ValidationException
import project.com.inflix_android.presentation.ValidationForm
import project.com.inflix_android.view.LoginViewInterface

class LoginPresenter(
    private var loginViewInterface: LoginViewInterface,
    private val validation: ValidationForm = ValidationForm()
    ) : LoginPresenterInterface{

    override fun onLogin(email: String, password: String) {
        runCatching {
            validation.isDataValid(email, password)

        }.onSuccess {
            doLogin(email, password)
        }.onFailure {
            when (it) {
                is ValidationException.EmailEmpty -> loginViewInterface.onLoginError(R.string.email_not_null)
                is ValidationException.EmailWrong -> loginViewInterface.onLoginError(R.string.wrong_email)
                is ValidationException.PasswordIncorrect -> loginViewInterface.onLoginError(R.string.wrong_password)
            }
        }
    }

    private fun doLogin(email: String, password: String){
        val repository : RepositoryContract = Repository()
        repository.loginRequest(loginRequest = LoginRequest(email, password))
    }
}