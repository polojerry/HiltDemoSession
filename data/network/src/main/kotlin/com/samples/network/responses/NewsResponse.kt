package com.samples.network.responses

import com.samples.network.models.NewsNetwork

data class NewsResponse(
    val status: String,
    val totalResults: String,
    val articles: List<NewsNetwork>,
)