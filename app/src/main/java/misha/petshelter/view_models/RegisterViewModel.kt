package misha.petshelter.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import misha.petshelter.ui.theme.EMAIL_PATTERN
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor (

) : ViewModel() {

    private val _name = MutableLiveData("")
    private val _email = MutableLiveData("")
    private val _password = MutableLiveData("")
    private val _passwordAgain = MutableLiveData("")

    val name: LiveData<String> = _name
    val email: LiveData<String> = _email
    val password: LiveData<String> = _password
    val passwordAgain: LiveData<String> = _passwordAgain

    fun isEmailValid(email: String): Boolean = Pattern.compile(EMAIL_PATTERN).matcher(email).matches()

    fun isPasswordValid(password: String): Boolean = password.isNotEmpty()

    fun isPasswordAgainValid(password: String, passwordAgain: String): Boolean = password == passwordAgain

    fun isNameValid(name: String): Boolean = name.isNotEmpty()

    fun tryRegister(name: String, email: String, password: String) {

    }
}