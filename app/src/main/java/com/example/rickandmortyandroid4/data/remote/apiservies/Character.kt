package com.example.rickandmortyandroid4.data.remote.apiservies

import com.example.rickandmortyandroid4.models.RickAndMortyResponse
import com.example.rickandmortyandroid4.models.character.CharacterModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApiService {

    @GET("character")
    suspend fun fetchCharacter(
        @Query("page") page: Int
    ): Response<RickAndMortyResponse<CharacterModel>>
}