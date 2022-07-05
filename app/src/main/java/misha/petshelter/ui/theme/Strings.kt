package misha.petshelter.ui.theme

class EditTextHints {
    companion object {
        const val EMAIL = "Email"
        const val NAME = "Имя"
        const val PASSWORD = "Пароль"
        const val PASSWORD_AGAIN = "Повторите пароль"
    }
}

class SelectorTexts {
    companion object {
        const val SIGN_ON = "Регистрация"
        const val SIGN_IN = "Вход"
    }
}

class LoginButtonsTexts {
    companion object {
        const val SIGN_ON = "Зарегистрироваться"
        const val SIGN_IN = "Войти"
        const val SIGN_LATE = "Войти позже"
        const val FORGOT_PASSWORD = "Забыли пароль?"
    }
}

class LoginExceptions {
     companion object {
         const val EMAIL_EXCEPTION = "Неверный формат email. Пример: name@gmail.com"
         const val PASSWORD_EXCEPTION = "Поле не должно быть пустым!"
     }
}

class RegisterExceptions {
    companion object {
        const val NAME_EXCEPTION = "Поле не должно быть пустым!"
        const val PASSWORD_AGAIN_EXCEPTION = "Не совпадает с введенным паролем!"
    }
}
