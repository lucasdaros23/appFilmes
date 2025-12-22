package com.example.appfilmes.ui.telas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.appfilmes.ui.components.ImageMovie
import com.example.appfilmes.ui.components.TextFieldEmail
import com.example.appfilmes.ui.components.TextFieldSenha
import com.example.appfilmes.viewModel.LoginViewModel

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    Box(
        Modifier
            .background(Color(0xff1A1A1A))
    ) {

        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
        )
        {
            Box(
                Modifier.padding(80.dp)
            ){
                ImageMovie()
            }

            TextFieldEmail(
                email = loginViewModel.uiState.email,
                onValueChange = { email -> loginViewModel.onEmailChange(email) }
            )
            TextFieldSenha(
                senha = loginViewModel.uiState.senha,
                onValueChange = { senha -> loginViewModel.onSenhaChange(senha) },
                loginViewModel
            )
        }
    }
}