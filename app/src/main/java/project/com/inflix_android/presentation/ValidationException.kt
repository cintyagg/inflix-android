package project.com.inflix_android.presentation

sealed class ValidationException : Exception() {
    class EmailOrPasswordWrong : ValidationException()
    class EmailOrPasswordEmpty : ValidationException()
}
