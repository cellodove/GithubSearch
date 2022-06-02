package com.peter.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.peter.domain.model.GithubRepo
import com.peter.domain.model.Item
import com.peter.domain.model.LocalGithubItem
import com.peter.presentation.MainViewModel
import com.peter.presentation.databinding.SearchItemBinding
import javax.inject.Inject

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>(){
    private val items = mutableListOf<Item>()
    private val bookmarks = mutableListOf<LocalGithubItem>()

    interface OnItemClickListener{
        fun onItemClick(item : Item, isBookmark : Boolean)
    }
    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }

    fun setItems(items: List<Item>, bookmark : List<LocalGithubItem>) {
        this.items.clear()
        this.items.addAll(items)
        this.bookmarks.clear()
        this.bookmarks.addAll(bookmark)

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


    inner class ViewHolder(private val binding: SearchItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(repo : Item){
            binding.repoName.text = repo.login
            binding.repoUrl.text = repo.url
            Glide.with(binding.root)
                .load(repo.avatar_url)
                .override(100,100)
                .into(binding.profileImage)
            bookmarks.forEach {
                binding.bookMark.isChecked = repo.login == it.login
            }

            binding.bookMark.setOnClickListener {
                if (binding.bookMark.isChecked){
                    listener?.onItemClick(repo,false)
                }else{
                    listener?.onItemClick(repo,true)
                }
            }
        }
    }
}