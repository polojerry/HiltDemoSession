package com.samples.domain.usecase

import com.samples.domain.model.News
import com.samples.domain.model.Resource
import com.samples.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

typealias FetchHeadlinesBaseUseCase = BaseUseCase<Unit,  Flow<Resource<List<News>>>>

class FetchHeadlinesUseCase constructor(private val newsRepository: NewsRepository) :
    FetchHeadlinesBaseUseCase {
    override suspend fun invoke(params: Unit): Flow<Resource<List<News>>> {
        return newsRepository.fetchTopHeadlines()
    }
}