package misha.petshelter.ui.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import misha.petshelter.viewModels.main.MainViewModel

@Composable
fun MainView(viewModel: MainViewModel) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()
        .background(color = Color.White)) {
        MainBottomBar(screenHeight = maxHeight, viewModel =  viewModel)
    }
}