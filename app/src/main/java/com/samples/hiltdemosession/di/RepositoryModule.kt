package com.samples.hiltdemosession.di

import com.samples.domain.repository.NewsRepository
import com.samples.network.api.NewsApi
import com.samples.network.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesNewsRepository(newsApi: NewsApi) : NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }
}