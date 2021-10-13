package com.samples.hiltdemosession.mappers

import com.samples.domain.models.News
import com.samples.domain.models.Source
import com.samples.hiltdemosession.models.NewsPresenter
import com.samples.hiltdemosession.models.SourcePresenter

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