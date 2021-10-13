package com.samples.domain.usecases

import com.samples.domain.models.News
import com.samples.domain.models.Resource
import com.samples.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

typealias FetchHeadlinesBaseUseCase = BaseUseCase<Unit,  Flow<Resource<List<News>>>>

class FetchHeadlinesUseCase constructor(private val newsRepository: NewsRepository) :
    FetchHeadlinesBaseUseCase {
    override suspend fun invoke(params: Unit): Flow<Resource<List<News>>> {
        return newsRepository.fetchTopHeadlines()
    }
}