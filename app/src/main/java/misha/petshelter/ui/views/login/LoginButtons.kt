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
import misha.petshelter.ui.theme.*
import misha.petshelter.view_models.RegisterViewModel

@Composable
fun LoginButtonView (text: String, paddingStart: Float, paddingEnd: Float,
                     passwordAgainState: MutableState<String> = mutableStateOf(""),
                     passwordState: MutableState<String> = mutableStateOf(""),
                     passwordAgainBorderSize: MutableState<Float> = mutableStateOf(0f),
                     passwordAgainBorderColor: MutableState<Color> = mutableStateOf(Color.Transparent),
                     passwordAgainExceptionText: MutableState<String> = mutableStateOf(""),
                     viewModel: ViewModel? = null)
{
    Button( onClick = {
        if(viewModel != null) {
            val model = viewModel as RegisterViewModel

            if(model.isPasswordAgainValid(passwordAgainState.value, passwordState.value)) {
                passwordAgainBorderSize.value = 0f
                passwordAgainBorderColor.value = Color.Transparent
                passwordAgainExceptionText.value = ""
            } else {
                passwordAgainBorderSize.value = EXCEPTION_BORDER_SIZE
                passwordAgainBorderColor.value = LoginExceptionColor
                passwordAgainExceptionText.value = PASSWORD_AGAIN_EXCEPTION
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

        modifier = Modifier.padding (
            top = FORGOT_PASSWORD_BUTTON_PADDING_TOP.dp,
            bottom = FORGOT_PASSWORD_BUTTON_PADDING_BOTTOM.dp,
            start = FORGOT_PASSWORD_BUTTON_PADDING_START.dp,
            end = FORGOT_PASSWORD_BUTTON_PADDING_END.dp
        ).clickable {
            decoration.value = TextDecoration.Underline
        }
    )
}