package com.example.rickandmortyandroid4.data.remote.apiservies

import com.example.rickandmortyandroid4.models.RickAndMortyResponse
import com.example.rickandmortyandroid4.models.location.LocationModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApiService {

    @GET("location")
    suspend fun fetchLocation(
        @Query("page") page: Int
    ): Response<RickAndMortyResponse<LocationModel>>
}