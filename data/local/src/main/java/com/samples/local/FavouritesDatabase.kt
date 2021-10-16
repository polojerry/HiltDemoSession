package com.samples.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.samples.local.dao.FavouritesDao
import com.samples.local.entity.FavouriteEntity

@Database(
    entities = [FavouriteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FavouritesDatabase : RoomDatabase() {

    abstract val favouritesDao: FavouritesDao
}