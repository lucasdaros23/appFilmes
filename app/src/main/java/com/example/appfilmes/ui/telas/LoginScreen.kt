package com.example.appfilmes.ui.telas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appfilmes.ui.components.ButtonBase
import com.example.appfilmes.ui.components.ButtonFacebook
import com.example.appfilmes.ui.components.ButtonGoogle
import com.example.appfilmes.ui.components.ImageMovie
import com.example.appfilmes.ui.components.TextBase
import com.example.appfilmes.ui.components.TextButtonBase
import com.example.appfilmes.ui.components.TextFieldEmail
import com.example.appfilmes.ui.components.TextFieldSenha
import com.example.appfilmes.ui.navigation.Routes
import com.example.appfilmes.viewModel.LoginViewModel

@Composable
fun LoginScreen(loginViewModel: LoginViewModel, navController: NavHostController) {
    Row(
        horizontalArrangement = Arrangement.Center
    ) {

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
                ) {
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButtonBase("Esqueceu a senha?", onClick = {})
                }

                ButtonBase("Entrar", onClick = { navController.navigate(Routes.HOME) })

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.Center
                ){
                    TextBase("Ou entre com")
                }

                Row(
                    Modifier.fillMaxWidth(),
                    Arrangement.SpaceEvenly

                ) {
                    ButtonGoogle()
                    ButtonFacebook()
                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 40.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextBase("Não tem uma conta? ")
                    TextButtonBase("Criar uma conta", onClick = { })
                }


            }
        }
    }
}
