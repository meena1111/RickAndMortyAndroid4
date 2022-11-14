package com.example.rickandmortyandroid4.ui.fragments.episode

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyandroid4.R
import com.example.rickandmortyandroid4.base.BaseFragment
import com.example.rickandmortyandroid4.common.Resource
import com.example.rickandmortyandroid4.databinding.FragmentEpisodeBinding
import com.example.rickandmortyandroid4.ui.adapters.EpisodeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EpisodeFragment :
    BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(R.layout.fragment_episode) {
    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private val adapter = EpisodeAdapter(arrayListOf())
    private var count = 1

    override fun initialize() {
        setupRecyclerView()
    }


    override fun setupSubscribe() {
        subscribeToEpisode()
    }

    private fun setupRecyclerView() {
        binding.episodeRv.adapter = adapter
        binding.episodeRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    Toast.makeText(requireActivity(), "Last", Toast.LENGTH_LONG).show()
                    ++count
                    subscribeToEpisode()
                }
            }
        })
    }

    private fun subscribeToEpisode() {
        lifecycleScope.launch {
            viewModel.fetchEpisode(page = count).collect {
                when (it) {
                    is Resource.Error -> {
                        Log.e("rick", it.message.toString())
                    }
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        it.data?.let { it1 -> adapter.addNewItems(it1.results) }
                        Log.e("rick", it.data?.results.toString())
                    }
                }
            }
        }
    }
}