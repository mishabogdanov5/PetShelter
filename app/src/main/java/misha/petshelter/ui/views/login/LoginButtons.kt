package misha.petshelter.ui.views.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import misha.petshelter.R
import misha.petshelter.models.AppDestination
import misha.petshelter.ui.theme.*
import misha.petshelter.viewModels.LoginViewModel
import misha.petshelter.viewModels.RegisterViewModel

@Composable
fun LoginButtonView (text: String, paddingStart: Float, paddingEnd: Float,
                     passwordAgainState: MutableState<String> = mutableStateOf(""),
                     passwordState: MutableState<String> = mutableStateOf(""),
                     emailState: MutableState<String> = mutableStateOf(""),
                     nameState: MutableState<String> = mutableStateOf(""),
                     passwordBorderSize: MutableState<Float> = mutableStateOf(0f),
                     passwordBorderColor: MutableState<Color> = mutableStateOf(Color.Transparent),
                     passwordExceptionText: MutableState<String> = mutableStateOf(""),
                     nameBorderSize: MutableState<Float> = mutableStateOf(0f),
                     nameBorderColor: MutableState<Color> = mutableStateOf(Color.Transparent),
                     nameExceptionText: MutableState<String> = mutableStateOf(""),
                     emailBorderSize: MutableState<Float> = mutableStateOf(0f),
                     emailBorderColor: MutableState<Color> = mutableStateOf(Color.Transparent),
                     emailExceptionText: MutableState<String> = mutableStateOf(""),
                     passwordAgainBorderSize: MutableState<Float> = mutableStateOf(0f),
                     passwordAgainBorderColor: MutableState<Color> = mutableStateOf(Color.Transparent),
                     passwordAgainExceptionText: MutableState<String> = mutableStateOf(""),
                     viewModel: ViewModel,
                     )
{

    val errorMessage = when(viewModel) {
        is LoginViewModel -> viewModel.errorMessage.observeAsState() as MutableState<String?>
        is RegisterViewModel -> viewModel.errorMessage.observeAsState() as MutableState<String?>
        else -> remember { mutableStateOf("") }
    }

    Text(text = errorMessage.value!!,
        style = TextStyle (
            color = LoginExceptionColor,
            fontSize = 18.sp,
            fontFamily = Mulish,
            fontWeight = FontWeight.Normal),
        modifier = Modifier.padding(
            top = 12.dp,
            start = (LOGIN_BUTTON_PADDING_START_SIGN_IN + 30).dp,
            bottom = 10.dp
    ))

    Button( onClick = {
        var isCorrect = true

        if(viewModel is RegisterViewModel) {

            if(viewModel.isNameValid(nameState.value)) {
                nameBorderSize.value = 0f
                nameBorderColor.value = Color.Transparent
                nameExceptionText.value = ""
            } else {
                nameBorderSize.value = EXCEPTION_BORDER_SIZE
                nameBorderColor.value = LoginExceptionColor
                nameExceptionText.value = NAME_EXCEPTION
                isCorrect = false
            }

            if(viewModel.isEmailValid(emailState.value)) {
                emailBorderSize.value = 0f
                emailBorderColor.value = Color.Transparent
                emailExceptionText.value = ""
            } else {
                emailBorderSize.value = EXCEPTION_BORDER_SIZE
                emailBorderColor.value = LoginExceptionColor
                emailExceptionText.value = EMAIL_EXCEPTION
                isCorrect = false
            }

            if(viewModel.isPasswordValid(passwordState.value)) {
                passwordBorderSize.value = 0f
                passwordBorderColor.value = Color.Transparent
                passwordExceptionText.value = ""
            } else {
                passwordBorderSize.value = EXCEPTION_BORDER_SIZE
                passwordBorderColor.value = LoginExceptionColor
                passwordExceptionText.value = PASSWORD_EXCEPTION
                isCorrect = false
            }

            if(viewModel.isPasswordAgainValid(passwordAgainState.value, passwordState.value)) {
                passwordAgainBorderSize.value = 0f
                passwordAgainBorderColor.value = Color.Transparent
                passwordAgainExceptionText.value = ""
            } else {
                passwordAgainBorderSize.value = EXCEPTION_BORDER_SIZE
                passwordAgainBorderColor.value = LoginExceptionColor
                passwordAgainExceptionText.value = PASSWORD_AGAIN_EXCEPTION
                isCorrect = false
            }

            if(isCorrect) {
                viewModel.name.value = nameState.value
                viewModel.password.value = passwordState.value
                viewModel.email.value = emailState.value

                viewModel.tryRegister()
            }

        } else if(viewModel is LoginViewModel) {

            if(viewModel.isEmailValid(emailState.value)) {
                emailBorderSize.value = 0f
                emailBorderColor.value = Color.Transparent
                emailExceptionText.value = ""
            } else {
                emailBorderSize.value = EXCEPTION_BORDER_SIZE
                emailBorderColor.value = LoginExceptionColor
                emailExceptionText.value = EMAIL_EXCEPTION
                isCorrect = false
            }

            if(viewModel.isPasswordValid(passwordState.value)) {
                passwordBorderSize.value = 0f
                passwordBorderColor.value = Color.Transparent
                passwordExceptionText.value = ""
            } else {
                passwordBorderSize.value = EXCEPTION_BORDER_SIZE
                passwordBorderColor.value = LoginExceptionColor
                passwordExceptionText.value = PASSWORD_EXCEPTION
                isCorrect = false
            }

            if(isCorrect) {
                viewModel.email.value = emailState.value
                viewModel.password.value = passwordState.value

                viewModel.tryLogin()
            }

        }

    },

        shape = RoundedCornerShape(LOGIN_BUTTON_SHAPE.dp),
        modifier = Modifier
            .padding(
                top = LOGIN_BUTTON_PADDING_TOP.dp, bottom = LOGIN_BUTTON_PADDING_BOTTOM.dp,
                start = paddingStart.dp, end = paddingEnd.dp
            )
            .shadow(elevation = LOGIN_BUTTON_ELEVATION.dp),

        colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor)
    ) {
        Image(imageVector = ImageVector.vectorResource(id = R.drawable.union), 
            contentDescription = "union", modifier = Modifier.padding(
                start = LOGIN_BUTTON_IMAGE_PADDING_START.dp, 
                top = LOGIN_BUTTON_IMAGE_PADDING_VERTICAL.dp,
                bottom = LOGIN_BUTTON_IMAGE_PADDING_VERTICAL.dp
            )
        )
        
        Text(text = text,
            style = TextStyle(
                color = WhiteTextColor,
                fontFamily = Mulish,
                fontWeight = FontWeight.Medium,
                fontSize = LOGIN_BUTTON_TEXT_SIZE.sp
            ),
            modifier = Modifier
                .padding(
                    top = LOGIN_BUTTON_TEXT_PADDING_VERTICAL.dp,
                    bottom = LOGIN_BUTTON_TEXT_PADDING_VERTICAL.dp,
                    start = LOGIN_BUTTON_TEXT_PADDING_START.dp,
                    end = LOGIN_BUTTON_TEXT_PADDING_END.dp
                )
                .background(color = Color.Transparent)
        )
    }
}

@Composable
fun LoginLateButtonView() {

    val decoration = remember { mutableStateOf(TextDecoration.None) }

    Row(modifier = Modifier
        .padding(
            start = LOGIN_LATE_BUTTON_PADDING_HORIZONTAL.dp,
            end = LOGIN_LATE_BUTTON_PADDING_HORIZONTAL.dp,
            top = LOGIN_LATE_BUTTON_PADDING_TOP.dp
        )
        .clickable {
            decoration.value = TextDecoration.Underline
        }
    ) {
        Text(
            text = SIGN_LATE,
            style = TextStyle(
                color = BlackTextColor,
                fontSize = LOGIN_LATE_BUTTON_TEXT_SIZE.sp,
                fontFamily = Mulish,
                fontWeight = FontWeight.Medium,
                textDecoration = decoration.value
            ),

            modifier = Modifier
                .padding(
                    start = LOGIN_LATE_BUTTON_TEXT_PADDING_START.dp,
                    end = LOGIN_LATE_BUTTON_TEXT_PADDING_END.dp
                )
                .background(color = Color.Transparent)

        )

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_left_arrow),
            contentDescription = "left-arrow", modifier = Modifier.padding(
                end = LOGIN_LATE_BUTTON_IMAGE_PADDING_END.dp,
                top = LOGIN_LATE_BUTTON_IMAGE_PADDING_TOP.dp,
            )
        )
    }
}

@Composable
fun ForgotPasswordButtonView() {

    val decoration = remember { mutableStateOf(TextDecoration.None) }


    Text(text = FORGOT_PASSWORD,
        style = TextStyle (
            color = BlackTextColor,
            fontSize = FORGOT_PASSWORD_BUTTON_TEXT_SIZE.sp,
            fontFamily = Mulish,
            fontWeight = FontWeight.Medium,
            textDecoration = decoration.value
        ),

        modifier = Modifier
            .padding(
                top = FORGOT_PASSWORD_BUTTON_PADDING_TOP.dp,
                bottom = FORGOT_PASSWORD_BUTTON_PADDING_BOTTOM.dp,
                start = FORGOT_PASSWORD_BUTTON_PADDING_START.dp,
                end = FORGOT_PASSWORD_BUTTON_PADDING_END.dp
            )
            .clickable {
                decoration.value = TextDecoration.Underline
            }
    )
}