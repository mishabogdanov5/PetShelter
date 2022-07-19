package misha.petshelter.view_models

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import misha.petshelter.data.repositories.UserRepository
import misha.petshelter.models.LoginInfo
import misha.petshelter.models.LoginResponse
import misha.petshelter.ui.theme.EMAIL_PATTERN
import javax.inject.Inject
import java.util.regex.Pattern

@HiltViewModel
class LoginViewModel @Inject constructor (

    private val userRepository: UserRepository
) : ViewModel() {

    private val _email = MutableLiveData("")
    private val _password = MutableLiveData("")
    //private val _response = MutableLiveData(LoginResponse("", ""))

    val email: LiveData<String> = _email
    val password: LiveData<String> = _password
    //val response: LiveData<LoginResponse> = _response

    fun isEmailValid(email: String): Boolean = Pattern.compile(EMAIL_PATTERN).matcher(email).matches()

    fun isPasswordValid(password: String): Boolean = password.isNotEmpty()

    fun tryLogin(email: String, password: String) = userRepository
        .loginUser(LoginInfo(email = email, password = password))

}