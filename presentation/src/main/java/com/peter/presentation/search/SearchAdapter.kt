package com.peter.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadStateAdapter
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.peter.domain.model.GithubRepo
import com.peter.domain.model.Item
import com.peter.presentation.databinding.SearchItemBinding

class SearchAdapter : PagingDataAdapter<Item,SearchAdapter.ViewHolder>(diffCallback){
    private val items = mutableListOf<Item>()

    interface ItemClickListener {
        fun onClick(clickData : Item)
    }

    fun setItems(items: List<Item>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(SearchItemBinding.inflate(layoutInflater))
    }

    class ViewHolder(private val binding: SearchItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(repo : Item){
            binding.repoName.text = repo.login
            binding.repoUrl.text = repo.url
            Glide.with(binding.root)
                .load(repo.avatar_url)
                .override(100,100)
                .into(binding.profileImage)
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }
        }
    }
}