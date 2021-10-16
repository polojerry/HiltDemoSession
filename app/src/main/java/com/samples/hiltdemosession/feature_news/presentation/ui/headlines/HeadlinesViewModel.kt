package com.samples.hiltdemosession.feature_news.presentation.ui.headlines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samples.domain.model.Resource
import com.samples.domain.usecase.FetchHeadlinesUseCase
import com.samples.hiltdemosession.feature_news.presentation.mappers.toPresentation
import com.samples.hiltdemosession.feature_news.presentation.models.NewsPresenter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeadlinesViewModel @Inject constructor(
    private val fetchHeadlinesUseCase: FetchHeadlinesUseCase,
) : ViewModel() {

    private val mutableHeadlineNewsState =
        MutableStateFlow<HeadlinesNewsState>(HeadlinesNewsState.Loading)
    val headlineNewsState: StateFlow<HeadlinesNewsState>
        get() = mutableHeadlineNewsState.asStateFlow()

    init {
        viewModelScope.launch {
            fetchHeadlinesUseCase(Unit).collect { resource ->

                when (resource) {
                    is Resource.Success -> {
                        mutableHeadlineNewsState.emit(
                            HeadlinesNewsState.Success(resource.data!!.map {
                                it.toPresentation()
                            })
                        )
                    }
                    is Resource.Error -> {
                        mutableHeadlineNewsState.emit(
                            HeadlinesNewsState.Error(resource.message.toString())
                        )
                    }
                    else -> {
                    }
                }
            }
        }
    }


    sealed class HeadlinesNewsState {
        data class Success(val news: List<NewsPresenter>) : HeadlinesNewsState()
        data class Error(val message: String) : HeadlinesNewsState()
        object Loading : HeadlinesNewsState()
    }
}