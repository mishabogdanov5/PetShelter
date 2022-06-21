package misha.petshelter.ui.views.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import misha.petshelter.ui.theme.*

@Composable
fun FieldsSignOnView() {
    EditTextView (
        keyboardType = KeyboardType.Text,
        text = EditTextHints.NAME,
        hasImages = false,
        imeAction = ImeAction.Next,
        topOffset = FIRST_EDIT_TEXT_OFFSET,
    )

    EditTextView (
        keyboardType = KeyboardType.Email,
        text = EditTextHints.EMAIL,
        hasImages = false,
        imeAction = ImeAction.Next,
        topOffset = FIRST_EDIT_TEXT_OFFSET + OFFSET_BETWEEN_EDIT_TEXTS,
    )

    EditTextView (
        keyboardType = KeyboardType.Password,
        text = EditTextHints.PASSWORD,
        hasImages = true,
        imeAction = ImeAction.Next,
        topOffset = FIRST_EDIT_TEXT_OFFSET + 2* OFFSET_BETWEEN_EDIT_TEXTS,
    )
    EditTextView (
        keyboardType = KeyboardType.Password,
        text = EditTextHints.PASSWORD_AGAIN,
        hasImages = true,
        imeAction = ImeAction.Done,
        topOffset = FIRST_EDIT_TEXT_OFFSET + 3* OFFSET_BETWEEN_EDIT_TEXTS,
    )

    LoginButtonView(text = LoginButtonsTexts.SIGN_ON,
        paddingStart = LOGIN_BUTTON_PADDING_START_SIGN_ON,
        paddingEnd = LOGIN_BUTTON_PADDING_END_SIGN_ON)

    LoginLateButtonView()
}

@Composable
fun FieldsSignInView() {
    EditTextView (
        keyboardType = KeyboardType.Email,
        text = EditTextHints.EMAIL,
        hasImages = false,
        imeAction = ImeAction.Next,
        topOffset = FIRST_EDIT_TEXT_OFFSET,
    )

    EditTextView (
        keyboardType = KeyboardType.Password,
        text = EditTextHints.PASSWORD,
        hasImages = true,
        imeAction = ImeAction.Done,
        topOffset = FIRST_EDIT_TEXT_OFFSET + OFFSET_BETWEEN_EDIT_TEXTS,
    )

    LoginButtonView(text = LoginButtonsTexts.SIGN_IN,
        paddingStart = LOGIN_BUTTON_PADDING_START_SIGN_IN,
        paddingEnd = LOGIN_BUTTON_PADDING_END_SIGN_IN)

    ForgotPasswordButtonView()

    LoginLateButtonView()
}