package com.peter.presentation.search

import androidx.recyclerview.widget.RecyclerView
import com.peter.domain.model.GithubRepo
import com.peter.presentation.databinding.SearchItemBinding

class SearchAdapter {
    class ViewHolder(private val binding: SearchItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(repo : GithubRepo){
            binding.repoName.text = repo.name
            binding.repoUrl.text = repo.url
            //binding.profileImage = repo.profileImage

        }
    }

}