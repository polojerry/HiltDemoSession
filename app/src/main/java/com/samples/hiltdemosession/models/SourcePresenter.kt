package com.samples.hiltdemosession.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SourcePresenter(
    val id :String?,
    val name : String
): Parcelable