package com.example.rickandmortyandroid4.data.repositories

import com.example.rickandmortyandroid4.base.BaseRepository
import com.example.rickandmortyandroid4.data.remote.apiservies.LocationApiService
import javax.inject.Inject

class LocationRepository @Inject constructor(private val service: LocationApiService) :
    BaseRepository() {

    fun fetchLocation(page: Int) = doRequest {
        service.fetchLocation(page)
    }
}