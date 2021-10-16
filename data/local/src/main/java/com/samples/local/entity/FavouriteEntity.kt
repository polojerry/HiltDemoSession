package com.samples.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_favourites")
data class FavouriteEntity(
    val author: String,
    val title: String,
    val imageUrl: String,
    val publishDate: String,

    @PrimaryKey
    val url: String,
    val sourceName: String,
    val content: String?
)