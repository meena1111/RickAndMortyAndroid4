package com.example.rickandmortyandroid4.models.character

import android.webkit.WebStorage
import com.example.rickandmortyandroid4.base.IBaseDiffModel
import com.example.rickandmortyandroid4.models.location.LocationModel
import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("origin")
    val origin: WebStorage.Origin,
    @SerializedName("location")
    val location: LocationModel
) : IBaseDiffModel<Int>
