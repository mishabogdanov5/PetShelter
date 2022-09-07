@file:OptIn(ExperimentalCoilApi::class)

package misha.petshelter.ui.views.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import misha.petshelter.R
import misha.petshelter.models.PetInfo
import misha.petshelter.services.network.isConnected
import misha.petshelter.ui.theme.*
import misha.petshelter.viewModels.main.MainViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AdvertsView(viewModel: MainViewModel) {

    if(isConnected(LocalContext.current)) viewModel.getAllPets()

   // viewModel.getAllPets()

    val pets = viewModel.pets.observeAsState() as MutableState<List<PetInfo>>

    LazyVerticalGrid(

        modifier = Modifier.padding( top = 22.dp).fillMaxHeight(0.886f),

        cells = GridCells.Fixed(2),


        contentPadding = PaddingValues(
            start = 4.dp,
            end = 4.dp,
            top = 8.dp,

        ),

        content =  {
            items(pets.value.size) { index ->
                PetView(pet = pets.value[index])
            }
        }
    )
}


@Composable
fun PetView(pet: PetInfo) {
    Card (
        backgroundColor = Color.White,
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp, bottom = 10.dp)
            .height(280.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PetPhoto(url = pet.imageUrl)
            PetDescription(pet = pet)
        }

    }
}

@Composable
fun PetPhoto(url: String) {

    val painter = rememberImagePainter(data = url, builder = {
        crossfade(600)
    })

    Image(
        painter = painter, contentDescription = null,
        modifier = Modifier
            .width(168.dp)
            .height(168.dp)
            .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
            .background(color = ImageBackgroundColor)
    )

    if (painter.state is ImagePainter.State.Loading) CircularProgressIndicator(color = PrimaryColor)

}

@Composable
fun PetDescription(pet: PetInfo) {
    Column(modifier = Modifier
        .padding(
        top = 8.dp,
        start = 10.dp,
        end = 10.dp,
        bottom = 14.dp),
    ) {
        Text (
            text = pet.title, 
            
            style = TextStyle(
                color = BlackTextColor,
                fontSize = 16.sp,
                fontFamily = Mulish
            ),

            modifier = Modifier.padding(top = 4.dp)
        )
        
        Text(
            text = pet.description,

            style = TextStyle(
                color = BlackTextColor,
                fontSize = 12.sp,
                fontFamily = Mulish
            ),

            modifier = Modifier.padding(top = 4.dp)
        )

        Row(modifier = Modifier.padding(top = 4.dp, start = 3.5.dp)) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_location),
                contentDescription = null
            )

            Text(
                text = pet.position.latitude.toString() + pet.position.longitude.toString(),
                style = TextStyle(
                    color = GrayTextColor,
                    fontSize = 12.sp,
                    fontFamily = Mulish
                )
            )
        }

    }
}

@Composable
fun EmptyPetsList() {

}