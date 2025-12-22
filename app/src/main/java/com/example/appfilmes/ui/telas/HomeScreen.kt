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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.appfilmes.ui.components.Filme
import com.example.appfilmes.ui.components.FilmeCard
import com.example.appfilmes.ui.theme.AppFilmesTheme

@Composable
fun HomeScreen() {
    val filmes = listOf(
        Filme(
            "A Queda do Império",
            "Um épico histórico que narra a ascensão e queda de um poderoso império."
        ),
    )

    val filmesEmAlta = listOf(
        Filme("Viajantes do Tempo", "Uma jornada no tempo repleta de mistérios."),
        Filme("Cidade Oculta", "Um futuro sombrio e cheio de segredos."),
        Filme("A Lenda Perdida", "A busca por uma civilização perdida."),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF000000))
    ) {
        TopBar()

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 20.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Lista de cards principais
            items(filmes) { filme ->
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
                    items(filmesEmAlta) { filme ->
                        FilmeCarouselCard(filme)
                    }
                }
            }

            item { Spacer(Modifier.height(20.dp)) }
        }

        BottomBar()
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(start = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(Color.White)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 3.dp),
                painter = painterResource(id = R.drawable.image_removebg_preview),
                contentDescription = "Logo"
            )
        }

        Spacer(Modifier.width(10.dp))

        Text(
            text = "CineCritica",
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(Modifier.width(140.dp))

        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "Buscar",
            tint = Color.White,
            modifier = Modifier.size(28.dp)
        )
    }
}

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    var itemSelecionado by remember { mutableStateOf(0) }
    NavigationBar(
        containerColor = Color(0xFF111111)
    ) {
        val items = listOf("Inicio", "Filmes", "Perfil")
        val icons = listOf(
            Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Person
        )

        // ✅ Corrige o loop para incluir o índice e o item corretamente
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = itemSelecionado == index,
                onClick = { itemSelecionado = index },
                icon = {
                    Icon(
                        imageVector = icons[index], contentDescription = item
                    )
                },
                label = { Text(item) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF3B49DF),
                    selectedTextColor = Color(0xFF3B49DF),
                    unselectedIconColor = Color.White,
                    unselectedTextColor = Color.White,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(modifier: Modifier = Modifier) {
    AppFilmesTheme() {
        HomeScreen()
    }
}