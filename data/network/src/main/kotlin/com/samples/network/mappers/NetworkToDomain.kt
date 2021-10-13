package com.samples.network.mappers

import com.samples.domain.models.News
import com.samples.domain.models.Source
import com.samples.network.models.NewsNetwork
import com.samples.network.models.SourceNetwork

fun NewsNetwork.toDomain(): News {
    return News(
        author,
        title,
        imageUrl,
        publishDate,
        url,
        source.toDomain(),
        content
    )
}

fun SourceNetwork.toDomain(): Source {
    return Source(
        id ?: "",
        name
    )
}