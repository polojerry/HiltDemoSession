package com.samples.hiltdemosession.feature_news.domain.usecase

import com.samples.hiltdemosession.feature_news.domain.model.News
import com.samples.hiltdemosession.feature_news.domain.repository.NewsRepository
import com.samples.hiltdemosession.util.Resource
import kotlinx.coroutines.flow.Flow

typealias FetchHeadlinesBaseUseCase = BaseUseCase<Unit,  Flow<Resource<List<News>>>>

class FetchHeadlinesUseCase constructor(private val newsRepository: NewsRepository) :
    FetchHeadlinesBaseUseCase {
    override suspend fun invoke(params: Unit): Flow<Resource<List<News>>> {
        return newsRepository.fetchTopHeadlines()
    }
}