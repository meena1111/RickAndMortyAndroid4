package com.example.rickandmortyandroid4.data.repositories

import com.example.rickandmortyandroid4.base.BaseRepository
import com.example.rickandmortyandroid4.data.remote.apiservies.EpisodeApiService
import javax.inject.Inject

class EpisodeRepository @Inject constructor(private val service: EpisodeApiService) :
    BaseRepository() {

    fun fetchEpisode(page: Int) = doRequest {
        service.fetchEpisode(page)
    }
}