package com.samples.network.util

import app.nexustracker.android.feature_trips.data.remote.util.MockResponseFileReader
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

class NewsRequestDispatcher : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            "/everything?q=top-headlines&apiKey=bfeead24fbab464cb7bad431e7373a5b" -> {
                return MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(MockResponseFileReader("json/news_response.json").content)
            }


            else -> MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_FOUND)
        }
    }
}