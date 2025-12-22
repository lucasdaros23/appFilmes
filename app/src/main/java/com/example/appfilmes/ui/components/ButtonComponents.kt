package com.example.appfilmes.ui.components

import android.R.attr.clickable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextButtonBase(
    text: String,
    onClick: () -> Unit,
) {
    Text(
        text,
        color = Color(0xff3D5AFE),
        fontSize = 15.sp,
        modifier = Modifier.clickable {
            onClick
        }
    )
}


@Composable
fun ButtonBase(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xff3D5AFE),
            contentColor = Color(0xff1A1A1A)
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(
            text,
            fontSize = 20.sp
        )
    }
}

@Composable
fun ButtonSocial(
    text: String,
    onClick: () -> Unit,
    ){
    OutlinedButton(
        onClick = onClick,
        Modifier,
        shape = RoundedCornerShape(20.dp)
    ){
        Row(
            Modifier.padding(13.dp)
        ) {
            if (text=="Google") IconGoogle() else IconFacebook()
            Spacer(Modifier.size(20.dp))
            Text(
                text,
                color = Color.White
            )
        }
    }
}

@Composable
fun ButtonGoogle(){
    ButtonSocial("Google", onClick = {})
}

@Composable
fun ButtonFacebook(){
    ButtonSocial("Facebook", onClick = {})
}