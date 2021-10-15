package com.samples.hiltdemosession.feature_news.presentation.ui.headlines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.samples.hiltdemosession.R
import com.samples.hiltdemosession.feature_news.presentation.adapters.HeadlinesRecyclerAdapter
import com.samples.hiltdemosession.feature_news.presentation.adapters.HeadlinesRecyclerAdapter.OnClickListener
import com.samples.hiltdemosession.databinding.HeadlinesFragmentBinding
import com.samples.hiltdemosession.feature_news.presentation.models.NewsPresenter
import com.samples.hiltdemosession.ui.bottomNavigation.BottomNavigationFragmentDirections
import com.samples.hiltdemosession.feature_news.presentation.ui.headlines.HeadlinesViewModel.HeadlinesNewsState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HeadlinesFragment : Fragment() {

    private val viewModel: HeadlinesViewModel by viewModels()
    private lateinit var binding: HeadlinesFragmentBinding
    private lateinit var adapter: HeadlinesRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HeadlinesFragmentBinding.inflate(layoutInflater, container, false)

        setUpDisplay()
        setUpObservers()

        return binding.root
    }

    private fun setUpDisplay() {
        adapter = HeadlinesRecyclerAdapter(OnClickListener { news ->
            navigateToDetails(news)
        })
        binding.recyclerHeadlines.adapter = adapter

    }

    private fun navigateToDetails(news: NewsPresenter) {
        val action =
            BottomNavigationFragmentDirections.actionBottomNavigationFragmentToNewsDetailsFragment(
                news
            )
        requireActivity().findNavController(R.id.nav_host_fragment).navigate(action)
    }

    private fun setUpObservers() {
        lifecycleScope.launchWhenCreated {
            viewModel.headlineNewsState.collect { state ->
                when (state) {
                    is HeadlinesNewsState.Error -> {
                        displayErrorState(state.message)
                    }
                    is HeadlinesNewsState.Success -> {
                        displaySuccessState(state.news)
                    }
                    is HeadlinesNewsState.Loading -> {
                        displayLoadingState()
                    }
                }
            }
        }

    }

    private fun displaySuccessState(news: List<NewsPresenter>) {
        adapter.submitList(news)
        binding.progressHeadlines.isVisible = false
    }

    private fun displayLoadingState() {
        binding.progressHeadlines.isVisible = true
    }

    private fun displayErrorState(message: String) {
        binding.progressHeadlines.isVisible = false
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }
}