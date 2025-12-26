package com.example.appfilmes.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.appfilmes.viewModel.CadastroViewModel
import com.example.appfilmes.viewModel.LoginViewModel
import com.example.appfilmes.viewModel.contract.EmailHandler
import com.example.appfilmes.viewModel.contract.SenhaHandler


@Composable
fun TextFieldBase(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    visualTransformation: VisualTransformation,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        placeholder = {
            Text(
                placeholder,
                color = Color(0xffB3B3B3)
            )
        },
        visualTransformation = visualTransformation,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color(0xff3C3C3C),
            unfocusedIndicatorColor = Color(0xff3C3C3C)
        ),
        shape = RoundedCornerShape(15.dp),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
}

@Composable
fun TextFieldEmail(handler: EmailHandler) {
    Row() {
        TextFieldBase(
            value = handler.email,
            onValueChange = handler::onEmailChange,
            placeholder = "Seu email",
            visualTransformation = VisualTransformation.None,
            leadingIcon = {
                IconEmail()
            }
        )
    }
}

@Composable
fun TextFieldSenha(handler: SenhaHandler) {
    TextFieldBase(
        handler.senha,
        onValueChange = handler::onSenhaChange,
        placeholder = "Sua senha",
        visualTransformation = if (handler.mostrarSenha) VisualTransformation.None else PasswordVisualTransformation(),
        leadingIcon = { IconLock() },
        trailingIcon = {
            IconButton(onClick = { handler.onOlhoChange() }) {
                IconEye(handler)
            }
        }
    )
}

@Composable
fun TextFieldNome(viewModel: CadastroViewModel) {
    TextFieldBase(
        value = viewModel.uiState.nome,
        onValueChange = { viewModel.onNomeChange(it) },
        placeholder = "Seu nome",
        visualTransformation = VisualTransformation.None
    )
}

@Composable
fun TextFieldSenhaConfirm(viewModel: CadastroViewModel) {
    TextFieldBase(
        value = viewModel.uiState.senhaConfirm,
        onValueChange = { viewModel.onSenhaConfirmChange(it) },
        placeholder = "Confirme sua senha",
        visualTransformation = if (viewModel.uiState.mostrarSenhaConfirm) VisualTransformation.None else PasswordVisualTransformation(),
        leadingIcon = { IconLock() },
        trailingIcon = {
            IconButton(onClick = { viewModel.onOlhoConfirmChange() }) {
                IconEyeConfirm(viewModel)
            }
        }
    )
}