package com.samples.hiltdemosession.feature_news_favourite.data.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.samples.domain.repository.FavouriteRepository
import com.samples.hiltdemosession.feature_news_favourite.data.BaseTest
import com.samples.hiltdemosession.feature_news_favourite.data.Fakes
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class FavouritesRepositoryImplTest : BaseTest() {
    private lateinit var favouriteRepository: FavouriteRepository

    override fun setUp() {
        super.setUp()
        favouriteRepository = FavouritesRepositoryImpl(favouritesDao)
    }


    @Test
    fun `When we call insertFavourite, the correct correct data should be inserted `() = runBlocking {
        val actualFavourite = Fakes.favourite
        favouriteRepository.insertFavourite(actualFavourite)

        val favourite = favouriteRepository.getFavourites().first().first()
        Truth.assertThat(actualFavourite).isEqualTo(favourite)
    }

    @Test
    fun `When we clear the favourites, all favourites should be removed`() = runBlocking {
        favouriteRepository.insertFavourite(Fakes.favourite)

        favouriteRepository.clear()

        val favourite = favouriteRepository.getFavourites().first()
        Truth.assertThat(favourite.size).isEqualTo(0)
    }

    @Test
    fun `When we get favourites, a list of the favourites should be returned`() = runBlocking {
        favouriteRepository.insertFavourite(Fakes.favourite)
        favouriteRepository.insertFavourite(Fakes.favourite1)

        val favourites = favouriteRepository.getFavourites().first()
        Truth.assertThat(favourites.size).isGreaterThan(1)

    }

}