package com.example.appfilmes.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.appfilmes.model.RodapeUiState

class RodapeViewModel :  ViewModel(){

    var uiState by mutableStateOf(RodapeUiState())
        private set

    fun onIconChange(index: Int){
        uiState = uiState.copy(
            selectedItem = index
        )
    }

}
