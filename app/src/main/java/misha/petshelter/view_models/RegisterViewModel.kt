package misha.petshelter.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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
}