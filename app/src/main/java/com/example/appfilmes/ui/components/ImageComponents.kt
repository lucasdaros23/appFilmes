package com.example.appfilmes.ui.components

import android.graphics.drawable.Icon
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.appfilmes.R
import com.example.appfilmes.viewModel.LoginViewModel

@Composable
fun ImageBase(
    painter: Painter,
    contentDescription: String,
    size: Int
){
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = Modifier.size(size.dp)

        ,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ImageMovie(size: Int){
    ImageBase(
        painterResource(R.drawable.icon),
        "foto",
        size
    )
}

@Composable
fun ImageFromUrl(url: String) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = url,
            contentDescription = "Minha imagem da internet",
            modifier = Modifier.size(200.dp),
            contentScale = ContentScale.Crop

        )
    }
}
