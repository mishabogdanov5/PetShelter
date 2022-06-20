package misha.petshelter.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.times
import misha.petshelter.R
import misha.petshelter.ui.theme.APP_LOGO_BOTTOM_TIME
import misha.petshelter.ui.theme.APP_LOGO_END_TIME
import misha.petshelter.ui.theme.APP_LOGO_START_TIME
import misha.petshelter.ui.theme.APP_LOGO_TOP_TIME

@Composable
fun AppLogoView(){
    BoxWithConstraints {

        Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_app_logo),
            contentDescription = "logo",

            modifier = Modifier
                .padding(top = APP_LOGO_TOP_TIME.times(maxHeight),
                start = APP_LOGO_START_TIME.times(maxWidth),
                end = APP_LOGO_END_TIME.times(maxWidth),
                bottom = APP_LOGO_BOTTOM_TIME.times(maxHeight)
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppLogoPreview(){
    Surface(Modifier.fillMaxSize()) {
        AppLogoView()
    }
}