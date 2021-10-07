package project.com.inflix_android

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test
import project.com.inflix_android.presentation.ValidationException
import project.com.inflix_android.presentation.ValidationForm
import project.com.inflix_android.login.presenter.LoginPresenter
import project.com.inflix_android.login.presenter.LoginPresenterInterface
import project.com.inflix_android.login.view.LoginViewInterface

class LoginPresenterTest {
    private lateinit var presenter : LoginPresenterInterface
    private val view : LoginViewInterface = mockk(relaxed = true)
    private val validation : ValidationForm = mockk(relaxed = true)
    @Before
    fun setup(){
        presenter = LoginPresenter(view, validation)
        println("setup")
    }

    @After
    fun destroy(){
        println("destroy")
    }

    @Test
    fun verifyEmptyEmailTest(){
        every {
            validation.isDataValid(any(), any())
        } throws ValidationException.EmptyEmail()

        presenter.onLogin("", "12345678")

        verify {
            view.onLoginError(any())
        }
        println("verifyEmptyEmailTest")
    }

    @Test
    fun verifyEmptyPasswordTest(){
        every {
            validation.isDataValid(any(), any())
        } throws ValidationException.EmptyPassword()

        presenter.onLogin("user@gmail.com", "")

        verify {
            view.onLoginError(any())
        }
        println("verifyEmptyPasswordTest")
    }

    @Test
    fun verifyWrongEmailTest(){
        every {
            validation.isDataValid(any(), any())
        } throws ValidationException.WrongEmail()

        presenter.onLogin("cintya@gmail.com", "12345678")

        verify {
            view.onLoginError(any())
        }
        println("verifyWrongEmailTest")
    }

    @Test
    fun verifyWrongPasswordTest(){
        every {
            validation.isDataValid(any(), any())
        } throws ValidationException.WrongPassword()

        presenter.onLogin("user@gmail.com", "8765")

        verify {
            view.onLoginError(any())
        }
        println("verifyWrongPasswordTest")
    }
}
