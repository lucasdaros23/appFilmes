package com.example.appfilmes.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.appfilmes.R
import com.example.appfilmes.viewModel.LoginViewModel


@Composable
fun IconBase(
    painter: Painter,
    contentDescription: String
){
    Icon(
        painter = painter,
        contentDescription = contentDescription,
        Modifier.size(25.dp),
        tint = Color(0xffB3B3B3)
    )
}

@Composable
fun IconEmail(){
    IconBase(
        painterResource(R.drawable.email),
        "email",
    )
}

@Composable
fun IconLock(){
    IconBase(
        painterResource(R.drawable.lock),
        "cadeado"
    )
}

@Composable
fun IconEye(loginViewModel: LoginViewModel){
    IconBase(
        painterResource(
            if (loginViewModel.uiState.mostrarSenha) R.drawable.openeye else R.drawable.closeeye),
        "olho"
    )
}

@Composable
fun IconGoogle(){
    IconBase(
        painterResource(R.drawable.google),
        "google",
    )
}

@Composable
fun IconFacebook(){
    IconBase(
    painterResource(R.drawable.facebook),
    "facebook")
}