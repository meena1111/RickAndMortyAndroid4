package com.example.rickandmortyandroid4.ui.fragments.location

import com.example.rickandmortyandroid4.base.BaseViewModel
import com.example.rickandmortyandroid4.data.repositories.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LocationViewModel @Inject constructor(private val repository: LocationRepository) :
    BaseViewModel() {

    fun fetchLocation(page: Int) = repository.fetchLocation(page)
}