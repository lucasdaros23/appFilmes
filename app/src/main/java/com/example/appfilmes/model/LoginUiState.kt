package com.example.appfilmes.model

data class LoginUiState(
    val email: String = "",
    val senha: String = "",
    val mostrarSenha: Boolean = false
)
