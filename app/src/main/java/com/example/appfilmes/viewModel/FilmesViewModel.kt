package com.example.appfilmes.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfilmes.data.model.Filme
import com.example.appfilmes.data.model.RetrofitClient
import kotlinx.coroutines.launch

class FilmesViewModel : ViewModel() {

    val apiKey = "d2acc0fb"
    private val _filmes = mutableStateOf<List<Filme>>(emptyList())
    val filmes: State<List<Filme>> = _filmes

    private val _filmesEmAlta = mutableStateOf<List<Filme>>(emptyList())
    val filmesEmAlta: State<List<Filme>> = _filmesEmAlta

    fun carregarFilmes() {
        viewModelScope.launch {
            try {
                val lista = listOf(
                    RetrofitClient.instance.getMovieById("tt1517268", apiKey),
                    RetrofitClient.instance.getMovieById("tt2293640", apiKey)
                )
                _filmes.value = lista
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun carregarFilmesEmAlta() {
        viewModelScope.launch {
            try {
                val lista = listOf(
                    RetrofitClient.instance.getMovieById("tt0317219", apiKey),
                    RetrofitClient.instance.getMovieById("tt2582802", apiKey),
                    RetrofitClient.instance.getMovieById("tt0414853", apiKey),
                    RetrofitClient.instance.getMovieById("tt30274401", apiKey),
                    RetrofitClient.instance.getMovieById("tt2490004", apiKey),
                    RetrofitClient.instance.getMovieById("tt2322441", apiKey),

                )
                _filmesEmAlta.value = lista
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}