package com.example.appfilmes.viewModel

import android.R
import androidx.lifecycle.ViewModel
import com.example.appfilmes.data.model.FilmaAvaliado
import com.example.appfilmes.data.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class ProfileViewModel : ViewModel() {
    private val _usuario = MutableStateFlow(User("Nomenastico da Silva", "nome@gmail.com", "senha123", reviewsCount = 8, avaliacoesCount = 12 ))
    val usuario: StateFlow<User> = _usuario

    fun alternarUsuario() {
        if (_usuario.value.nome == "Gustavo Santos") {
            _usuario.value = User("Juliana Silva", "juliana@gmail.com", "juliana123", reviewsCount = 15, avaliacoesCount = 24)
        } else {
            _usuario.value = User("Gustavo Santos", "gustavo@gmail.com", "gustavo123", reviewsCount = 28, avaliacoesCount = 31)
        }
    }

    private val _filmesAvaliados = MutableStateFlow(listOf(
        FilmaAvaliado("O Grande Hotel Budapeste", 5, R.drawable.ic_menu_report_image),
        FilmaAvaliado("Interstellar", 4, R.drawable.ic_menu_report_image),
    ))
    val filmesAvaliados: StateFlow<List<FilmaAvaliado>> = _filmesAvaliados
}