package com.samples.hiltdemosession.ui.headlines

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samples.domain.models.Resource
import com.samples.domain.usecases.FetchHeadlinesUseCase
import com.samples.hiltdemosession.mappers.toPresentation
import com.samples.hiltdemosession.models.NewsPresenter
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
    savedStateHandle: SavedStateHandle
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