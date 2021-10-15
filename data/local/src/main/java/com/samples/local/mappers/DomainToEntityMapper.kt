package com.samples.local.mappers

import com.samples.domain.model.Favourite
import com.samples.local.entity.FavouriteEntity

fun Favourite.toEntity(): FavouriteEntity {
    return FavouriteEntity(
        author,
        title,
        imageUrl,
        publishDate,
        url,
        sourceName,
        content
    )
}