package com.example.rickandmortyandroid4.models

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse<T>(
    @SerializedName("info")
    val info: Information,
    @SerializedName("results")
    val results: List<T>
)