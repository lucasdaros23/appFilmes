package com.example.appfilmes.model

data class Usuario(
    val nome: String,
    val ReviewsCount: Int,
    val avaliacoesCount: Int,
    val fotoUrl: String? = null
)