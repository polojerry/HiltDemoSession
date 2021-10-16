package com.samples.hiltdemosession.feature_news.presentation.ui.newsDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.samples.hiltdemosession.databinding.NewsDetailsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailsFragment : Fragment() {

    private val viewModel: NewsDetailsViewModel by viewModels()

    private lateinit var binding: NewsDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewsDetailsFragmentBinding.inflate(layoutInflater, container, false)
        binding.news = viewModel.news.value
        binding.toolbarHeadlines.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }
}