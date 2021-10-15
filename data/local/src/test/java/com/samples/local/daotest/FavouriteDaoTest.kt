package com.samples.local.daotest

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.samples.local.BaseTest
import com.samples.local.Fakes
import com.samples.local.dao.FavouritesDao
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class FavouriteDaoTest : BaseTest() {

    private lateinit var favouritesDao: FavouritesDao

    override fun setUp() {
        super.setUp()
        favouritesDao = favouritesDatabase.favouritesDao
    }

    @Test
    fun `When we save a favourite, the correct correct data should be inserted `() = runBlocking {
        val actualFavourite = Fakes.favourite
        favouritesDao.insertFavourite(actualFavourite)

        val favourite = favouritesDao.getFavourites().first().first()
        Truth.assertThat(actualFavourite).isEqualTo(favourite)
    }

    @Test
    fun `When we clear the favourites, all favourites should be removed`() = runBlocking {
        favouritesDao.insertFavourite(Fakes.favourite)

        favouritesDao.clearFavourites()

        val favourite = favouritesDao.getFavourites().first()
        Truth.assertThat(favourite.size).isEqualTo(0)
    }

    @Test
    fun `When we get favourites, a list of the favourites should be returned`() = runBlocking {
        favouritesDao.insertFavourite(Fakes.favourite)
        favouritesDao.insertFavourite(Fakes.favourite1)

        val favourites = favouritesDao.getFavourites().first()
        Truth.assertThat(favourites.size).isGreaterThan(1)

    }


}