package com.samples.network.repository

import com.google.common.truth.Truth
import com.samples.domain.models.Resource
import com.samples.domain.repository.NewsRepository
import com.samples.network.BaseTest
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Test

class NewsRepositoryImplTest : BaseTest() {
    private lateinit var newsRepository: NewsRepository

    override fun setup() {
        super.setup()
        newsRepository = NewsRepositoryImpl(newsApi)
    }

    @Test
    fun `When fetchTopHeadlines is called, a list of user headlines news should be returned`() =
        runBlocking {
            newsRepository.fetchTopHeadlines().collect { response ->
                Truth.assertThat(response.data?.size).isEqualTo(4)
            }
        }
}