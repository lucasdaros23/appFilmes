package com.example.appfilmes.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.appfilmes.model.LoginUiState

class LoginViewModel : ViewModel(){
    var uiState by mutableStateOf(LoginUiState())
        private set


    fun onEmailChange(novoEmail: String){
        uiState = uiState.copy(
            email = novoEmail
        )
    }

    fun onSenhaChange(novaSenha: String){
        uiState = uiState.copy(
            senha = novaSenha
        )
    }

    fun onOlhoChange(){
        uiState = uiState.copy(
            mostrarSenha = if (uiState.mostrarSenha) false else true
        )
    }

}