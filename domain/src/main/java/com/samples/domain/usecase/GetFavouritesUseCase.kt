package com.samples.domain.usecase

import com.samples.domain.model.Favourite
import com.samples.domain.repository.FavouriteRepository
import kotlinx.coroutines.flow.Flow

typealias GetFavouritesBaseUseCase = BaseUseCase<Unit, Flow<List<Favourite>>>

class GetFavouritesUseCase constructor(private val favouriteRepository: FavouriteRepository) :
    GetFavouritesBaseUseCase {
    override suspend fun invoke(params: Unit): Flow<List<Favourite>> {
        return favouriteRepository.getFavourites()
    }
}