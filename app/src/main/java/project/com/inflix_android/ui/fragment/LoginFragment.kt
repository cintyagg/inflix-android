package project.com.inflix_android.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_login.*
import project.com.inflix_android.R
import project.com.inflix_android.presenter.LoginPresenter
import project.com.inflix_android.presenter.LoginPresenterInterface
import project.com.inflix_android.ui.activity.MainActivity
import project.com.inflix_android.view.LoginViewInterface

class LoginFragment : NavHostFragment(), LoginViewInterface {

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

    lateinit var loginPresenter : LoginPresenterInterface

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Init
        loginPresenter = LoginPresenter(this)

        //Event
        login_button.setOnClickListener {
            loginPresenter.onLogin(
                login_editTextTextEmailAddress.text.toString(),
                login_editTextNumberPassword.editText?.text.toString()
            )
        }
        login_register_account.setOnClickListener {
            val act = activity as? MainActivity
            act?.showRegister()
        }
    }

    override fun onLoginSuccess(message: Int) {
        val act = activity as? MainActivity
        act?.showHome()
    }

    override fun onLoginError(message: Int) {
        activity?.let { Toasty.error(it, message, Toast.LENGTH_SHORT).show() }
    }
}
