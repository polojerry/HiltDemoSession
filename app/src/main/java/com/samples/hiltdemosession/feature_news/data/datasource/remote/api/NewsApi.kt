package com.samples.hiltdemosession.feature_news.data.datasource.remote.api

import com.samples.hiltdemosession.feature_news.data.datasource.remote.responses.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun fetchHeadlines(
        @Query("q") query: String = "top-headlines",
        @Query("apiKey") apiKey: String = "bfeead24fbab464cb7bad431e7373a5b"
    ): Response<NewsResponse>
}