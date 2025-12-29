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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appfilmes.ui.components.AlertCriarConta
import com.example.appfilmes.ui.components.ButtonBase
import com.example.appfilmes.ui.components.ImageMovie
import com.example.appfilmes.ui.components.TextBase
import com.example.appfilmes.ui.components.TextButtonBase
import com.example.appfilmes.ui.components.TextFieldEmail
import com.example.appfilmes.ui.components.TextFieldNome
import com.example.appfilmes.ui.components.TextFieldSenha
import com.example.appfilmes.ui.components.TextFieldSenhaConfirm
import com.example.appfilmes.ui.components.TextMaior
import com.example.appfilmes.ui.navigation.Routes
import com.example.appfilmes.viewModel.CadastroViewModel
import com.example.appfilmes.viewModel.UserViewModel

@Composable
fun CadastroScreen(handler: CadastroViewModel, navController: NavHostController, userViewModel: UserViewModel) {
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
                    Modifier
                        .padding(70.dp)
                        .fillMaxWidth(),
                    Alignment.Center
                ) {
                    ImageMovie(120)
                }

                TextMaior("Nome Completo")
                TextFieldNome(handler)
                TextMaior("Email")
                TextFieldEmail(handler)
                TextMaior("Senha")
                TextFieldSenha(handler)
                TextMaior("Confirmar Senha")
                TextFieldSenhaConfirm(handler)

                Row(Modifier.padding(10.dp)){
                    ButtonBase("Criar Conta", onClick = { handler.onCriarConta()})
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 40.dp),
                    horizontalArrangement = Arrangement.Center
                ){
                    TextBase("Já tem uma conta? ")
                    TextButtonBase("Entrar", onClick = { navController.navigate(Routes.LOGIN) })
                }
            }
        }
    }
    AlertCriarConta(handler, navController, userViewModel)
}

/*
@Preview(showBackground = true)
@Composable
fun CadastroPreview(){
    CadastroScreen()
}
*/