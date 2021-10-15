package com.samples.hiltdemosession.feature_news.data.datasource.remote.mappers

import com.samples.hiltdemosession.feature_news.data.datasource.remote.models.NewsNetwork
import com.samples.hiltdemosession.feature_news.data.datasource.remote.models.SourceNetwork
import com.samples.domain.model.News
import com.samples.domain.model.Source

fun NewsNetwork.toDomain(): News {
    return News(
        author ?: "Unknown",
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