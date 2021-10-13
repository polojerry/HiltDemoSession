package com.samples.network.repository

import com.samples.domain.models.News
import com.samples.domain.models.Resource
import com.samples.domain.repository.NewsRepository
import com.samples.network.api.NewsApi
import com.samples.network.mappers.toDomain
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
                        })
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