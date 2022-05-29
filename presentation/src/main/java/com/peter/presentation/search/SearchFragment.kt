package com.peter.presentation.search

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.peter.presentation.MainViewModel
import com.peter.presentation.base.BaseFragment
import com.peter.presentation.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate){
    private val viewModel: MainViewModel by viewModels()
    private val adapter: SearchAdapter by lazy { SearchAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        binding.searchButton.setOnClickListener {
            val owner = binding.searchEditText.text.toString()
            if (owner.isEmpty()){
                Toast.makeText(requireContext(),"내용을 입력하세요.",Toast.LENGTH_SHORT).show()
            }else{
                viewModel.getGithubRepositories(owner)
            }

        }
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.githubRepositories.observe(viewLifecycleOwner) {
            (binding.recyclerView.adapter as SearchAdapter).setItems(it.item)
        }
    }
}