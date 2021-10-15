package com.samples.domain.usecase

import com.samples.domain.repository.FavouriteRepository

typealias ClearFavouritesBaseUseCase = BaseUseCase<Unit, Unit>

class ClearFavouritesUseCase constructor(private val favouriteRepository: FavouriteRepository) :
    ClearFavouritesBaseUseCase {
    override suspend fun invoke(params: Unit) {
        return favouriteRepository.clear()
    }
}