package misha.petshelter.ui.views.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import misha.petshelter.ui.theme.*
import misha.petshelter.ui.views.AppLogoView
import misha.petshelter.ui.views.EditTextView

@Composable
fun LoginView(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {

        AppLogoView()

        EditTextView(
            keyboardType = KeyboardType.Text,
            text = EditTextHints.NAME,
            hasImages = false,
            imeAction = ImeAction.Next,
            topOffset = FIRST_EDIT_TEXT_OFFSET,
        )

        EditTextView(
            keyboardType = KeyboardType.Email,
            text = EditTextHints.EMAIL,
            hasImages = false,
            imeAction = ImeAction.Next,
            topOffset = FIRST_EDIT_TEXT_OFFSET + OFFSET_BETWEEN_EDIT_TEXTS,
        )

        EditTextView(
            keyboardType = KeyboardType.Password,
            text = EditTextHints.PASSWORD,
            hasImages = true,
            imeAction = ImeAction.Next,
            topOffset = FIRST_EDIT_TEXT_OFFSET + 2* OFFSET_BETWEEN_EDIT_TEXTS,
        )
        EditTextView(
            keyboardType = KeyboardType.Password,
            text = EditTextHints.PASSWORD_AGAIN,
            hasImages = true,
            imeAction = ImeAction.Done,
            topOffset = FIRST_EDIT_TEXT_OFFSET + 3* OFFSET_BETWEEN_EDIT_TEXTS,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun LoginViewPreview(){
    LoginView()
}