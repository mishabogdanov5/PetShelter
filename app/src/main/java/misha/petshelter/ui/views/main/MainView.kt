package misha.petshelter.ui.views.main


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import misha.petshelter.models.MainScreenStates
import misha.petshelter.viewModels.main.MainViewModel

@Composable
fun MainView(viewModel: MainViewModel) {
    BoxWithConstraints(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {

        val maxHeight = maxHeight

        Column {

            val screenState = viewModel.screenState.observeAsState() as MutableState<MainScreenStates>

            when(screenState.value) {
                MainScreenStates.ADVERTS -> AdvertsView(viewModel = viewModel)
                MainScreenStates.CREATE_ADVERTS -> CreateAdvertsView()
                else -> ProfileView("Имя")
            }

            MainBottomBar(screenHeight = maxHeight, viewModel =  viewModel)
        }


    }
}