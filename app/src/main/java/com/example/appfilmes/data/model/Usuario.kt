package com.example.appfilmes.data.model

data class Usuario(
    val nome: String,
    val ReviewsCount: Int,
    val avaliacoesCount: Int,
    val fotoUrl: String? = null
)