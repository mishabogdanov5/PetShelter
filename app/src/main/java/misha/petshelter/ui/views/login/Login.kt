package misha.petshelter.ui.views.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import misha.petshelter.ui.theme.APP_LOGO_END_TIME
import misha.petshelter.ui.theme.APP_LOGO_START_TIME
import misha.petshelter.ui.theme.APP_LOGO_TOP_TIME
import misha.petshelter.ui.views.AppLogoView

@Composable
fun LoginView(){
    AppLogoView()
}


@Preview(showBackground = true)
@Composable
fun LoginViewPreview(){
    LoginView()
}