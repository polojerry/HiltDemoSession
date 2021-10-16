package com.samples.hiltdemosession.feature_news.presentation.mappers

import com.samples.domain.model.Favourite
import com.samples.hiltdemosession.feature_news.presentation.models.NewsPresenter

fun NewsPresenter.toFavourite() : Favourite {
    return Favourite(
        author,
        title,
        imageUrl,
        publishDate,
        url,
        source.name,
        content = content
    )
}