package com.samples.hiltdemosession.di

import com.samples.domain.repository.FavouriteRepository
import com.samples.domain.repository.NewsRepository
import com.samples.domain.usecase.ClearFavouritesUseCase
import com.samples.domain.usecase.FetchHeadlinesUseCase
import com.samples.domain.usecase.GetFavouritesUseCase
import com.samples.domain.usecase.InsertFavouriteUseCase
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

    @Provides
    fun providesInsertFavouritesUseCase(favouritesRepository: FavouriteRepository): InsertFavouriteUseCase {
        return InsertFavouriteUseCase(favouritesRepository)
    }

    @Provides
    fun providesGetFavouritesUseCase(favouritesRepository: FavouriteRepository): GetFavouritesUseCase {
        return GetFavouritesUseCase(favouritesRepository)
    }

    @Provides
    fun providesClearFavouritesUseCase(favouritesRepository: FavouriteRepository): ClearFavouritesUseCase {
        return ClearFavouritesUseCase(favouritesRepository)
    }
}