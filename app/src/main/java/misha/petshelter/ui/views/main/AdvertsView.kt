@file:OptIn(ExperimentalCoilApi::class)

package misha.petshelter.ui.views.main

import android.content.Context
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import misha.petshelter.R
import misha.petshelter.models.PetInfo
import misha.petshelter.services.network.isConnected
import misha.petshelter.viewModels.main.MainViewModel

@Composable
fun AdvertsView(viewModel: MainViewModel) {

    if(isConnected(LocalContext.current)) viewModel.getAllPets()

   // viewModel.getAllPets()

    val pets = viewModel.pets.observeAsState() as MutableState<List<PetInfo>>

    LazyColumn {

        items(pets.value) {
            PetView(pet = it)
        }
    }
}

@Composable
fun PetView(pet: PetInfo) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        PetPhoto(url = pet.imageUrl)
        Text(text = pet.type)
    }
}

@Composable
fun PetPhoto(url: String) {

   val painter = rememberImagePainter(data = url, builder = {
       crossfade(600)
        error(R.drawable.ic_add)
    })

    Image(painter = painter, contentDescription = null,
        modifier = Modifier.width(100.dp).height(100.dp))

    if(painter.state is ImagePainter.State.Loading) CircularProgressIndicator()

   //if(painter.state is ImagePainter.State.Empty) Text(text = url)
    


    //print(url)
}

@Composable
fun A (viewModel: MainViewModel) {

    viewModel.getAllPets()


    val pets = viewModel.pets.observeAsState() as MutableState<List<PetInfo>>

    if(pets.value.isNotEmpty()) {

        Box(modifier = Modifier.fillMaxSize()) {
            val painter = rememberImagePainter(data = pets.value[0].imageUrl)

            Image(painter = painter, contentDescription = null)

            if(painter.state is ImagePainter.State.Empty) Text(text = pets.value[0].imageUrl)
        }

    }

}