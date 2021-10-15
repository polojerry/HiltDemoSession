package com.samples.hiltdemosession.feature_news.presentation.ui.bottomNavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.samples.hiltdemosession.databinding.BottomNavigationFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomNavigationFragment : Fragment() {

    private lateinit var binding : BottomNavigationFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomNavigationFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}