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



        val screenState = viewModel.screenState.observeAsState() as MutableState<MainScreenStates>

        when(screenState.value) {

            MainScreenStates.ADVERTS ->

                Column(modifier = Modifier.fillMaxSize()) {
                    AdvertsView(viewModel = viewModel)
                    MainBottomBar(screenHeight = maxHeight, viewModel =  viewModel)
                }


            MainScreenStates.CREATE_ADVERTS ->
            Column(modifier = Modifier.fillMaxSize()) {
                CreateAdvertsView()
                MainBottomBar(screenHeight = maxHeight, viewModel =  viewModel)
            }


            else ->

            Column(modifier = Modifier.fillMaxSize()) {
                ProfileView(name = "Имя")
                MainBottomBar(screenHeight = maxHeight, viewModel = viewModel)
            }
        }


    }
}