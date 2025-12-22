package com.example.appfilmes.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun TextBase(text: String){
    Text(
        text,
        color = Color(0xffB3B3B3),
        fontSize = 15.sp
    )
}