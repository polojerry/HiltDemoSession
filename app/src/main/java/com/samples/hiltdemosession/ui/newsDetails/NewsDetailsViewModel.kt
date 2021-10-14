package com.samples.hiltdemosession.ui.newsDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.samples.hiltdemosession.models.NewsPresenter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NewsDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val mutableNewsState = MutableStateFlow<NewsPresenter?>(null)
    val news: StateFlow<NewsPresenter?> = mutableNewsState.asStateFlow()

    init {
        mutableNewsState.value = savedStateHandle.get<NewsPresenter>("news")
    }
}