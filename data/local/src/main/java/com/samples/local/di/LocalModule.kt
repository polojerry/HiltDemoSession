package com.samples.local.di

import android.content.Context
import androidx.room.Room
import com.samples.local.FavouritesDatabase
import com.samples.local.dao.FavouritesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun providesMaDrinksDatabase(@ApplicationContext context: Context): FavouritesDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            FavouritesDatabase::class.java,
            "favourites_database.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesFavouritesDao(database: FavouritesDatabase): FavouritesDao {
        return database.favouritesDao
    }
}