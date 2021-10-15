package com.samples.domain.repository

import com.samples.domain.model.Favourite
import kotlinx.coroutines.flow.Flow

interface FavouriteRepository {
    suspend fun insertFavourite(favourite: Favourite)

    suspend fun getFavourites(): Flow<List<Favourite>>

    suspend fun clear()
}