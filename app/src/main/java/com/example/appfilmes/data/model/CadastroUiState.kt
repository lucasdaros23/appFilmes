package com.example.appfilmes.data.model

data class CadastroUiState(
    val nome: String = "",
    val email: String = "",
    val senha: String = "",
    val senhaConfirm: String = "",
    val mostrarSenha: Boolean = false,
    val mostrarSenhaConfirm: Boolean = false,
    val alertMessage: String = ""
)
