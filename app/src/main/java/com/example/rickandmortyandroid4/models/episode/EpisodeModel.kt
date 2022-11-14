package com.example.rickandmortyandroid4.models.episode

import com.example.rickandmortyandroid4.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class EpisodeModel(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("episode")
    val episode: String
): IBaseDiffModel<Int>
