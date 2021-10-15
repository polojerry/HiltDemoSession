package com.samples.hiltdemosession.di

import com.samples.hiltdemosession.feature_news.data.datasource.remote.api.NewsApi
import com.samples.hiltdemosession.feature_news.data.repository.NewsRepositoryImpl
import com.samples.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesNewsRepository(newsApi: NewsApi): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }
}