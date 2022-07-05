package misha.petshelter.ui.views.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import misha.petshelter.ui.theme.*
import misha.petshelter.view_models.LoginViewModel
import misha.petshelter.view_models.RegisterViewModel

@Composable
fun SelectorView(viewModel: LoginViewModel, registerViewModel: RegisterViewModel) {
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
            .weight(1f, true)
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
                    .align(CenterHorizontally)
                    .padding(bottom = 20.dp)
            )

            Divider(color = PrimaryColor,
            thickness = if (isActive.value) SELECTOR_ACTIVE_SPACER_HEIGHT.dp
            else SELECTOR_INACTIVE_SPACER_HEIGHT.dp
            )
        }

        Column(modifier = Modifier
            .weight(1f, true)
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
                    .align(CenterHorizontally)
                    .padding(bottom = 20.dp)
            )

            Divider(color = PrimaryColor,
                thickness = if (!isActive.value) SELECTOR_ACTIVE_SPACER_HEIGHT.dp
                else SELECTOR_INACTIVE_SPACER_HEIGHT.dp
            )
        }
    }

    if (isActive.value) FieldsSignInView(viewModel)
    else FieldsSignOnView(registerViewModel)

}


