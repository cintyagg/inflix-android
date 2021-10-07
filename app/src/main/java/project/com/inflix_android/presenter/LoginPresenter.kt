package project.com.inflix_android.presenter

import project.com.inflix_android.R
import project.com.inflix_android.api.dataclass.LoginRequest
import project.com.inflix_android.api.repository.Repository
import project.com.inflix_android.presentation.ValidationException
import project.com.inflix_android.presentation.ValidationForm
import project.com.inflix_android.view.LoginViewInterface
import retrofit2.HttpException
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class LoginPresenter(
    private var loginViewInterface: LoginViewInterface,
    private val validation: ValidationForm = ValidationForm(),
    private val repository: Repository = Repository()
) : LoginPresenterInterface {
    override fun onLogin(email: String, password: String) {
        runCatching {
            validation.isDataValid(email, password)
        }.onSuccess {
            doLogin(email, password)
        }.onFailure {
            when (it) {
                is ValidationException.EmailOrPasswordEmpty -> loginViewInterface.onLoginError(R.string.empty_email_or_password)
                is ValidationException.EmailOrPasswordWrong -> loginViewInterface.onLoginError(R.string.wrong_email_or_password)
            }
        }
    }
    private fun showException(throwable: Throwable) {
        when ((throwable as HttpException).code()) {
            400 -> loginViewInterface.onLoginError(R.string.empty_email_or_password)
            403 -> loginViewInterface.onLoginError(R.string.wrong_email_or_password)
        }
    }
    private fun doLogin(email: String, password: String){
        repository.loginRequest(loginRequest = LoginRequest(email, password))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {  }
            .doOnTerminate {  }
            .doOnError {  }
            .subscribe({
                loginViewInterface.onLoginSuccess(R.string.login_success)
            },{
                showException(it)
            })
    }
}
