package com.samples.hiltdemosession.feature_news.presentation.mappers

import com.samples.hiltdemosession.feature_news.domain.model.News
import com.samples.hiltdemosession.feature_news.domain.model.Source
import com.samples.hiltdemosession.feature_news.presentation.models.NewsPresenter
import com.samples.hiltdemosession.feature_news.presentation.models.SourcePresenter

fun News.toPresentation(): NewsPresenter {
    return NewsPresenter(
        author,
        title,
        imageUrl,
        publishDate,
        url,
        source.toPresentation(),
        content
    )
}

fun Source.toPresentation(): SourcePresenter {
    return SourcePresenter(
        id ?: "",
        name
    )
}