package com.example.appfilmes.ui.navigation

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appfilmes.ui.telas.LoginScreen
import com.example.appfilmes.viewModel.LoginViewModel

@Composable
fun NavGraph(loginViewModel: LoginViewModel, navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ){
        composable(Routes.LOGIN) {
            LoginScreen(loginViewModel, navController)
        }
        composable(Routes.LOGIN) {
            HomeScreen()
        }
    }
}