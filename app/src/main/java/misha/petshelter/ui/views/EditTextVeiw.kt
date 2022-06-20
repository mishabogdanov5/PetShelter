package misha.petshelter.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
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
                 hasImages: Boolean, imeAction: ImeAction, topOffset: Float) {

    val message = remember {mutableStateOf("")}

    val transformation = remember{mutableStateOf(PasswordVisualTransformation() as VisualTransformation)}

    TextField(
        value = message.value,
        onValueChange = { message.value = it },

        shape = RoundedCornerShape(EDIT_TEXT_SHAPE.dp),

        singleLine = hasImages,

        modifier = Modifier
            .padding(18.dp)
            .offset(y = topOffset.dp)
            .fillMaxWidth()
            .height(EDIT_TEXT_HEIGHT.dp)
            .border(width = 0.dp, color = Color.Transparent)
            .background(Color.Transparent)
            .shadow(elevation = 10.dp, clip = true),

        placeholder = {
            Text(
                text = text,
                style = TextStyle(
                    color = HintColor,
                    fontSize = EDIT_TEXT_SIZE.sp,
                    fontFamily = Mulish
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

            }
        ),
    )
} // что то по типу нужного!
