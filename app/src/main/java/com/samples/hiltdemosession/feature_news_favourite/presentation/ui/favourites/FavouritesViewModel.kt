package com.samples.hiltdemosession.feature_news_favourite.presentation.ui.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samples.domain.usecase.ClearFavouritesUseCase
import com.samples.domain.usecase.GetFavouritesUseCase
import com.samples.hiltdemosession.feature_news.presentation.models.NewsPresenter
import com.samples.hiltdemosession.feature_news.presentation.ui.headlines.HeadlinesViewModel
import com.samples.hiltdemosession.feature_news_favourite.mappers.toPresentation
import com.samples.hiltdemosession.feature_news_favourite.models.FavouritePresenter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val getFavouritesUseCase: GetFavouritesUseCase,
    private val clearFavouritesUseCase: ClearFavouritesUseCase,
) : ViewModel() {
    private val mutableFavouritesState =
        MutableStateFlow<FavouritesNewsState>(FavouritesNewsState.Empty)
    val favouritesNewsState: StateFlow<FavouritesNewsState>
        get() = mutableFavouritesState.asStateFlow()


    init {
        viewModelScope.launch {
            getFavouritesUseCase(Unit).collect { favourites->
                if(favourites.isEmpty()){
                    mutableFavouritesState.emit(
                        FavouritesNewsState.Empty
                    )
                }else{
                    mutableFavouritesState.emit(
                        FavouritesNewsState.Success(favourites.map {
                            it.toPresentation()
                        })
                    )
                }
            }
        }
    }

    fun clearFavourites() {
        viewModelScope.launch {
            clearFavouritesUseCase(Unit)
        }
    }


    sealed class FavouritesNewsState {
        data class Success(val news: List<FavouritePresenter>) : FavouritesNewsState()
        data class Error(val message: String) : FavouritesNewsState()
        object Loading : FavouritesNewsState()
        object Empty : FavouritesNewsState()
    }
}