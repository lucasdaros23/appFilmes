package com.example.appfilmes.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.appfilmes.data.model.CadastroUiState
import com.example.appfilmes.data.repository.UserRepository
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

    fun onCriarConta(){
        uiState = uiState.copy(alertMessage =
        if (
            senha != "" &&
            uiState.senhaConfirm != "" &&
            email != "" &&
            uiState.nome != ""
            ){
            if (senha == uiState.senhaConfirm) "Sua conta foi criada com sucesso!"
            else "As senhas não coincidem. Verifique e tente novamente."
        } else "Preencha todos os campos corretamente.")
    }

    fun clearAlertMessage(){
        uiState = uiState.copy(alertMessage = "")
    }
}