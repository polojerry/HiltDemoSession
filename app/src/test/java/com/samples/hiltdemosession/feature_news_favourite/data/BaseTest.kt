package com.samples.hiltdemosession.feature_news_favourite.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.samples.local.FavouritesDatabase
import com.samples.local.dao.FavouritesDao
import org.junit.After
import org.junit.Before
import java.io.IOException

open class BaseTest {

    private lateinit var favouritesDatabase: FavouritesDatabase
    lateinit var favouritesDao: FavouritesDao

    @Before
    open fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        favouritesDatabase = Room.inMemoryDatabaseBuilder(
            context, FavouritesDatabase::class.java
        ).build()

        favouritesDao  = favouritesDatabase.favouritesDao
    }

    @After
    @Throws(IOException::class)
    open fun tearDown() {
        favouritesDatabase.close()
    }
}