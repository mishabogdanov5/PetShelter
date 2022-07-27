package misha.petshelter.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import misha.petshelter.models.AppDestination
import misha.petshelter.services.network.NetworkRemote
import misha.petshelter.models.UserTokens
import misha.petshelter.models.RegisterInfo
import misha.petshelter.services.localStorage.UserStorage
import misha.petshelter.services.navigation.AppNavigation
import misha.petshelter.ui.theme.EMAIL_PATTERN
import misha.petshelter.ui.theme.SIGN_ON_EXCEPTION
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor (
    private val network: NetworkRemote,
    private val storage: UserStorage,
    private val navigation: AppNavigation
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val name = MutableLiveData("")
    val email = MutableLiveData("")
    val password = MutableLiveData("")

    val errorMessage = MutableLiveData("")

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun isEmailValid(email: String): Boolean = Pattern.compile(EMAIL_PATTERN).matcher(email).matches()

    fun isPasswordValid(password: String): Boolean = password.isNotEmpty()

    fun isPasswordAgainValid(password: String, passwordAgain: String): Boolean = password == passwordAgain

    fun isNameValid(name: String): Boolean = name.isNotEmpty()

    fun tryRegister(/*name: String, email: String, password: String, onSuccess: Consumer<UserTokens>,
                    onError: Consumer<Throwable>*/) = compositeDisposable.add(network
            .registerUser(RegisterInfo(name = name.value!!, email = email.value!!,
                password = password.value!!))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    onSuccessRegister(it)
                },
                {
                    onErrorRegister()
                }
            ))

    private fun onSuccessRegister(tokens: UserTokens) {
        storage.saveTokens(tokens)
        navigation.navigateTo(AppDestination.MainScreen)
    }

    private fun onErrorRegister() {
        errorMessage.value = SIGN_ON_EXCEPTION
    }
}