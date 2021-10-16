package com.samples.local.mappers

import com.samples.domain.model.Favourite
import com.samples.local.entity.FavouriteEntity

fun FavouriteEntity.toDomain(): Favourite {
    return Favourite(
        author,
        title,
        imageUrl,
        publishDate,
        url,
        sourceName,
        content
    )
}