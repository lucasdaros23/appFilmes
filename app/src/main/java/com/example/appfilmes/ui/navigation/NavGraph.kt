package com.example.appfilmes.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appfilmes.ui.telas.CadastroScreen
import com.example.appfilmes.ui.telas.HomeScreen
import com.example.appfilmes.ui.telas.LoginScreen
import com.example.appfilmes.ui.telas.ProfileScreenView
import com.example.appfilmes.viewModel.CadastroViewModel
import com.example.appfilmes.viewModel.FilmesViewModel
import com.example.appfilmes.viewModel.LoginViewModel
import com.example.appfilmes.viewModel.ProfileViewModel
import com.example.appfilmes.viewModel.RodapeViewModel
import com.example.appfilmes.viewModel.UserViewModel

@Composable
fun NavGraph(loginViewModel: LoginViewModel,
             cadastroViewModel: CadastroViewModel,
             navController: NavHostController,
             rodapeViewModel: RodapeViewModel,
             profileViewModel: ProfileViewModel,
             userViewModel: UserViewModel,
             filmesViewModel: FilmesViewModel
             ){
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ){
        composable(Routes.LOGIN) {
            LoginScreen(loginViewModel, navController)
        }
        composable(Routes.HOME) {
            HomeScreen(navController, rodapeViewModel, filmesViewModel)
        }
        composable(Routes.PERFIL) {
            ProfileScreenView(profileViewModel, navController, rodapeViewModel)
        }
        composable (Routes.CADASTRO){
            CadastroScreen(cadastroViewModel, navController, userViewModel)
        }
    }
}