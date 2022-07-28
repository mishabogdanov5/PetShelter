package misha.petshelter.ui.views.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import misha.petshelter.ui.views.AppLogoView
import misha.petshelter.viewModels.LoginViewModel
import misha.petshelter.viewModels.RegisterViewModel

@Composable
fun LoginView(loginViewModel: LoginViewModel, registerViewModel: RegisterViewModel) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
            AppLogoView()
            SelectorView(loginViewModel, registerViewModel)
    }
}
