package com.samples.domain.usecases

import com.samples.domain.models.News
import com.samples.domain.models.Resource
import com.samples.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

typealias FetchHeadlinesBaseUseCase = BaseUseCase<Unit, Resource<Flow<List<News>>>>

class FetchHeadlinesUseCase constructor(private val newsRepository: NewsRepository) :
    FetchHeadlinesBaseUseCase {
    override suspend fun invoke(params: Unit): Resource<Flow<List<News>>> {
        return newsRepository.fetchTopHeadlines()
    }
}