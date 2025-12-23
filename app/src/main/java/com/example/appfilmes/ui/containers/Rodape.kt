package com.example.appfilmes.ui.containers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.appfilmes.ui.navigation.Routes
import com.example.appfilmes.viewModel.RodapeViewModel

@Composable
fun BottomBar(navController: NavHostController, rodapeViewModel: RodapeViewModel) {
    val uiState = rodapeViewModel.uiState
    val itemSelecionado = uiState.selectedItem
    Column(
        verticalArrangement = Arrangement.Bottom
    ){
        NavigationBar(
            containerColor = Color(0xFF111111)
        ) {
            val items = listOf("Home", "Filmes", "Perfil")
            val icons = listOf(
                Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Person
            )

            // ✅ Corrige o loop para incluir o índice e o item corretamente
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = itemSelecionado == index,
                    onClick = {
                        rodapeViewModel.onIconChange(index)

                        when (item){
                            "Perfil" -> navController.navigate(Routes.PERFIL)
                            "Home" -> navController.navigate(Routes.HOME)
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = icons[index], contentDescription = item
                        )
                    },
                    label = { Text(item) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF3B49DF),
                        selectedTextColor = Color(0xFF3B49DF),
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White,
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}