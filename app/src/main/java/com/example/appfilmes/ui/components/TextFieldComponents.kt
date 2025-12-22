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
import com.example.appfilmes.viewModel.LoginViewModel


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
        shape = RoundedCornerShape(20.dp),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
}

@Composable
fun TextFieldEmail(email: String, onValueChange: (String) -> Unit) {
    Row() {
        TextFieldBase(
            value = email,
            onValueChange = { onValueChange(it) },
            placeholder = "Seu email",
            visualTransformation = VisualTransformation.None,
            leadingIcon = {
                IconEmail()
            }
        )
    }
}

@Composable
fun TextFieldSenha(senha: String, onValueChange: (String) -> Unit, loginViewModel: LoginViewModel) {
    TextFieldBase(
        senha,
        onValueChange = { onValueChange(it) },
        placeholder = "Sua senha",
        visualTransformation = if (loginViewModel.uiState.mostrarSenha) VisualTransformation.None else PasswordVisualTransformation(),
        leadingIcon = { IconLock() },
        trailingIcon = {
            IconButton(onClick = { loginViewModel.onOlhoChange() }) {
                IconEye(loginViewModel)
            }
        }
    )
}