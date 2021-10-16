package com.samples.hiltdemosession.feature_news_favourite.data.repository

import com.samples.domain.model.Favourite
import com.samples.domain.repository.FavouriteRepository
import com.samples.local.dao.FavouritesDao
import com.samples.local.mappers.toDomain
import com.samples.local.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouritesRepositoryImpl @Inject constructor(private val favouriteDao: FavouritesDao) :
    FavouriteRepository {
    override suspend fun insertFavourite(favourite: Favourite) {
        favouriteDao.insertFavourite(favourite.toEntity())
    }

    override suspend fun getFavourites(): Flow<List<Favourite>> {
        return favouriteDao.getFavourites().map {
            it.map { entity ->
                entity.toDomain()

            }
        }
    }

    override suspend fun clear() {
       favouriteDao.clearFavourites()
    }
}