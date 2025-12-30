package com.example.appfilmes.ui.telas

import FilmeCarouselCard
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appfilmes.R
import com.example.appfilmes.data.model.Filme
import com.example.appfilmes.ui.components.FilmeCard
import com.example.appfilmes.ui.containers.BottomBar
import com.example.appfilmes.ui.containers.TopBar
import com.example.appfilmes.ui.theme.AppFilmesTheme
import com.example.appfilmes.viewModel.FilmesViewModel
import com.example.appfilmes.viewModel.RodapeViewModel


@Composable
fun HomeScreen(
    navController: NavHostController,
    rodapeViewModel: RodapeViewModel,
    filmesViewModel: FilmesViewModel
) {


    val filmes = filmesViewModel.filmes.value
    val filmesEmAlta = filmesViewModel.filmesEmAlta.value
x
    LaunchedEffect(Unit) {
        filmesViewModel.carregarFilmes()
        filmesViewModel.carregarFilmesEmAlta()
    }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF000000))
    ) {
        TopBar()
        if (filmes.isEmpty() && filmesEmAlta.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Carregando...", color = Color.White)

            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Lista de cards principais
                items(items = filmes) { filme ->
                    FilmeCard(filme)
                }

                // Espaço entre seções
                item { Spacer(Modifier.height(30.dp)) }

                // Título "Em Alta"
                item {
                    Text(
                        text = "Em Alta",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
                    )
                }

                // Carrossel horizontal
                item {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(items = filmesEmAlta) { filme ->
                            FilmeCarouselCard(filme)
                        }
                    }
                }

                item { Spacer(Modifier.height(20.dp)) }
            }
        }
        BottomBar(navController, rodapeViewModel)
    }
}




/*
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(modifier: Modifier = Modifier) {
    AppFilmesTheme() {
        val navController = rememberNavController()
        val rodapeViewModel = RodapeViewModel()
        HomeScreen(navController, rodapeViewModel)
    }
}

 */