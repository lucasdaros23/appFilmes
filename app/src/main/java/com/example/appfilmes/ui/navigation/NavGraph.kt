package com.example.appfilmes.ui.navigation

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appfilmes.ui.telas.LoginScreen
import com.example.appfilmes.ui.telas.ProfileScreen
import com.example.appfilmes.viewModel.LoginViewModel
import com.example.appfilmes.viewModel.RodapeViewModel

@Composable
fun NavGraph(loginViewModel: LoginViewModel, navController: NavHostController, rodapeViewModel: RodapeViewModel){
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ){
        composable(Routes.LOGIN) {
            LoginScreen(loginViewModel, navController)
        }
        composable(Routes.HOME) {
            HomeScreen(navController, rodapeViewModel)
        }
        composable(Routes.PERFIL) {
            ProfileScreen("lucas", navController, rodapeViewModel)
        }
    }
}