package com.samples.hiltdemosession.di

import com.samples.domain.repository.FavouriteRepository
import com.samples.hiltdemosession.feature_news.data.datasource.remote.api.NewsApi
import com.samples.hiltdemosession.feature_news.data.repository.NewsRepositoryImpl
import com.samples.domain.repository.NewsRepository
import com.samples.hiltdemosession.feature_news_favourite.data.repository.FavouritesRepositoryImpl
import com.samples.local.dao.FavouritesDao
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

    @Provides
    @Singleton
    fun provideFavouritesRepository(favouritesDao: FavouritesDao) : FavouriteRepository {
        return FavouritesRepositoryImpl(favouritesDao)
    }
}