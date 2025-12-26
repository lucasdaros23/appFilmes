package com.example.appfilmes.viewModel.contract

interface SenhaHandler {
    val mostrarSenha: Boolean
    val senha: String
    fun onSenhaChange(value: String)
    fun onOlhoChange()



}