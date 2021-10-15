package com.samples.hiltdemosession.feature_news.data

import com.samples.hiltdemosession.feature_news.data.datasource.remote.api.NewsApi
import com.samples.hiltdemosession.feature_news.data.util.NewsRequestDispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class BaseTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient

    lateinit var newsApi: NewsApi

    @Before
    open fun setup() {
        mockWebServer = MockWebServer().apply {
            dispatcher = NewsRequestDispatcher()
        }

        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .build()

        newsApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(NewsApi::class.java)

    }

    @After
    open fun tearDown() {
        mockWebServer.shutdown()
    }
}