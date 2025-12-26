package com.example.appfilmes.ui.telas

import TopBar
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appfilmes.data.model.FilmaAvaliado
import com.example.appfilmes.ui.containers.BottomBar
import com.example.appfilmes.viewModel.ProfileViewModel
import com.example.appfilmes.viewModel.RodapeViewModel

@Composable
fun ProfileScreen(name: String) {
    TopBar()
    Column(
        Modifier.fillMaxHeight()
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 2.dp
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Foto de Perfil",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
//                Image(
//                    painter = painterResource(id = R.drawable.avatar),
//                    contentDescription = "Foto de Perfil",
//                    modifier = Modifier
//                        .size(80.dp)
//                        .clip(CircleShape)
//                )
                    Surface(
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.BottomEnd),
                        color = Color(0xFF4CAF50),
                        shape = CircleShape,
                        border = BorderStroke(3.dp, MaterialTheme.colorScheme.surface)
                    ) {}
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Row(modifier = Modifier.padding(top = 4.dp)) {
                        Text(
                            text = "15 Reviews",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "22 Avaliações",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    val rodapeViewModel = RodapeViewModel()
    ProfileScreen(name = "Nomenastico da Silva")
}

@Composable
fun ProfileScreenView(viewModel: ProfileViewModel = viewModel(), navController: NavHostController, rodapeViewModel: RodapeViewModel
) {
    val usuario by viewModel.usuario.collectAsState()
    val filmes by viewModel.filmesAvaliados.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Perfil",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth()
            )
        }

        ProfileScreen(name = usuario.nome)


        Text(
            text = "Meus Reviews",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(filmes) { filme ->
                MovieCard(filme)
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        SettingsSection(onEditProfileClick = {
            viewModel.alternarUsuario()
        })
        Spacer(modifier = Modifier.height(44.dp))


        BottomBar(navController, rodapeViewModel)
    }
}

@Composable
fun SettingsSection(onEditProfileClick: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Configurações",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        SettingItem(
            icon = Icons.Default.Person,
            title = "Editar Perfil",
            onClick = onEditProfileClick
        )
    }
}

@Composable
fun SettingItem(icon: ImageVector, title: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = Color(0xFF6200EE))
        Text(
            text = title,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            color = MaterialTheme.colorScheme.onBackground
        )
        Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = Color.Gray)
    }
}

@Composable
fun MovieCard(filme: FilmaAvaliado) {
    Column(modifier = Modifier.width(160.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Gray)
        )
        Text(
            text = filme.titulo,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp),
            color = MaterialTheme.colorScheme.onBackground
        )
        Row {
            repeat(filme.nota) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color(0xFF2196F3),
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}