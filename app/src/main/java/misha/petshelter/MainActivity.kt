package misha.petshelter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import misha.petshelter.ui.theme.FIRST_EDIT_TEXT_OFFSET
import misha.petshelter.ui.theme.OFFSET_BETWEEN_EDIT_TEXTS
import misha.petshelter.ui.theme.PetShelterTheme
import misha.petshelter.ui.views.AppLogoView
import misha.petshelter.ui.views.EditTextView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.White)) {
                AppLogoView()
                EditTextView(
                    keyboardType = KeyboardType.Text,
                    text = "Имя",
                    hasImages = false,
                    imeAction = ImeAction.Next,
                    topOffset = FIRST_EDIT_TEXT_OFFSET,
                )

                EditTextView(
                    keyboardType = KeyboardType.Email,
                    text = "E-mail",
                    hasImages = false,
                    imeAction = ImeAction.Next,
                    topOffset = FIRST_EDIT_TEXT_OFFSET + OFFSET_BETWEEN_EDIT_TEXTS,
                )

                EditTextView(
                    keyboardType = KeyboardType.Password,
                    text = "Password",
                    hasImages = true,
                    imeAction = ImeAction.Next,
                    topOffset = FIRST_EDIT_TEXT_OFFSET + 2* OFFSET_BETWEEN_EDIT_TEXTS,
                )
            }
        }
    }
}


