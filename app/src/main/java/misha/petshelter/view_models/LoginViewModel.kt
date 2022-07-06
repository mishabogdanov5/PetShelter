package misha.petshelter.view_models

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import misha.petshelter.data.repositories.UserRepository
import misha.petshelter.models.TestModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (

    private val userRepository: UserRepository
) : ViewModel() {

    private val _email = MutableLiveData("")
    private val _password = MutableLiveData("")

    val email: LiveData<String> = _email
    val password: LiveData<String> = _password

    fun tryLogin(email: String, password: String) {

    }

    fun getTestResult(): LiveData<TestModel> {
        return liveData {
            userRepository.getTestResult().body()?.let { emit(it) }
        }
    }
}