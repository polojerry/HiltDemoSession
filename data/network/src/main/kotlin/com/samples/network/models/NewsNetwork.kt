package com.samples.network.models

import com.google.gson.annotations.SerializedName


data class NewsNetwork(
    val author: String,
    val title: String,

    @SerializedName("urlToImage")
    val imageUrl: String,

    @SerializedName("publishedAt")
    val publishDate: String,

    val url: String,
    val source: SourceNetwork,
    val content : String,
)