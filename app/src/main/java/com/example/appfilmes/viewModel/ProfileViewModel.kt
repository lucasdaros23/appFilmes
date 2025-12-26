package com.example.appfilmes.viewModel

import android.R
import androidx.lifecycle.ViewModel
import com.example.appfilmes.data.model.FilmaAvaliado
import com.example.appfilmes.data.model.Usuario
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
        FilmaAvaliado("O Grande Hotel Budapeste", 5, R.drawable.ic_menu_report_image),
        FilmaAvaliado("Interstellar", 4, R.drawable.ic_menu_report_image),
    ))
    val filmesAvaliados: StateFlow<List<FilmaAvaliado>> = _filmesAvaliados
}

