package com.peter.presentation.bookmark

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.peter.domain.model.Item
import com.peter.domain.model.LocalGithubItem
import com.peter.presentation.MainViewModel
import com.peter.presentation.base.BaseFragment
import com.peter.presentation.databinding.FragmentBookmarkBinding
import com.peter.presentation.search.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookMarkFragment : BaseFragment<FragmentBookmarkBinding>(FragmentBookmarkBinding::inflate){
    private val viewModel: MainViewModel by viewModels()
    private val bookmarkAdapter : BookmarkAdapter by lazy { BookmarkAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.bookmarkGet()
        subscribeToLiveData()

        binding.recyclerView.adapter = bookmarkAdapter
        binding.recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        bookmarkAdapter.setOnItemClickListener(object : BookmarkAdapter.OnItemClickListener{
            override fun onItemClick(item: LocalGithubItem, isBookmark: Boolean) {
                viewModel.bookmarkDeleteForLocal(item)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.bookmarkGet()
    }


    private fun subscribeToLiveData() {
        viewModel.localRepositories.observe(viewLifecycleOwner){
            bookmarkAdapter.setItems(it)
        }
    }
}