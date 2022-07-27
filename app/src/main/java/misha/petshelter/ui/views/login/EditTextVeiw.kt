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
import misha.petshelter.ui.theme.*

@Composable
fun EditTextView(keyboardType: KeyboardType, text: String,
                 hasImages: Boolean, imeAction: ImeAction, topOffset: Float,
                 message: MutableState<String> = mutableStateOf(""),
                 borderSize: MutableState<Float> = mutableStateOf(0f),
                 borderColor: MutableState<Color> = mutableStateOf(Color.Transparent),
                 exceptionText: MutableState<String> = mutableStateOf(""),
                    )
{

    val transformation = remember{ mutableStateOf(PasswordVisualTransformation() as VisualTransformation) }

    val keyboardFocus = LocalFocusManager.current


    TextField(

        value = message.value,

        onValueChange = {
            message.value = it
        },

        shape = RoundedCornerShape(EDIT_TEXT_SHAPE.dp),

        singleLine = true,

        modifier = Modifier
            .padding(top = 8.dp, start = 18.dp, end = 18.dp, bottom = 10.dp)
            .offset(y = topOffset.dp)
            .fillMaxWidth()
            .height(EDIT_TEXT_HEIGHT.dp)
            .border(
                width = borderSize.value.dp,
                color = borderColor.value,
                shape = RoundedCornerShape(EDIT_TEXT_SHAPE.dp)
            )

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

    Text( text = exceptionText.value,

        style = TextStyle (
            color = LoginExceptionColor,
            fontSize = LOGIN_EXCEPTION_TEXT_SIZE.sp,
            fontFamily = Mulish,
            fontWeight = FontWeight.Normal
        ),
        modifier = Modifier.padding(start = EXCEPTION_TEXT_PADDING_START.dp,
            top = EXCEPTION_TEXT_PADDING_TOP.dp)
    )
} // что то по типу нужного!
