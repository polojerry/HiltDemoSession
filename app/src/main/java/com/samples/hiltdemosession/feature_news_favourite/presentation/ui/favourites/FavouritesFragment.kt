package com.samples.hiltdemosession.feature_news_favourite.presentation.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.samples.hiltdemosession.R
import com.samples.hiltdemosession.databinding.FavouritesFragmentBinding
import com.samples.hiltdemosession.feature_news_favourite.adapters.FavouritesRecyclerAdapter
import com.samples.hiltdemosession.feature_news_favourite.models.FavouritePresenter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class FavouritesFragment : Fragment() {

    private val viewModel: FavouritesViewModel by viewModels()

    private lateinit var binding: FavouritesFragmentBinding
    private lateinit var adapter: FavouritesRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FavouritesFragmentBinding.inflate(inflater, container, false)

        setUpDisplay()
        setUpCollectors()

        return binding.root
    }

    private fun setUpDisplay() {
        adapter = FavouritesRecyclerAdapter()
        binding.recyclerFavourites.adapter = adapter
        binding.toolbarFavourites.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_clear_favourites -> {
                    clearFavourites()
                }
            }
            false
        }
    }

    private fun clearFavourites() {
        viewModel.clearFavourites()
    }

    private fun setUpCollectors() {
        lifecycleScope.launchWhenCreated {
            viewModel.favouritesNewsState.collect { favouriteState ->
                when (favouriteState) {
                    is FavouritesViewModel.FavouritesNewsState.Error -> {
                        displayErrorState(favouriteState.message)
                    }
                    is FavouritesViewModel.FavouritesNewsState.Success -> {
                        displaySuccessState(favouriteState.news)
                    }
                    is FavouritesViewModel.FavouritesNewsState.Loading -> {
                        displayLoadingState()
                    }
                    is FavouritesViewModel.FavouritesNewsState.Empty -> {
                        displayEmptyState()
                    }
                }

            }

        }
    }

    private fun displayEmptyState() {
        with(binding) {
            progressFavourites.isVisible = false
            stateFavourite.isVisible = true
            stateFavourite.text = getString(R.string.empty_favourite_state)
        }
        adapter.submitList(null)
    }

    private fun displayLoadingState() {
        with(binding){
            progressFavourites.isVisible = true
            stateFavourite.isVisible = false
        }
    }

    private fun displaySuccessState(news: List<FavouritePresenter>) {
        with(binding) {
            progressFavourites.isVisible = false
            stateFavourite.isVisible = false
        }

        adapter.submitList(news)
    }

    private fun displayErrorState(message: String) {
        with(binding) {
            progressFavourites.isVisible = false
            stateFavourite.text = message
        }

        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()

    }


}