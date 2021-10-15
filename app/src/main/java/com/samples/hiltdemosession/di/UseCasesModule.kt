package com.samples.hiltdemosession.di

import com.samples.hiltdemosession.feature_news.domain.repository.NewsRepository
import com.samples.hiltdemosession.feature_news.domain.usecase.FetchHeadlinesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object UseCasesModule {

    @Provides
    fun providesFetchHeadlinesUseCase(newsRepository: NewsRepository): FetchHeadlinesUseCase {
        return FetchHeadlinesUseCase(newsRepository)
    }
}