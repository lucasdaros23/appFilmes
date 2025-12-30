package com.example.appfilmes.viewModel.contract

import com.example.appfilmes.data.model.Filme
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(".")
    suspend fun getMovieByTitle(
        @Query("t") title: String,
        @Query("apikey") apiKey: String
    ): Filme
    @GET(".")
    suspend fun getMovieById(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey: String
    ): Filme
}
