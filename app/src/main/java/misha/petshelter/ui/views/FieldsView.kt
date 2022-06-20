package misha.petshelter.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import misha.petshelter.ui.theme.EditTextHints
import misha.petshelter.ui.theme.FIRST_EDIT_TEXT_OFFSET
import misha.petshelter.ui.theme.OFFSET_BETWEEN_EDIT_TEXTS

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
}