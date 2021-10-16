package com.samples.domain.model

data class Favourite(
    val author: String,
    val title: String,
    val imageUrl: String,
    val publishDate: String,
    val url: String,
    val sourceName: String,
    val content : String?
)