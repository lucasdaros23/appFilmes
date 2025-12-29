package com.example.appfilmes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appfilmes.data.model.User
import com.example.appfilmes.ui.navigation.Routes
import com.example.appfilmes.viewModel.CadastroViewModel
import com.example.appfilmes.viewModel.UserViewModel

@Composable
fun AlertBox(content: @Composable () -> Unit, erro: Boolean) {
    Box(
        Modifier
            .background(
                color = Color(if (erro) 0xFF380009 else 0xFF000a38),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(20.dp)
    ) {
        content()
    }
}


@Composable
fun AlertBase(content: @Composable () -> Unit) {
    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(
            dismissOnClickOutside = false,
            dismissOnBackPress = false
        ),
    ) {
        content()
    }
}

@Composable
fun AlertCriarConta(
    cadastroViewModel: CadastroViewModel,
    navController: NavHostController,
    userViewModel: UserViewModel
) {
    val state = cadastroViewModel.uiState
    val erro = state.alertMessage != "Sua conta foi criada com sucesso!"
    if (state.alertMessage != "") {
        AlertBase {
            AlertBox(erro = erro, content = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(state.alertMessage)
                    Column(Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ){
                        ButtonAlert(
                            text = "OK",
                            erro = erro,
                            onClick = {
                                if (!erro) {
                                    userViewModel.addUser(
                                        User(
                                            state.nome,
                                            cadastroViewModel.email,
                                            cadastroViewModel.senha
                                        )
                                    )
                                    navController.navigate(Routes.HOME)
                                }
                                cadastroViewModel.clearAlertMessage()
                            }
                        )
                    }
                }
            })
        }
    }
}
@Preview
@Composable
fun AlertCriarContaErrorPreview(){
    AlertCriarConta(CadastroViewModel(), rememberNavController(), UserViewModel())
}