package com.example.appfilmes.viewModel.contract

interface EmailHandler {
    val email: String
    fun onEmailChange(value: String)
}