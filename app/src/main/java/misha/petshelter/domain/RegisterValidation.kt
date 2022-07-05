package misha.petshelter.domain

class RegisterValidation: LoginValidation() {

    fun isPasswordAgainValid(passwordAgain: String, password: String): Boolean {
        return password == passwordAgain
    }

    fun isNameValid(name: String): Boolean {
        return name.isNotEmpty()
    }
}