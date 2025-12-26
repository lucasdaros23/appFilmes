package com.example.appfilmes.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.appfilmes.data.model.CadastroUiState
import com.example.appfilmes.viewModel.contract.EmailHandler
import com.example.appfilmes.viewModel.contract.SenhaHandler

class CadastroViewModel : ViewModel(), SenhaHandler, EmailHandler {

    var uiState by mutableStateOf(CadastroUiState())
        private set

    override val senha: String
        get() = uiState.senha

    override val email: String
        get() = uiState.email

    override val mostrarSenha: Boolean
        get() = uiState.mostrarSenha

    override fun onOlhoChange() {
        uiState = uiState.copy(mostrarSenha = !uiState.mostrarSenha)
    }

    override fun onEmailChange(value: String){
        uiState = uiState.copy(email = value)
    }

    override fun onSenhaChange(value: String) {
        uiState = uiState.copy(senha = value)
    }

    fun onNomeChange(value: String){
        uiState = uiState.copy(
            nome = value
        )
    }

    fun onSenhaConfirmChange(value: String){
        uiState = uiState.copy(
            senhaConfirm = value
        )
    }

    fun onOlhoConfirmChange() {
        uiState = uiState.copy(mostrarSenhaConfirm = !uiState.mostrarSenhaConfirm)
    }
}