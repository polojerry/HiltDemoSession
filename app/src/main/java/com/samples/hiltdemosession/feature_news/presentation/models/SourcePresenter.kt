package com.samples.hiltdemosession.feature_news.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SourcePresenter(
    val id :String?,
    val name : String
): Parcelable