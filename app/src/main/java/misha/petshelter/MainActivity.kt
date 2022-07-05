package misha.petshelter

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import misha.petshelter.ui.views.login.LoginView
import misha.petshelter.view_models.LoginViewModel
import misha.petshelter.view_models.RegisterViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            val registerViewModel = hiltViewModel<RegisterViewModel>()

            LoginView(loginViewModel, registerViewModel)
        }

    }
}


