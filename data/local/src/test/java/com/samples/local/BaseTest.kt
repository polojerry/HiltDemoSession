package com.samples.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.samples.local.dao.FavouritesDao
import org.junit.After
import org.junit.Before
import java.io.IOException

open class BaseTest {

    lateinit var favouritesDatabase: FavouritesDatabase

    @Before
    open fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        favouritesDatabase = Room.inMemoryDatabaseBuilder(
            context, FavouritesDatabase::class.java
        ).build()

    }

    @After
    @Throws(IOException::class)
    open fun tearDown() {
        favouritesDatabase.close()
    }
}