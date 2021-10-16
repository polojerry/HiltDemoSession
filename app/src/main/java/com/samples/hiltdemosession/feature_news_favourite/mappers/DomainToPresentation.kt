package com.samples.hiltdemosession.feature_news_favourite.mappers

import com.samples.domain.model.Favourite
import com.samples.domain.model.News
import com.samples.domain.model.Source
import com.samples.hiltdemosession.feature_news.presentation.models.NewsPresenter
import com.samples.hiltdemosession.feature_news.presentation.models.SourcePresenter
import com.samples.hiltdemosession.feature_news_favourite.models.FavouritePresenter

fun Favourite.toPresentation(): FavouritePresenter {
    return FavouritePresenter(
        author,
        title,
        imageUrl,
        publishDate,
        url,
        sourceName,
        content
    )
}