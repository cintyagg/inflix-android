package project.com.inflix_android.presentation

sealed class ValidationException : Exception() {
    class EmailEmpty : ValidationException()
    class EmailWrong : ValidationException()
    class PasswordIncorrect : ValidationException()
}
