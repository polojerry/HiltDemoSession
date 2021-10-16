package com.samples.hiltdemosession.feature_news.data.repository

import com.google.common.truth.Truth
import com.samples.hiltdemosession.feature_news.data.BaseTest
import com.samples.domain.repository.NewsRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Test

class NewsRepositoryImplTest : BaseTest() {
    private lateinit var newsRepository: NewsRepository

    override fun setup() {
        super.setup()
        newsRepository = NewsRepositoryImpl(newsApi)
    }

    @Test
    fun `When fetchTopHeadlines is called, a list of user headlines news should be returned`() =  runBlocking {
            newsRepository.fetchTopHeadlines().collect { response ->
                Truth.assertThat(response.data?.size).isEqualTo(4)
            }
        }
}