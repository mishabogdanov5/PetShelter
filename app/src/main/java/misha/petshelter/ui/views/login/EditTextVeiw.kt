package misha.petshelter.ui.views.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import misha.petshelter.R
import misha.petshelter.domain.LoginValidation
import misha.petshelter.domain.RegisterValidation
import misha.petshelter.ui.theme.*


@Composable
fun EditTextView(keyboardType: KeyboardType, text: String,
                 hasImages: Boolean, imeAction: ImeAction, topOffset: Float,
                 message: MutableState<String> = mutableStateOf(""),
                 isLogin: Boolean = true,
                 passwordAgainBorderSize: MutableState<Float> = mutableStateOf(0f),
                 passwordAgainBorderColor: MutableState<Color> = mutableStateOf(Color.Transparent),
                 passwordAgainExceptionText: MutableState<String> = mutableStateOf("")
                    )
{

    val transformation = remember{ mutableStateOf(PasswordVisualTransformation() as VisualTransformation) }

    val keyboardFocus = LocalFocusManager.current

    val borderSizeState = remember { mutableStateOf(0f) }
    val borderColorState = remember { mutableStateOf(Color.Transparent) }
    val exceptionTextState = remember { mutableStateOf("") }

    val isPasswordValid = remember { mutableStateOf(false) }
    val isEmailValid = remember { mutableStateOf(false) }

    val isNameValid = remember { mutableStateOf(false) }
    val isEmailValidRegister = remember { mutableStateOf(false) }
    val isPasswordValidRegister = remember { mutableStateOf(false) }

    TextField(
        value = message.value,

        onValueChange = {
            message.value = it
            if(isLogin) {
                if(hasImages) isPasswordValid.value = LoginValidation().isPasswordValid(message.value)
                else isEmailValid.value = LoginValidation().isEmailValid(message.value)
            }

            if(!isLogin) {

                when (text) {
                    EditTextHints.PASSWORD -> isPasswordValidRegister.value = RegisterValidation()
                        .isPasswordValid(message.value)

                    EditTextHints.NAME -> isNameValid.value = RegisterValidation().isNameValid(message.value)

                    EditTextHints.EMAIL -> isEmailValidRegister.value = RegisterValidation()
                        .isEmailValid(message.value)

                }
            }

            borderSizeState.value = if(isLogin) {
                if(hasImages) {
                    if(isPasswordValid.value) 0f
                    else EXCEPTION_BORDER_SIZE
                } else {
                    if(isEmailValid.value) 0f
                    else EXCEPTION_BORDER_SIZE
                }
            } else {
                when (text) {
                    EditTextHints.PASSWORD -> if(isPasswordValidRegister.value) 0f else EXCEPTION_BORDER_SIZE

                    EditTextHints.NAME -> if(isNameValid.value) 0f else EXCEPTION_BORDER_SIZE

                    EditTextHints.EMAIL -> if(isEmailValidRegister.value) 0f else EXCEPTION_BORDER_SIZE

                    else -> 0f
                }
            }

            borderColorState.value = if (isLogin) {
                if(hasImages) {
                    if(isPasswordValid.value) Color.Transparent
                    else LoginExceptionColor
                } else {
                    if(isEmailValid.value) Color.Transparent
                    else LoginExceptionColor
                }
            } else {
                when (text) {
                    EditTextHints.PASSWORD -> if(isPasswordValidRegister.value) Color.Transparent
                    else LoginExceptionColor

                    EditTextHints.NAME -> if(isNameValid.value) Color.Transparent
                    else LoginExceptionColor

                    EditTextHints.EMAIL -> if(isEmailValidRegister.value) Color.Transparent
                    else LoginExceptionColor

                    else -> Color.Transparent
                }
            }

            exceptionTextState.value = if(isLogin) {
                if(hasImages) {
                    if(isPasswordValid.value) ""
                    else LoginExceptions.PASSWORD_EXCEPTION
                } else {
                    if(isEmailValid.value) ""
                    else LoginExceptions.EMAIL_EXCEPTION
                }
            } else {
                when (text) {
                    EditTextHints.PASSWORD -> if(isPasswordValidRegister.value) ""
                    else LoginExceptions.PASSWORD_EXCEPTION

                    EditTextHints.NAME -> if(isNameValid.value) ""
                    else RegisterExceptions.NAME_EXCEPTION

                    EditTextHints.EMAIL -> if(isEmailValidRegister.value) ""
                    else LoginExceptions.EMAIL_EXCEPTION

                    else -> ""
                }
            }

        },

        shape = RoundedCornerShape(EDIT_TEXT_SHAPE.dp),

        singleLine = true,

        modifier = Modifier
            .padding(top = 8.dp, start = 18.dp, end = 18.dp, bottom = 10.dp)
            .offset(y = topOffset.dp)
            .fillMaxWidth()
            .height(EDIT_TEXT_HEIGHT.dp)
            .border(
                width = if(text != EditTextHints.PASSWORD_AGAIN) borderSizeState.value.dp
            else passwordAgainBorderSize.value.dp,

                color = if(text != EditTextHints.PASSWORD_AGAIN) borderColorState.value
                else passwordAgainBorderColor.value,

                shape = RoundedCornerShape(EDIT_TEXT_SHAPE.dp))
            .background(Color.Transparent)
            .shadow(elevation = 10.dp, clip = true),

        placeholder = {
            Text (
                text = text,
                style = TextStyle(
                    color = HintColor,
                    fontSize = EDIT_TEXT_SIZE.sp,
                    fontFamily = Mulish,
                ),
            )
        },

        textStyle = TextStyle(
            color = EditTextColor,
            fontFamily = Mulish,
            fontSize = EDIT_TEXT_SIZE.sp
        ),

        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = EditTextColor
        ),

        trailingIcon = {
            val resState = remember{mutableStateOf(R.drawable.ic_visibility_off)}

            if(hasImages){
                    Icon(
                        imageVector = ImageVector.vectorResource(id =
                        resState.value),
                        contentDescription = "visibility_on",
                        tint = PrimaryColor,

                        modifier = Modifier.clickable {

                            if(resState.value == R.drawable.ic_visibility_off){
                                resState.value = R.drawable.ic_visibility_on
                                transformation.value = VisualTransformation.None
                            } else {
                                resState.value = R.drawable.ic_visibility_off
                                transformation.value = PasswordVisualTransformation()
                            }
                        }
                    )
                }
            },

        visualTransformation = if(hasImages) transformation.value else VisualTransformation.None,

        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),

        keyboardActions = KeyboardActions(
            onAny = {
                keyboardFocus.clearFocus()
            }
        ),
    )

    Text( if(text != EditTextHints.PASSWORD_AGAIN)exceptionTextState.value
        else passwordAgainExceptionText.value,

        style = TextStyle (
            color = LoginExceptionColor,
            fontSize = LOGIN_EXCEPTION_TEXT_SIZE.sp,
            fontFamily = Mulish,
            fontWeight = FontWeight.Normal
        ),
        modifier = Modifier.padding(start = 22.dp, top = 8.dp)
    )
} // что то по типу нужного!
