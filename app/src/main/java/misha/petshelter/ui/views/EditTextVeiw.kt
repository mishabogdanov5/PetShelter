package misha.petshelter.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import misha.petshelter.ui.theme.SELECTOR_HEIGHT_TIME


@Composable
fun EditTextView(){
    val message = remember {mutableStateOf("")}

    TextField ( value = message.value,
        onValueChange = {text -> message.value = text},
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(elevation = 10.dp)
            .border(width = 0.dp, color = Color.LightGray),

        placeholder = {
            Text (text = "E-mail",
                style = TextStyle (
                    color = Color.Gray,
                    fontSize = 18.sp,
                )
            ) },

        textStyle = TextStyle(color = Color.Black,
            fontFamily = FontFamily.Serif, fontSize = 20.sp),

        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Black
        )
    )
} // что то по типу нужного textfield!

@Preview(showBackground = true)
@Composable
fun EditTextPreview(){
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        EditTextView()
    }

}