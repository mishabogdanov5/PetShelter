package misha.petshelter.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import misha.petshelter.ui.theme.*

@Composable
fun SelectorView() {
    val isActive = remember { mutableStateOf(true) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(
                top = SELECTOR_VERTICAL_PADDING.dp, bottom = SELECTOR_VERTICAL_PADDING.dp,
                start = SELECTOR_HORIZONTAL_PADDING.dp, end = SELECTOR_HORIZONTAL_PADDING.dp
            )
    ) {

        Column(modifier = Modifier
            .fillMaxWidth(0.5f)
            .clickable {
                isActive.value = true
            }
        ) {
            Text(
                text = SelectorTexts.SIGN_IN,
                style = TextStyle(
                    color = BlackTextColor,
                    fontSize = SELECTOR_TEXT_SIZE.sp,
                    fontFamily = Mulish,
                    fontWeight = FontWeight.SemiBold
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.background(color = Color.Transparent)
            )

            Spacer(
                modifier = Modifier
                    .background(color = PrimaryColor)
                    .height(if (isActive.value) SELECTOR_ACTIVE_SPACER_HEIGHT.dp else SELECTOR_INACTIVE_SPACER_HEIGHT.dp)
            )
        }

        Column(modifier = Modifier
            .fillMaxWidth(0.5f)
            .clickable {
                isActive.value = false
            }
        ) {

            Text(
                text = SelectorTexts.SIGN_ON,
                style = TextStyle(
                    color = BlackTextColor,
                    fontSize = SELECTOR_TEXT_SIZE.sp,
                    fontFamily = Mulish,
                    fontWeight = FontWeight.SemiBold
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.background(color = Color.Transparent)
            )

            Spacer(
                modifier = Modifier
                    .background(color = PrimaryColor)
                    .height(if (!isActive.value) SELECTOR_ACTIVE_SPACER_HEIGHT.dp else SELECTOR_INACTIVE_SPACER_HEIGHT.dp)
            )

        }
    }

    if (isActive.value) FieldsSignInView()
    else FieldsSignOnView()

}


