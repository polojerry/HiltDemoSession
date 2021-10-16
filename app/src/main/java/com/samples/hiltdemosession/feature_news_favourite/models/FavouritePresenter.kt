package com.samples.hiltdemosession.feature_news_favourite.models

data class FavouritePresenter(
    val author: String,
    val title: String,
    val imageUrl: String,
    val publishDate: String,
    val url: String,
    val sourceName: String,
    val content : String?
)
