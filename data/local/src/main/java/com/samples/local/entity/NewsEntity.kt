package com.samples.local.entity

data class NewsEntity(
    val author: String,
    val title: String,
    val imageUrl: String,
    val publishDate: String,
    val url: String,
    val source: SourceEntity,
    val content : String?
)