package com.peter.presentation.search

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.peter.domain.model.Item
import com.peter.presentation.MainViewModel
import com.peter.presentation.base.BaseFragment
import com.peter.presentation.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate){
    private val viewModel: MainViewModel by viewModels()
    private val searchAdapter :SearchAdapter by lazy { SearchAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.bookmarkGet()
        binding.recyclerView.adapter = searchAdapter
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

        searchAdapter.setOnItemClickListener(object : SearchAdapter.OnItemClickListener{
            override fun onItemClick(item: Item, isBookmark : Boolean) {
                if (isBookmark){
                    viewModel.bookmarkDelete(item)
                }else{
                    viewModel.bookmarkSave(item)
                }
                Toast.makeText(requireContext(),item.url,Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun subscribeToLiveData() {
        viewModel.localRepositories.observe(viewLifecycleOwner){ bookmarks ->
            viewModel.githubRepositories.observe(viewLifecycleOwner) {
                searchAdapter.setItems(it.item,bookmarks)
            }
        }
    }
}