package com.example.appfilmes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.appfilmes.ui.navigation.NavGraph
import com.example.appfilmes.ui.theme.AppFilmesTheme
import com.example.appfilmes.viewModel.CadastroViewModel
import com.example.appfilmes.viewModel.FilmesViewModel
import com.example.appfilmes.viewModel.LoginViewModel
import com.example.appfilmes.viewModel.ProfileViewModel
import com.example.appfilmes.viewModel.RodapeViewModel
import com.example.appfilmes.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFilmesTheme {
                val navController = rememberNavController()
                val loginViewModel: LoginViewModel = viewModel()
                val rodapeViewModel: RodapeViewModel = viewModel()
                val profileViewModel: ProfileViewModel = viewModel()
                val cadastroViewModel: CadastroViewModel = viewModel()
                val userViewModel: UserViewModel = viewModel()
                val filmesViewModel: FilmesViewModel = viewModel()
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    NavGraph(loginViewModel, cadastroViewModel, navController, rodapeViewModel, profileViewModel, userViewModel, filmesViewModel)
                }
            }
        }
    }
}