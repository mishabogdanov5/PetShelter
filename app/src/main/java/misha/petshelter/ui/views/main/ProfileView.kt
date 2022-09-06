package misha.petshelter.ui.views.main

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import misha.petshelter.R
import misha.petshelter.ui.theme.BlackTextColor
import misha.petshelter.ui.theme.Mulish
import misha.petshelter.ui.theme.PROFILE_IMAGE_SIZE
import misha.petshelter.ui.theme.PrimaryColor

@Composable
fun ProfileView(name: String) {
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val currentContext = LocalContext.current

    val bitmap = remember {
        mutableStateOf<Bitmap?>(null)
    }

    
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()) {
        imageUri = it
    }

    Column {

        TopAppBar(backgroundColor = PrimaryColor,
            modifier = Modifier.padding(bottom = 48.dp))
        {

            Image (imageVector = Icons.Default.Create,
                contentDescription = null,
                modifier = Modifier.padding(start = 380.dp)
            )

        }


        Image(
            bitmap = getBitmapFromVectorDrawable(currentContext, R.drawable.ic_profile_default_photo)
                .asImageBitmap(),

            contentDescription = null,

            modifier = Modifier
                .height(PROFILE_IMAGE_SIZE.dp)
                .width(PROFILE_IMAGE_SIZE.dp)
                .clip(RoundedCornerShape(PROFILE_IMAGE_SIZE.dp))
                .clickable {
                    launcher.launch("image/*")
                }
                .padding(start = 96.dp, end = 96.dp, bottom = 40.dp),

            contentScale = ContentScale.Crop,
        )



        Text(text = name, style = TextStyle (
            fontSize = 24.sp,
            color = BlackTextColor,
            fontFamily = Mulish,
            textAlign = TextAlign.Center
            ),

            modifier = Modifier
                .padding(bottom = 168.5.dp, start = 16.dp, end = 16.dp)
                .align(Alignment.CenterHorizontally)
        )
        
        Text(text = "Изменить пароль", style = TextStyle(
            fontSize = 16.sp,
            color = BlackTextColor,
            fontFamily = Mulish,
            textAlign = TextAlign.Center
            ),

            modifier = Modifier.padding(start = 120.dp, end = 121.dp, bottom = 53.5.dp)
        )

        Row(modifier = Modifier.padding(start = 154.dp)) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_leave_account), 
                contentDescription = null,
                modifier = Modifier.padding(end = 11.dp)
            )

            Text(text = "Выйти", style = TextStyle(
                color = BlackTextColor,
                fontSize = 16.sp,
                fontFamily = Mulish
            )
            )
        }

    }

    imageUri?.let {
        bitmap.value = if(Build.VERSION.SDK_INT < 28) {

            MediaStore.Images.Media.getBitmap(currentContext.contentResolver, it)
        } else {

            val source = ImageDecoder.createSource(currentContext.contentResolver, it)
            ImageDecoder.decodeBitmap(source)
        }
    }
}

private fun getBitmapFromVectorDrawable(context: Context, drawableId: Int): Bitmap {
    val drawable = ContextCompat.getDrawable(context, drawableId)
    val bitmap = Bitmap.createBitmap(
        drawable!!.intrinsicWidth,
        drawable.intrinsicHeight, Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(bitmap)
    drawable.setBounds(0, 0, canvas.width, canvas.height)
    drawable.draw(canvas)
    return bitmap
}