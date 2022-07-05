package misha.petshelter.domain

open class LoginValidation  {


    fun isEmailValid(email: String): Boolean {

        val lettersLower = "a".."z"
        val lettersUpper = "A".."Z"
        val specialSymbols = listOf(".", "_", "-", "@")

        val emailDomains = listOf ("@mail.ru", "@inbox.ru", "@list.ru", "@bk.ru", "@yandex.ru",
            "@internet.ru", "@gmail.com", "@yahoo.com", "@hotmail.com", "@outlook.com")

        var hasCorrectForm = false

        for(i in 0 until email.length) {

            if (!lettersLower.contains(email[i].toString()) &&
                !lettersUpper.contains(email[i].toString()) &&
                !specialSymbols.contains(email[i].toString())
            ) return false

        }


        //if(email == "asd@mail.ru") return true

        emailDomains.forEach { if(email.contains(it)) hasCorrectForm = true}

        if(hasCorrectForm) return true

        return false
    }

   open fun isPasswordValid (password: String): Boolean {
        if (password.isEmpty()) return false

        return true
    }
}