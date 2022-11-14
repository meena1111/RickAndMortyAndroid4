package com.example.rickandmortyandroid4.models

import com.google.gson.annotations.SerializedName

data class Information(
    @SerializedName("count")
    var count: Int? = null,

    @SerializedName("pages")
    var pages: Int = 1,

    @SerializedName("next")
    val next: String? = null,

    @SerializedName("prev")
    val prev: String? = null
)