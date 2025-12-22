package com.example.appfilmes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appfilmes.ui.telas.ProfileScreenPreview
import com.example.appfilmes.ui.theme.AppFilmesTheme
import com.example.appfilmes.viewModel.ProfileScreenView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFilmesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileScreenView()
                }
            }
        }
    }
}

data class Usuario(
    val nome: String,
    val ReviewsCount: Int,
    val avaliacoesCount: Int,
    val fotoUrl: String? = null
)

data class FilmaAvaliado(
    val titulo: String,
    val nota: Int,
    val imagemRes: Int
)
