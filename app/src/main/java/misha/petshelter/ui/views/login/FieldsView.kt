package misha.petshelter.ui.views.login

import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import misha.petshelter.ui.theme.*
import misha.petshelter.viewModels.login.LoginViewModel
import misha.petshelter.viewModels.login.RegisterViewModel

@Composable
fun FieldsSignOnView(viewModel: RegisterViewModel) {

    val nameState = viewModel.name.observeAsState() as MutableState<String>
    val emailState = viewModel.email.observeAsState() as MutableState<String>
    val passwordState = viewModel.password.observeAsState() as MutableState<String>
    val passwordAgainState = remember { mutableStateOf("") }

    val nameBorderSize = remember { mutableStateOf(0f) }
    val nameBorderColor = remember { mutableStateOf(Color.Transparent) }
    val nameExceptionText = remember { mutableStateOf("") }

    val emailBorderSize = remember { mutableStateOf(0f) }
    val emailBorderColor = remember { mutableStateOf(Color.Transparent) }
    val emailExceptionText = remember { mutableStateOf("") }

    val passwordBorderSize = remember { mutableStateOf(0f) }
    val passwordBorderColor = remember { mutableStateOf(Color.Transparent) }
    val passwordExceptionText = remember { mutableStateOf("") }

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
        borderSize = nameBorderSize,
        borderColor = nameBorderColor,
        exceptionText = nameExceptionText
    )

    EditTextView (
        keyboardType = KeyboardType.Email,
        text = EMAIL,
        hasImages = false,
        imeAction = ImeAction.Next,
        topOffset = FIRST_EDIT_TEXT_OFFSET + OFFSET_BETWEEN_EDIT_TEXTS,
        message = emailState,
        borderSize = emailBorderSize,
        borderColor = emailBorderColor,
        exceptionText = emailExceptionText
    )

    EditTextView (
        keyboardType = KeyboardType.Password,
        text = PASSWORD,
        hasImages = true,
        imeAction = ImeAction.Next,
        topOffset = FIRST_EDIT_TEXT_OFFSET + 2* OFFSET_BETWEEN_EDIT_TEXTS,
        message = passwordState,
        borderSize = passwordBorderSize,
        borderColor = passwordBorderColor,
        exceptionText = passwordExceptionText
    )
    EditTextView (
        keyboardType = KeyboardType.Password,
        text = PASSWORD_AGAIN,
        hasImages = true,
        imeAction = ImeAction.Done,
        topOffset = FIRST_EDIT_TEXT_OFFSET + 3* OFFSET_BETWEEN_EDIT_TEXTS,
        message = passwordAgainState,
        borderSize = passwordAgainBorderSize,
        borderColor = passwordAgainBorderColor,
        exceptionText = passwordAgainExceptionText
    )

    LoginButtonView ( text = SIGN_ON_BUTTON,
        paddingStart = LOGIN_BUTTON_PADDING_START_SIGN_ON,
        paddingEnd = LOGIN_BUTTON_PADDING_END_SIGN_ON,
        nameState = nameState,
        emailState = emailState,
        passwordState = passwordState,
        passwordAgainState = passwordAgainState,
        nameBorderSize = nameBorderSize,
        nameBorderColor = nameBorderColor,
        nameExceptionText = nameExceptionText,
        emailBorderSize = emailBorderSize,
        emailBorderColor = emailBorderColor,
        emailExceptionText = emailExceptionText,
        passwordBorderSize = passwordBorderSize,
        passwordBorderColor = passwordBorderColor,
        passwordExceptionText = passwordExceptionText,
        passwordAgainBorderSize = passwordAgainBorderSize,
        passwordAgainBorderColor = passwordAgainBorderColor,
        passwordAgainExceptionText = passwordAgainExceptionText,
        viewModel= viewModel
    )

    LoginLateButtonView()
}

@Composable
fun FieldsSignInView(viewModel: LoginViewModel) {

    val emailState = viewModel.email.observeAsState() as MutableState<String>
    val passwordState = viewModel.password.observeAsState() as MutableState<String>

    val emailBorderSize = remember { mutableStateOf(0f) }
    val emailBorderColor = remember { mutableStateOf(Color.Transparent) }
    val emailExceptionText = remember { mutableStateOf("") }

    val passwordBorderSize = remember { mutableStateOf(0f) }
    val passwordBorderColor = remember { mutableStateOf(Color.Transparent) }
    val passwordExceptionText = remember { mutableStateOf("") }

    EditTextView (
        keyboardType = KeyboardType.Email,
        text = EMAIL,
        hasImages = false,
        imeAction = ImeAction.Next,
        topOffset = FIRST_EDIT_TEXT_OFFSET,
        message = emailState,
        borderSize = emailBorderSize,
        borderColor = emailBorderColor,
        exceptionText = emailExceptionText
    )

    EditTextView (
        keyboardType = KeyboardType.Password,
        text = PASSWORD,
        hasImages = true,
        imeAction = ImeAction.Done,
        topOffset = FIRST_EDIT_TEXT_OFFSET + OFFSET_BETWEEN_EDIT_TEXTS,
        message = passwordState,
        borderSize = passwordBorderSize,
        borderColor = passwordBorderColor,
        exceptionText = passwordExceptionText
    )


    LoginButtonView ( text = SIGN_IN_BUTTON,
        paddingStart = LOGIN_BUTTON_PADDING_START_SIGN_IN,
        paddingEnd = LOGIN_BUTTON_PADDING_END_SIGN_IN,
        viewModel = viewModel,
        emailState = emailState,
        passwordState = passwordState,
        emailBorderSize = emailBorderSize,
        emailBorderColor = emailBorderColor,
        emailExceptionText = emailExceptionText,
        passwordBorderSize = passwordBorderSize,
        passwordBorderColor = passwordBorderColor,
        passwordExceptionText = passwordExceptionText,
    )

    ForgotPasswordButtonView()

    LoginLateButtonView()
}