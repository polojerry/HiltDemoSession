package com.samples.hiltdemosession.models

data class NewsPresenter(
    val author: String,
    val title: String,
    val imageUrl: String,
    val publishDate: String,
    val url: String,
    val source: SourcePresenter,
    val content: String?
)