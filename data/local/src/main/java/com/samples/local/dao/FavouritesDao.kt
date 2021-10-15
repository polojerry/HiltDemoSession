package com.samples.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.samples.local.entity.FavouriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {

    @Query("SELECT * FROM table_favourites")
    fun getFavourites(): Flow<List<FavouriteEntity>>

    @Insert(onConflict = REPLACE)
    suspend fun insertFavourite(favourite: FavouriteEntity)

    @Query("DELETE FROM table_favourites")
    suspend fun clearFavourites()


}