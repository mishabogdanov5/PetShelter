package misha.petshelter.viewModels.login

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import misha.petshelter.models.AppDestination
import misha.petshelter.models.LoginInfo
import misha.petshelter.models.UserTokens
import misha.petshelter.services.localStorage.UserStorage
import misha.petshelter.services.navigation.AppNavigation
import misha.petshelter.services.network.retrofit.RetrofitService
import misha.petshelter.ui.theme.EMAIL_PATTERN
import misha.petshelter.ui.theme.SIGN_IN_EXCEPTION
import javax.inject.Inject
import java.util.regex.Pattern

@HiltViewModel
class LoginViewModel @Inject constructor (

    private val network: RetrofitService,
    private val storage: UserStorage,
    private val navigation: AppNavigation
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val email = MutableLiveData("")
    val password = MutableLiveData("")

    var errorMessage = MutableLiveData("")

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun isEmailValid(email: String): Boolean = Pattern.compile(EMAIL_PATTERN).matcher(email).matches()

    fun isPasswordValid(password: String): Boolean = password.isNotEmpty()

    fun tryLogin() = compositeDisposable.add(network
        .loginUser(LoginInfo(email = email.value!!, password = password.value!!))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {
                onSuccessLogin(it)
            },
            {
                onErrorLogin()
            }
        ))

    private fun onSuccessLogin(tokens: UserTokens) {
        storage.saveTokens(tokens)
        navigation.navigateTo(AppDestination.MainScreen)
    }

    private fun onErrorLogin() {
        errorMessage.value = SIGN_IN_EXCEPTION
    }
}