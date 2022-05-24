package com.peter.presentation.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.peter.presentation.MainViewModel
import com.peter.presentation.base.BaseFragment
import com.peter.presentation.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate){
    private val viewModel: MainViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = SearchAdapter()

        binding.searchButton.setOnClickListener {
            val owner = binding.searchEditText.text.toString()
            viewModel.getGithubRepositories(owner)
        }
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.githubRepositories.observe(viewLifecycleOwner) {
            (binding.recyclerView.adapter as SearchAdapter).setItems(it)
        }
    }
}