package project.com.inflix_android.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_login.*
import project.com.inflix_android.R
import project.com.inflix_android.presenter.LoginPresenter
import project.com.inflix_android.presenter.LoginPresenterInterface
import project.com.inflix_android.view.LoginViewInterface

class LoginFragment : Fragment(), LoginViewInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        lateinit var loginPresenter : LoginPresenterInterface

        //Init
        loginPresenter = LoginPresenter(this)
        //Event
        val button : Button? = view?.findViewById<Button>(R.id.login_button)
        button!!.setOnClickListener {
            loginPresenter.onLogin(
                login_editTextTextEmailAddress.text.toString(),
                login_editTextNumberPassword.text.toString()
            )
        }
    }

    override fun onLoginSuccess(message: String) {
        activity?.let { Toasty.success(it, message, Toast.LENGTH_SHORT).show() }
    }

    override fun onLoginError(message: String) {
        activity?.let { Toasty.error(it, message, Toast.LENGTH_SHORT).show() }
    }
}
