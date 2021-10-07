package project.com.inflix_android.presentation

sealed class ValidationException : Exception() {
    class EmptyEmail : ValidationException()
    class EmptyPassword : ValidationException()
    class WrongEmail : ValidationException()
    class WrongPassword : ValidationException()
}
