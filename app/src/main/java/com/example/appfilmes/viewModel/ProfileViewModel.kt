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

