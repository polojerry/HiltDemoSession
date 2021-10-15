package com.samples.domain.usecase

import com.samples.domain.model.Favourite
import com.samples.domain.repository.FavouriteRepository

typealias InsertFavouriteBaseUseCase = BaseUseCase<Favourite, Unit>

class InsertFavouriteUseCase constructor(private val favouriteRepository: FavouriteRepository) :
    InsertFavouriteBaseUseCase {
    override suspend fun invoke(params: Favourite) {
        favouriteRepository.insertFavourite(params)
    }
}