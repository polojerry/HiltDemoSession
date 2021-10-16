package com.samples.domain.model

data class News(
    val author: String,
    val title: String,
    val imageUrl: String,
    val publishDate: String,
    val url: String,
    val source: Source,
    val content : String?
)