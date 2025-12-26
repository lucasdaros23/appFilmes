package com.example.appfilmes.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextBase(text: String){
    Text(
        text,
        color = Color(0xffB3B3B3),
        fontSize = 15.sp
    )
}

@Composable
fun TextMaior(text: String){
    Text(
        text,
        color = Color(0xffFFFFFF),
        fontSize = 18.sp,
        modifier = Modifier.padding(start = 20.dp)
    )
}
