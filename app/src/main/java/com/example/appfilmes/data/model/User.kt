package com.example.appfilmes.data.model

import java.util.UUID

data class User(
    val nome: String,
    val email: String,
    val senha: String,
    val id: String = UUID.randomUUID().toString(),
    val reviewsCount: Int = 0,
    val avaliacoesCount: Int = 0,
    val fotoUrl: String? = null
)