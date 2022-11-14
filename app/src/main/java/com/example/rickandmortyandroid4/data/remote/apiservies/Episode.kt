package com.example.rickandmortyandroid4.data.remote.apiservies

import com.example.rickandmortyandroid4.models.RickAndMortyResponse
import com.example.rickandmortyandroid4.models.episode.EpisodeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("episode")
    suspend fun fetchEpisode(
        @Query("page") page: Int
    ): Response<RickAndMortyResponse<EpisodeModel>>
}