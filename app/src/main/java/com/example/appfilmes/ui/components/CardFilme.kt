package com.example.appfilmes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appfilmes.R
import com.example.appfilmes.data.model.Filme
import com.example.appfilmes.ui.theme.BlackTransparente

@Composable
fun FilmeCard(filme: Filme) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        ImageFromUrl(filme.Poster)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = BlackTransparente),
            verticalArrangement = Arrangement.Bottom,

            ) {
            Column(
                Modifier
                    .padding(horizontal = 16.dp, vertical = 12.dp)

            ) {

                Text(
                    text = filme.Title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Text(
                    text = filme.Year,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
                )

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF3B49DF))
                        .fillMaxWidth()
                        .height(38.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Ver Detalhes",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun FilmeCardPreview() {
    FilmeCard(
        Filme(
            Title = "oiiii",
            Year = "2024",
            Plot = "blablabla",
            Poster = "https://www.theguardian.com/science/2019/jun/17/how-dogs-capture-your-heart-evolution-puppy-dog-eyes"
        )
    )
}