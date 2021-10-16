package com.samples.hiltdemosession.feature_news.presentation.ui.newsDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samples.domain.usecase.InsertFavouriteUseCase
import com.samples.hiltdemosession.feature_news.presentation.mappers.toFavourite
import com.samples.hiltdemosession.feature_news.presentation.models.NewsPresenter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val insertFavouriteUseCase: InsertFavouriteUseCase
) : ViewModel() {

    private val mutableNewsState = MutableStateFlow<NewsPresenter?>(null)
    val news: StateFlow<NewsPresenter?> = mutableNewsState.asStateFlow()

    init {
        mutableNewsState.value = savedStateHandle.get<NewsPresenter>("news")
    }

    fun insertFavourite(newsPresenter: NewsPresenter){
        viewModelScope.launch {
            insertFavouriteUseCase(newsPresenter.toFavourite())
        }
    }
}