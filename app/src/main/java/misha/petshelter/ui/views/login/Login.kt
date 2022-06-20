package misha.petshelter.ui.views.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import misha.petshelter.ui.views.AppLogoView
import misha.petshelter.ui.views.SelectorView

@Composable
fun LoginView(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
            AppLogoView()
            SelectorView()
    }
}


@Preview(showBackground = true)
@Composable
fun LoginViewPreview(){
    LoginView()
}