package com.peter.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.peter.domain.model.GithubRepo
import com.peter.presentation.databinding.SearchItemBinding

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>(){
    private val items = mutableListOf<GithubRepo>()

    fun setItems(items: List<GithubRepo>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(SearchItemBinding.inflate(layoutInflater))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(private val binding: SearchItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(repo : GithubRepo){
            binding.repoName.text = repo.name
            binding.repoUrl.text = repo.url
            Glide.with(binding.root)
                .load(repo.profileImage)
                .into(binding.profileImage)
        }
    }
}