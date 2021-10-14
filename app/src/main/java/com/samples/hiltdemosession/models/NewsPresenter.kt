package com.samples.hiltdemosession.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsPresenter(
    val author: String,
    val title: String,
    val imageUrl: String,
    val publishDate: String,
    val url: String,
    val source: SourcePresenter,
    val content: String?
): Parcelable