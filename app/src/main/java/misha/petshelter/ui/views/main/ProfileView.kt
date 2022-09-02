package misha.petshelter.ui.views.main

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp

@Composable
fun ProfileView() {
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    var bitmap by remember {
        mutableStateOf<Bitmap?>(null)
    }
    
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()) {
        imageUri = it
    }

    Column {
        Button(onClick = {
            launcher.launch("image/*")
        }) {
            Text(text = "Pick image")
        }

        Spacer(modifier = Modifier.height(24.dp))

        imageUri?.let {
            if(Build.VERSION.SDK_INT < 28) {

                bitmap = MediaStore.Images.Media.getBitmap(LocalContext.current.contentResolver, it)
            } else {

                val source = ImageDecoder.createSource(LocalContext.current.contentResolver, it)
                bitmap = ImageDecoder.decodeBitmap(source)
            }
        }

        bitmap?.let {
            Image(bitmap = it.asImageBitmap(), contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .width(200.dp)
            )
        }
    }
}