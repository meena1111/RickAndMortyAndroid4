package com.example.rickandmortyandroid4.data.repositories

import com.example.rickandmortyandroid4.base.BaseRepository
import com.example.rickandmortyandroid4.data.remote.apiservies.CharacterApiService
import com.example.rickandmortyandroid4.models.RickAndMortyResponse
import com.example.rickandmortyandroid4.models.character.CharacterModel
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

class CharacterRepository @Inject constructor(val service: CharacterApiService) :
    BaseRepository() {

    fun fetchCharacter(page: Int) = doRequest {
        service.fetchCharacter(page)
    }
}