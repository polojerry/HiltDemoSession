package com.samples.hiltdemosession.feature_news.data.repository

import com.samples.hiltdemosession.feature_news.data.datasource.remote.api.NewsApi
import com.samples.hiltdemosession.feature_news.data.datasource.remote.mappers.toDomain
import com.samples.domain.model.News
import com.samples.domain.model.Resource
import com.samples.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val newsApi: NewsApi) : NewsRepository {
    override fun fetchTopHeadlines(): Flow<Resource<List<News>>>  = flow{
        try {
            val response = newsApi.fetchHeadlines()

            when {
                response.isSuccessful -> {
                    emit(
                        Resource.Success(data = response.body()!!.articles.map {
                            it.toDomain()
                        }.shuffled())
                    )
                }
                else -> {
                    emit(Resource.Error(message = "Server Error"))
                }
            }

        } catch (exception: Exception) {
            emit(Resource.Error(message = exception.message))

        } catch (ioException: IOException) {
            emit(Resource.Error(message = "Network Error: Kindly Check our Internet"))
        }
    }
}