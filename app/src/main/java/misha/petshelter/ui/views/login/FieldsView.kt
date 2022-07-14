package misha.petshelter.ui.views.login

import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import misha.petshelter.ui.theme.*
import misha.petshelter.view_models.LoginViewModel
import misha.petshelter.view_models.RegisterViewModel

@Composable
fun FieldsSignOnView(viewModel: RegisterViewModel) {

    val nameState = viewModel.name.observeAsState() as MutableState<String>
    val emailState = viewModel.email.observeAsState() as MutableState<String>
    val passwordState = viewModel.password.observeAsState() as MutableState<String>
    val passwordAgainState = viewModel.passwordAgain.observeAsState() as MutableState<String>

    val passwordAgainBorderSize = remember { mutableStateOf(0f) }
    val passwordAgainBorderColor = remember { mutableStateOf(Color.Transparent) }
    val passwordAgainExceptionText = remember { mutableStateOf("") }


    EditTextView (
        keyboardType = KeyboardType.Text,
        text = NAME,
        hasImages = false,
        imeAction = ImeAction.Next,
        topOffset = FIRST_EDIT_TEXT_OFFSET,
        message = nameState,
        isLogin = false,
        viewModel = viewModel
    )

    EditTextView (
        keyboardType = KeyboardType.Email,
        text = EMAIL,
        hasImages = false,
        imeAction = ImeAction.Next,
        topOffset = FIRST_EDIT_TEXT_OFFSET + OFFSET_BETWEEN_EDIT_TEXTS,
        message = emailState,
        isLogin = false,
        viewModel = viewModel
    )

    EditTextView (
        keyboardType = KeyboardType.Password,
        text = PASSWORD,
        hasImages = true,
        imeAction = ImeAction.Next,
        topOffset = FIRST_EDIT_TEXT_OFFSET + 2* OFFSET_BETWEEN_EDIT_TEXTS,
        message = passwordState,
        isLogin = false,
        viewModel = viewModel
    )
    EditTextView (
        keyboardType = KeyboardType.Password,
        text = PASSWORD_AGAIN,
        hasImages = true,
        imeAction = ImeAction.Done,
        topOffset = FIRST_EDIT_TEXT_OFFSET + 3* OFFSET_BETWEEN_EDIT_TEXTS,
        message = passwordAgainState,
        isLogin = false,
        passwordAgainBorderSize = passwordAgainBorderSize,
        passwordAgainBorderColor = passwordAgainBorderColor,
        passwordAgainExceptionText = passwordAgainExceptionText,
        viewModel = viewModel
    )

    LoginButtonView ( text = SIGN_ON_BUTTON,
        paddingStart = LOGIN_BUTTON_PADDING_START_SIGN_ON,
        paddingEnd = LOGIN_BUTTON_PADDING_END_SIGN_ON,
        passwordAgainState = passwordAgainState,
        passwordState = passwordState,
        passwordAgainBorderSize = passwordAgainBorderSize,
        passwordAgainBorderColor = passwordAgainBorderColor,
        passwordAgainExceptionText = passwordAgainExceptionText,
        viewModel= viewModel
    )

    LoginLateButtonView()
}

@Composable
fun FieldsSignInView(viewModel: LoginViewModel, result: String) {

    val emailState = viewModel.email.observeAsState() as MutableState<String>
    val passwordState = viewModel.password.observeAsState() as MutableState<String>

    EditTextView (
    keyboardType = KeyboardType.Email,
    text = EMAIL,
    hasImages = false,
    imeAction = ImeAction.Next,
    topOffset = FIRST_EDIT_TEXT_OFFSET,
    message = emailState,
    viewModel = viewModel
    )


    EditTextView (
        keyboardType = KeyboardType.Password,
        text = PASSWORD,
        hasImages = true,
        imeAction = ImeAction.Done,
        topOffset = FIRST_EDIT_TEXT_OFFSET + OFFSET_BETWEEN_EDIT_TEXTS,
        message = passwordState,
        viewModel = viewModel
    )


    LoginButtonView ( text = result,
        paddingStart = LOGIN_BUTTON_PADDING_START_SIGN_IN,
        paddingEnd = LOGIN_BUTTON_PADDING_END_SIGN_IN)

    ForgotPasswordButtonView()

    LoginLateButtonView()
}