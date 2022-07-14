package misha.petshelter

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import misha.petshelter.ui.views.login.LoginView
import misha.petshelter.view_models.LoginViewModel
import misha.petshelter.view_models.RegisterViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            val registerViewModel = hiltViewModel<RegisterViewModel>()
            val message = remember { mutableStateOf("фывфыв") }

            compositeDisposable.add(loginViewModel.getTestResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        message.value = it.title
                    },
                    {
                        message.value = "a"
                    }
                ))

            LoginView(loginViewModel, registerViewModel, message.value)
        }

    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}


