package com.example.appfilmes.viewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items // Import fundamental para listas
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.appfilmes.model.FilmaAvaliado
import com.example.appfilmes.model.Usuario
import com.example.appfilmes.ui.telas.ProfileScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class ProfileViewModel : ViewModel() {
    private val _usuario = MutableStateFlow(Usuario("Nomenastico da Silva", 15, 22))
    val usuario: StateFlow<Usuario> = _usuario

    fun alternarUsuario() {
        if (_usuario.value.nome == "Gustavo Santos") {
            _usuario.value = Usuario("Juliana Silva", 12, 45)
        } else {
            _usuario.value = Usuario("Gustavo Santos", 8, 30)
        }
    }

    private val _filmesAvaliados = MutableStateFlow(listOf(
        FilmaAvaliado("O Grande Hotel Budapeste", 5, android.R.drawable.ic_menu_report_image),
        FilmaAvaliado("Interstellar", 4, android.R.drawable.ic_menu_report_image),
    ))
    val filmesAvaliados: StateFlow<List<FilmaAvaliado>> = _filmesAvaliados
}

@Preview
@Composable
fun ProfileScreenView(viewModel: ProfileViewModel = viewModel()){
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

        val navController = rememberNavController()
        val rodapeViewModel = RodapeViewModel()
        ProfileScreen(name = usuario.nome, navController, rodapeViewModel)


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
            .clickable{ onClick() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = Color(0xFF6200EE))
        Text(
            text = title,
            modifier = Modifier.weight(1f).padding(start = 16.dp),
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