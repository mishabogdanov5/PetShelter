package misha.petshelter.ui.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import misha.petshelter.ui.theme.*
import misha.petshelter.viewModels.main.MainViewModel

@Composable
fun MainBottomBar(screenHeight: Dp, viewModel: MainViewModel) {
    Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.fillMaxHeight()) {

        val profilePictIdState = viewModel.profilePictId.observeAsState() as MutableState<Int>
        val addPictIdState = viewModel.addPictId.observeAsState() as MutableState<Int>
        val unionPictIdState = viewModel.unionPictId.observeAsState() as MutableState<Int>

        val advertFontWeight = remember { mutableStateOf(FontWeight.SemiBold) }
        val addFontWeight = remember { mutableStateOf(FontWeight.Light) }
        val profileFontWeight = remember { mutableStateOf(FontWeight.Light) }
        BottomAppBar(modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight.times(BOTTOM_BAR_HEIGHT)),
            backgroundColor = PrimaryColor)
        {
            Column(modifier = Modifier
                .weight(1f)
                .background(color = Color.Transparent),
                horizontalAlignment = Alignment.CenterHorizontally) {

                IconButton(
                    onClick = {
                        viewModel.switchUnionPict()
                        advertFontWeight.value = FontWeight.SemiBold
                    },
                    modifier = Modifier.background(color = Color.Transparent),
                ) {
                    Icon(imageVector = ImageVector.vectorResource(id = unionPictIdState.value),
                        contentDescription = ADVERTS, tint = WhiteTextColor)
                }

                Text(text = ADVERTS, style = TextStyle (color = WhiteTextColor,
                    fontSize = BOTTOM_BAR_TEXT_SIZE.sp,
                    fontFamily = Mulish,
                    fontWeight = advertFontWeight.value), modifier = Modifier
                    .padding(top = BOTTOM_BAR_TEXT_PADDING_TOP.dp)
                )
            }

            Column(modifier = Modifier
                .weight(1f)
                .background(color = Color.Transparent),
                horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(
                    onClick = {
                        viewModel.switchAddPict()
                        addFontWeight.value = FontWeight.SemiBold
                    }
                ){
                    Icon(imageVector = ImageVector.vectorResource(id = addPictIdState.value),
                    contentDescription = CREATE_ADVERT, tint = WhiteTextColor,)
                }
                
                Text(text = CREATE_ADVERT, style = TextStyle(
                    color = WhiteTextColor,
                    fontSize = BOTTOM_BAR_TEXT_SIZE.sp,
                    fontFamily = Mulish,
                    fontWeight = addFontWeight.value
                ), modifier = Modifier.padding(top = BOTTOM_BAR_TEXT_PADDING_TOP.dp))
            }

            Column(modifier = Modifier
                .weight(1f)
                .background(color = Color.Transparent),
                horizontalAlignment = Alignment.CenterHorizontally) {

                IconButton(
                    onClick = {
                        viewModel.switchProfilePict()
                        profileFontWeight.value = FontWeight.SemiBold
                    }
                ) {
                    Icon(imageVector = ImageVector.vectorResource(id = profilePictIdState.value),
                        contentDescription = PROFILE, tint = WhiteTextColor)
                }

                Text(text = PROFILE, style = TextStyle(
                    color = WhiteTextColor,
                    fontSize = BOTTOM_BAR_TEXT_SIZE.sp,
                    fontFamily = Mulish,
                    fontWeight = profileFontWeight.value
                ), modifier = Modifier.padding(top = BOTTOM_BAR_TEXT_PADDING_TOP.dp))
            }
        }
    }

}