package com.samples.network.api

import com.samples.network.BuildConfig
import com.samples.network.responses.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/everything")
    suspend fun fetchHeadlines(
        @Query("q") query: String = "top-headlines",
        @Query("apiKey") apiKey :String = "bfeead24fbab464cb7bad431e7373a5b"
    ): Response<NewsResponse>
}