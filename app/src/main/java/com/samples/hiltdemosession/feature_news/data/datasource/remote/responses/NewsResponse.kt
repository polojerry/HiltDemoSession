package com.samples.hiltdemosession.feature_news.data.datasource.remote.responses

import com.samples.hiltdemosession.feature_news.data.datasource.remote.models.NewsNetwork

data class NewsResponse(
    val status: String,
    val totalResults: String,
    val articles: List<NewsNetwork>,
)