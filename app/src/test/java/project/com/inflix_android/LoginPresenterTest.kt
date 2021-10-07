package project.com.inflix_android

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test
import project.com.inflix_android.presentation.ValidationException
import project.com.inflix_android.presentation.ValidationForm
import project.com.inflix_android.presenter.LoginPresenter
import project.com.inflix_android.presenter.LoginPresenterInterface
import project.com.inflix_android.view.LoginViewInterface

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
    fun verifyWrongEmailTest(){
        every {
            validation.isDataValid(any(), any())
        } throws ValidationException.EmailWrong()

        presenter.onLogin("cgggmail.com", "12345678")

        verify {
            view.onLoginError(any())
        }
        println("verifyWrongEmailTest")
    }

    @Test
    fun verifyEmptyTest(){
        every {
            validation.isDataValid(any(), any())
        } throws ValidationException.EmailEmpty()

        presenter.onLogin("", "12345678")

        verify {
            view.onLoginError(any())
        }
        println("verifyEmptyTest")
    }

    @Test
    fun verifyPasswordTest(){
        every {
            validation.isDataValid(any(), any())
        } throws ValidationException.PasswordIncorrect()

        presenter.onLogin("userResponse@gmail.com", "12345")

        verify {
            view.onLoginError(any())
        }
        println("verifyPasswordTest")
    }
}